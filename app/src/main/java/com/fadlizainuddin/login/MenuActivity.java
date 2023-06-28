package com.fadlizainuddin.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MenuActivity extends AppCompatActivity {
    private Button _mahasiswaButton, _hotelButton, _forexButton, _cuacaButton;
    private Intent _menuIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        _mahasiswaButton = findViewById(R.id.mahasiswaButton);
        _hotelButton = findViewById(R.id.hotelButton);
        _forexButton = findViewById(R.id.forexButton);
        _cuacaButton = findViewById(R.id.cuacaButton);
        _mahasiswaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncHttpClient asyncHttpClient;
                String url = "https://stmikpontianak.net/011100862/tampilMahasiswa.php";
                asyncHttpClient = new AsyncHttpClient();
                asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Toast.makeText(getApplicationContext(), "Menu Mahasiswa ", Toast.LENGTH_SHORT).show();
                        _menuIntent = new Intent(getApplicationContext(), MahasiswaActivity.class);
                        startActivity(_menuIntent);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        _hotelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Menu Hotel App ", Toast.LENGTH_SHORT).show();
                _menuIntent = new Intent(getApplicationContext(), HotelActivity.class);
                startActivity(_menuIntent);
            }
        });

        _forexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://openexchangerates.org/api/latest.json?app_id=a3639d9e887c427785fb9622965c33ee";
                AsyncHttpClient asyncHttpClient;
                asyncHttpClient = new AsyncHttpClient();
                asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Toast.makeText(getApplicationContext(), "Menu Forex App ", Toast.LENGTH_SHORT).show();
                        _menuIntent = new Intent(getApplicationContext(), ForexActivity.class);
                        startActivity(_menuIntent);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        _cuacaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.openweathermap.org/data/2.5/forecast?id=1630789&appid=e72ea467a7ed89b95c85923726893d13";
                AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
                asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Toast.makeText(getApplicationContext(), "Menu Weather App ", Toast.LENGTH_SHORT).show();
                        _menuIntent = new Intent(getApplicationContext(), CuacaActivity.class);
                        startActivity(_menuIntent);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}