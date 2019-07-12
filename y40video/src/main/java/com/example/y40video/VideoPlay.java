package com.example.y40video;

import android.view.Surface;

public class VideoPlay {
    static {
        System.loadLibrary("play");
    }

    public native void play(String path, Surface surface);
}
