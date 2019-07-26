package com.example.day02_lianxiche;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {


    private WebView mWe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();


    }


    private void initView() {
        mWe = (WebView) findViewById(R.id.we);

        Intent intent = getIntent();
        String src = intent.getStringExtra("src");
        mWe.loadUrl(src);
        mWe.setWebViewClient(new WebViewClient());
    }
}
