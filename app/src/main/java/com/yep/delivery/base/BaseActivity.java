package com.yep.delivery.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.hardware.input.InputManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

import com.yep.delivery.R;

public class BaseActivity extends AppCompatActivity {
    public final int NO_ACTION_BAR = 0;
    public final int CUSTOM_ACTION_BAR = 1;
    public final int CUSTOM_ACTION_BAR_BACK = 2;
    public final int CUSTOM_ACTION_BAR_SEARCH = 3;
    public final int CUSTOM_ACTION_BAR_EXIT = 4;
    public final int CUSTOM_ACTION_BAR_SETTING = 5;
    ImageView actionbar_back, actionbar_right, actionbar_right_extra;
    RelativeLayout actionbar_search;
    EditText actionbar_search_et;
    ImageView actionbar_search_icon;
    TextView actionbar_title;
    Intent intent;
    private int type;
    private String title;
    private View view;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));

    }

    public void setActionBar(int type, String title) {
        if (type == NO_ACTION_BAR) {
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        } else {
            ActionBar actionbar = getSupportActionBar();
            actionbar.setDisplayShowCustomEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(false);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
            actionbar.setDisplayShowTitleEnabled(false);        //액션바에 표시되는 제목의 표시유무를 설정합니다.
            actionbar.setDisplayShowHomeEnabled(false);            //홈 아이콘을 숨김처리합니다.
            View customView = LayoutInflater.from(this).inflate(R.layout.c_actionbar, null);

            actionbar_back = (ImageView) customView.findViewById(R.id.actionbar_back);
            actionbar_title = (TextView) customView.findViewById(R.id.actionbar_title);

            actionbar.setCustomView(customView);

            // 기본 padding 0
            Toolbar parent = (Toolbar) customView.getParent();
            parent.setContentInsetsAbsolute(0, 0);

            actionbar.setBackgroundDrawable(getResources().getDrawable(R.color.color_main));

            ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                    ActionBar.LayoutParams.MATCH_PARENT);
            if (type == CUSTOM_ACTION_BAR_BACK) {
                actionbar_back.setVisibility(View.VISIBLE);
                actionbar_title.setVisibility(View.VISIBLE);
                actionbar_title.setText(title);
                actionbar_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
            } else if (type == CUSTOM_ACTION_BAR_EXIT) {
                actionbar_back.setVisibility(View.INVISIBLE);
                actionbar_right.setVisibility(View.VISIBLE);
                actionbar_right_extra.setVisibility(View.INVISIBLE);
                actionbar_search.setVisibility(View.INVISIBLE);
                actionbar_search_et.setVisibility(View.INVISIBLE);
                actionbar_search_icon.setVisibility(View.INVISIBLE);
                actionbar_title.setVisibility(View.VISIBLE);
                actionbar_title.setText(title);
                actionbar_right.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            } else if (type == CUSTOM_ACTION_BAR_SETTING) {
                actionbar_back.setVisibility(View.INVISIBLE);
                actionbar_right.setVisibility(View.VISIBLE);
                actionbar_search.setVisibility(View.INVISIBLE);
                actionbar_search_et.setVisibility(View.INVISIBLE);
                actionbar_search_icon.setVisibility(View.INVISIBLE);
                actionbar_title.setVisibility(View.VISIBLE);
                actionbar_title.setText(title);
                actionbar_right.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Intent intent = new Intent(getApplicationContext(), Setting.class);
                        startActivity(intent);
                    }
                });
            }else if (type == CUSTOM_ACTION_BAR) {
                actionbar_back.setVisibility(View.INVISIBLE);
                actionbar_title.setVisibility(View.VISIBLE);
                actionbar_title.setText(title);
            } else if (type == CUSTOM_ACTION_BAR_SEARCH) {
                actionbar_back.setVisibility(View.VISIBLE);
                actionbar_right.setVisibility(View.VISIBLE);
//                actionbar_right.setBackground(getResources().getDrawable(R.drawable.actionbar_cart));
                actionbar_right_extra.setVisibility(View.INVISIBLE);
                actionbar_search.setVisibility(View.VISIBLE);
                actionbar_search_et.setVisibility(View.VISIBLE);
                actionbar_search_icon.setVisibility(View.VISIBLE);
                actionbar_title.setVisibility(View.INVISIBLE);
//                actionbar_title.setText(title);
                actionbar_right.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Intent intent = new Intent(getApplicationContext(), Cart.class);
                        startActivity(intent);
                    }
                });
                actionbar_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
                actionbar_search_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view= getCurrentFocus();
                        if(view!=null){
                            InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
//                        Intent intent = new Intent(getApplicationContext(), Product.class);
                        startActivity(intent);

                    }
                });
                actionbar_search_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        switch (actionId) {
                            case EditorInfo.IME_ACTION_SEARCH:
                                break;
                            default:
                                view= getCurrentFocus();
                                if(view!=null){
                                    InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                                }
//                                Intent intent = new Intent(getApplicationContext(), Product.class);
                                startActivity(intent);
                                return false;
                        }
                        return true;
                    }
                });


            }
        }
    }


}
