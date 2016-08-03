package com.uet.anh.tank.common;


import javax.swing.*;
import java.awt.*;

/**
 * Created by tuana on 27/07/2016.
 */
public class CommonVLs {
    public static final int HEGHT_SCREEN = 450;
    public static final int WIDTH_SCREEN = 600;
    public static final int HEGHT_PLAY = 400;
    public static final int WIDTH_PLAY = 400;
    public static final int HEGHT_MENU = 150;
    public static final int WIDTH_MENU = 200;

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    public Image getImage(String name){
        return new ImageIcon(getClass().getResource("/RESOURCE/Image/"+ name)).getImage();
    }
    public String getPath(String name){
        return getClass().getResource("/RESOURCE/sound/"+ name).getPath();
    }
}
