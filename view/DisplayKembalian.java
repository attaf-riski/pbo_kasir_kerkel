package pbo_kerkel.view;

import pbo_kerkel.controller.Pengembalian;

public class DisplayKembalian {
    Pengembalian pengembalian;

    public DisplayKembalian(int totalHarga, int uang) {
        pengembalian = new Pengembalian();
        tampilkanKembalian(pengembalian.hitungKembalian(totalHarga, uang));
    }

    public void tampilkanKembalian(int kembalian) {
        System.out.println("Kembalian: " + kembalian);
    }
}
