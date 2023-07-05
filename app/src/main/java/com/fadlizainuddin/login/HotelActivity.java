package com.fadlizainuddin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HotelActivity extends AppCompatActivity {
    private ImageView _imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        _imageView = findViewById(R.id.imageView1);
        String imageUrl = "https://th.bing.com/th/id/R.dea882626f5a5224480590b5eeca078e?rik=GGVEwoxI%2bLU3nQ&pid=ImgRaw&r=0";
        Picasso.with(this).load(imageUrl).into(_imageView);
    }
}