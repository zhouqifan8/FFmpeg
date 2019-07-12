package com.example.y402video;

import android.view.Surface;

public class VideoPlay {
    static {
        System.loadLibrary("play");
    }

    public native void play(String path, Surface surface);
}
