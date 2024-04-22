package com.cgm.hello_android_app_k15pm06;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.cgm.hello_android_app_k15pm06.entities.Product;
import com.cgm.hello_android_app_k15pm06.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.productListView);
        List<Product> productList = new ArrayList<>();

//        List<Product> productListData = Arrays.asList(
//                new Product("Sam sung galaxy s 21", 1500, "ss.jpg"),
//                new Product("Iphone 15 promax", 2000, "ip.jpg")
//        );

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/hello-web-app/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProductService productService = retrofit.create(ProductService.class);

        Call<List<Product>> call = productService.getAllProducts();//Call<List<Product>>

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(response.isSuccessful()){
                    List<Product> productListData = response.body();
                    ArrayAdapter<Product> adapter =
                            new ArrayAdapter<Product>
                                    (MainActivity.this,
                                            android.R.layout.simple_list_item_1, productListData);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });


    }
}