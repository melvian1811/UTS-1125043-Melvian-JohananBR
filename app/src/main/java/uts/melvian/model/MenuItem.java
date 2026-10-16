package uts.melvian.model;
import uts.melvian.util.InputUtil;
public abstract class MenuItem implements Customize {
    String nama;
    String id;
    double hargaBase;
    int stok;
    double biayaKustomisasiTotal = 0;

    public MenuItem(String nama, String id, double hargaBase, int stok){
        this.nama = nama;
        this.id = id;
        this.hargaBase = hargaBase;
        this.stok = stok;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }   

    public double getHargaBase(){
        return hargaBase;
    }

    public void setHargaBase(double hargaBase){
        this.hargaBase = hargaBase;
    }

    public int getStok(){
        return stok;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

    public abstract double hitungHargaTotal();
    
    public abstract String getOrderDetail();

    public double hitungHargaTotal(int jumlah) {
    
    return (hargaBase + biayaKustomisasiTotal) * jumlah;
    }

    public double hitungHargaTotal(int jumlah, String kodePromo) {
        double total = hitungHargaTotal(jumlah);
        if ("PROMO10".equalsIgnoreCase(kodePromo)) {
            total = total * 0.9;
        }
        return total;
    }

    public double getBiayaKustomisasiTotal() {
    return biayaKustomisasiTotal;
    }
}
