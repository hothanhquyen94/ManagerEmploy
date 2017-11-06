package com.example.unitec.quanlynhanvien.Adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by Unitec on 02/11/2017.
 */

public class CustomListViewNhanVien extends ArrayAdapter {
    public CustomListViewNhanVien(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
