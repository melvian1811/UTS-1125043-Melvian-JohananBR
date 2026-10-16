package uts.melvian;

import uts.melvian.controller.OrderController;
import uts.melvian.model.Kopi;
import uts.melvian.model.Roti;
import uts.melvian.model.Teh;
import uts.melvian.view.OrderView;

public class Mains {
    public static void main(String[] args) {
        OrderController controller = new OrderController();

        // Inisialisasi Data Awal sesuai Soal
        controller.tambahMenu(new Kopi("M-01", "Kopi Susu", 18000, 5));
        controller.tambahMenu(new Teh("M-02", "Teh Tarik", 12000, 10));
        controller.tambahMenu(new Roti("M-03", "Roti Cokelat", 15000, 8));

        OrderView view = new OrderView(controller);
        view.mulaiPemesanan();
    }
}