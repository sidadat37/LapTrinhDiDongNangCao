package com.example.shopmobile.Model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int id ;
    private String nameSP , giaSP ,motaSP, hinhSP ;

    public SanPham(String nameSP, String giaSP) {
        this.nameSP = nameSP;
        this.giaSP = giaSP;
    }

    public SanPham(int id, String nameSP, String giaSP, String motaSP, String hinhSP) {
        this.id = id;
        this.nameSP = nameSP;
        this.giaSP = giaSP;
        this.motaSP = motaSP;
        this.hinhSP = hinhSP;
    }

    public String getMotaSP() {
        return motaSP;
    }

    public void setMotaSP(String motaSP) {
        this.motaSP = motaSP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSP() {
        return nameSP;
    }

    public void setNameSP(String nameSP) {
        this.nameSP = nameSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    public String getHinhSP() {
        return hinhSP;
    }

    public void setHinhSP(String hinhSP) {
        this.hinhSP = hinhSP;
    }

    @Override
    public String toString() {
        return getNameSP() + getGiaSP() + getHinhSP();
    }
}
