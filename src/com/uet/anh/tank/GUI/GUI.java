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

    /**
     * Back menu
     */
    public void backMenu() {
        this.pauseGame();
        this.menu.setVisible(true);
        this.play.setVisible(false);
        this.status.setVisible(false);
    }

    /**
     *   hàm dùng khi vào chơi
     */
    public void playGame(){
        System.out.println("gui: " + isFocusable());
        this.pauseGame();
//        this.menu.setFocusable(false);
        this.menu.setVisible(false);
        this.status.setVisible(true);
//        this.play.setFocusable(true);
        this.play.setVisible(true);
        this.play.start();
    }

    /**
     * Hàm dùng khi restart game
     */
    public void resetGame(){
        this.pauseGame();
        this.play.restart();
    }

    /**
     * Hàm dùng pause game
     */
    public void pauseGame(){
        this.play.pause();
    }


    public void setStatus(boolean check) {
        this.status.setVisible(check);
    }

    public void setPlaying(boolean isPlaying) {
        play.setIsPlaying(isPlaying);
    }

    public void setNewGame() {
        play.setFocusable(true);
        //play.reset();
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
