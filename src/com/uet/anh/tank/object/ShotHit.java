package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;
import com.uet.anh.tank.playSound.PlaySound;
import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;

import static com.uet.anh.tank.object.Tank.SIZE_TANK;

/**
 * Created by tuana on 02/08/2016.
 */
public class ShotHit {
    CommonVLs comon = new CommonVLs();
    private int x;
    private  int y;

    private PlaySound playSound = new PlaySound();
    /**
     * player bắn chết địch
     */

    public void shotHitTank(EnemyTankManager enemyTank, BulletManager bulletManager,
                            AnimationManager animationManager) {
        Rectangle rec = new Rectangle(SIZE_TANK, SIZE_TANK);
        Rectangle rec1 = new Rectangle(8 , 8);
        int count = 0;
        for (int i = 0; i < enemyTank.getArrEnemyTank().size(); i++) {
            rec.setLocation(enemyTank.getArrEnemyTank().get(i).getX(), enemyTank.getArrEnemyTank().get(i).getY());
            for (int j = 0; j < bulletManager.getArrBullet().size(); j++) {
                count++;
                rec1.setLocation(bulletManager.getArrBullet().get(j).getX(), bulletManager.getArrBullet().get(j).getY());
                if (rec.intersects(rec1)) {
                    playSound.playSound("buildBouns.wav");
                    x = (int)rec.getX();
                    y = (int)rec.getY();
                    animationManager.addAnim(CommonVLs.TANK_EXPLORE,
                            x, y );
                    enemyTank.getArrEnemyTank().remove(i);
                    bulletManager.getArrBullet().remove(j);
                    break;
                }
            }
        }
//        if (count == 0)
//            imgExplosion = comon.getImage("");
    }

    /**
     * địch bắn chết player
     */

    public boolean shotHitEnemy(PlayerTank player,BulletManager bulletManager){
        Rectangle rec = new Rectangle(SIZE_TANK, SIZE_TANK);
        Rectangle rec1 = new Rectangle(8 , 8);
            rec.setLocation(player.getX(), player.getY());
            for (int i = 0; i < bulletManager.getArrBullet().size(); i++) {
                rec1.setLocation(bulletManager.getArrBullet().get(i).getX(), bulletManager.getArrBullet().get(i).getY());
                if (rec.intersects(rec1)) {
                    playSound.playSound("buildBouns.wav");
                    JOptionPane.showMessageDialog(null,"Thua rồi!","Information",JOptionPane.INFORMATION_MESSAGE);
                    bulletManager.getArrBullet().remove(i);
                    player.setX(50);
                    player.setY(50);
                    return true;
                }
            }
            return false;
    }
    // vẽ ảnh nổ
//    public void drawExplosion(Graphics2D g2D) {
//        g2D.drawImage(imgExplosion, x, y, SIZE_TANK, SIZE_TANK, null);
//    }
}

