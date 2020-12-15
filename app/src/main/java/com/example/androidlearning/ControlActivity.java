package com.example.androidlearning;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ControlActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "AL_ControlActivity";
    private static boolean isImage1 = true;

    private ImageView imageView;

    private ProgressBar progressBar;
    private ProgressBar progressBar1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        Button changeImage = (Button)findViewById(R.id.changeImage);
        imageView = (ImageView)findViewById(R.id.image_view);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        progressBar1 = (ProgressBar)findViewById(R.id.progress_bar1);
        changeImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick :" + v.getId());
        switch (v.getId()) {
            case R.id.changeImage:
                if (isImage1) {
                    imageView.setImageResource(R.drawable.img_2);
                } else {
                    imageView.setImageResource(R.drawable.img_1);
                }
                isImage1 = !isImage1;
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                int progress = progressBar1.getProgress();
                progress += 10;
                progressBar1.setProgress(progress);
                break;
            default:
                break;
        }
    }
}
