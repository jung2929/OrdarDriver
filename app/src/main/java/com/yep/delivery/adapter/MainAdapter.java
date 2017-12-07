package com.yep.delivery.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.executor.Prioritized;
import com.yep.delivery.R;
import com.yep.delivery.activity.Detail;
import com.yep.delivery.model.MainData;

import java.util.ArrayList;

import static android.support.design.R.styleable.RecyclerView;

/**
 * Created by yep on 2017. 10. 13..
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<MainData> listViewItemList;
    private Context context;
    private int type;
    public static final int ITEM_TYPE_MAIN = 1;
    public static final int ITEM_TYPE_DETAIL = 2;
    public static final int ITEM_TYPE_TITLE = 3;
    public static final int ITEM_TYPE_MORE = 4;
    private RequestManager requestManager;
    private boolean more = false;
    private int spin_no;


    public MainAdapter(ArrayList<MainData> item, Context context, RequestManager requestManager) {
        this.context = context;
        this.listViewItemList = item;
        this.requestManager = requestManager;

    }


    @Override
    public int getItemViewType(int position) {

        if (listViewItemList.get(position).getType() == 1) {
            this.type = 1;
            return ITEM_TYPE_MAIN;
        } else if (listViewItemList.get(position).getType() == 2) {
            this.type = 2;
            return ITEM_TYPE_DETAIL;
        } else if (listViewItemList.get(position).getType() == 3) {
            this.type = 3;
            return ITEM_TYPE_TITLE;
        } else {
            this.type = 4;
            return ITEM_TYPE_MORE;
        }

    }

    /**
     * 레이아웃을 만들어서 Holer에 저장
     *
     * @param viewGroup
     * @param viewType
     * @return
     */
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view;
        if (viewType == 1) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i_main, viewGroup, false);
            return new MainAdapter.ViewHolder(view, 1);
        } else if (viewType == 2) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i_detail, viewGroup, false);
            return new MainAdapter.ViewHolder(view, 2);
        } else if (viewType == 3) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i_title, viewGroup, false);
            return new MainAdapter.ViewHolder(view, 3);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i_more, viewGroup, false);
            return new MainAdapter.ViewHolder(view, 4);
        }


    }


    @Override
    public void onBindViewHolder(final MainAdapter.ViewHolder viewHolder, final int position) {
        final int itemtype = getItemViewType(position);

        if (itemtype == ITEM_TYPE_MAIN) {
            viewHolder.back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, Detail.class);
                    context.startActivity(intent);
                }
            });
            viewHolder.adr.setText(listViewItemList.get(position).getAdr());
            viewHolder.time.setText(listViewItemList.get(position).getTime());
            viewHolder.date.setText(listViewItemList.get(position).getDate());
            viewHolder.group_no.setText(listViewItemList.get(position).getGroup_no());
            viewHolder.num.setText(listViewItemList.get(position).getNum());
        } else if (itemtype == ITEM_TYPE_DETAIL) {
//            int type,String img, String name, String num, String code)
//            Log.i("img","res : ",listViewItemList.get(position).getImg().toString());
            requestManager.load(listViewItemList.get(position).getImg()).asBitmap().into(viewHolder.product_img);
            viewHolder.name.setText(listViewItemList.get(position).getName());
            viewHolder.num.setText(listViewItemList.get(position).getNum());
            viewHolder.code.setText(listViewItemList.get(position).getCode());
        } else if (itemtype == ITEM_TYPE_TITLE) {
            viewHolder.date.setText(listViewItemList.get(position).getDate());
            viewHolder.group_no.setText(listViewItemList.get(position).getGroup_no());
        } else if (itemtype == ITEM_TYPE_MORE) {
//            requestManager.load(listViewItemList.get(position).getImg()).asBitmap().into(viewHolder.product_img);
        }


    }


    @Override
    public int getItemCount() {
        return (null != listViewItemList ? listViewItemList.size() : 0);
    }

    /**
     * 뷰 재활용을 위한 viewHolder`
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        protected RelativeLayout back;
        protected ImageView product_img;
        protected TextView adr, time, date, group_no, num;
        protected TextView name, code;


        public ViewHolder(View itemView, int type) {
            super(itemView);
            back = (RelativeLayout) itemView.findViewById(R.id.back);
            if (type == ITEM_TYPE_MAIN) {
                adr = (TextView) itemView.findViewById(R.id.adr);
                time = (TextView) itemView.findViewById(R.id.time);
                date = (TextView) itemView.findViewById(R.id.date);
                group_no = (TextView) itemView.findViewById(R.id.group_no);
                num = (TextView) itemView.findViewById(R.id.group_num);
            } else if (type == ITEM_TYPE_DETAIL) {
                product_img = (ImageView) itemView.findViewById(R.id.product_img);
                name = (TextView) itemView.findViewById(R.id.product_name);
                num = (TextView) itemView.findViewById(R.id.product_no);
                code = (TextView) itemView.findViewById(R.id.product_code);
            } else if (type == ITEM_TYPE_TITLE) {
                date = (TextView) itemView.findViewById(R.id.odar_date);
                group_no = (TextView) itemView.findViewById(R.id.odar_no);
            }
        }

    }


}

