package pbo_kerkel.model;

// Nama File : Sembako.java
// Deskripsi : POJO Sembako
// Pembuat : 
// Tanggal : Minggu, 4 Juni 2023

public class Sembako {
    // KAMUS
    private int idSembako;
    private String namaSembako;
    private String jenis;

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    // Constructor
    public Sembako(int idSembako, String namaSembako, String jenis) {
        this.idSembako = idSembako;
        this.namaSembako = namaSembako;
        this.jenis = jenis;
    }

    // GETTER and SETTER
    public int getIdSembako() {
        return idSembako;
    }

    public void setIdSembako(int idSembako) {
        this.idSembako = idSembako;
    }

    public String getNamaSembako() {
        return namaSembako;
    }

    public void setNamaSembako(String namaSembako) {
        this.namaSembako = namaSembako;
    }

}
