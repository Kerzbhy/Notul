package com.adi.notulen;

public class ModelData {

    private String nama;
    private String judul;
    private String waktu;
    private String key;

    public ModelData(){

    }


    public ModelData(String nama, String judul, String waktu) {
        this.nama = nama;
        this.judul = judul;
        this.waktu = waktu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

