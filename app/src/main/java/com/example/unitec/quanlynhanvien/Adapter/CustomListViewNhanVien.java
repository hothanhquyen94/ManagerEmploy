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
import com.example.unitec.quanlynhanvien.R;

import java.util.List;

/**
 * Created by Unitec on 02/11/2017.
 */

public class CustomListViewNhanVien extends ArrayAdapter {
    Context context;
    int resource;
    List<NhanVienDTO> objects;

    public CustomListViewNhanVien(Context context,int resource,  List<NhanVienDTO> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_listview_nhanvien,parent,false);
        TextView tvTenNhanVien = (TextView)view.findViewById(R.id.txtTenNhanVien);
        TextView tvGioiTinh = (TextView)view.findViewById(R.id.txtGioitinh);
        TextView tvSDT = (TextView)view.findViewById(R.id.txtSoDienThoai);
        tvTenNhanVien.setText("Tên: "+objects.get(position).getTenNV());
        tvGioiTinh.setText("SDT: "+objects.get(position).getGioiTinhNV());
        tvSDT.setText("Giới Tính: "+objects.get(position).getSdtNV());
        return view;
    }
}
