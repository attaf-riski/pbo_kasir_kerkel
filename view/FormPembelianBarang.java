package pbo_kerkel.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import pbo_kerkel.controller.Perhitungan;
import pbo_kerkel.model.Sembako;

// Nama File : FormPembelianSembako.java
// Deskripsi : Tampilan untuk Form pembelian Sembako
// Pembuat : Attaf Riski Putra Ramadhan
// Tanggal : Minggu, 4 Juni 2023

public class FormPembelianBarang {

    public FormPembelianBarang() {
        // KAMUS LOKAL
        Perhitungan perhitungan = new Perhitungan();
        Scanner input = new Scanner(System.in);
        char isNext = 'y';
        try {
            int totalHarga = 0;
            int idSembako = 0;
            int banyakBeli = 0;
            int uang = 0;
            String satuan = "";
            ArrayList<Sembako> SembakoBelanjaan = new ArrayList<>(); // menyimpan Sembako belanjaan
            ArrayList<String> jumlahBelanjaan = new ArrayList<>(); // menyimpan jumlah

            // ALGORITMA
            do {
                input = new Scanner(System.in);
                System.out.print("Masukkan id sembako yang dibeli: ");
                try {
                    idSembako = input.nextInt();
                } catch (InputMismatchException ex) {
                    System.err.println("Tipe masukkan salah");
                }

                SembakoBelanjaan.add(perhitungan.getSembako(idSembako));
                if (SembakoBelanjaan.get(SembakoBelanjaan.size() - 1) == null) {
                    SembakoBelanjaan.remove(SembakoBelanjaan.size() - 1);
                    System.out.print("Id sembako tidak ditemukan\n");
                    System.out.print("Masukkan lagi Sembako(y/n)? ");
                    isNext = input.next().charAt(0);
                    if (isNext == 'n')
                        return;
                    continue;
                }

                System.out
                        .println("Anda memilih: " + SembakoBelanjaan.get(SembakoBelanjaan.size() - 1).getNamaSembako());
                System.out.print("Masukkan jumlah pembelian: ");
                try {
                    banyakBeli = input.nextInt();
                } catch (InputMismatchException ex) {
                    System.err.println("Tipe masukkan salah");
                    SembakoBelanjaan.remove(SembakoBelanjaan.size() - 1);
                    continue;
                }
                satuan = perhitungan.getSatuan(SembakoBelanjaan.get(SembakoBelanjaan.size() - 1));
                jumlahBelanjaan.add(banyakBeli + " " + satuan);
                System.out.println("Anda memilih " + SembakoBelanjaan.get(SembakoBelanjaan.size() - 1).getNamaSembako()
                        + " sebanyak: "
                        + banyakBeli + " " + satuan);
                // tampilkan Sembako belanjaan
                for (int i = 1; i <= SembakoBelanjaan.size(); i++) {
                    System.out.printf("%d. %s sejumlah %s\n", i, SembakoBelanjaan.get(i - 1).getNamaSembako(),
                            jumlahBelanjaan.get(i - 1));
                }
                // hitung total
                totalHarga = perhitungan.hitungTotal(SembakoBelanjaan.get(SembakoBelanjaan.size() - 1), banyakBeli,
                        totalHarga);
                updateLabelTotalHarga(totalHarga);
                System.out.print("Masukkan lagi Sembako(y/n)? ");
                isNext = input.next().charAt(0);
            } while (isNext != 'n');

            // jika masukkan lagi Sembako pindah ke checkpoint a
            // jika bayar lanjut
            bayarPembelian(); // bekerja seperti tombol
            tampilkanMasukkanUang();
            uang = input.nextInt();
            hitungKembalian(); // bekerja seperti tombol, karena cli berurutan sehingga ini tidak bergitu
                               // berguna
            new DisplayKembalian(totalHarga, uang);
            input.close();
        } catch (InputMismatchException ex) {
            System.err.println("Tipe masukkan salah");
        } catch (NullPointerException ex) {
            System.err.println("id sembako tidak ditemukan");
        } catch (Exception ex) {
            System.err.println("Terjadi Kesalahan Program");
            ex.printStackTrace();
        } finally {
            input.close();
        }

    }

    static void bayarPembelian() {
        System.out.println("===Sesi Pembayaran");
    }

    static void hitungKembalian() {
        System.out.println("===Sesi Kembalian Uang");
    }

    static void tampilkanMasukkanUang() {
        System.out.print("Masukkan Uang: ");
    }

    static void updateLabelTotalHarga(int totalHarga) {
        System.out.println("\nTotal Harga: " + totalHarga);
    }
}
