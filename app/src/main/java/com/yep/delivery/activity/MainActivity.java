package com.yep.delivery.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yep.delivery.R;
import com.yep.delivery.adapter.MainAdapter;
import com.yep.delivery.base.BaseActivity;
import com.yep.delivery.model.MainData;
import com.yep.delivery.util.Dialog;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private MainAdapter adapter;
    private ArrayList<MainData> item;
    private RequestManager requestManager;
    private RecyclerView recycler;
    private Dialog dialog;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR_BACK,"배송목록");
        setContentView(R.layout.l_main);
        find_id();


        item = new ArrayList<>();
        requestManager = Glide.with(this);
        adapter = new MainAdapter(item, this, requestManager);
        item.add(new MainData(MainActivity.this, 1,"서울시 강남구 테헤란로 342-33","17.10.20","A_543_112","17.10.30 23:00","총 12개"));
        item.add(new MainData(MainActivity.this, 1,"서울시 강남구 테헤란로 311","17.10.20","A_123_112","17.10.30 23:00","총 7개"));
        item.add(new MainData(MainActivity.this, 1,"서울시 강남구 선릉로 431","17.10.20","A_133_112","17.10.30 23:30","총 6개"));
        item.add(new MainData(MainActivity.this, 1,"서울시 강남구 선릉로 155","17.10.20","A_323_232","17.10.30 23:40","총 12개"));
        item.add(new MainData(MainActivity.this, 1,"서울시 강남구 역삼로 67-1","17.10.20","A_543_232","17.10.30 23:50","총 3개"));
        item.add(new MainData(MainActivity.this, 1,"서울시 강남구 역삼로 110","17.10.20","A_434_776","17.10.30 24:00","총 20개"));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

    }


    public void onClick(View view) {
        switch (view.getId()) {

        }
    }


    void find_id() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
    }
}
