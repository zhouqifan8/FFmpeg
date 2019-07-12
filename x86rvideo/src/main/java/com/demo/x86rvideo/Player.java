package com.demo.x86rvideo;

import android.view.Surface;

public class Player {

    static {
//        System.loadLibrary("avcodec");
//        System.loadLibrary("avdevice");
//        System.loadLibrary("avfilter");
//        System.loadLibrary("avformat");
//        System.loadLibrary("avutil");
//        System.loadLibrary("swresample");
//        System.loadLibrary("swscale");
        System.loadLibrary("native-lib");

    }

    public native void playVideo(String path, Surface surface);
}
