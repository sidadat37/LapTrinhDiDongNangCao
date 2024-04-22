package com.example.shopmobile.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopmobile.MainActivity;
import com.example.shopmobile.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class MainActivitydt2 extends AppCompatActivity {
    TextView txtTSP2, txtGSP2, txtMTSP2 ;
    ImageView imageViewSP ,imageViewGioHng ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitydt2);
        anhXa2();
        Intent intent = getIntent();
        
        ////
        String tsp2 = intent.getStringExtra("TSP");
        txtTSP2.setText(tsp2);
        String giaSp2 = intent.getStringExtra("GSP");
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtGSP2.setText("Giá : "+decimalFormat.format(Double.parseDouble(giaSp2)));
//        int imageSP2 = intent.getIntExtra("imageSP",123);
//        imageViewSP.setImageResource(imageSP2);
        String mtsp2 = intent.getStringExtra("MTSP");
        txtMTSP2.setText(mtsp2);
        String imgSP2 = intent.getStringExtra("IMGSP");
        Picasso.get().load(imgSP2).into(imageViewSP);
        
        // img gio hang click
        imageViewGioHng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivitydt2.this, tsp2 + giaSp2 + imgSP2, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivitydt2.this, MainActivity_gioHang.class);
                intent.putExtra("TSP2",tsp2);
                intent.putExtra("GSP2",giaSp2);
                intent.putExtra("IMGSP2",imgSP2);
                startActivity(intent);
            }
        });
    }

    // anh xa
    private void anhXa2() {
        txtTSP2 = (TextView) findViewById(R.id.textViewTSP);
        txtGSP2 = (TextView) findViewById(R.id.textViewGSP);
        txtMTSP2 = (TextView) findViewById(R.id.textViewMTSP);
        imageViewSP = (ImageView) findViewById(R.id.imageViewSP);
        imageViewGioHng = (ImageView) findViewById(R.id.img_GIoHang);

    }
}