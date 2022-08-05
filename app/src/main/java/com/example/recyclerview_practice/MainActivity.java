package com.example.recyclerview_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdopterProduct productAdaptor;
    List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        productAdaptor = new AdopterProduct(generateData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(productAdaptor);
        recyclerView.setHasFixedSize(true);
        productAdaptor.setOnclick(new AdopterProduct.OnClick() {
            @Override
            public void onclick(View view, int position) {
                if(position==0) {
                    Toast.makeText(MainActivity.this, ""+products.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                }
                else if(position==1){
                    Toast.makeText(MainActivity.this, ""+products.get(position).getPrice(), Toast.LENGTH_SHORT).show();
                }else if (position==2){
                    Toast.makeText(MainActivity.this, ""+products.get(position).getPrice(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, ""+products.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    List<Product> generateData() {

        products.add(new Product("Burger", 550.0, R.drawable.burger1));
        products.add(new Product("Pizza", 200000, R.drawable.img_2));
        products.add(new Product("Pasta", 550.0, R.drawable.img_1));
        products.add(new Product("Wings", 550.0, R.drawable.img));
        return products;
    }
}