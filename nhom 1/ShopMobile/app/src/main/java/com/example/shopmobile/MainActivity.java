package com.example.shopmobile;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.support.v7.widget.Toolbar;

import com.example.shopmobile.Adapter.SPAdapter;
import com.example.shopmobile.Dao.SanPhamDao;
import com.example.shopmobile.Main.MainActivity_listRecy;
import com.example.shopmobile.Main.MainActivity_log;
import com.example.shopmobile.Model.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewHome ;
    ViewFlipper viewFlipperHome ;
    public static ArrayList<SanPham> arrayListSPHome ;
    public  static SPAdapter spAdapter ;
    TextView txtSMMN ;
    Toolbar toolbarMH01 ;
    DrawerLayout drawerLayoutMH01 ;
    ViewFlipper viewFlippeMH01;
    ListView listMenu ;
    // tao menu
    ArrayList<String> arrayMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        reCySP();
        ActionBar();
        ActionViewFlipper();
        listMenu();


        txtSMMN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity_log.class));
            }
        });
    }

    private void listMenu() {
        arrayMenu = new ArrayList<>();
        arrayMenu.add("Trang chủ");
        arrayMenu.add("Sản Phẩm Mới");
        arrayMenu.add("Đăng Nhập");
        arrayMenu.add("Liên hệ");
        arrayMenu.add("Giỏ hàng");
        arrayMenu.add("Admin");
        arrayMenu.add("Đăng Xuất");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1,arrayMenu);
        listMenu.setAdapter(adapter);

        // set clicl
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0 : break;
                    case 1 : break;

                    case 2 : {
                        if (MainActivity_log.xacNhan == false){
                            startActivity(new Intent(MainActivity.this,MainActivity_log.class));
                            break;
                        }else {
                            Toast.makeText(MainActivity.this, "Bạn Đã Đăng Nhập", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                    case 5: {
                        if(MainActivity_log.xacNhanAdimn == true){
                            startActivity(new Intent(MainActivity.this,MainActivity_listRecy.class));
                            break;
                        }else {
                            Toast.makeText(MainActivity.this, "Không thể truy cập", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                    case 6: {
                        MainActivity_log.xacNhan = false;
                        MainActivity_log.xacNhanAdimn = false;
                        startActivity(new Intent(MainActivity.this,MainActivity_log.class));
                        Toast.makeText(MainActivity.this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();
                        break;
                            }
                }
            }
        });
    }

    // set danh sach
    private void reCySP() {
        arrayListSPHome = new ArrayList<>();

        arrayListSPHome = SanPhamDao.getAll(MainActivity.this);
        spAdapter = new SPAdapter(MainActivity.this,arrayListSPHome);
        recyclerViewHome.setHasFixedSize(true);
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewHome.setAdapter(spAdapter);
        spAdapter.notifyDataSetChanged();

    }

    // set menu

    // set ành quảng cáo
    private void ActionViewFlipper() {

        // tạo ảnh ảnh quảng cáo chuyển động
        int[] mangQuangCao ={R.drawable.sss,R.drawable.zzz,R.drawable.www};
        for (int i = 0 ; i < mangQuangCao.length ; i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(mangQuangCao[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlippeMH01.addView(imageView);
        }
        viewFlippeMH01.setFlipInterval(3000);
        viewFlippeMH01.setAutoStart(true);

//        Animation animationIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sile_in_right);
//        Animation animationOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sile_out_right);
//        viewFlipperMH01.setInAnimation(animationIn);
//        viewFlippeMH01.setOutAnimation(animationOut);
    }

    // set cho tool bar
    private void ActionBar() {
        setSupportActionBar(toolbarMH01);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarMH01.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbarMH01.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayoutMH01.openDrawer(GravityCompat.START);
            }
        });
    }

    // anh xa

    private void anhXa() {

        recyclerViewHome = (RecyclerView) findViewById(R.id.RecylistviewMH1);
        viewFlipperHome = (ViewFlipper) findViewById(R.id.viFx01);
        txtSMMN = (TextView) findViewById(R.id.SMMN);
        toolbarMH01 = (Toolbar) findViewById(R.id.tool_bar_mainHome);
        drawerLayoutMH01 = (DrawerLayout) findViewById(R.id.drawMH1);
        viewFlippeMH01 = (ViewFlipper) findViewById(R.id.viFx01);
        listMenu = (ListView) findViewById(R.id.listviewMH2);
    }
}