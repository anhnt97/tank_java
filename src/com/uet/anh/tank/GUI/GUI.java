package com.uet.anh.tank.GUI;

import com.uet.anh.tank.common.CommonVLs;
import com.uet.anh.tank.panel.ScreenPlay;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tuana on 27/07/2016.
 */
public class GUI extends JFrame {
    private ScreenPlay screenPlay = new ScreenPlay();
    private CommonVLs commonVLs = new CommonVLs();
    public GUI(){
        super("Game Tank");
        setLayout(null);
        setBounds(200,200, CommonVLs.WIDTH_SCREEN,CommonVLs.HEGHT_SCREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image imgIcon = commonVLs.getImage("IconFrame.png");
        setIconImage(imgIcon);

        add(screenPlay);
    }
}
