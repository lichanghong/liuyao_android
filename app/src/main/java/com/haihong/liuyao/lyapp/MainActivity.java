package com.haihong.liuyao.lyapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import org.json.*;
import com.loopj.android.http.*;

import com.haihong.liuyao.Http.HttpUtil;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends Activity {
    BaGuaView _baguaView1;
    BaGuaView _baguaView2;
    GuaManager _guaManager;
    String[] _yaos;
    String[] _bianyaos;

    String[] liushenArr;//六神

    Button _nianzhi,_yuezhi,_rizhi,_shizhi;
    TextView guaTitle,kongzhi;
    TextView liushen1,liushen2,liushen3,liushen4,liushen5,liushen6;
    TextView wuxing1,wuxing2,wuxing3,wuxing4,wuxing5,wuxing6;
    ArrayList<TextView> shiyingArr;
    TextView shi1,shi2,shi3,shi4,shi5,shi6;
    TextView bianwuxing1,bianwuxing2,bianwuxing3,bianwuxing4,bianwuxing5,bianwuxing6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        initView();
        _guaManager = GuaManager.getInstance();
//        Log.i("test", _guaManager._guaTreeNames.get(_guaManager._guaNames.get(1)));
        createData();
        loadGanzhi();

        liushenArr = _guaManager.liushenArrWithDay("丁丑");
        liushen1.setText(liushenArr[5]);
        liushen2.setText(liushenArr[4]);
        liushen3.setText(liushenArr[3]);
        liushen4.setText(liushenArr[2]);
        liushen5.setText(liushenArr[1]);
        liushen6.setText(liushenArr[0]);

        refreshData();
        refreshBianData();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        用过用户没有手动设置时间，则loadGanzhi
        loadGanzhi();
    }

    private void createData() {
        shiyingArr = new ArrayList<>();

        _yaos = new String[]{"1","1","1","1","1","1"};
        _bianyaos =  new String[]{"1","1","1","1","1","1"};

        int index = _guaManager.chargeGuaWithYao(true,true,true,true,true,true);
        String guaName = _guaManager._guaNames[index];
        String guaValue = _guaManager._guaTreeNames.get(guaName);
        guaTitle.setText(guaValue+" 》"+ guaName);

        shiyingArr.add(shi1);
        shiyingArr.add(shi2);
        shiyingArr.add(shi3);
        shiyingArr.add(shi4);
        shiyingArr.add(shi5);
        shiyingArr.add(shi6);
    }

    private boolean isTrue(String str)
    {
        return str.equals("1")?true:false;
    }
    private void refreshData(){
        int index = _guaManager.chargeGuaWithYao(isTrue(_yaos[0]),isTrue(_yaos[1])
                ,isTrue(_yaos[2]),isTrue(_yaos[3]),isTrue(_yaos[4]), isTrue(_yaos[5]));

        String guaname = _guaManager._guaNames[index];
        String guaValue = _guaManager._guaTreeNames.get(guaname);
        guaTitle.setText(guaValue+" 》"+ guaname);

        String[] wuxings = _guaManager.wuxings.get(index);
        wuxing1.setText(wuxings[0].toString());
        wuxing2.setText(wuxings[1].toString());
        wuxing3.setText(wuxings[2].toString());
        wuxing4.setText(wuxings[3].toString());
        wuxing5.setText(wuxings[4].toString());
        wuxing6.setText(wuxings[5].toString());
        //世应
        int shiindex = 6-Integer.parseInt(wuxings[6]);
        int yingindex = 6- Integer.parseInt(wuxings[7]);

            for (int i=0;i<6; i++) {
                TextView  shilabel = shiyingArr.get(i);

                if (i != shiindex && i != yingindex) {
                    shilabel.setVisibility(View.INVISIBLE);
                } else {
                    shilabel.setVisibility(View.VISIBLE);

                    if (i == shiindex) {
                        shilabel.setText("世");
                    } else
                        shilabel.setText("应");
                }
            }
    }

    private void refreshBianData(){
        int index = _guaManager.chargeGuaWithYao(isTrue(_bianyaos[0]),isTrue(_bianyaos[1])
                ,isTrue(_bianyaos[2]),isTrue(_bianyaos[3]),isTrue(_bianyaos[4]), isTrue(_bianyaos[5]));

        String[] wuxings = _guaManager.wuxings.get(index);
        bianwuxing1.setText(wuxings[0].toString().substring(1, 3));
        bianwuxing2.setText(wuxings[1].toString().substring(1, 3));
        bianwuxing3.setText(wuxings[2].toString().substring(1, 3));
        bianwuxing4.setText(wuxings[3].toString().substring(1,3));
        bianwuxing5.setText(wuxings[4].toString().substring(1,3));
        bianwuxing6.setText(wuxings[5].toString().substring(1, 3));
    }

    private void initView() {
        guaTitle = (TextView) findViewById(R.id.guaTitle);
        _nianzhi = (Button) findViewById(R.id.nianzhi);
        _yuezhi = (Button) findViewById(R.id.yuezhi);
        _rizhi = (Button) findViewById(R.id.rizhi);
        _shizhi = (Button) findViewById(R.id.shizhi);
        kongzhi = (TextView) findViewById(R.id.kongzhi);

        _baguaView1 = (BaGuaView) findViewById(R.id.baguaV1);
        _baguaView2 = (BaGuaView) findViewById(R.id.baguaV2);
        _baguaView1.isBianyao = false;
        _baguaView2.isBianyao = true;
        _baguaView1.setOnClickListener(new BaGuaOnClickListener() {
            @Override
            public void onClickAtIndex(int index) {
            Log.i("onClickAtIndex", index + "one");
                _baguaView2.clearBianAtIndex(index);
                int  item = Integer.parseInt(_yaos[index]);
                if(item==1)
                {
                    _yaos[index] = "0";
                }
                else{
                    _yaos[index] = "1";
                }
                int  item2 = Integer.parseInt(_bianyaos[index]);
                if(item2==1)
                {
                    _bianyaos[index] = "0";
                }
                else{
                    _bianyaos[index] = "1";
                }
                _baguaView2.changeAtIndex(index);

                refreshData();
                refreshBianData();

            }


        });
        _baguaView2.setOnClickListener(new BaGuaOnClickListener() {
            @Override
            public void onClickAtIndex( int index) {
                Log.i("onClickAtIndex", index + "two");
                int  item = Integer.parseInt(_bianyaos[index]);
                if(item==1)
                {
                    _bianyaos[index] = "0";
                }
                else{
                    _bianyaos[index] = "1";
                }
                refreshBianData();
            }

        });
        liushen1 = (TextView) findViewById(R.id.liushen1);
        liushen2 = (TextView) findViewById(R.id.liushen2);
        liushen3 = (TextView) findViewById(R.id.liushen3);
        liushen4 = (TextView) findViewById(R.id.liushen4);
        liushen5 = (TextView) findViewById(R.id.liushen5);
        liushen6 = (TextView) findViewById(R.id.liushen6);
        wuxing1 = (TextView) findViewById(R.id.wuxing1);
        wuxing2 = (TextView) findViewById(R.id.wuxing2);
        wuxing3 = (TextView) findViewById(R.id.wuxing3);
        wuxing4 = (TextView) findViewById(R.id.wuxing4);
        wuxing5 = (TextView) findViewById(R.id.wuxing5);
        wuxing6 = (TextView) findViewById(R.id.wuxing6);
        shi1 = (TextView) findViewById(R.id.shi1);
        shi2 = (TextView) findViewById(R.id.shi2);
        shi3 = (TextView) findViewById(R.id.shi3);
        shi4 = (TextView) findViewById(R.id.shi4);
        shi5 = (TextView) findViewById(R.id.shi5);
        shi6 = (TextView) findViewById(R.id.shi6);
        bianwuxing1 = (TextView) findViewById(R.id.bianwuxing1);
        bianwuxing2 = (TextView) findViewById(R.id.bianwuxing2);
        bianwuxing3 = (TextView) findViewById(R.id.bianwuxing3);
        bianwuxing4 = (TextView) findViewById(R.id.bianwuxing4);
        bianwuxing5 = (TextView) findViewById(R.id.bianwuxing5);
        bianwuxing6 = (TextView) findViewById(R.id.bianwuxing6);

    }


    private void loadGanzhi()
    {
        String hostname = HttpUtil.getGanZhiURL(this);

        HttpUtil.get(hostname,new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(JSONObject response) {
                super.onSuccess(response);
                try {
                    final String nianzhi = response.getString("GanZhiYear");
                    final String yuezhi = response.getString("GanZhiMonth");
                    final String rizhi = response.getString("GanZhiDay");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            时支
                            Calendar calendar = Calendar.getInstance();
                            int hour =  calendar.get(Calendar.HOUR_OF_DAY);
                            String shiStr = "";
                            if (hour>=23 || hour<=1) {
                                shiStr = "子时";
                            }
                            else if(hour>1 && hour<3) {
                                shiStr = "丑时";
                            }
                            else if(hour>=3 && hour<5) {
                                shiStr = "寅时";
                            }
                            else if(hour>=5 && hour<7) {
                                shiStr = "卯时";
                            }
                            else if(hour>=7 && hour<9) {
                                shiStr = "辰时";
                            }
                            else if(hour>=9 && hour<11) {
                                shiStr = "巳时";
                            }
                            else if(hour>=11 && hour<13) {
                                shiStr = "午时";
                            }
                            else if(hour>=13 && hour<15) {
                                shiStr = "未时";
                            }
                            else if(hour>=15 && hour<17) {
                                shiStr = "申时";
                            }
                            else if(hour>=17 && hour<19) {
                                shiStr = "酉时";
                            }
                            else if(hour>=19 && hour<21) {
                                shiStr = "戌时";
                            }
                            else if(hour>=21 && hour<23) {
                                shiStr = "亥时";
                            }
                            SharedPreferences.Editor e = getPreferences(MODE_PRIVATE).edit();
                            e.putString("nian",nianzhi);
                            e.putString("yue",yuezhi);
                            e.putString("ri",rizhi);
                            e.putString("shi",shiStr);
                            e.commit();

                            setTextForTime(nianzhi,yuezhi,rizhi,shiStr);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                    handleTimeError();
                }
            }

            @Override
            public void onFailure(Throwable e, JSONObject errorResponse) {
                super.onFailure(e, errorResponse);
                handleTimeError();
            }
        });
    }

    private void setTextForTime(String nian,String yue,String ri,String shi) {
        _nianzhi.setText(nian);
        _yuezhi.setText(yue);
        _rizhi.setText(ri);

        liushenArr = _guaManager.liushenArrWithDay(ri);
        liushen1.setText(liushenArr[0]);
        liushen2.setText(liushenArr[1]);
        liushen3.setText(liushenArr[2]);
        liushen4.setText(liushenArr[3]);
        liushen5.setText(liushenArr[4]);
        liushen6.setText(liushenArr[5]);
        kongzhi.setText(_guaManager.kongwuWithDay(ri));
        _shizhi.setText(shi);
    }

    private void handleTimeError()
    {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        String nian=sp.getString("nian", "");
        String yue = sp.getString("yue", "");
        String ri = sp.getString("ri", "");
        String shi = sp.getString("shi", "");
        setTextForTime(nian,yue,ri,shi);
    }
}
