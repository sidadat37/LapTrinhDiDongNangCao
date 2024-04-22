package com.example.shopmobile.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopmobile.Dao.DatHangDao;
import com.example.shopmobile.Dao.SanPhamDao;
import com.example.shopmobile.MainActivity;
import com.example.shopmobile.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class MainActivity_gioHang extends AppCompatActivity {
    TextView txtTSP3, txtGSP3 ;
    ImageView imageViewSPGH  ;
    Button btnMuaHang ;
    EditText editTextDC ,editTextTKK , editTextSDTT ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gio_hang);
        anhXa3();
        Intent intent = getIntent();
        String tsp3 = intent.getStringExtra("TSP2");
        txtTSP3.setText("Sản Phẩm : " +tsp3);
        String giaSp3 = intent.getStringExtra("GSP2");
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtGSP3.setText("Tổng Tiền : "+ decimalFormat.format(Double.parseDouble(giaSp3)));
//        int imageSP2 = intent.getIntExtra("imageSP",123);
//        imageViewSP.setImageResource(imageSP2);
        String imgSP23 = intent.getStringExtra("IMGSP2");
        Picasso.get().load(imgSP23).into(imageViewSPGH);

        btnMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tkkk = editTextTKK.getText().toString().trim();
                String sdtt = editTextSDTT.getText().toString().trim();
                String diachi = editTextDC.getText().toString().trim();
                Toast.makeText(MainActivity_gioHang.this, tsp3 + tkkk + sdtt + diachi, Toast.LENGTH_SHORT).show();
                if(DatHangDao.insertDHDAO(MainActivity_gioHang.this,tsp3,tkkk,sdtt,diachi)){
                    Toast.makeText(MainActivity_gioHang.this, "Mua hàng thành công", Toast.LENGTH_SHORT).show();
//                    MainActivity.arrayListSPHome.clear();
//                    MainActivity.arrayListSPHome.addAll(SanPhamDao.getAll(MainActivity_gioHang.this));
//                    MainActivity.spAdapter.notifyDataSetChanged();
//                    startActivity(new Intent(MainActivity_gioHang.this,MainActivity.class));

                    MainActivity_xemHang.spList3.clear();
                    MainActivity_xemHang.spList3.addAll(DatHangDao.getAll(MainActivity_gioHang.this));
                    MainActivity_xemHang.dhAdapter.notifyDataSetChanged();
                    startActivity(new Intent(MainActivity_gioHang.this,MainActivity_listRecy.class));
                }else{
                    Toast.makeText(MainActivity_gioHang.this, "Them that bai", Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(MainActivity_gioHang.this,MainActivity.class));
            }
        });
    }

    private void anhXa3() {
        txtTSP3 = (TextView) findViewById(R.id.txt_tenthanhToan);
        txtGSP3 = (TextView) findViewById(R.id.txt_TOngTien);
        imageViewSPGH = (ImageView) findViewById(R.id.img_gioHang_img);
        btnMuaHang = (Button) findViewById(R.id.btn_MuaHang);
        editTextDC = (EditText) findViewById(R.id.edit_DiaChi);
        editTextTKK = (EditText) findViewById(R.id.edit_TKHH);
        editTextSDTT = (EditText) findViewById(R.id.edit_SDTT);

    }
}