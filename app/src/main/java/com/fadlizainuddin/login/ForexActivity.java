package com.fadlizainuddin.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;

public class ForexActivity extends AppCompatActivity {
    private ProgressBar loadingProgressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView _usdTextView, _idrTextView, _aedTextView, _afnTextView, _allTextView, _amdTextView, _angTextView, _aoaTextView, _arsTextView, _audTextView, _awgTextView, _aznTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forex);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout1);
        _aedTextView = findViewById(R.id.aedTextView);
        _afnTextView = findViewById(R.id.afnTextView);
        _allTextView = findViewById(R.id.allTextView);
        _amdTextView = findViewById(R.id.amdTextView);
        _angTextView = findViewById(R.id.angTextView);
        _aoaTextView = findViewById(R.id.aoaTextView);
        _arsTextView = findViewById(R.id.arsTextView);
        _audTextView = findViewById(R.id.audTextView);
        _awgTextView = findViewById(R.id.awgTextView);
        _aznTextView = findViewById(R.id.aznTextView);
        _idrTextView = findViewById(R.id.idrTextView);
        _usdTextView = findViewById(R.id.usdTextView);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);

        initSwipeRefreshLayout();
        initForex();
    }

    private void initForex() {
        loadingProgressBar.setVisibility(TextView.VISIBLE);

        String url = "https://openexchangerates.org/api/latest.json?app_id=a3639d9e887c427785fb9622965c33ee";

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                RootModel rootModel = gson.fromJson(new String(responseBody), RootModel.class);
                RatesModel ratesModel = rootModel.getRatesModel();

                double aed = ratesModel.getIDR() / ratesModel.getAED();
                double afn = ratesModel.getIDR() / ratesModel.getAFN();
                double all = ratesModel.getIDR() / ratesModel.getALL();
                double amd = ratesModel.getIDR() / ratesModel.getAMD();
                double ang = ratesModel.getIDR() / ratesModel.getANG();
                double aoa = ratesModel.getIDR() / ratesModel.getAOA();
                double ars = ratesModel.getIDR() / ratesModel.getARS();
                double aud = ratesModel.getIDR() / ratesModel.getAUD();
                double awg = ratesModel.getIDR() / ratesModel.getAWG();
                double azh = ratesModel.getIDR() / ratesModel.getAZN();
                double usd = ratesModel.getIDR() / ratesModel.getUSD();
                double idr = ratesModel.getIDR();

                _aedTextView.setText(formatNumber(aed, "###,##0.##"));
                _afnTextView.setText(formatNumber(afn, "###,##0.##"));
                _allTextView.setText(formatNumber(all, "###,##0.##"));
                _amdTextView.setText(formatNumber(amd, "###,##0.##"));
                _angTextView.setText(formatNumber(ang, "###,##0.##"));
                _aoaTextView.setText(formatNumber(aoa, "###,##0.##"));
                _arsTextView.setText(formatNumber(ars, "###,##0.##"));
                _audTextView.setText(formatNumber(aud, "###,##0.##"));
                _awgTextView.setText(formatNumber(awg, "###,##0.##"));
                _aznTextView.setText(formatNumber(azh, "###,##0.##"));
                _usdTextView.setText(formatNumber(usd, "###,##0.##"));
                _idrTextView.setText(formatNumber(idr, "###,##0.##"));

                loadingProgressBar.setVisibility(TextView.INVISIBLE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                loadingProgressBar.setVisibility(TextView.INVISIBLE);
            }
        });
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            initForex();

            swipeRefreshLayout.setRefreshing(false);
        });
    }

    public String formatNumber(double number, String format) {
        DecimalFormat decimalFormat = new DecimalFormat();
        return decimalFormat.format(number);
    }
}