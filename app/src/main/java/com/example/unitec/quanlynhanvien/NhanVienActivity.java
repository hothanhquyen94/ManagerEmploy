package com.example.unitec.quanlynhanvien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Unitec on 02/11/2017.
 */

public class NhanVienActivity extends AppCompatActivity {
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nhanvien);
        LinearLayout linearLayout_nhanvien = (LinearLayout)findViewById(R.id.linearNhanVien);
        registerForContextMenu(linearLayout_nhanvien);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_chucnang,menu);
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