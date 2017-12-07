package com.yep.delivery.util;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yep on 2017. 9. 25..
 */

public class U_TextWatcher implements android.text.TextWatcher {
    private EditText et_input;
    private ImageView iv_delete;
    private TextView tv_alert;
    private String et_hint;


    public U_TextWatcher(EditText et_input, ImageView iv_delete, TextView tv_alert, String et_hint) {
        this.et_input = et_input;
        this.iv_delete = iv_delete;
        this.et_hint = et_hint;
        this.tv_alert = tv_alert;
    }

    public U_TextWatcher(EditText et_input, String et_hint) {
        this.et_input = et_input;
        this.et_hint = et_hint;

    }

    @Override
    public void afterTextChanged(Editable edit) {
        String s = edit.toString();
        if (s.length() > 0){
            iv_delete.setVisibility(View.VISIBLE);
            tv_alert.setVisibility(View.INVISIBLE);
        }
        else{
            et_input.setHint(et_hint);
            iv_delete.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
}