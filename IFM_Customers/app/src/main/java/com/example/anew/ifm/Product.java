package com.example.anew.ifm;

/**
 * Created by new on 12-01-2018.
 */

public class Product {
    int idd;
    String codee;
    String pname;
    String ratepk;
    String disc_per_prod;
    int pquan;
    int kgs;
    int gms;
    int pquanx;
    int kgsx;
    int gmsx;

    public Product(int idd, String codee, String pname, String ratepk, String disc_per_prod, int pquan, int kgs, int gms, int pquanx, int kgsx, int gmsx) {
        this.idd = idd;
        this.codee = codee;
        this.pname = pname;
        this.ratepk = ratepk;
        this.disc_per_prod = disc_per_prod;
        this.pquan = pquan;
        this.kgs = kgs;
        this.gms = gms;
        this.pquanx = pquanx;
        this.kgsx = kgsx;
        this.gmsx = gmsx;
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getCodee() {
        return codee;
    }

    public void setCodee(String codee) {
        this.codee = codee;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getRatepk() {
        return ratepk;
    }

    public void setRatepk(String ratepk) {
        this.ratepk = ratepk;
    }

    public String getDisc_per_prod() {
        return disc_per_prod;
    }

    public void setDisc_per_prod(String disc_per_prod) {
        this.disc_per_prod = disc_per_prod;
    }

    public int getPquan() {
        return pquan;
    }

    public void setPquan(int pquan) {
        this.pquan = pquan;
    }

    public int getKgs() {
        return kgs;
    }

    public void setKgs(int kgs) {
        this.kgs = kgs;
    }

    public int getGms() {
        return gms;
    }

    public void setGms(int gms) {
        this.gms = gms;
    }

    public int getPquanx() {
        return pquanx;
    }

    public void setPquanx(int pquanx) {
        this.pquanx = pquanx;
    }

    public int getKgsx() {
        return kgsx;
    }

    public void setKgsx(int kgsx) {
        this.kgsx = kgsx;
    }

    public int getGmsx() {
        return gmsx;
    }

    public void setGmsx(int gmsx) {
        this.gmsx = gmsx;
    }
}
