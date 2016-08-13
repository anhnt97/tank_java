package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by tuana on 27/07/2016.
 */
public class PlayerTank extends Tank {

    public PlayerTank(int x,int y) {
        super(x,y);
        this.setSpeed(SPEED_LOW);
    }

//    public void keyPress(KeyEvent e) {
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_UP:
//                this.setDirection(CommonVLs.UP);
//                break;
//            case KeyEvent.VK_DOWN:
//                this.setDirection(CommonVLs.DOWN);
//                break;
//            case KeyEvent.VK_LEFT:
//                this.setDirection(CommonVLs.LEFT);
//                break;
//            case KeyEvent.VK_RIGHT:
//                this.setDirection(CommonVLs.RIGHT);
//                break;
//        }
//    }

    @Override
    public void moveTank(int orient) {
        //if (!checkImpact())
            super.moveTank(orient);
    }


    // check va chạm giữa tank và enemy tank
    public boolean checkCrashTank(EnemyTankManager enemyTankManager) {
        Rectangle rec = new Rectangle(getX(), getY(), SIZE_TANK, SIZE_TANK);
        Rectangle rec1 = new Rectangle(SIZE_TANK, SIZE_TANK);
        for (int i = 0; i < enemyTankManager.getArrEnemyTank().size(); i++) {
            rec1.setLocation(enemyTankManager.getArrEnemyTank().get(i).getX(), enemyTankManager.getArrEnemyTank().get(i).getY());
            if (rec.intersects(rec1) || rec1.intersects(rec)) {
                System.out.println("Chạm tank");
                enemyTankManager.getArrEnemyTank().get(i).luiTank();
                return true;
            }
        }
        return false;
    }


}
