package com.uet.anh.tank.object;

import com.uet.anh.tank.playSound.PlaySound;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static com.uet.anh.tank.common.CommonVLs.*;

/**
 * Created by tuana on 31/07/2016.
 */
public class EnemyTankManager {
    private PlaySound playSound = new PlaySound();
    private long previousTime;
    private ArrayList<EnemyTank> arrEnemyTank;
    private BulletManager bulletManager;
    private Random random;

    public EnemyTankManager() {
        arrEnemyTank = new ArrayList<>();
        bulletManager = new BulletManager();
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

    public void autoShot() {
        int ramdomBullet = random.nextInt(100);
        if (ramdomBullet == 5)
            for (int i = 0; i < arrEnemyTank.size(); i++) {
                bulletManager.addBullet(arrEnemyTank.get(i));
                playSound.playSound("shoot_tank.wav");

            }

    }

    public void drawAll(Graphics2D g2D) {
        for (int i = 0; i < arrEnemyTank.size(); i++) {
            arrEnemyTank.get(i).drawTank(g2D);
        }
    }

    public boolean checkImpact() {
        for (int i = 0; i < arrEnemyTank.size(); i++) {
            for (int j = i + 1; j < arrEnemyTank.size(); j++) {
                if (checkCrash(arrEnemyTank.get(i), arrEnemyTank.get(j)))
                    return true;
                    break;
            }

        }
        return false;
    }

    public void moveAll() {
        for (int i = 0; i < arrEnemyTank.size(); i++) {
            checkImpact();
            arrEnemyTank.get(i).moveTank();
        }
    }

    /**
     *Xử lí va chạm giữa 2 tank
     */
    public boolean checkCrash(EnemyTank enemy1, EnemyTank enemy2) {
        Rectangle rec = new Rectangle(enemy1.getCoordinatesX(), enemy1.getCoordinatesY(), enemy1.SIZE_TANK, enemy1.SIZE_TANK);
        Rectangle rec1 = new Rectangle(enemy2.getCoordinatesX(), enemy2.getCoordinatesY(), enemy2.SIZE_TANK, enemy2.SIZE_TANK);

        if (rec.intersects(rec1)) {
            int randomInt = random.nextInt(4);
            int randomInt2 = random.nextInt(4);
            while (randomInt == enemy1.getDirection() || randomInt == enemy2.getDirection() || randomInt == randomInt2) {
                randomInt = random.nextInt(4);
                randomInt2 = random.nextInt(4);
            }
            enemy1.setDirection(randomInt);
            enemy2.setDirection(randomInt2);
            return true;
        }
        return false;
    }

}
