package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(this);//直接绑定事件
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){//多个根据id判断
            case R.id.btn1 :
                startActivity(new Intent(this,Test1.class));//快速启动界面
                break;
            case R.id.btn2 :
                startActivity(new Intent(this,Test2.class));//快速启动界面
                break;
            case R.id.btn3 :
                startActivity(new Intent(this,Test3.class));
                break;
            case R.id.btn4 :
                startActivity(new Intent(this,Test4.class));
                break;
        }
    }
}
