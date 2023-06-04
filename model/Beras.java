package pbo_kerkel.model;

public class Beras extends Sembako {
    int idBeras;
    int harga;
    String satuan;

    public Beras(int idBarang, String namaBarang, String jenis, int harga, String satuan) {
        super(idBarang, namaBarang, jenis);
        this.idBeras = idBarang;
        this.harga = harga;
        this.satuan = satuan;
    }

    public int getIdBeras() {
        return idBeras;
    }

    public void setIdBeras(int idBeras) {
        this.idBeras = idBeras;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
}
