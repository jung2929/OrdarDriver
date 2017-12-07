package com.yep.delivery.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yep.delivery.R;
import com.yep.delivery.adapter.MainAdapter;
import com.yep.delivery.base.BaseActivity;
import com.yep.delivery.model.MainData;
import com.yep.delivery.util.Dialog;

import java.util.ArrayList;

public class Detail extends BaseActivity {
    private MainAdapter adapter;
    private ArrayList<MainData> item;
    private RequestManager requestManager;
    private RecyclerView recycler;
    private Dialog dialog;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR_BACK, "상세정보");
        setContentView(R.layout.l_detail);
        find_id();


        item = new ArrayList<>();
        requestManager = Glide.with(this);
        adapter = new MainAdapter(item, this, requestManager);
        item.add(new MainData(this, 3, "17.10.20", "A_112_112"));
        item.add(new MainData(this, 2, "http://image.homeplus.co.kr/UserFiles/Pressimages/69/320/121428969_0.jpg", "돼지갈비 3KG 외 5개품목", "14개", "88734"));
        item.add(new MainData(this, 4, "http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg", "야채야채야채", "35,000원", "4개"));
        item.add(new MainData(this, 3, "17.10.20", "A_123_112"));
        item.add(new MainData(this, 2, "http://image.homeplus.co.kr/UserFiles/Pressimages/97/320/120285597_0.jpg", "마늘_500G(봉) 외 5개품목", "14개", "88734"));
        item.add(new MainData(this, 4, "http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg", "야채야채야채", "35,000원", "4개"));
        item.add(new MainData(this, 3, "17.10.20", "A_133_112"));
        item.add(new MainData(this, 2, "http://images.homeplus.co.kr/goods/main/320/58/98/54/999589854.jpg", "토 호박고구마 3kg 외 7개 품목", "14개", "88734"));
        item.add(new MainData(this, 4, "http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg", "야채야채야채", "35,000원", "4개"));

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
