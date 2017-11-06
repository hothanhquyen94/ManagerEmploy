package com.example.unitec.quanlynhanvien.Adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.unitec.quanlynhanvien.DTO.NhanVienDTO;
import com.example.unitec.quanlynhanvien.DTO.PhongBanDTO;
import com.example.unitec.quanlynhanvien.R;

import java.util.List;

/**
 * Created by QuyenHT on 11/2/2017.
 */

public class Custom_Spiner_ThemNhanVien extends ArrayAdapter<PhongBanDTO> {
    Context context;
    int resource;
    List<PhongBanDTO> objects;
    public Custom_Spiner_ThemNhanVien(Context context, int resource, List<PhongBanDTO> objects) {
        super(context, resource, objects);
        this.context =context;
        this.resource =resource;
        this.objects = objects;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_layout_spiner,parent,false);
        TextView txtPhongBan = (TextView)view.findViewById(R.id.vspiner_phongban);

        PhongBanDTO phongBanDTO = objects.get(position);
        txtPhongBan.setText(String.valueOf(phongBanDTO.getTenPhongBan()));
        return view;
    }
}
