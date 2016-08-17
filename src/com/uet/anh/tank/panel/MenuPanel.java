package com.uet.anh.tank.panel;

import com.uet.anh.tank.GUI.GUI;
import com.uet.anh.tank.common.CommonVLs;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by tuana on 16/08/2016.
 */
public class MenuPanel extends JPanel {
    private CommonVLs commonVLs;
    private Graphics2D g2D;
    private Image img;
    private Image imgNewGame, imgGuide, imgAuthor, imgHighScore, imgQuitGame;
    private JButton btNewGame;
    private JButton btGuide;
    private JButton btAuthor;
    private JButton btHighScore;
    private JButton btQuitGame;
    private GUI gui;

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public MenuPanel() {
        setLayout(null);
        commonVLs = new CommonVLs();
        setBackground(Color.white);
        setBounds(1, 1, CommonVLs.WIDTH_SCREEN, CommonVLs.HEGHT_SCREEN);
        img = commonVLs.getImage("Panel.png");
        imgNewGame = commonVLs.getImage("gameMoi.png");
        imgGuide = commonVLs.getImage("huongDan.png");
        imgAuthor = commonVLs.getImage("diemCao.png");
        //imgHighScore = commonVLs.getImage(".png");
        imgQuitGame = commonVLs.getImage("thoatGame.png");
        btNewGame = new JButton();
        btGuide = new JButton();
        btAuthor = new JButton();
        btQuitGame = new JButton();

        printMenu();
        action();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2D = (Graphics2D) g;
        g2D.drawImage(img, 1, 1, CommonVLs.WIDTH_SCREEN, CommonVLs.HEGHT_SCREEN, null);
    }

    public void printMenu() {
        Icon iconNewGame = new ImageIcon(imgNewGame);
        Icon iconGuide = new ImageIcon(imgGuide);
        Icon iconAuthor = new ImageIcon(imgAuthor);
        Icon iconQuitGame = new ImageIcon(imgQuitGame);
        btNewGame.setIcon(iconNewGame);
        btNewGame.setBounds(70, 150, 180, 50);

        btGuide.setIcon(iconGuide);
        btGuide.setBounds(70, 200, 180, 50);

        btAuthor.setIcon(iconAuthor);
        btAuthor.setBounds(70, 250, 180, 50);

        btQuitGame.setIcon(iconQuitGame);
        btQuitGame.setBounds(70, 300, 180, 50);


        add(btNewGame);
        add(btGuide);
        add(btAuthor);
        add(btQuitGame);
    }

    public void action() {
        btNewGame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btNewGame.setFocusable(false);
                MenuPanel.this.gui.playGame();
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
        btGuide.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btGuide.setIcon(new ImageIcon(commonVLs.getImage("huongDan1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btGuide.setIcon(new ImageIcon(commonVLs.getImage("huongDan.png")));
            }
        });

        btAuthor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btAuthor.setIcon(new ImageIcon(commonVLs.getImage("diemCao1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btAuthor.setIcon(new ImageIcon(commonVLs.getImage("diemCao.png")));
            }
        });

        btQuitGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btQuitGame.setIcon(new ImageIcon(commonVLs.getImage("thoatGame1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btQuitGame.setIcon(new ImageIcon(commonVLs.getImage("thoatGame.png")));
            }
        });
    }

    MouseAdapter adapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
        }
    };
}
