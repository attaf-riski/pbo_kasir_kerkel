package pbo_kerkel.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import pbo_kerkel.model.Sembako;
import pbo_kerkel.model.SembakoDAO;
import pbo_kerkel.model.Beras;
import pbo_kerkel.model.BerasDAO;
import pbo_kerkel.model.Minyak;
import pbo_kerkel.model.MinyakDAO;

public class Perhitungan {

    // koneksi
    public Sembako getSembako(int idSembako) {
        Sembako b = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/kasir_pbo",
                    "root",
                    "");

            // get parent tabel
            SembakoDAO SembakoDAO = new SembakoDAO(conn);
            b = SembakoDAO.doGet(idSembako);

            // get child
            if (b.getJenis().equals("BERAS")) {
                BerasDAO berasDAO = new BerasDAO(conn);
                Beras br = berasDAO.doGet(idSembako);
                return br;
            } else if (b.getJenis().equals("MINYAK")) {
                MinyakDAO minyakDAO = new MinyakDAO(conn);
                Minyak m = minyakDAO.doGet(idSembako);
                return m;
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Kelas jdbc tidak ditemukan");
        } catch (NullPointerException ex) {
            System.err.println("Id Sembako tidak ditemukan");
        } catch (Exception ex) {
            System.err.println("Terjadi kesalahan program");
            ex.printStackTrace();
        }

        return b;

    }

    public int hitungTotal(Sembako Sembako, int banyakBeli, int totalSementara) {
        int total = 0;
        if (Sembako instanceof Beras) {
            Beras br = (Beras) Sembako;
            total = totalSementara + br.getHarga() * banyakBeli;
        } else if (Sembako instanceof Minyak) {
            Minyak m = (Minyak) Sembako;
            total = totalSementara + m.getHarga() * banyakBeli;

        }
        return total;
    }

    public String getSatuan(Sembako b) {
        if (b instanceof Beras) {
            return ((Beras) b).getSatuan();
        } else if (b instanceof Minyak) {
            return ((Minyak) b).getSatuan();
        }
        return "satuan";
    }

}
