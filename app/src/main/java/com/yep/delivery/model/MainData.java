package com.yep.delivery.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yep on 2017. 10. 13..
 */

public class MainData {

    int type;


    Context context;
    String adr, time, date, group_no, num;
    String img, name, code;

    public MainData(Context context, int type, String adr, String time, String date, String group_no, String num) {
        this.context = context;
        this.type = type;
        this.adr = adr;
        this.time = time;
        this.date = date;
        this.group_no = group_no;
        this.num = num;

    }  public MainData(Context context, int type,String img, String name, String num, String code) {
        this.context = context;
        this.type = type;
        this.name = name;
        this.img = img;
        this.num = num;
        this.code = code;

    }
    public MainData(Context context, int type,String date, String group_no) {
        this.context = context;
        this.type = type;
        this.date = date;
        this.group_no = group_no;

    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGroup_no() {
        return group_no;
    }

    public void setGroup_no(String group_no) {
        this.group_no = group_no;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }




}
