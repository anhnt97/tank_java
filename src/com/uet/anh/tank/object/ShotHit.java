package com.uet.anh.tank.object;

import com.uet.anh.tank.playSound.PlaySound;
import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;

import static com.uet.anh.tank.object.Tank.SIZE_TANK;

/**
 * Created by tuana on 02/08/2016.
 */
public class ShotHit {
    private PlaySound playSound = new PlaySound();
    // tank bắn chết địch
    public void shotHitTank(EnemyTankManager enemyTank, BulletManager bulletManager) {
        Rectangle rec = new Rectangle(SIZE_TANK, SIZE_TANK);
        Rectangle rec1 = new Rectangle(8 , 8);
        for (int i = 0; i < enemyTank.getArrEnemyTank().size(); i++) {
            rec.setLocation(enemyTank.getArrEnemyTank().get(i).getCoordinatesX(), enemyTank.getArrEnemyTank().get(i).getCoordinatesY());
            for (int j = 0; j < bulletManager.getArrBullet().size(); j++) {
                rec1.setLocation(bulletManager.getArrBullet().get(j).getX(), bulletManager.getArrBullet().get(j).getY());
                if (rec.intersects(rec1)) {
                    playSound.playSound("buildBouns.wav");
                    enemyTank.getArrEnemyTank().remove(i);
                    bulletManager.getArrBullet().remove(j);
                    break;
                }
            }
        }
    }
    // địch bắn chết
    public void shotHitEnemy(PlayerTank player,BulletManager bulletManager){
        Rectangle rec = new Rectangle(SIZE_TANK, SIZE_TANK);
        Rectangle rec1 = new Rectangle(8 , 8);
            rec.setLocation(player.getCoordinatesX(), player.getCoordinatesY());
            for (int i = 0; i < bulletManager.getArrBullet().size(); i++) {
                rec1.setLocation(bulletManager.getArrBullet().get(i).getX(), bulletManager.getArrBullet().get(i).getY());
                if (rec.intersects(rec1)) {
                    playSound.playSound("buildBouns.wav");
                    JOptionPane.showMessageDialog(null,"Thua rồi!","Information",JOptionPane.INFORMATION_MESSAGE);
                    bulletManager.getArrBullet().remove(i);
                    player.setCoordinatesX(50);
                    player.setCoordinatesY(50);
                    break;
                }
            }
    }

}

