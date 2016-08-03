package com.uet.anh.tank.panel;

import com.uet.anh.tank.common.CommonVLs;
import com.uet.anh.tank.object.*;
import com.uet.anh.tank.playSound.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by tuana on 27/07/2016.
 */
public class ScreenPlay extends JPanel implements KeyListener {
    private PlaySound playSound;
    private ShotHit shotHit;
    private Graphics2D g2D;
    private ArrayList<EnemyTank> arrEnemy;
    private EnemyTank enemyTank;
    private EnemyTankManager enemyTankManager;
    private PlayerTank playerTank;
    private BulletManager bulletManager;
    private BulletManager bulletEnemy;
    private Bullet bullet = new Bullet();
    private boolean checkTank = false;
    private boolean isPlaying = true;
    private int speed = 3;

    public ScreenPlay() {
        setLayout(null);
        setBounds(1, 1, CommonVLs.WIDTH_PLAY, CommonVLs.HEGHT_PLAY);
        setBackground(Color.cyan);
        playSound = new PlaySound();
        playerTank = new PlayerTank();
        enemyTank = new EnemyTank();
        arrEnemy = new ArrayList<>();
        arrEnemy.add(enemyTank);
        arrEnemy.add(new EnemyTank());
        arrEnemy.add(new EnemyTank());

        enemyTankManager = new EnemyTankManager();
        bulletManager = new BulletManager();
        bulletEnemy = new BulletManager();
        enemyTankManager.setArrEnemyTank(arrEnemy);
        enemyTankManager.setBulletManager(bulletEnemy);
        shotHit = new ShotHit();


        thread.start();
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2D = (Graphics2D) g;
        playerTank.drawTank(g2D);
        playerTank.drawExplosion(g2D, 5, 5);
        bulletManager.drawAll(g2D);
        bulletEnemy.drawAll(g2D);
        enemyTankManager.drawAll(g2D);

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

        shotHit.shotHitTank(enemyTankManager, bulletManager);
        if (enemyTankManager.getArrEnemyTank().isEmpty()) {
            JOptionPane.showMessageDialog(null, "You win!", "congratulations", JOptionPane.INFORMATION_MESSAGE);
            isPlaying = false;
        }
        shotHit.shotHitEnemy(playerTank, bulletEnemy);
        bulletManager.moveAll();
        bulletEnemy.moveAll();
        if (count % 5 == 0 && checkTank) {
            if (!playerTank.checkCrashTank(enemyTankManager, g2D))
                playerTank.moveTank();
        }
        if (count % 5 == 0) {

            enemyTankManager.checkImpact();

            enemyTankManager.moveAll();
            enemyTankManager.autoShot();

        }
        count++;
        if (count == 100000)
            count = 0;
        // vẽ lại giao diện
        repaint();
    }

    long count = 0;
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            playSound.playSound("enter_game.wav");
            while (isPlaying) {
                update();
                try {
                    // update sau một thời gian
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
            playSound.playSound("move.wav");
        }


        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bulletManager.addBullet(playerTank);
            playSound.playSound("shoot.wav");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            checkTank = false;
        }

    }

    /**
     * và 1 biến chỉ hướng (orient)
     * mỗi khi nhấn up, down, .. thì orient thay đổi theo, speed
     * mình sẽ check tank được đi hay ko ở hàm update() dựa vào speed và orient
     * speed > 0 tức là người dùng đang nhấn giữ tank di chuyển
     * speed = 0 tức là ko di chuyển
     * dựa vào orient để biết tank sẽ đi về hướng nào
     *
     */
}
