package com.example.test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


public class Test4 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btn10).setOnClickListener(this);
        findViewById(R.id.btn11).setOnClickListener(this);
        findViewById(R.id.btn12).setOnClickListener(this);
        findViewById(R.id.btn13).setOnClickListener(this);
        findViewById(R.id.btn14).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn8://直接创建提示框
                new AlertDialog.Builder(this)//链式调用
                        .setTitle("删除数据")//设置标题
                        .setMessage("确定要删除吗?")//设置内容
                        .setNegativeButton("删除", new DialogInterface.OnClickListener() {
                            @Override//设置确定回调
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //若要使用外面的this需要加类名
                                Toast.makeText(Test4.this,"确认删除",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                            @Override//设置取消回调
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //若要使用外面的this需要加类名
                                Toast.makeText(Test4.this,"取消删除",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();//显示
                break;
            case R.id.btn9:
                final String[] items={"博丽灵梦","雾雨魔理沙","十六夜咲夜","白上吹雪"};
                new AlertDialog.Builder(this)
                        .setTitle("选择角色")//设置单选 items显示数组 默认显示项 回调
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Test4.this,items[i],Toast.LENGTH_SHORT).show();
                                dialogInterface.dismiss();//取消该窗口
                            }
                        }).show();
                break;
            case R.id.btn10:
                //加载布局文件 显示在哪   布局id    嵌入位置没有填null
                View view1 = View.inflate(this, R.layout.my_view, null);
                final EditText username = view1.findViewById(R.id.username);//获取组件信息
                final EditText password = view1.findViewById(R.id.password);
                new AlertDialog.Builder(this)
                        .setTitle("填写信息")
                        .setView(view1)//设置自定义视图
                        .setNegativeButton("取消",null)//不想要回调事件可以填空默认按钮会取消显示
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Test4.this,username.getText().toString()+":"+password.getText().toString(),Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                break;
            case R.id.btn11:
                //显示圆形加载进度不会自动消失
                final ProgressDialog show = ProgressDialog.show(this, "加载中", "玩命加载中!!!");
                new Thread(){//无法使用蓝不大表达式
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);//模拟加载
                        } catch (InterruptedException e) {

                        }
                        show.dismiss();//在线程中手动消失
                    }
                }.start();
                break;
            case R.id.btn12:
                final ProgressDialog progressDialog = new ProgressDialog(this);//创建进度提示
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//设置样式
                progressDialog.show();//显示不会自动变化
                new Thread(){
                    @Override
                    public void run() {
                        for (int i=1;i<101;i++){
                            progressDialog.setProgress(i);//设置进度
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {

                            }
                        }
                        progressDialog.dismiss();//消失
                    }
                }.start();
                break;
            case R.id.btn13://显示日期选择器
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override//设置选着回调
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {//传入选中的
                        Toast.makeText(Test4.this,i+"-"+i1+"-"+i2,Toast.LENGTH_SHORT).show();
                    }
                },0,0,0).show();//填写默认值
                break;
            case R.id.btn14://显示时间选中器
                new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override//设置时间选中回调
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {//传入选中的
                        Toast.makeText(Test4.this,i+":"+i1,Toast.LENGTH_SHORT).show();
                    }
                },0,0,true).show();//设置默认显示的时间及是否使用24小时制
                break;
        }
    }
}
