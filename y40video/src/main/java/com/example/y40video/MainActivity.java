package com.example.y40video;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView = (SurfaceView) findViewById(R.id.surface_view);
        surfaceHolder = surfaceView.getHolder();
    }

    public void play(View view) {
        String videoPath = "http://47.111.2.18:8042/V2019050715260811668.mp4";
        VideoPlay videoPlay = new VideoPlay();
        videoPlay.play(videoPath, surfaceHolder.getSurface());

    }
}
