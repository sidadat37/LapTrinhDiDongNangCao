package com.example.shopmobile.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shopmobile.R;

public class MainActivity_dangky extends AppCompatActivity {

    Button btnDangKy ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dangky);
        btnDangKy = (Button) findViewById(R.id.btn_dangky);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_dangky.this,MainActivity_log.class));
            }
        });
    }
}