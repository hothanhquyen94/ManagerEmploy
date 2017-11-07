package com.example.unitec.quanlynhanvien;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.unitec.quanlynhanvien.Adapter.Custom_Spiner_ThemNhanVien;
import com.example.unitec.quanlynhanvien.DAO.NhanVienDAO;
import com.example.unitec.quanlynhanvien.DAO.PhongBanDAO;
import com.example.unitec.quanlynhanvien.DTO.NhanVienDTO;
import com.example.unitec.quanlynhanvien.DTO.PhongBanDTO;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QuyenHT on 11/2/2017.
 */

public class ThemNhanVien extends AppCompatActivity {
    Spinner spinnerPhongBan;
    EditText txtTenNV,txtDiaChi,txtEmail,txtSDT,txtNgaySinh,txtLuong;
    Button bntThem,btnThoat;
    List<PhongBanDTO> listPhongBan;
    PhongBanDAO phongBanDAO;

    NhanVienDAO nhanVienDAO;
    int vitri;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themnhanvien);

        txtTenNV = (EditText)findViewById(R.id.editTenNhanVien);
        txtDiaChi = (EditText)findViewById(R.id.editDiaChi);
        txtEmail = (EditText)findViewById(R.id.editEmail);
        txtSDT = (EditText)findViewById(R.id.editSDT);
        txtNgaySinh = (EditText)findViewById(R.id.editBirthDay);
        txtLuong = (EditText)findViewById(R.id.editLuong);

        bntThem = (Button)findViewById(R.id.btndangkiNhanVien);
        btnThoat = (Button)findViewById(R.id.btnthoatdangkiNhanVien);


        phongBanDAO = new PhongBanDAO(this);
        nhanVienDAO = new NhanVienDAO(this);
        spinnerPhongBan = (Spinner)findViewById(R.id.spinner);
        listPhongBan = phongBanDAO.AllPhongBan();
        Custom_Spiner_ThemNhanVien adapter = new Custom_Spiner_ThemNhanVien(this,R.layout.custom_layout_spiner,listPhongBan);
        spinnerPhongBan.setAdapter(adapter);

        spinnerPhongBan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                vitri = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bntThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup =(RadioGroup)findViewById(R.id.radio_group);
                int rdId = radioGroup.getCheckedRadioButtonId();
                String gioitinh ="";
               // RadioButton  rdIdCheck  = (RadioButton)findViewById(rdId);
                if(rdId==R.id.rdNam){
                    gioitinh = "Nam";
                }else if (rdId==R.id.rdNu){
                    gioitinh = "Nữ";
                }

                //String gioitinh = rdIdCheck.getText().toString();
                int maPB = listPhongBan.get(vitri).getMaPhongBan();
                try{
                    NhanVienDTO nhanVienDTO = new NhanVienDTO();
                    nhanVienDTO.setEmailNV(txtEmail.getText().toString());
                    nhanVienDTO.setDiachiNV(txtDiaChi.getText().toString());
                    nhanVienDTO.setLuongNV(Integer.parseInt(txtLuong.getText().toString()));
                    nhanVienDTO.setTenNV(txtTenNV.getText().toString());
                    nhanVienDTO.setNgaysinhNV(txtNgaySinh.getText().toString());
                    nhanVienDTO.setSdtNV((txtSDT.getText().toString()));
                    nhanVienDTO.setGioiTinhNV(gioitinh);
                    nhanVienDTO.setMaPB(maPB);

                    nhanVienDAO.ThemNhanVien(nhanVienDTO);
                    Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ThemNhanVien.this,NhanVienActivity.class);
                    startActivity(intent);

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
