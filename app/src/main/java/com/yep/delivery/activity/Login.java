package com.yep.delivery.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yep.delivery.R;
import com.yep.delivery.base.BaseActivity;
import com.yep.delivery.util.Dialog;
import com.yep.delivery.util.U_TextWatcher;

public class Login extends BaseActivity {
    private EditText loginId, loginPw;
    private TextView loginIdCh, loginPwCh;
    private ImageView loginDeleteId, loginDeletePw;
    private RelativeLayout loginAuto;
    private ImageView loginAutoIv;
    private TextView loginAutoTv;
    private LinearLayout loginBack;
    private TextView login, loginToJoin;

    private Intent intent;
    private boolean login_auto = false;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR,"인증하기");
        setContentView(R.layout.l_login);
        find_id();
//        loginId.addTextChangedListener(new U_TextWatcher(loginId, loginDeleteId, loginIdCh, "이름"));
//        loginPw.addTextChangedListener(new U_TextWatcher(loginPw, loginDeletePw, loginPwCh, "인증번호"));

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                hide_keyboard();
                loginId.clearFocus();
                loginPw.clearFocus();
                break;
            case R.id.login_id:
                loginIdCh.setVisibility(View.INVISIBLE);
                break;
            case R.id.login_pw:
                loginPwCh.setVisibility(View.INVISIBLE);
                break;
            case R.id.login_delete_id:
                loginId.setText("");
                loginId.setHint("이름");
                loginDeleteId.setVisibility(View.INVISIBLE);
                break;
            case R.id.login_delete_pw:
                loginPw.setText("");
                loginPw.setHint("인증번호");
                loginDeletePw.setVisibility(View.INVISIBLE);
                break;
            case R.id.next:
                //@@@login@@@
                if (loginId.getText().toString().equals("test") && loginPw.getText().toString().equals("11aa")) {
                    intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else if (loginId.getText().toString().equals("") || loginPw.getText().toString().equals("")) {
                    if (!loginId.getText().toString().equals("")) {
                        loginPwCh.setVisibility(View.VISIBLE);
                    } else if (!loginPw.getText().toString().equals("")) {
                        loginIdCh.setVisibility(View.VISIBLE);
                    } else {
                        loginIdCh.setVisibility(View.VISIBLE);
                        loginPwCh.setVisibility(View.VISIBLE);
                    }
                } else {
                    dialog = new Dialog(Login.this, "인증하기", "");
                    dialog.show();
                }
                break;
        }

    }


    void hide_keyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(loginId.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(loginPw.getWindowToken(), 0);
    }

    void find_id() {
        loginId = (EditText)findViewById(R.id.login_id);
        loginPw = (EditText)findViewById(R.id.login_pw);
        loginDeleteId =(ImageView)findViewById(R.id.login_delete_id);
        loginDeletePw =(ImageView)findViewById(R.id.login_delete_pw);
    }

}
