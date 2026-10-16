package uts.melvian.controller;

import uts.melvian.Exception.InputTidakValidException;
import uts.melvian.Exception.MenuTidakDitemukanException;
import uts.melvian.Exception.StokTidakCukupException;
import uts.melvian.model.Ukuran;
import uts.melvian.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private List<MenuItem> menuList;

    public OrderController() {
        this.menuList = new ArrayList<>();
    }

    public void tambahMenu(MenuItem item) {
        menuList.add(item);
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public MenuItem cariMenuById(String id) throws MenuTidakDitemukanException {
        for (MenuItem item : menuList) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        throw new MenuTidakDitemukanException("ID Menu '" + id + "' tidak ditemukan!");
    }

    public void validasiJumlah(int jumlah, MenuItem item) throws InputTidakValidException, StokTidakCukupException {
        if (jumlah <= 0) {
            throw new InputTidakValidException("Jumlah pesanan harus lebih dari 0");
        }
        if (jumlah > item.getStok()) {
            throw new StokTidakCukupException("Stok tidak cukup\n Stok tersedia: " + item.getStok());
        }
    }

    public double prosesPemesanan(MenuItem item, int jumlah, int[] customizations, String kodePromo) {
    item.Customize(customizations);
    double totalHarga = item.hitungHargaTotal(jumlah, kodePromo );
    return totalHarga;        
}
}
