package com.yep.delivery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
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
//        super.setActionBar(CUSTOM_ACTION_BAR_BACK,"주문요청");
        setContentView(R.layout.l_main);
        find_id();


        item = new ArrayList<>();
        requestManager = Glide.with(this);
        adapter = new MainAdapter(item, this, requestManager);
        item.add(new MainData(this, 1,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
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
