package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Test2 extends AppCompatActivity {

    Button btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        findViewById(R.id.btn7).setOnCreateContextMenuListener(this);//设置长按显示菜单
    }

    @Override//长按菜单
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //添加新菜单项 分组(不关心可以填NONE) id必须不一样 排序(不关心填NONE)    显示信息
        menu.add(Menu.NONE,1,Menu.NONE,"博丽灵梦");
        menu.add(Menu.NONE,2,Menu.NONE,"雾雨魔理沙");
        menu.add(Menu.NONE,3,Menu.NONE,"十六夜咲夜");
        menu.add(Menu.NONE,4,Menu.NONE,"白上吹雪");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {//当长按弹出菜单选中某项时回调
        Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //添加新菜单项 分组(不关心可以填NONE) id必须不一样 排序(不关心填NONE)    显示信息
        menu.add(Menu.NONE,1,Menu.NONE,"博丽灵梦");
        menu.add(Menu.NONE,2,Menu.NONE,"雾雨魔理沙");
        menu.add(Menu.NONE,3,Menu.NONE,"十六夜咲夜");
        menu.add(Menu.NONE,4,Menu.NONE,"白上吹雪");
        return super.onCreateOptionsMenu(menu);
    }

    @Override//当菜单选中时回调
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
