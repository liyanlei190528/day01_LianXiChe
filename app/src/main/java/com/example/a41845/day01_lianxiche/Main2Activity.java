package com.example.a41845.day01_lianxiche;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.a41845.day01_lianxiche.fragment.AFragment;
import com.example.a41845.day01_lianxiche.fragment.BFragment;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout mVp;
    /**
     * 列表
     */
    private Button mBtn1;
    /**
     * 收藏
     */
    private Button mBtn2;
    private ArrayList<Fragment> fragments;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private AFragment aFragment;
    private BFragment bFragment;
    private ProgressBar mPb;
    private Timer timer;
    private static final String TAG = "Main2Activity";
    private int count = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            if (msg.what ==1){

                mPb.setProgress(count++);
                Log.e(TAG, "handleMessage: "+count );
                fragmentTransaction1 = manager.beginTransaction();
                fragmentTransaction1.hide(aFragment);

                if (count == 100){
                    timer.cancel();
                    mPb.setVisibility(View.GONE);
                    fragmentTransaction1.show(bFragment);
                }else {
                    mPb.setVisibility(View.VISIBLE);
                }


                fragmentTransaction1.commit();
            }

        }
    };
    private FragmentTransaction fragmentTransaction1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        manager = getSupportFragmentManager();
        initView();
    }


    private void initView() {
        mVp = (FrameLayout) findViewById(R.id.vp);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mPb = (ProgressBar) findViewById(R.id.pb);

        aFragment = new AFragment();
        bFragment = new BFragment();


        transaction = manager.beginTransaction();
        transaction.add(R.id.vp, aFragment);
        transaction.add(R.id.vp, bFragment);
        transaction.show(aFragment);
        transaction.hide(bFragment);
        transaction.commit();



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn1:
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.show(aFragment);
                fragmentTransaction.hide(bFragment);
                fragmentTransaction.commit();
                break;
            case R.id.btn2:


                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(1);
                    }
                },100,200);


                /*for (int i = 0; i <=100 ; i++) {
                    mPb.setProgress(i);
                }*/


                break;

        }

    }
}
