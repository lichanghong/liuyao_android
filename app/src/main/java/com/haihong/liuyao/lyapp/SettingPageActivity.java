package com.haihong.liuyao.lyapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.haihong.liuyao.lyapp.Login.LoginRegActivity;

public class SettingPageActivity extends Activity {
    Button backBtn,contactusBtn,clearchcheBtn,loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);

        initView();

        initAction();
    }

    private void initAction() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                finish();
            }
        });

        contactusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //联系我们
                android.app.AlertDialog.Builder  builder = new android.app.AlertDialog.Builder(SettingPageActivity.this);
                builder.setTitle("联系我们").setIcon(android.R.drawable.ic_dialog_info).
                        setMessage("我的QQ:1197678813\n我们的邮箱:haihong@139.com").
                        setNegativeButton("知道了", null).
                        show();
            }
        });
        clearchcheBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (false)
                {
                    //logout
                    finish();
                }
                else
                {
                    // to login
                    Intent intent = new Intent(SettingPageActivity.this, LoginRegActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void initView() {
     backBtn = (Button) findViewById(R.id.comment_backbutton);
        contactusBtn = (Button) findViewById(R.id.contactus);
        clearchcheBtn = (Button) findViewById(R.id.clearcache);
        loginBtn = (Button) findViewById(R.id.login);
        if (false)
        {
            loginBtn.setText("退出登陆");
            loginBtn.setTextColor(Color.parseColor("#FF0000"));
        }
        else
        {
            loginBtn.setText("登陆");
            loginBtn.setTextColor(Color.parseColor("#1DA645"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
