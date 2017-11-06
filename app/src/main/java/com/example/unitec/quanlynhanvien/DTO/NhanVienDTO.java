package com.example.unitec.quanlynhanvien.DTO;

/**
 * Created by Unitec on 02/11/2017.
 */

public class NhanVienDTO {
    private int maNV;
    private String tenNV;
    private String sdtNV;
    private String gioiTinhNV;
    private String ngaysinhNV;
    private String diachiNV;
    private String emailNV;
    private int  luongNV;
    private int maPB;


    public NhanVienDTO( ) {
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public String getGioiTinhNV() {
        return gioiTinhNV;
    }

    public void setGioiTinhNV(String gioiTinhNV) {
        this.gioiTinhNV = gioiTinhNV;
    }

    public String getNgaysinhNV() {
        return ngaysinhNV;
    }

    public void setNgaysinhNV(String ngaysinhNV) {
        this.ngaysinhNV = ngaysinhNV;
    }

    public String getDiachiNV() {
        return diachiNV;
    }

    public void setDiachiNV(String diachiNV) {
        this.diachiNV = diachiNV;
    }

    public String getEmailNV() {
        return emailNV;
    }

    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }

    public int getLuongNV() {
        return luongNV;
    }

    public void setLuongNV(int luongNV) {
        this.luongNV = luongNV;
    }

    public int getMaPB() {
        return maPB;
    }

    public void setMaPB(int maPB) {
        this.maPB = maPB;
    }
}
