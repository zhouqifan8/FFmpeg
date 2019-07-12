package com.demo.x86yvideo;

import android.view.Surface;

public class VideoPlayer {
    static {
        System.loadLibrary("play");
    }

    public native void play(String path, Surface surface);
}
