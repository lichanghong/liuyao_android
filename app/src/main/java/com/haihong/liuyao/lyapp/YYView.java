package com.haihong.liuyao.lyapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * TODO: document your custom view class.
 */
public class YYView extends FrameLayout {
    private OnClickListener onClickListener;

    FrameLayout _frameL;
    LinearLayout _yinL;
    LinearLayout _yangL;

    TextView _yin1;
    TextView _yin2;
    TextView _yin3;
    TextView _yang;
    Button   _yaobtn;
    public void setOnClickListener(OnClickListener l)
    {
        this.onClickListener = l;
    }

    public YYView(Context context) {
        super(context);
    }

    public YYView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.yyview, this);

        _yinL = (LinearLayout) findViewById(R.id.yinl);
        _yangL = (LinearLayout) findViewById(R.id.yangl);

        _yin1 = (TextView) findViewById(R.id.yin1);
        _yin2 = (TextView) findViewById(R.id.yin2);
        _yin3 = (TextView) findViewById(R.id.yin3);
        _yang = (TextView) findViewById(R.id.yang);
        _yaobtn = (Button) findViewById(R.id.yaobtn);
        _yaobtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(_yaobtn);
                if (_yangL.getVisibility() == VISIBLE)
                setIsYang(INVISIBLE);
                else setIsYang(VISIBLE);
            }
        });
    }

    public boolean isYang()
    {
        return (_yangL.getVisibility() == VISIBLE);
    }
    public void setIsYang(int isYang)
    {
        if (isYang==VISIBLE) {
            _yangL.setVisibility(VISIBLE);
            _yin1.setVisibility(INVISIBLE);
            _yin2.setVisibility(INVISIBLE);
            _yin3.setVisibility(INVISIBLE);
        }
        else
        {
            _yangL.setVisibility(INVISIBLE);
            _yin1.setVisibility(VISIBLE);
            _yin2.setVisibility(VISIBLE);
            _yin3.setVisibility(VISIBLE);
        }
    }
    public void changeToBianYao(boolean isbian)
    {
        if (isbian) {
            _yin1.setBackgroundColor(Color.BLUE);
            _yin3.setBackgroundColor(Color.BLUE);
            _yang.setBackgroundColor(Color.BLUE);
            if (isYang())
            {
                _yin2.setBackgroundColor(Color.TRANSPARENT);
            }
            else
                _yin2.setBackgroundColor(Color.BLUE);
        }
        else
        {
            _yin1.setBackgroundColor(Color.BLACK);
            _yin3.setBackgroundColor(Color.BLACK);
            _yang.setBackgroundColor(Color.BLACK);
            if (isYang())
            {
                _yin2.setBackgroundColor(Color.TRANSPARENT);
            }
            else
                _yin2.setBackgroundColor(Color.BLACK);
        }
    }



    public YYView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);





    }



}
