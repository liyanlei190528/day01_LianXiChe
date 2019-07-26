package com.example.a41845.day01_lianxiche;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//李艳雷  1812B
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 欢迎来到积云教育
     */
    private TextView mTv;
    /**
     * 跳过
     */
    private Button mBtn1;
    private ImageView mAnimImg;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mAnimImg = (ImageView) findViewById(R.id.anim_img);


         Animation animation = AnimationUtils.loadAnimation(this, R.anim.my_anim);
                 animation.setDuration(5000);
                 mAnimImg .startAnimation(animation);
                 mTv .startAnimation(animation);
           timer = new CountDownTimer(5000, 1000) {
                       @Override
                       public void onTick(final long millisUntilFinished) {
                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {

                               }
                           });

                       }

                       @Override
                       public void onFinish() {
                           startActivity(new Intent(MainActivity.this,Main2Activity.class));
                           finish();
                       }
                   }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn1:
                timer.cancel();
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                finish();
                break;
        }
    }
}
