/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis_ups.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UpsProperty {
    private StringProperty kd_ups;
    private StringProperty nama_produk;
    private StringProperty tgl_produksi;
    private StringProperty merk;
   
    private StringProperty harga;

    public UpsProperty(String kd_ups, String nama_produk, String tgl_produksi, String merk, String harga) {
        this.kd_ups = new SimpleStringProperty(kd_ups);
        this.nama_produk = new SimpleStringProperty(nama_produk);
        this.tgl_produksi = new SimpleStringProperty(tgl_produksi);
        this.merk = new SimpleStringProperty(merk);
       
        this.harga = new SimpleStringProperty(harga);
    }
    
    public UpsProperty(Ups t) {
        this.kd_ups = new SimpleStringProperty(t.getKd_Ups());
        this.nama_produk = new SimpleStringProperty(t.getNama());
        this.tgl_produksi = new SimpleStringProperty(t.getTglProduksi());
        this.merk = new SimpleStringProperty(t.getMerk());
      
        this.harga = new SimpleStringProperty(t.getHarga());
    }
    
    public StringProperty getKd_upsProperty() {
        return kd_ups;
    }

    public void setKd_ups(String kd_ups) {
        this.kd_ups = new SimpleStringProperty (kd_ups);
    }

    public StringProperty getNama_produkProperty() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = new SimpleStringProperty (nama_produk);
    }

    public StringProperty getTgl_produksiProperty() {
        return tgl_produksi;
    }

    public void setTgl_produksi(String tgl_produksi) {
        this.tgl_produksi = new SimpleStringProperty (tgl_produksi);
    }

    public StringProperty getMerkProperty() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = new SimpleStringProperty (merk);
    }

   
    public StringProperty getHargaProperty() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = new SimpleStringProperty (harga);
    }

    public String getKd_ups() {
        return kd_ups.get();
    }

    public String getNama_produk() {
        return nama_produk.get();
    }

    public String getTgl_produksi() {
        return tgl_produksi.get();
    }

    public String getMerk() {
        return merk.get();
    }

   

    public String getHarga() {
        return harga.get();
    }
}
