package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;
import com.uet.anh.tank.object.map.MapManager;
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
                EnemyTank tank = arrEnemyTank.get(i);
                bulletManager.addBullet(tank);
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

    /**
     * Check va chạm với tường và tank khác
     */

    public void checkAndMoveTank(MapManager mapManager,PlayerTank player) {
        for (int i = 0; i < arrEnemyTank.size(); i++) {
            EnemyTank tank = arrEnemyTank.get(i);
            boolean isAllowMove = true;
            switch (tank.getDirection()) {
                case CommonVLs.UP:
                    if (mapManager.checkInsideTank(tank.getX(), tank.getY() - tank.getSpeed(),
                            tank.SIZE_TANK)) {
                        isAllowMove = false;
                    }
                    break;
                case CommonVLs.DOWN:
                    if (mapManager.checkInsideTank(tank.getX(), tank.getY() + tank.getSpeed(),
                            tank.SIZE_TANK)) {
                        isAllowMove = false;
                    }
                    break;
                case CommonVLs.LEFT:
                    if (mapManager.checkInsideTank(tank.getX() - tank.getSpeed(), tank.getY(),
                            tank.SIZE_TANK)) {
                        isAllowMove = false;
                    }
                    break;
                case CommonVLs.RIGHT:
                    if (mapManager.checkInsideTank(tank.getX() + tank.getSpeed(), tank.getY(),
                            tank.SIZE_TANK)) {
                        isAllowMove = false;
                    }
                    break;
            }
            /**
             *  Check with other tank
             */

            for (int j = 0; j < arrEnemyTank.size(); j++) {
                EnemyTank tank2 = arrEnemyTank.get(j);
//                Rectangle rec = new Rectangle(tank.getX(),tank.getY(),tank.SIZE_TANK,tank.SIZE_TANK);
//                Rectangle rec2 = new Rectangle(arrEnemyTank.get(j).getX(),
//                        arrEnemyTank.get(j).getY(),tank.SIZE_TANK,tank.SIZE_TANK);
                //System.out.println("Chạm tank");
                if (tank2 != tank){
                    switch (tank.getDirection()) {
                        case CommonVLs.UP:
                            if (tank2.isObjInside(tank.getX(), tank.getY() - tank.getSpeed())) {
                                isAllowMove = false;
                                tank.setDirection(DOWN);
                            }
                            break;
                        case CommonVLs.DOWN:
                            if (tank2.isObjInside(tank.getX(), tank.getY() + tank.getSpeed())) {
                                isAllowMove = false;
                                tank.setDirection(UP);
                            }
                            break;
                        case CommonVLs.LEFT:
                            if (tank2.isObjInside(tank.getX() - tank.getSpeed(), tank.getY())) {
                                isAllowMove = false;
                                tank.setDirection(RIGHT);
                            }
                            break;
                        case CommonVLs.RIGHT:
                            if (tank2.isObjInside(tank.getX() + tank.getSpeed(), tank.getY())) {
                                isAllowMove = false;
                                tank.setDirection(LEFT);
                            }
                            break;
                    }
                }

            }

//            /**
//             * check with player
//             */
//            if (tank.isObjInside(player.getX(),player.getY())){
//                isAllowMove =false;
//            }


            if (isAllowMove) {
                tank.moveTank();
            }
        }
    }

    /**
     *  check crash with player tank
     */

    public boolean  checkPlayerTank(PlayerTank player){
        for (int i = 0; i < arrEnemyTank.size(); i++) {
            EnemyTank tank = arrEnemyTank.get(i);
            switch (tank.getDirection()) {
                case CommonVLs.UP:
                    if (player.isObjInside(tank.getX(), tank.getY() - tank.getSpeed())) {
                        return false;
                    }
                    break;
                case CommonVLs.DOWN:
                    if (player.isObjInside(tank.getX(), tank.getY() + tank.getSpeed())) {
                        return false;
                    }
                    break;
                case CommonVLs.LEFT:
                    if (player.isObjInside(tank.getX() - tank.getSpeed(), tank.getY())) {
                       return false;
                    }
                    break;
                case CommonVLs.RIGHT:
                    if (player.isObjInside(tank.getX() + tank.getSpeed(), tank.getY())) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }


    /**
     * Move all tank
     */

    public void moveAll() {
        for (int i = 0; i < arrEnemyTank.size(); i++) {
            EnemyTank tank = arrEnemyTank.get(i);
            tank.randomRun();
        }
    }

}
