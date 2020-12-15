package com.example.androidlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NormalActivity extends BasicActivity {
    private static final String TAG = "AL_NormalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        Log.d(TAG, "task id is " + getTaskId());
        Button testSingleTop = (Button)findViewById(R.id.test_singletop1);
        testSingleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 测试singleTop模式，每次启动一次Activity，则创建一次Activity的实例
                Intent intent1 = new Intent(NormalActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}