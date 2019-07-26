package com.example.a41845.day01_lianxiche;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Main3Activity extends AppCompatActivity {

    private ImageView mImage;
    /**
     * xxxxxx
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mImage = (ImageView) findViewById(R.id.image);
        mTv = (TextView) findViewById(R.id.tv);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String desc = intent.getStringExtra("desc");
        Glide.with(this)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(mImage);
        mTv.setText(desc);
    }
}
