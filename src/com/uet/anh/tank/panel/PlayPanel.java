package com.uet.anh.tank.panel;

import com.uet.anh.tank.GUI.GUI;
import com.uet.anh.tank.common.CommonVLs;
import com.uet.anh.tank.object.*;
import com.uet.anh.tank.object.map.MapManager;
import com.uet.anh.tank.object.map.Observe;
import com.uet.anh.tank.playSound.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by tuana on 27/07/2016.
 */
public class PlayPanel extends JPanel implements KeyListener {
    private Menu screenStart;
    // private GUI gui ;
    private PlaySound playSound;
    private ShotHit shotHit;
    private Graphics2D g2D;
    private ArrayList<EnemyTank> arrEnemy;
    private EnemyTank enemyTank;
    private EnemyTank enemyTank1;
    private EnemyTank enemyTank2;
    private EnemyTankManager enemyTankManager;
    private PlayerTank playerTank;
    private BulletManager bulletTank;
    private BulletManager bulletEnemy;

    private AnimationManager animManager;
    private Bullet bullet;
    MapManager mapManager;
    //private boolean checkTank = false;
    private boolean isPlaying;
    private int orient;

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

//    //public void setGui(GUI gui) {
//        this.gui = gui;
//    }

    public PlayPanel() {
        isPlaying = true;
        setLayout(null);
        setBounds(1, 1, CommonVLs.WIDTH_PLAY, CommonVLs.HEGHT_PLAY);
        setBackground(Color.cyan);
        initCompoments();

        thread.start();

    }

    private void initCompoments() {
        //screenStart = new Menu();
        //this.add(screenStart);
        playSound = new PlaySound();
        playerTank = new PlayerTank(200, 200);
        enemyTank = new EnemyTank();
        enemyTank1 = new EnemyTank();
        enemyTank2 = new EnemyTank();
        arrEnemy = new ArrayList<>();
        arrEnemy.add(enemyTank);
        arrEnemy.add(enemyTank1);
        arrEnemy.add(enemyTank2);

        animManager = new AnimationManager();

        bullet = new Bullet();
        enemyTankManager = new EnemyTankManager();
        bulletTank = new BulletManager();
        bulletEnemy = new BulletManager();
        enemyTankManager.setArrEnemyTank(arrEnemy);
        enemyTankManager.setBulletManager(bulletEnemy);
        shotHit = new ShotHit();

        mapManager = new MapManager();
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2D = (Graphics2D) g;
        playerTank.drawTank(g2D);
        bulletTank.drawAll(g2D);
        bulletEnemy.drawAll(g2D);
        enemyTankManager.drawAll(g2D);
        mapManager.drawAll(g2D);
        if (count % 3 == 0)
            animManager.drawAll(g2D);

    }

    private void update() {
        /**
         * check va chạm
         * nếu tank bị va chạm với tank khác
         * -> không cho tank di chuyển
         *
         * hoặc tank va chạm với đạn
         * -> new game (xét isPlaying = false)
         * hoặc hồi sinh ở vị trí khác
         */

        shotHit.shotHitTank(enemyTankManager, bulletTank, animManager);
        if (enemyTankManager.getArrEnemyTank().isEmpty()) {
            JOptionPane.showMessageDialog(null, "You win!", "congratulations", JOptionPane.INFORMATION_MESSAGE);
            isPlaying = false;
        }
        if (shotHit.shotHitEnemy(playerTank, bulletEnemy)) {
            orient = 0;
        }

        if (!mapManager.checkInsideBullet(bulletEnemy, animManager)) {
            bulletEnemy.moveAll();
        }

        if (!mapManager.checkInsideBullet(bulletTank, animManager))
            bulletTank.moveAll();

        mapManager.checkInsideEnemy(enemyTankManager);
        //enemyTankManager.moveAll();
        enemyTankManager.checkImpact();
        enemyTankManager.autoShot();
        enemyTankManager.moveAll();
        if (orient != 0) {
            switch (orient) {
                case CommonVLs.UP:
                    if (!mapManager.checkInsideTank(playerTank.getX(), playerTank.getY() - playerTank.getSpeed(),
                            playerTank.SIZE_TANK)) {
                        playerTank.moveTank(orient);
                    }
                    break;
                case CommonVLs.DOWN:
                    if (!mapManager.checkInsideTank(playerTank.getX(), playerTank.getY() + playerTank.getSpeed(),
                            playerTank.SIZE_TANK)) {
                        playerTank.moveTank(orient);
                    }
                    break;
                case CommonVLs.LEFT:
                    if (!mapManager.checkInsideTank(playerTank.getX() - playerTank.getSpeed(), playerTank.getY(),
                            playerTank.SIZE_TANK)) {
                        playerTank.moveTank(orient);
                    }
                    break;
                case CommonVLs.RIGHT:
                    if (!mapManager.checkInsideTank(playerTank.getX() + playerTank.getSpeed(),
                            playerTank.getY(),
                            playerTank.SIZE_TANK) && !playerTank.checkCrashTank(enemyTankManager)) {
                        playerTank.moveTank(orient);
                    }
                    break;
            }
        }




        // vẽ lại giao diện
        repaint();
    }
    // bien kiem soat animation
    private int count = 0;

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            playSound.playSound("enter_game.wav");
            while (isPlaying) {
                count ++;
                update();
                try {
                    // update sau một thời gian
                    Thread.sleep(17);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (count > 9999999)
                count = 0;
        }
    });

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                orient = CommonVLs.UP;
                //checkTank = true;
                break;
            case KeyEvent.VK_DOWN:
                orient = CommonVLs.DOWN;
                //checkTank = true;
                break;
            case KeyEvent.VK_LEFT:
                orient = CommonVLs.LEFT;
                //checkTank = true;
                break;
            case KeyEvent.VK_RIGHT:
                orient = CommonVLs.RIGHT;
                //checkTank = true;
                break;
            case KeyEvent.VK_SPACE:
                bulletTank.addBullet(playerTank);
                playSound.playSound("shoot.wav");

                break;
        }
        //playSound.playSound("move.wav");
        setIsPlaying(true);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        orient = 0;
    }


}

