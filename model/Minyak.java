package pbo_kerkel.model;

public class Minyak extends Sembako {
    private int idMinyak;
    private int harga;
    private String satuan;
    private String merk;

    public Minyak(int idSembako, String nama, String jenis, int harga, String satuan, String merk) {
        super(idSembako, nama, jenis);
        this.idMinyak = idSembako;
        this.harga = harga;
        this.satuan = satuan;
        this.merk = merk;
    }

    public int getIdMinyak() {
        return idMinyak;
    }

    public void setIdMinyak(int idMinyak) {
        this.idMinyak = idMinyak;
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

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
}
