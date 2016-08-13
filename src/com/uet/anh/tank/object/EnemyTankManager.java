package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;
import com.uet.anh.tank.playSound.PlaySound;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static com.uet.anh.tank.common.CommonVLs.*;

/**
 * Created by tuana on 31/07/2016.
 */
public class EnemyTankManager {
    private PlaySound playSound;
    private long previousTime;
    private ArrayList<EnemyTank> arrEnemyTank;
    private BulletManager bulletManager;
    private Random random;

    public EnemyTankManager() {
        arrEnemyTank = new ArrayList<>();
        bulletManager = new BulletManager();
        playSound = new PlaySound();
        random = new Random();
    }

    public ArrayList<EnemyTank> getArrEnemyTank() {
        return arrEnemyTank;
    }

    public void setArrEnemyTank(ArrayList<EnemyTank> arrEnemyTank) {
        this.arrEnemyTank = arrEnemyTank;
    }

    public void setBulletManager(BulletManager bulletManager) {
        this.bulletManager = bulletManager;
    }

    /**
     * Tự động bắn đạn
     */
    public void autoShot() {
        int ramdomBullet = random.nextInt(100);
        if (ramdomBullet == 5)
            for (int i = 0; i < arrEnemyTank.size(); i++) {
                bulletManager.addBullet(arrEnemyTank.get(i));
                playSound.playSound("shoot_tank.wav");
            }
    }

    /**
     * Vẽ tank địch
     */
    public void drawAll(Graphics2D g2D) {
        for (int i = 0; i < arrEnemyTank.size(); i++) {
            arrEnemyTank.get(i).drawTank(g2D);
        }
    }

    public void checkImpact() {
        for (int i = 0; i < arrEnemyTank.size() - 1; i++) {
            for (int j = i + 1; j < arrEnemyTank.size(); j++) {
                checkCrash(arrEnemyTank.get(i), arrEnemyTank.get(j));
            }
        }
    }

    /**
     * Di chuyển tank địch
     */
    public void moveAll() {
        for (int i = 0; i < arrEnemyTank.size(); i++) {
            arrEnemyTank.get(i).moveTank();
        }
    }

    /**
     * Xử lí va chạm giữa 2 tank
     */
    public void checkCrash(EnemyTank enemy1, EnemyTank enemy2) {
        Rectangle rec = new Rectangle(enemy1.getX(), enemy1.getY(), enemy1.SIZE_TANK, enemy1.SIZE_TANK);
        Rectangle rec1 = new Rectangle(enemy2.getX(), enemy2.getY(), enemy2.SIZE_TANK, enemy2.SIZE_TANK);
        if (rec.intersects(rec1)) {
            //enemy2.luiTank();
            //enemy1.luiTank();

            System.out.println("Chạm tank rồi");
        }
    }



}
