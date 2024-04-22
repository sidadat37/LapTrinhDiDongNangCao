package com.example.shopmobile.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shopmobile.Adapter.DHAdapter;
import com.example.shopmobile.Adapter.SPAdapter;
import com.example.shopmobile.Dao.DatHangDao;
import com.example.shopmobile.Dao.SanPhamDao;
import com.example.shopmobile.Model.DanHang;
import com.example.shopmobile.Model.SanPham;
import com.example.shopmobile.R;

import java.util.ArrayList;

public class MainActivity_xemHang extends AppCompatActivity {

    RecyclerView recyclerViewXemHang ;
    public static ArrayList<DanHang> spList3 ;
    public static DHAdapter dhAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_xem_hang);
        recyclerViewXemHang = (RecyclerView) findViewById(R.id.recy_MainList_add222);

        spList3 = new ArrayList<>();

        spList3 = DatHangDao.getAll(MainActivity_xemHang.this);
        // adapter
        dhAdapter = new DHAdapter(MainActivity_xemHang.this,spList3);
        recyclerViewXemHang.setHasFixedSize(true);
        recyclerViewXemHang.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewXemHang.setAdapter(dhAdapter);
        dhAdapter.notifyDataSetChanged();
    }
}