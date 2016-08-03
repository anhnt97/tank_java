package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by tuana on 27/07/2016.
 */
public class PlayerTank extends Tank {
    CommonVLs comon = new CommonVLs();
    private Image imgExplosion;

    public PlayerTank(int x, int y, int speed) {
        super(x, y, speed);
        imgExplosion = comon.getImage("explosion.png");
    }

    public PlayerTank() {
        super();
    }

    public void keyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
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

    // check va chạm giữa tank và enemy tank
    public boolean checkCrashTank(EnemyTankManager enemyTankManager, Graphics2D g2D) {
        Rectangle rec = new Rectangle(getCoordinatesX(), getCoordinatesY(), SIZE_TANK, SIZE_TANK);
        Rectangle rec1 = new Rectangle(SIZE_TANK, SIZE_TANK);
        for (int i = 0; i < enemyTankManager.getArrEnemyTank().size(); i++) {
            rec1.setLocation(enemyTankManager.getArrEnemyTank().get(i).getCoordinatesX(), enemyTankManager.getArrEnemyTank().get(i).getCoordinatesY());
            if (rec.intersects(rec1)) {
                return true;
            }
        }
        return false;
    }

    // vẽ ảnh nổ
    public void drawExplosion(Graphics2D g2D, int x, int y) {
        g2D.drawImage(imgExplosion, x, y, SIZE_TANK, SIZE_TANK, null);
    }
}
