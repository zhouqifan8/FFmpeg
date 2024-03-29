package com.demo.y39videoandmusic;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    Play davidPlayer;
    SurfaceView surfaceView;
    TextView mTextView, mTextCurTime;
    SeekBar mSeekBar;
    boolean isSetProgress = false;
    private static final int HIDE_CONTROL_LAYOUT = -1;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == HIDE_CONTROL_LAYOUT) {
                refreshControl();
            } else {
                //  mTextCurTime.setText(formatTime(msg.what));
                mSeekBar.setProgress(msg.what);
            }
            // mSeekBar.setProgress(msg.what);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView = (SurfaceView) findViewById(R.id.surface);
        davidPlayer = new Play();
        davidPlayer.setSurfaceView(surfaceView);
        mTextView = findViewById(R.id.textview);
        mSeekBar = findViewById(R.id.seekBar);
        mTextCurTime = findViewById(R.id.tvcur);
        init();
    }

    private void init() {
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //进度改变
                mTextCurTime.setText(formatTime(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //开始拖动
                mTextCurTime.setText(formatTime(seekBar.getProgress()));
                isSetProgress = true;
                refreshControl();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //停止拖动
                isSetProgress = false;
                davidPlayer.seekTo(seekBar.getProgress());
                refreshControl();
            }
        });
    }

    public void player(View view) {
        String videoPath = "http://47.111.2.18:8042/V2019050715260811668.mp4";
        davidPlayer.playJava(videoPath);
        // mTextView.setText(davidPlayer.getTotalTime()+"");
        if (davidPlayer.getTotalTime() != 0) {
            mTextView.setText(formatTime(davidPlayer.getTotalTime() / 1000));
            mSeekBar.setMax(davidPlayer.getTotalTime() / 1000);
            updateSeekBar();
        }
    }

    public void stop(View view) {
        davidPlayer.release();
        // Toast.makeText(MainActivity.this,davidPlayer.getTotalTime()+"",Toast.LENGTH_SHORT).show();
        //
        //  mTextView.setText(formatTime(davidPlayer.getTotalTime()/1000));
    }

    public void pause(View view) {
        davidPlayer.stop();
    }


    public void stepback(View view) {
        //快退
        davidPlayer.stepBack();
    }

    public void stepup(View view) {
        //快进
        davidPlayer.stepUp();
    }


    private String formatTime(long time) {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        return format.format(time);
    }

    //更新进度
    public void updateSeekBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Message message = new Message();
                        message.what = (int) davidPlayer.getCurrentPosition() * 1000;
                        handler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void refreshControl() {
        if (isSetProgress) {
            isSetProgress = false;
        } else {
            isSetProgress = true;
            handler.removeMessages(HIDE_CONTROL_LAYOUT);
            handler.sendEmptyMessageDelayed(HIDE_CONTROL_LAYOUT, 5000);
        }
    }
}
