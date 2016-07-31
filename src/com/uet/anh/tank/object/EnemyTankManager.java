package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tuana on 31/07/2016.
 */
public class EnemyTankManager {
    private ArrayList<EnemyTank> arrEnemyTank ;
    private BulletManager bulletManager ;
    private Random random;
    public EnemyTankManager (){
        arrEnemyTank = new ArrayList<>();
        bulletManager = new BulletManager();
        random = new Random();
    }

    public void setBulletManager(BulletManager bulletManager) {
        this.bulletManager = bulletManager;
    }
        public void autoShot(){
       for (int i = 0; i < arrEnemyTank.size() ; i++) {
           bulletManager.addBullet(arrEnemyTank.get(i));
       }
   }


}
