package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;




public class Test1 extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    EditText text2;
    ImageView img1;
    CheckBox a;
    CheckBox c;
    CheckBox g;
    CheckBox n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        findViewById(R.id.btn5).setOnClickListener(this);
        text2=findViewById(R.id.text2);
        img1=findViewById(R.id.img1);
        img1.setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        a=findViewById(R.id.a);
        c=findViewById(R.id.c);
        g=findViewById(R.id.g);
        n=findViewById(R.id.n);
        a.setOnCheckedChangeListener(this);//添加状态改变监听
        c.setOnCheckedChangeListener(this);
        g.setOnCheckedChangeListener(this);
        n.setOnCheckedChangeListener(this);
    }

    boolean isOn=true;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn5:
                Toast.makeText(this, text2.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.img1:
                isOn=!isOn;
                if(isOn){//动态更改资源
                    img1.setImageResource(android.R.drawable.btn_star_big_on);//若想用系统的R类必须写类名否则使用自己的R类
                }else {
                    img1.setImageResource(android.R.drawable.btn_star_big_off);
                }
                break;
            case R.id.btn6:
                StringBuilder sb=new StringBuilder();
                if(a.isChecked()){//判断是否选中
                    sb.append(a.getText().toString()).append("\t");
                }
                if(c.isChecked()){
                    sb.append(c.getText().toString()).append("\t");
                }
                if(g.isChecked()){
                    sb.append(g.getText().toString()).append("\t");
                }
                if(n.isChecked()){
                    sb.append(n.getText().toString());
                }
                Toast.makeText(this,sb.toString(),Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {//状态改变回调方法
        String value=b?"选中":"未选中";
        Toast.makeText(this,compoundButton.getText().toString() +value,Toast.LENGTH_LONG).show();
    }
}
