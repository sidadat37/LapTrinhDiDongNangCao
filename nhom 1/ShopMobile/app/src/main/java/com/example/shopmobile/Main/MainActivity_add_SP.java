package com.example.shopmobile.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shopmobile.Dao.SanPhamDao;
import com.example.shopmobile.MainActivity;
import com.example.shopmobile.R;
import com.squareup.picasso.Picasso;

public class MainActivity_add_SP extends AppCompatActivity {

    EditText editTextTSP , editTextGSP, editTextMTSP , editTextHSP ;
    Button buttonSave ,buttonLoad ;
    ImageView img_Sp_add ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_sp);
        inttList();
        buttonSave_click();
        btnLoad_click();
    }

    private void btnLoad_click() {
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imgSP_home = editTextHSP.getText().toString().trim();
                Picasso.get().load(imgSP_home).into(img_Sp_add);
            }
        });
    }

    private void buttonSave_click() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namSP_home = editTextTSP.getText().toString().trim();
                String giaSP_home = editTextGSP.getText().toString().trim();
                String motaSP = editTextMTSP.getText().toString().trim();
                String imgSP_home = editTextHSP.getText().toString().trim();
                //Toast.makeText(MainActivity_add_SP.this, namSP_home+ giaSP_home + imgSP_home, Toast.LENGTH_SHORT).show();
                if(SanPhamDao.insertSPDAO(MainActivity_add_SP.this,namSP_home,giaSP_home,motaSP,imgSP_home)){
                    Toast.makeText(MainActivity_add_SP.this, "THêm Thanh công", Toast.LENGTH_SHORT).show();
                    MainActivity.arrayListSPHome.clear();
                    MainActivity.arrayListSPHome.addAll(SanPhamDao.getAll(MainActivity_add_SP.this));
                    MainActivity.spAdapter.notifyDataSetChanged();
                    startActivity(new Intent(MainActivity_add_SP.this,MainActivity.class));
                }else{
                    Toast.makeText(MainActivity_add_SP.this, "Them thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inttList() {
        editTextTSP = (EditText) findViewById(R.id.edit_text_TSP);
        editTextGSP = (EditText) findViewById(R.id.edit_text_GSP);
        editTextHSP = (EditText) findViewById(R.id.edit_text_HSP);
        editTextMTSP = (EditText) findViewById(R.id.edit_text_motaSP);
        buttonSave = (Button) findViewById(R.id.btb_ThemSP);
        buttonLoad = (Button) findViewById(R.id.btn_LoadHA);
        img_Sp_add = (ImageView) findViewById(R.id.img_sanpham_load);

    }
}