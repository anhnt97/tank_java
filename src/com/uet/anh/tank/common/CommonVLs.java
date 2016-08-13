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
    public static final int HEGHT_MENU = 400;
    public static final int WIDTH_MENU = 230;

    public static final int BRICK_TYPE  = 1;

    public static final int OBSERVE_SIZE  = 20;

    public static final int TANK_EXPLORE = 1;
    public static final int BULLET_EXPLORE = 2;
    public static final int ANIMATION_SIZE = 25;

    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;

    public Image getImage(String name){
        return new ImageIcon(getClass().getResource("/RESOURCE/Image/"+ name)).getImage();
    }
    public String getPath(String name){
        return getClass().getResource("/RESOURCE/sound/"+ name).getPath();
    }
}
