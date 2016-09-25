package com.haihong.liuyao.lyapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.haihong.liuyao.lyapp.Help.Help;

import java.util.Calendar;

public class Client extends Activity {
    Button mBack,mHelp,mBegin,mSend;
    int mGender;//1 man ;2 woman
    EditText mQuestion,mYear,mMonth,mDay,mHour,mResult;
    String year,month,day,hour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        mBack = (Button) findViewById(R.id.client_back);
        mBegin = (Button) findViewById(R.id.client_begin);
        mSend = (Button) findViewById(R.id.client_send);
        mGender = 1;
        mQuestion = (EditText) findViewById(R.id.client_ask);
        mYear = (EditText) findViewById(R.id.client_year);
        mMonth = (EditText) findViewById(R.id.client_month);
        mDay = (EditText) findViewById(R.id.client_day);
        mHour = (EditText) findViewById(R.id.client_hour);
        mResult = (EditText) findViewById(R.id.client_result);
        mHelp = (Button) findViewById(R.id.client_help);
        initAction();
        fetchDate();
    }

    private void fetchDate()
    {
        final Calendar mCalendar=Calendar.getInstance();
        int year = mCalendar.get(Calendar.YEAR);
        int month = mCalendar.get(Calendar.MONTH)+1;
        int day = mCalendar.get(Calendar.DAY_OF_MONTH);
        int hour =mCalendar.get(Calendar.HOUR);

        mYear.setText(year+"");
        mMonth.setText(month+"");
        mDay.setText(day+"");
        mHour.setText(hour+"");
    }

    private void initAction() {
        /** 设置旋转动画 */
        final RotateAnimation animation =new RotateAnimation(0f,359f, Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(2000);//设置动画持续时间
        /** 常用方法 */
        animation.setRepeatCount(100);//设置重复次数
        animation.setFillAfter(false);//动画执行完后是否停留在执行完的状态
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Client.this, Help.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
            }
        });

        mBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder  builder = new android.app.AlertDialog.Builder(Client.this);
                if (mQuestion.getText().length()<2)
                {
                    builder.setTitle("错误").setIcon(android.R.drawable.ic_dialog_info).
                            setMessage("请填写您想要预测的事情").
                            setNegativeButton("知道了", null).
                            show();
                    return;
                }
                if (mYear.getText().length()<4 || mMonth.getText().length()<1 || mDay.getText().length()<1 || mHour.getText().length()<1)
                {
                    builder.setTitle("错误").setIcon(android.R.drawable.ic_dialog_info).
                            setMessage("请填写您预测的时间").
                            setNegativeButton("知道了", null).
                            show();
                    return;
                }



                if (!animation.hasStarted())
                {
                    /** 开始动画 */
                    animation.startNow();
                    v.startAnimation(animation);
                }

            }
        });

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //根据ID找到RadioGroup实例
        RadioGroup group = (RadioGroup) this.findViewById(R.id.client_radioGroup);
        //绑定一个匿名监听器
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) Client.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                if (rb.getText() == "男") {
                    mGender = 1;
                } else {
                    mGender = 2;
                }
            }
        });

    }


}
