package uts.melvian.model;

import java.util.List;

public class Kopi extends MenuItem {

    private int rum;    // +3000 [0-1]
    private int es;     // free [0-5]
    private int gula;   // free [0-5]
    private int karamel; // +3000 [0-5]

    public Kopi(String nama, String id, int hargaBase, int stok) {
        super(nama, id, hargaBase, stok);
    }

    @Override
    public void Customize(int[] customizations) {
        if (customizations.length >= 4) {
            this.rum = Math.min(Math.max(customizations[0], 0), 1);
            this.es = Math.min(Math.max(customizations[1], 0), 5);
            this.gula = Math.min(Math.max(customizations[2], 0), 5);
            this.karamel = Math.min(Math.max(customizations[3], 0), 5);

            this.biayaKustomisasiTotal = (this.rum * 3000) + (this.karamel * 3000);
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
        return "Kopi: "+ nama +" | Rum: "+rum+"| Es: "+ es+" Gula: "+gula+"| Karamel: "+karamel+" | Biaya Kustom: Rp."+biayaKustomisasiTotal;
    }
    
    
}
