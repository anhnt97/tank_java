package com.uet.anh.tank.panel;

import com.uet.anh.tank.GUI.GUI;
import com.uet.anh.tank.common.CommonVLs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by tuana on 27/07/2016.
 */
public class StatusPanel extends JPanel {
    //private Menu menu;
    private GUI gui;
    private Graphics2D g2D;
    private JButton btNewGame;
    private JButton btBackMenu;
    private JButton btPause;
    private CommonVLs commonVLs = new CommonVLs();
    private Image imgIcon = commonVLs.getImage("icon.jpg");
    private Image imgNewGame;
    private Image imgPause;
    private Image imgBack;
    public StatusPanel(){
        setLayout(null);
        setBounds(360,1,CommonVLs.WIDTH_MENU,CommonVLs.HEGHT_MENU);
        setBackground(Color.white);
       // menu = new Menu();
        //
        // this.add(menu);

        initComponents();
        action();

    }

    private void initComponents() {
        imgNewGame = commonVLs.getImage("gameMoi.png");
        imgPause = commonVLs.getImage("bt_pause0.png");
        imgBack = commonVLs.getImage("bt_back0.png");

        btNewGame = new JButton();
        btPause = new JButton();
        btBackMenu = new JButton();
        Icon iconNewGame = new ImageIcon(imgNewGame);
        Icon iconPauseGame = new ImageIcon(imgPause);
        Icon iconBackGame = new ImageIcon(imgBack);
        btNewGame.setIcon(iconNewGame);
        btNewGame.setBounds(50, 130, 180, 50);

        btPause.setIcon(iconPauseGame);
        btPause.setBounds(50,200,180,50);

        btBackMenu.setIcon(iconBackGame);
        btBackMenu.setBounds(50,270,180,50);


        add(btNewGame);
        add(btPause);
        add(btBackMenu);
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

    public void action(){
       btNewGame.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
               btNewGame.setFocusable(false);
               gui.resetGame();
           }

           @Override
           public void mousePressed(MouseEvent e) {

           }

           @Override
           public void mouseReleased(MouseEvent e) {

           }

           @Override
           public void mouseEntered(MouseEvent e) {
               btNewGame.setIcon(new ImageIcon(commonVLs.getImage("gameMoi1.png")));
           }

           @Override
           public void mouseExited(MouseEvent e) {
               btNewGame.setIcon(new ImageIcon(commonVLs.getImage("gameMoi.png")));

           }
       });

        btPause.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btPause.setFocusable(false);
                    gui.pauseGame();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btPause.setIcon(new ImageIcon(commonVLs.getImage("bt_pause1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btPause.setIcon(new ImageIcon(commonVLs.getImage("bt_pause0.png")));

            }
        });

        btBackMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btBackMenu.setFocusable(false);
                gui.backMenu();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btBackMenu.setIcon(new ImageIcon(commonVLs.getImage("bt_back1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btBackMenu.setIcon(new ImageIcon(commonVLs.getImage("bt_back0.png")));
            }
        });
    }

}
