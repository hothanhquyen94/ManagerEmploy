package com.example.unitec.quanlynhanvien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unitec.quanlynhanvien.Adapter.CustomListViewNhanVien;
import com.example.unitec.quanlynhanvien.DAO.NhanVienDAO;
import com.example.unitec.quanlynhanvien.DTO.NhanVienDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Unitec on 02/11/2017.
 */

public class NhanVienActivity extends AppCompatActivity {
    NhanVienDAO nhanVienDAO;
    List<NhanVienDTO> dsNhanVien;
    ListView listViewNhanVien;
    CustomListViewNhanVien adapter;
    LinearLayout linearNhanVien;
    int position;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nhanvien);
        LinearLayout linearLayout_nhanvien = (LinearLayout)findViewById(R.id.linearNhanVien);
        registerForContextMenu(linearLayout_nhanvien);
        listViewNhanVien = (ListView)findViewById(R.id.listNhanVien);
        nhanVienDAO = new NhanVienDAO(this);
        dsNhanVien = new ArrayList<NhanVienDTO>();
        linearNhanVien = (LinearLayout)findViewById(R.id.linearNhanVien) ;

        loadListNhanvien();
        registerForContextMenu(listViewNhanVien);
        registerForContextMenu(linearNhanVien);

        listViewNhanVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                return false;
            }
        });
    }

    private void loadListNhanvien(){
        dsNhanVien = nhanVienDAO.LoadAllNhanVien();
        adapter = new CustomListViewNhanVien(this,R.layout.custom_listview_nhanvien,dsNhanVien);
        listViewNhanVien.setAdapter(adapter);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_chucnang,menu);

        if(v.getId()==R.id.listNhanVien){
            menu.getItem(0).setVisible(false);
            menu.getItem(1).setVisible(false);
            menu.getItem(2).setVisible(false);
        }else if (v.getId()==R.id.linearNhanVien){
            menu.getItem(1).setVisible(false);
            menu.getItem(2).setVisible(false);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id ==R.id.menuThem){
            Intent intentThemNhanVien = new Intent(NhanVienActivity.this,ThemNhanVien.class);
            startActivity(intentThemNhanVien);
        }
        return super.onContextItemSelected(item);
    }

}