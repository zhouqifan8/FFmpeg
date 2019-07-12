package com.demo.ff86;

import android.view.Surface;

public class Player {

    static {
        System.loadLibrary("player");
    }

    public native void playVideo(String path, Surface surface);
}
