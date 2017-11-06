package com.example.unitec.quanlynhanvien.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.unitec.quanlynhanvien.DTO.NhanVienDTO;
import com.example.unitec.quanlynhanvien.DTO.PhongBanDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Unitec on 02/11/2017.
 */

public class NhanVienDAO  {
    Context context;
    SQLiteDatabase sqLiteDatabase;
    Database database;

    public NhanVienDAO(Context context) {
        this.context = context;
        database = new Database(context);
    }
    public List<NhanVienDTO> LoadAllNhanVien(){
        List<NhanVienDTO> list = new ArrayList<>();
        sqLiteDatabase = database.getWritableDatabase();
        String sql = " select * from "+ Database.TABLE_NHANVIEN;

        Cursor cursor =  sqLiteDatabase.rawQuery(sql,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            NhanVienDTO nhanVienDTO = new NhanVienDTO();
            nhanVienDTO.setTenNV(cursor.getString(cursor.getColumnIndex(Database.TenNV_NHANVIEN)));
            nhanVienDTO.setMaPB(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Database.MaPB_PHONGBAN))));
            nhanVienDTO.setMaNV(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Database.MaNV_NHANVIEN))));
            nhanVienDTO.setDiachiNV(cursor.getString(cursor.getColumnIndex(Database.DiaChi_NHANVIEN)));
            nhanVienDTO.setEmailNV(cursor.getString(cursor.getColumnIndex(Database.EmailNV_NHANVIEN)));
            nhanVienDTO.setGioiTinhNV(cursor.getString(cursor.getColumnIndex(Database.GioiTinhNV_NHANVIEN)));
            nhanVienDTO.setNgaysinhNV(cursor.getString(cursor.getColumnIndex(Database.NGAYSINH)));
            nhanVienDTO.setSdtNV(cursor.getString(cursor.getColumnIndex(Database.SDT_NHANVIEN)));
            nhanVienDTO.setLuongNV(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Database.LuongNV_NHANVIEN))));
            list.add(nhanVienDTO);
            cursor.moveToNext();
        }
        return list;
    }

    public void ThemNhanVien(NhanVienDTO nhanVienDTO){
        sqLiteDatabase = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Database.TenNV_NHANVIEN,nhanVienDTO.getTenNV());
        values.put(Database.SDT_NHANVIEN,nhanVienDTO.getSdtNV());
        values.put(Database.NGAYSINH,nhanVienDTO.getNgaysinhNV());
        values.put(Database.DiaChi_NHANVIEN,nhanVienDTO.getDiachiNV());
        values.put(Database.LuongNV_NHANVIEN,nhanVienDTO.getLuongNV());
        values.put(Database.EmailNV_NHANVIEN,nhanVienDTO.getEmailNV());
        values.put(Database.MaPB_PHONGBAN,nhanVienDTO.getMaPB());

        sqLiteDatabase.insert(Database.TABLE_NHANVIEN,null,values);
        sqLiteDatabase.close();

    }
}
