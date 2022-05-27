package kuis_ups.model;


public class Ups {
    private String kd_ups;
    private String nama;
    private String tglProduksi;
    private String merk;
    
    private String harga;

    public Ups(String kd_tv, String nama, String tglProduksi, String merk,  String harga) {
        this.kd_ups = kd_tv;
        this.nama = nama;
        this.tglProduksi = tglProduksi;
        this.merk = merk;
       
        this.harga = harga;
    }

    public void setKd_ups(String kd_ups) {
        this.kd_ups = kd_ups;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTglProduksi(String tglProduksi) {
        this.tglProduksi = tglProduksi;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKd_Ups() {
        return kd_ups;
    }

    public String getNama() {
        return nama;
    }

    public String getTglProduksi() {
        return tglProduksi;
    }

    public String getMerk() {
        return merk;
    }

    

    public String getHarga() {
        return harga;
    }

   

    
    
}
