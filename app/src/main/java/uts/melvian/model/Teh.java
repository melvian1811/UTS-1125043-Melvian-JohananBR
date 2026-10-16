package uts.melvian.model;

import java.util.List;

public class Teh extends MenuItem {
    private int boba;   // +1000 [0-3]
    private int es;     // free [0-5]
    private int gula;   // free [0-5]
    private int karamel; // +3000 [0-5]

    public Teh(String id, String nama, double hargaBase, int stok) {
        super(id, nama, hargaBase, stok);
    }

    @Override
    public void Customize(int[] customizations) {
        if (customizations.length >= 4) {
            this.boba = Math.min(Math.max(customizations[0], 0), 3);
            this.es = Math.min(Math.max(customizations[1], 0), 5);
            this.gula = Math.min(Math.max(customizations[2], 0), 5);
            this.karamel = Math.min(Math.max(customizations[3], 0), 5);

            this.biayaKustomisasiTotal = (this.boba * 1000) + (this.karamel * 3000);
        }
    }

    @Override
    public void Customize(List<Integer> customizations) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Customize'");
    }

    @Override
    public double hitungHargaTotal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hitungHargaTotal'");
    }

    @Override
    public String getOrderDetail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderDetail'");
    }
}
