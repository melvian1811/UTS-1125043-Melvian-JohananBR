package uts.melvian.model;

public enum Ukuran {
    SMALL(0), 
    MEDIUM(3000), 
    LARGE(5000);

    private final double tambahanHarga;

    Ukuran(double tambahanHarga) {
    this.tambahanHarga = tambahanHarga;
    }

    public double getTambahanHarga() {
    return tambahanHarga;
    }
}

