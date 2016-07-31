package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import java.awt.event.KeyEvent;

/**
 * Created by tuana on 27/07/2016.
 */
public class PlayerTank extends Tank {
    public PlayerTank(int x, int y,int speed) {
        super(x, y,speed);
    }

    public PlayerTank() {
        super();
    }
     public void keyPress(KeyEvent e){
             switch (e.getKeyCode()){
                 case KeyEvent.VK_UP:
                     this.setDirection(CommonVLs.UP);

                     break;
                 case KeyEvent.VK_DOWN:
                     this.setDirection(CommonVLs.DOWN);
                     break;
                 case KeyEvent.VK_LEFT:
                     this.setDirection(CommonVLs.LEFT);
                     break;
                 case KeyEvent.VK_RIGHT:
                     this.setDirection(CommonVLs.RIGHT);
                     break;
             }
     }

    @Override
    public void moveTank() {
        if (!checkImpact())
            super.moveTank();
    }
}
