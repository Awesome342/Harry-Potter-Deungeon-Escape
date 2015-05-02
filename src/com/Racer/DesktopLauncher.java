package com.Racer;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopLauncher {
        public static void main (String[] args) {
                new LwjglApplication(new Adventure(), "Falling Blocks", 512, 512, false);
        }
}
