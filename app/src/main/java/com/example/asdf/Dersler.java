package com.example.asdf;

import java.util.ArrayList;

public class Dersler {
    private int imageID;
    private String ad;
    private String not;
    private String say;
    private String notOrt;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public String getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(String notOrt) {
        this.notOrt = notOrt;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }


    public static ArrayList<Dersler> getData() {
        ArrayList<Dersler> dataList = new ArrayList<Dersler>();

        int[] resimler = {R.drawable.beden, R.drawable.cografya, R.drawable.edebiyat,
                R.drawable.fen, R.drawable.matematik, R.drawable.muzik,
                R.drawable.resim, R.drawable.sosyal, R.drawable.tarih, R.drawable.turkce};

        String[] dersler = {"Beden", "Cografya", "Edebiyat", "Fen", "Matematik",
                "Müzik", "Resim", "Sosyal", "Tarih", "Türkçe"};

        String[] notlar = {"23", "53", "76", "35", "92", "44", "84", "11", "88", "100"};

        String[] notort = {"34.7", "63.3", "94", "57.8", "13.1", "77.9", "44.1", "85.3", "36.2", "63.5"};

        String[] sayı = {"38","123","68","22","95","47","82","48","68","112"};

        for (int i = 0; i < resimler.length; i++) {
            Dersler gecici = new Dersler();
            gecici.setImageID(resimler[i]);
            gecici.setAd(dersler[i]);
            gecici.setNot(notlar[i]);
            gecici.setNotOrt(notort[i]);
            gecici.setSay(sayı[i]);
            dataList.add(gecici);
        }
        return dataList;
    }
}
