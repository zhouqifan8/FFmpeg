package com.demo.x86rmusic;

public class MusicPlay {

    static{
//        System.loadLibrary("avcodec");
//        System.loadLibrary("avfilter");
//        System.loadLibrary("avformat");
//        System.loadLibrary("avutil");
//        System.loadLibrary("swresample");
//        System.loadLibrary("swscale");
        System.loadLibrary("native-lib");
    }
    public native void play();

    public native void  stop();
}
