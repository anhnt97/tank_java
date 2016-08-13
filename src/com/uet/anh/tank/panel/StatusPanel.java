package com.uet.anh.tank.panel;

import com.uet.anh.tank.GUI.GUI;
import com.uet.anh.tank.common.CommonVLs;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tuana on 27/07/2016.
 */
public class StatusPanel extends JPanel {
    private Menu menu;
    private GUI gui;
    private Graphics2D g2D;
    private JButton btNewGame;
    private JButton btBackMenu;
    private CommonVLs commonVLs = new CommonVLs();
    private Image imgIcon = commonVLs.getImage("icon.jpg");
    public StatusPanel(){
        setBounds(360,1,CommonVLs.WIDTH_MENU,CommonVLs.HEGHT_MENU);
        setBackground(Color.white);
        menu = new Menu();
        //this.add(menu);

    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public void drawItem(Graphics2D g2D){
        g2D.drawImage(imgIcon,60,1,150,100,null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2D = (Graphics2D) g ;
        drawItem(g2D);
    }

}
