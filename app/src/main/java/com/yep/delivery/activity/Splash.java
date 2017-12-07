package com.yep.delivery.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yep.delivery.R;
import com.yep.delivery.base.BaseActivity;


public class Splash extends BaseActivity {

    private NetworkInfo mobile;
    private NetworkInfo wifi;
    private ConnectivityManager manager;
    private Intent internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(NO_ACTION_BAR,"");
//        setContentView(R.layout.l_splash);
        manager = (ConnectivityManager) Splash.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        mobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//      dialog = new Util_Dialog(Page_Splash.this, getResources().getDrawable(R.drawable.icon_warning), "인터넷 연결을 확인해주세요.","나가기", "확인", "network");

        internet = getIntent();
//        if (wifi.isConnected() || mobile.isConnected()) {

//        super.setActionBar(NO_ACTION_BAR, "");
        setContentView(R.layout.l_splash);

//        Glide.with(Splash.this).load("").asBitmap().into();
        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // 3초 후에 hd Handler 실행
//        } else if (internet.getBooleanExtra("finish", false)) {
//            moveTaskToBack(true);
//            finish();
//            android.os.Process.killProcess(android.os.Process.myPid());
//        } else {
//        dialog.show();
//        }


    }
}
