package com.demo.y46ffandopen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private VideoSurface mVideoSurface;
    private RelativeLayout mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoSurface = new VideoSurface(this);
        mRootView = findViewById(R.id.video_surface_layout);
        mRootView.addView(mVideoSurface);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoSurface.resumePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVideoSurface.pausePlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoSurface.stopPlayer();
    }
}
