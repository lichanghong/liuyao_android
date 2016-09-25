package com.haihong.liuyao.lyapp.Login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haihong.liuyao.lyapp.Help.Help;
import com.haihong.liuyao.lyapp.Help.ProtocalActivity;
import com.haihong.liuyao.lyapp.MainActivity;
import com.haihong.liuyao.lyapp.MainPageActivity;
import com.haihong.liuyao.lyapp.R;
import com.haihong.liuyao.lyapp.util.AES;
import com.haihong.liuyao.lyapp.util.LYConstants;

import java.util.HashMap;

public class Register extends Activity {
    Button mBack,mRegister,mProtocal;
    EditText mPhone,mPwd,mPwdAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initAction();
    }

    private void initAction() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**隐藏软键盘**/
                if (getCurrentFocus() != null) {
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(getCurrentFocus()
                                            .getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                }

                String phone, pwd, confirmpwd;
                phone = mPhone.getText().toString();
                pwd = mPwd.getText().toString();
                confirmpwd = mPwdAgain.getText().toString();

                if (phone.isEmpty() || !LoginRegActivity.isMobileNO(phone)) {
                    mPhone.setError("请正确输入手机号");
                    return;
                }
                if (pwd.isEmpty()) {
                    mPwd.setError("请设置您的密码");
                    return;
                }
                if (confirmpwd.isEmpty()) {
                    mPwdAgain.setError("请确认密码");
                    return;
                }
                if (!pwd.equals(confirmpwd)) {
                    mPwdAgain.setError("两次输入密码不一样");
                    return;
                }
                String encryptpwd = null;
                try {
                    encryptpwd = AES.encrypt(LYConstants.AESKey, pwd).toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("phone", phone);
                params.put("password", encryptpwd);
                params.put("registertime", String.valueOf(System.currentTimeMillis()));
                final ProgressDialog proDialog = android.app.ProgressDialog.show(Register.this, "", "注册中...");
//                RegisterManager.register(RegisterActivity.this,params,new RegisterResponse(){
//                    @Override
//                    public void register(Response response) {
//                        super.register(response);
//                        if (response.getErrno().equals("0")) {
                            Toast.makeText(Register.this, "恭喜您！注册成功", Toast.LENGTH_LONG).show();
                            finish();
                            Intent intent = new Intent(Register.this,MainPageActivity.class);
                            startActivity(intent);
                            overridePendingTransition(android.R.anim.fade_out, android.R.anim.slide_in_left);
//                        } else {
//                            Toast.makeText(Register.this, response.getErrmsg(), Toast.LENGTH_LONG).show();
//                        }
                        proDialog.cancel();
//                    }
//                });
//            }
            }
        });

        mProtocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, ProtocalActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
            }
        });
    }

    private void initView() {
        mBack = (Button) findViewById(R.id.register_back);
        mRegister = (Button) findViewById(R.id.register_btn);
        mProtocal = (Button) findViewById(R.id.protocal_btn);
        mPhone = (EditText) findViewById(R.id.register_phone);
        mPwd = (EditText) findViewById(R.id.register_pwd);
        mPwdAgain = (EditText) findViewById(R.id.register_pwd_again);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
