package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TestActivity extends BasicActivity {
    private static final String TAG = "AL_TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        Log.d(TAG, "task id is " + getTaskId());
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        // 从上一个活动中获取数据
        String data = intent.getStringExtra("extra_data");
        Log.d(TAG, "extra_data:" + data);
        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setText("Test standard");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 测试standard模式,测试需修改launchMode
                Intent intent1 = new Intent(TestActivity.this, TestActivity.class);
                startActivity(intent1);
            }
        });

        Button testSingleTop = (Button)findViewById(R.id.test_singletop);
        testSingleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 测试singletop模式，测试需修改launchMode
                Intent intent1 = new Intent(TestActivity.this, NormalActivity.class);
                startActivity(intent1);
            }
        });

        Button testSingleTask = (Button)findViewById(R.id.test_singletask);
        testSingleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 测试singletask模式，测试需修改launchMode
                Intent intent1 = new Intent(TestActivity.this, NormalActivity.class);
                startActivity(intent1);
            }
        });

        Button testSingleInstance = (Button)findViewById(R.id.test_singleinstance);
        testSingleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 测试singleinstance模式，测试需修改launchMode
                Intent intent1 = new Intent(TestActivity.this, NormalActivity.class);
                startActivity(intent1);
            }
        });

        Button testFinishAll = (Button)findViewById(R.id.test_finshall);
        testFinishAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
                android.os.Process.killProcess(Process.myPid());
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}