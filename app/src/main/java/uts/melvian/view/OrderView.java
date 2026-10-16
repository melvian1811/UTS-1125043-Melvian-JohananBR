package uts.melvian.view;

import uts.melvian.controller.OrderController;
import uts.melvian.Exception.InputTidakValidException;
import uts.melvian.Exception.MenuTidakDitemukanException;
import uts.melvian.Exception.StokTidakCukupException;
import uts.melvian.model.*;

import java.util.Scanner;

public class OrderView {
    private OrderController controller;
    private Scanner scanner;

    public OrderView(OrderController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void tampilkanMenuAwal() {
        System.out.println("====== DAFTAR MENU COFFEE SHOP ======");
        for (MenuItem item : controller.getMenuList()) {
            System.out.printf("%s: %s (Stok: %d) - Rp%.0f%n",
                    item.getId(), item.getNama(), item.getStok(), item.getHargaBase());
        }
    }

    public void mulaiPemesanan() {
        tampilkanMenuAwal();

        MenuItem itemDipilih = null;
        while (itemDipilih == null) {
            try {
                System.out.print("Masukkan ID Menu yang ingin dipesan: ");
                String id = scanner.nextLine().trim();
                itemDipilih = controller.cariMenuById(id);
            } catch (MenuTidakDitemukanException e) {
                System.out.println(e.getMessage());
            }
        }

        int jumlah = 0;
        while (true) {
            try {
                System.out.print("Masukkan Jumlah Pesanan: ");
                jumlah = Integer.parseInt(scanner.nextLine().trim());
                controller.validasiJumlah(jumlah, itemDipilih);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka");

            } catch (InputTidakValidException | StokTidakCukupException e) {
                System.out.println(e.getMessage());
            }
        }

        Ukuran ukuran = Ukuran.SMALL;
        if (itemDipilih instanceof Kopi || itemDipilih instanceof Teh) {
            System.out.print("Pilih Ukuran (1. SMALL, 2. MEDIUM, 3. LARGE): ");
            int pilUkuran = Integer.parseInt(scanner.nextLine().trim());
            if (pilUkuran == 2) ukuran = Ukuran.MEDIUM;
            else if (pilUkuran == 3) ukuran = Ukuran.LARGE;
        }

        int[] kustomisasi = inputKustomisasi(itemDipilih);
        double totalHarga = controller.prosesPemesanan(itemDipilih, jumlah, ukuran, kustomisasi);

        cetakStruk(itemDipilih, jumlah, ukuran, totalHarga);
    }

    private int[] inputKustomisasi(MenuItem item) {
        System.out.println("\n--- Input Kustomisasi ---");
        if (item instanceof Kopi) {
            System.out.print("Rum (0-1): "); 
            int rum = scanner.nextInt();

            System.out.print("Es (0-5): "); 
            int es = scanner.nextInt();

            System.out.print("Gula (0-5): "); 
            int gula = scanner.nextInt();

            System.out.print("Karamel (0-5): "); 
            int karamel = scanner.nextInt();
            scanner.nextLine();
            return new int[]{rum, es, gula, karamel};
        } else if (item instanceof Teh) {
            System.out.print("Boba (0-3): "); 
            int boba = scanner.nextInt();

            System.out.print("Es (0-5): "); 
            int es = scanner.nextInt();

            System.out.print("Gula (0-5): "); 
            int gula = scanner.nextInt();

            System.out.print("Karamel (0-5): "); 
            int karamel = scanner.nextInt();
            scanner.nextLine();
            return new int[]{boba, es, gula, karamel};
        } else if (item instanceof Roti) {
            System.out.print("Gula (0-5): "); 
            int gula = scanner.nextInt();

            System.out.print("Meses (0-5): "); 
            int meses = scanner.nextInt();

            System.out.print("Karamel (0-5): "); 
            int karamel = scanner.nextInt();
            scanner.nextLine();
            return new int[]{gula, meses, karamel};
        }
        return new int[]{};
    }

    private void cetakStruk(MenuItem item, int jumlah, Ukuran ukuran, double totalHarga) {
        System.out.println("\n================ STRUK PEMESANAN ================");
        System.out.println("Detail Rincian : " + item.getOrderDetail());
        System.out.println("Ukuran         : " + ukuran);
        System.out.println("Jumlah         : " + jumlah);
        System.out.println("Sisa Stok Menu : " + item.getStok());
        System.out.printf("TOTAL HARGA    : Rp%.0f%n", totalHarga);
        System.out.println("=================================================");
    }
}
