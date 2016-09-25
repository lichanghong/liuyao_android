package com.haihong.liuyao.lyapp.Login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.haihong.liuyao.lyapp.R;
import com.haihong.liuyao.lyapp.util.AES;
import com.haihong.liuyao.lyapp.util.LYConstants;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginRegActivity extends Activity {
    Button mLoginBtn,mRegisterBtn,mBackBtn,mForgetBtn;
    EditText mPhoneText,mPwdText;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg);
        initView();
        initAction();

    }

    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    private void initAction() {
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mPhoneText.getText().toString().trim();
                String pwd = mPwdText.getText().toString().trim();

                if (phone.isEmpty() || !LoginRegActivity.isMobileNO(phone)) {
                    mPhoneText.setError("请正确输入手机号登陆");
                    return;
                }
                if (pwd.isEmpty() || pwd.length() < 6) {
                    mPwdText.setError("密码长度至少为6位");
                    return;
                }
                try {
                    String decrypt = AES.encrypt(LYConstants.AESKey, pwd).toString();
                    loginWith(phone, decrypt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Toast.makeText(LoginRegActivity.this,
                            "系统异常,请反馈给我们", Toast.LENGTH_LONG).show();
                }

            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginRegActivity.this, Register.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mForgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder  builder = new android.app.AlertDialog.Builder(LoginRegActivity.this);
                builder.setTitle("忘记密码？").setIcon(android.R.drawable.ic_dialog_info).
                        setMessage("发短信给我们找回密码").
                        setNegativeButton("取消", null).
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (true)//下载到配置官网手机号存在
                                {
                                    sendSMS("找回密码,我的其他联系方式是(QQ或邮箱等):","156562284495");
                                }
                                else {
                                    Toast.makeText(LoginRegActivity.this, "联系方式获得失败", Toast.LENGTH_LONG).show();
                                }
                            }
                        }).
                        show();
            }
        });
        
    }
    private void sendSMS(String smsBody,String num)
    {
        Uri smsToUri = Uri.parse("smsto:"+num);
        Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);
        intent.putExtra("sms_body", smsBody);
        startActivity(intent);
    }

    private void loginWith(String phone,String encryptpwd)
    {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("phone", phone);
        params.put("password", encryptpwd);
        final ProgressDialog proDialog = android.app.ProgressDialog.show(LoginRegActivity.this, "", "登陆中...");
//        LoginManager.login(LoginRegActivity.this, params, new LoginResponse() {
//            @Override
//            public void login(Response response) {
//                super.login(response);
//                if (response.getErrno().equals("0")) {
                    Toast.makeText(LoginRegActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
//                    loginSuccess();
//                } else {
//                    Toast.makeText(LoginActivity.this, response.getErrmsg(), Toast.LENGTH_LONG).show();
//                }
                proDialog.cancel();
        finish();
//            }
//        });
    }

    private void initView() {
        mBackBtn = (Button) findViewById(R.id.loginBackButton);
        mLoginBtn = (Button) findViewById(R.id.login_loginBtn);
        mForgetBtn = (Button) findViewById(R.id.loginForgetPwdBtn);
        mRegisterBtn = (Button) findViewById(R.id.login_registerBtn);
        mPhoneText = (EditText) findViewById(R.id.login_phone);
        mPwdText = (EditText) findViewById(R.id.login_pwd);
        mImageView = (ImageView) findViewById(R.id.loginBuaguaImage);
    }


}
