package com.example.shopmobile.Model;

import java.io.Serializable;

public class DanHang implements Serializable {
    private int idDH ;
    private String TenSPHang , tenKhang, SDT, DIaCHi ;

    public DanHang(int idDH, String tenSPHang, String tenKhang, String SDT, String DIaCHi) {
        this.idDH = idDH;
        TenSPHang = tenSPHang;
        this.tenKhang = tenKhang;
        this.SDT = SDT;
        this.DIaCHi = DIaCHi;
    }

    public int getIdDH() {
        return idDH;
    }

    public void setIdDH(int idDH) {
        this.idDH = idDH;
    }

    public String getTenSPHang() {
        return TenSPHang;
    }

    public void setTenSPHang(String tenSPHang) {
        TenSPHang = tenSPHang;
    }

    public String getTenKhang() {
        return tenKhang;
    }

    public void setTenKhang(String tenKhang) {
        this.tenKhang = tenKhang;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDIaCHi() {
        return DIaCHi;
    }

    public void setDIaCHi(String DIaCHi) {
        this.DIaCHi = DIaCHi;
    }
}
