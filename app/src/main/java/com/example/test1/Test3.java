package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;


public class Test3 extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    ProgressBar pb1;
    ProgressBar pb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        pb1=findViewById(R.id.pb1);
        pb2=findViewById(R.id.pb2);
        SeekBar sb = findViewById(R.id.sb1);
        sb.setOnSeekBarChangeListener(this);//设置滑动监听
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//值改变时调用
        Log.e("TEST",i+"");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {//开始滑动调用
        Log.e("TEST","开始滑动");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {//结束滑动调用
        int progress = seekBar.getProgress();//获取当前进度
        pb2.setProgress(progress);//设置进度
        if(progress==seekBar.getMax()){//获取最大值
            pb1.setVisibility(View.INVISIBLE);//设置可见性   INVISIBLE不可见占空间 VISIBLE可见   GONE不可见不占空间
        }else {
            pb1.setVisibility(View.VISIBLE);
        }
    }
}
