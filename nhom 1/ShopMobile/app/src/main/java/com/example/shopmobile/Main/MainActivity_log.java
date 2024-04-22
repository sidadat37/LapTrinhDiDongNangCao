package com.example.shopmobile.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopmobile.MainActivity;
import com.example.shopmobile.R;

public class MainActivity_log extends AppCompatActivity {

    TextView txtDangKy ;
    EditText editTextTaiKhoan , editTextMatKhau ;
    public  static  String tkKhach = "user";
    public  static   String mkKhach = "12345";
    public  static  String tkAdmin = "admin";
    public  static   String mkAdmin = "12345";
    public static boolean xacNhan = false;
    public static boolean xacNhanAdimn = false;
    Button btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log);
        anh_xa();
        txtDangKy_click();
        btnLog_click();

    }

    private void btnLog_click() {
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tkk = editTextTaiKhoan.getText().toString().trim();
                String mkk = editTextMatKhau.getText().toString().trim();
                //Toast.makeText(MainActivity_log.this, tkk +mkk, Toast.LENGTH_SHORT).show();
                if(tkk.equals(tkKhach) && mkk.equals(mkKhach)){
                    Toast.makeText(MainActivity_log.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    xacNhan = true;
                    startActivity(new Intent(MainActivity_log.this,MainActivity.class));
                }
                else if(tkAdmin.equals(tkk) && mkAdmin.equals(mkk)){
                    Toast.makeText(MainActivity_log.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    xacNhanAdimn = true;
                    startActivity(new Intent(MainActivity_log.this,MainActivity.class));
                }
                else {
                    Toast.makeText(MainActivity_log.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void txtDangKy_click() {
        txtDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_log.this, MainActivity_dangky.class));
            }
        });
    }

    private void anh_xa() {
        txtDangKy = (TextView) findViewById(R.id.txt_dangKy);
        editTextTaiKhoan = (EditText) findViewById(R.id.edit_text_TaiKhoan);
        editTextMatKhau = (EditText) findViewById(R.id.edit_text_MatKhau);
        btnLog = (Button) findViewById(R.id.btb_Log);
        editTextMatKhau.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

}