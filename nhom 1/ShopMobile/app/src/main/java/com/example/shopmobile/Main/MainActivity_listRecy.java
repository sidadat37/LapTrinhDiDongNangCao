package com.example.shopmobile.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.shopmobile.Adapter.SPAdapter;
import com.example.shopmobile.Dao.SanPhamDao;
import com.example.shopmobile.Model.SanPham;
import com.example.shopmobile.R;

import java.util.ArrayList;

public class MainActivity_listRecy extends AppCompatActivity {

    Button btdAddOne ,btnXemHang;
    RecyclerView recyclerViewAddOne ;
    public static ArrayList<SanPham> spList ;
    public static SPAdapter spAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_recy);
        intt();
        btdAddOneClick();
        reCySP_List();
        btnXemHangClick();
    }

    private void btnXemHangClick() {
        btnXemHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_listRecy.this,MainActivity_xemHang.class));

            }
        });
    }

    private void reCySP_List() {
        spList = new ArrayList<>();

        spList = SanPhamDao.getAll(MainActivity_listRecy.this);
        // adapter
        spAdapter = new SPAdapter(MainActivity_listRecy.this,spList);
        recyclerViewAddOne.setHasFixedSize(true);
        recyclerViewAddOne.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewAddOne.setAdapter(spAdapter);
        spAdapter.notifyDataSetChanged();

    }

    private void btdAddOneClick() {
        btdAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_listRecy.this,MainActivity_add_SP.class));
            }
        });
    }

    // ánh xạ
    private void intt() {
        btdAddOne = (Button) findViewById(R.id.btn_add_one);
        btnXemHang = (Button) findViewById(R.id.btn_add_xemHang);

        recyclerViewAddOne = (RecyclerView) findViewById(R.id.recy_MainList_add);
    }
}