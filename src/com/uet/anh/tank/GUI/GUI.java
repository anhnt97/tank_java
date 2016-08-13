package com.uet.anh.tank.GUI;

import com.uet.anh.tank.common.CommonVLs;
import com.uet.anh.tank.panel.StatusPanel;
import com.uet.anh.tank.panel.PlayPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tuana on 27/07/2016.
 */
public class GUI extends JFrame {
    //public boolean checkPlay = false;
    //private Menu menu;
    private PlayPanel play;
    //private StatusPanel status;
    private CommonVLs commonVLs;

    public GUI() {
        super("Game Tank");
        setLayout(null);
        setBounds(200, 200, CommonVLs.WIDTH_SCREEN, CommonVLs.HEGHT_SCREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        commonVLs = new CommonVLs();

//        menu = new Menu();
//        menu.setGui(this);
//        this.add(this.menu);

        play = new PlayPanel();
        //play.setGui(this);
        //play.setVisible(false);
        this.add(play);

//        status = new StatusPanel();
//        status.setGui(this);
//        status.setVisible(false);
//        this.add(this.status);

        Image imgIcon = commonVLs.getImage("IconFrame.png");
        setIconImage(imgIcon);
    }

//    //public void setMenu() {
//        this.menu.setVisible(true);
//    }

//    public void setPlay() {
//        this.play.setVisible(true);
//    }

//    public void setStatus() {
//        this.status.setVisible(true);
//    }
}
