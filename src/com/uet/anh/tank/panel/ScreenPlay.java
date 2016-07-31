package com.uet.anh.tank.panel;

import com.uet.anh.tank.common.CommonVLs;
import com.uet.anh.tank.object.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by tuana on 27/07/2016.
 */
public class ScreenPlay extends JPanel implements KeyListener {
    private Graphics2D g2D;
    private EnemyTank enemyTank;
    private EnemyTankManager enemyTankManager;
    private PlayerTank playerTank;
    private BulletManager bulletManager;
    private Bullet bullet = new Bullet();
    private boolean checkTank = false;

    public ScreenPlay() {
        setLayout(null);
        setBounds(1, 1, CommonVLs.WIDTH_PLAY, CommonVLs.HEGHT_PLAY);
        setBackground(Color.cyan);
        playerTank = new PlayerTank();
        enemyTank = new EnemyTank();
        enemyTankManager = new EnemyTankManager();
        bulletManager = new BulletManager();
        enemyTankManager.setBulletManager(bulletManager);
        thread.start();
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2D = (Graphics2D) g;
        playerTank.drawTank(g2D);
        bulletManager.drawAll(g2D);
        enemyTank.drawTank(g2D);

    }

    long count = 0;
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                if (count % 5 == 0 && checkTank ) {
                   playerTank.moveTank();
                }
                if (count % 5 == 0){
                    enemyTank.moveTank();
                }
                count++;
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }

        }
    });

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            checkTank = true;
            playerTank.keyPress(e);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bulletManager.addBullet(playerTank);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            checkTank = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_0){
            System.out.println(playerTank.getCoordinatesX() + " " + playerTank.getCoordinatesY());
        }

    }
}
