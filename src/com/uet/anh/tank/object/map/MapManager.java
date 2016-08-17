package com.uet.anh.tank.object.map;

import com.uet.anh.tank.common.CommonVLs;
import com.uet.anh.tank.object.AnimationManager;
import com.uet.anh.tank.object.BulletManager;
import com.uet.anh.tank.object.EnemyTankManager;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by tuana on 07/08/2016.
 */
public class MapManager {
    private ArrayList<Observe> observes;
    int speed = 2;

    public MapManager() {
        initData();
    }

    private void initData() {
        observes = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i == 0 || j == 0 || i == 19 || j == 19)
                    observes.add(new Observe(i, j, CommonVLs.BRICK_TYPE));
            }
            observes.add(new Observe(15, 3, CommonVLs.BRICK_TYPE));
            observes.add(new Observe(10, 15, CommonVLs.BRICK_TYPE));
            observes.add(new Observe(8, 9, CommonVLs.BRICK_TYPE));
            observes.add(new Observe(12, 10, CommonVLs.BRICK_TYPE));
        }
    }

    public void drawAll(Graphics2D g2D) {
        for (int i = 0; i < observes.size(); i++) {
            observes.get(i).draw(g2D);
        }
    }

    /**
     * check va chạm giữa tank và map
     */

    public boolean checkInsideTank(int xObj, int yObj, int sizeObj) {
        for (int i = 0; i < observes.size(); i++) {
            if (observes.get(i).isObjInside(xObj, yObj, sizeObj)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Check va chạm giữa đạn với tường
     */
    public boolean checkInsideBullet(BulletManager bulletManager, AnimationManager animationManager) {
        for (int i = 0; i < bulletManager.getArrBullet().size(); i++) {
            for (int j = 0; j < observes.size(); j++) {
                if (observes.get(j).isObjInside(bulletManager.getArrBullet().get(i).getX(),
                        bulletManager.getArrBullet().get(i).getY(), bulletManager.getArrBullet().get(i).SIZE_BULLET)) {
                    animationManager.addAnim(CommonVLs.BULLET_EXPLORE,
                            bulletManager.getArrBullet().get(i).getX() - CommonVLs.ANIMATION_SIZE / 2,
                            bulletManager.getArrBullet().get(i).getY() - CommonVLs.ANIMATION_SIZE / 2);
                    bulletManager.getArrBullet().remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}
