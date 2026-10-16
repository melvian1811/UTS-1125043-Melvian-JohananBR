package uts.melvian.model;

import java.util.List;

public class Teh extends MenuItem {
    private int boba;  
    private int es;    
    private int gula;  
    private int karamel; 

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
        int[] arr = customizations.stream().mapToInt(i -> i).toArray();
        Customize(arr);
    }

    @Override
    public double hitungHargaTotal() {
        return getHargaBase() + biayaKustomisasiTotal;
    }

    @Override
    public String getOrderDetail() {
        return "Teh: "+nama+" | Boba: "+boba+" Es: "+ es +"Gula: "+gula +"| Karamel: "+karamel +"| Biaya Kustom: Rp."+biayaKustomisasiTotal;
    }
}

