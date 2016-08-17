package com.uet.anh.tank.GUI;

import com.uet.anh.tank.common.CommonVLs;
import com.uet.anh.tank.panel.MenuPanel;
import com.uet.anh.tank.panel.StatusPanel;
import com.uet.anh.tank.panel.PlayPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tuana on 27/07/2016.
 */
public class GUI extends JFrame {
    public boolean checkPlay = false;
    private MenuPanel menu;
    private PlayPanel play;
    private StatusPanel status;
    private CommonVLs commonVLs;

    public GUI() {
        super("Game Tank");
        setLayout(null);
        setBounds(200, 200, CommonVLs.WIDTH_SCREEN, CommonVLs.HEGHT_SCREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        commonVLs = new CommonVLs();

        menu = new MenuPanel();
        menu.setGui(this);
        this.add(this.menu);

        play = new PlayPanel();
        play.setGui(this);
        play.setVisible(false);
        this.add(play);

        status = new StatusPanel();
        status.setGui(this);
        status.setVisible(false);
        this.add(this.status);

        Image imgIcon = commonVLs.getImage("IconFrame.png");
        setIconImage(imgIcon);
    }

    public void setMenu(boolean check) {
        this.menu.setVisible(check);
    }

    public void setPlay(boolean check) {
        this.play.setFocusable(check);
        this.play.setVisible(check);
    }

    public void playGame(){
        this.menu.setVisible(false);
        this.status.setVisible(true);
        this.play.setVisible(true);
        this.play.start();
    }

    public void setStatus(boolean check) {
        this.status.setVisible(check);
    }

    public void setPlaying(boolean isPlaying) {
        play.setIsPlaying(isPlaying);
    }

    public void setNewGame() {
        play.setFocusable(true);
        play.reset();
//        PlayPanel panel = new PlayPanel();
//        panel.removeAll();
//        this.add(panel);
//        panel.updateUI();
//        panel.validate();
//        panel.repaint();
        //this.validate();
        //this.repaint();
    }
}
