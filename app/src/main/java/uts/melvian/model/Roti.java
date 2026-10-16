package uts.melvian.model;
import java.util.List;

public class Roti extends MenuItem {
    private int gula;   // free [0-5]
    private int karamel; // +3000 [0-5]
    private int meses; //+500 [0-5]
    
    public Roti(String id, String nama, double hargaBase, int stok) {
        super(id, nama, hargaBase, stok);
    }

    @Override
    public void Customize(int[] customizations) {
        if (customizations.length >= 3) {
            this.gula = Math.min(Math.max(customizations[0], 0), 5);
            this.meses = Math.min(Math.max(customizations[1], 0), 5);
            this.karamel = Math.min(Math.max(customizations[2], 0), 5);

            this.biayaKustomisasiTotal = (this.meses * 500) + (this.karamel * 3000);
        }
    }

    @Override
    public void Customize(List<Integer> customizations) {
        int[] arr = customizations.stream().mapToInt(i -> i).toArray();
        Customize(arr);
    }

    @Override
    public double hitungHargaTotal() {
        return getHargaBase() + biayaKustomisasiTotal;
    }

    @Override
    public String getOrderDetail() {
        return "Roti: "+nama+" Gula: "+gula+" Meses: "+meses+"Karamel:  |"+karamel+" Biaya Kustom: Rp."+biayaKustomisasiTotal;
    }
}
