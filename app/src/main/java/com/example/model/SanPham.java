package com.example.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int ma;
    private String ten;
    private String gia;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public SanPham() {
    }

    public SanPham(int ma, String ten, String gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }

    @Override
    public String toString() {
        return this.ten;
    }
}
