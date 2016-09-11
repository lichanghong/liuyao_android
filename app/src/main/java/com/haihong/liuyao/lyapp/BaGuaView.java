package com.haihong.liuyao.lyapp;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by lichanghong on 5/29/16.
 */
public class BaGuaView extends LinearLayout {
    YYView _yyview1;
    YYView _yyview2;
    YYView _yyview3;
    YYView _yyview4;
    YYView _yyview5;
    YYView _yyview6;
    boolean isBianyao;
    BaGuaView baguaview;
    ArrayList<YYView>viewArr;

    private BaGuaOnClickListener onClickListen;

    public BaGuaView(Context context) {
        super(context);


    }
    public void setOnClickListener(BaGuaOnClickListener l)
    {
        this.onClickListen = l;
    }

    public void clearBianAtIndex(int index)
    {
        YYView view = viewArr.get(index);
        view.changeToBianYao(false);
    }
    public BaGuaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public BaGuaView(Context context,AttributeSet attributeSet)
    {
        super(context, attributeSet);
        // TODO Auto-generated constructor stub
        LayoutInflater.from(context).inflate(R.layout.baguaview, this);

        _yyview1 = (YYView) findViewById(R.id.yyview1);
        _yyview2 = (YYView) findViewById(R.id.yyview2);
        _yyview3 = (YYView) findViewById(R.id.yyview3);
        _yyview4 = (YYView) findViewById(R.id.yyview4);
        _yyview5 = (YYView) findViewById(R.id.yyview5);
        _yyview6 = (YYView) findViewById(R.id.yyview6);
        viewArr = new ArrayList<>();
        viewArr.add(_yyview1);
        viewArr.add(_yyview2);
        viewArr.add(_yyview3);
        viewArr.add(_yyview4);
        viewArr.add(_yyview5);
        viewArr.add(_yyview6);

        _yyview1.setIsYang(View.VISIBLE);
        _yyview2.setIsYang(View.VISIBLE);
        _yyview3.setIsYang(View.VISIBLE);
        _yyview4.setIsYang(View.VISIBLE);
        _yyview5.setIsYang(View.VISIBLE);
        _yyview6.setIsYang(View.VISIBLE);
        baguaview = this;
        _yyview1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                _yyview1.changeToBianYao(isBianyao);
                onClickYaoAtIndex(0);
            }
        });
        _yyview2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                _yyview2.changeToBianYao(isBianyao);
                onClickYaoAtIndex(1);

            }
        });
        _yyview3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                _yyview3.changeToBianYao(isBianyao);
                onClickYaoAtIndex(2);

            }
        });
        _yyview4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                _yyview4.changeToBianYao(isBianyao);
                onClickYaoAtIndex(3);

            }
        });
        _yyview5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                _yyview5.changeToBianYao(isBianyao);
                onClickYaoAtIndex(4);

            }
        });
        _yyview6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                _yyview6.changeToBianYao(isBianyao);
                onClickYaoAtIndex(5);

            }
        });
    }

    public void changeAtIndex(int index)
    {
        YYView   view= viewArr.get(index);
        view.setIsYang(view.isYang()?INVISIBLE:VISIBLE);
    }

    private void onClickYaoAtIndex(int index) {
        onClickListen.onClickAtIndex(index);
    }
}
