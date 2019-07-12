package com.demo.y39music;

public class MusicPlay {

    static{
        System.loadLibrary("play");
    }
    public native void play();

    public native void  stop();
}
