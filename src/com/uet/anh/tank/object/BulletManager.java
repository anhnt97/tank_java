package com.uet.anh.tank.object;

import com.sun.javafx.font.directwrite.RECT;
import com.uet.anh.tank.common.CommonVLs;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by tuana on 28/07/2016.
 */
public class BulletManager {
    private ArrayList<Bullet> arrBullet = new ArrayList<>();
    Image img ;

    public void setArrBullet(ArrayList<Bullet> arrBullet) {
        this.arrBullet = arrBullet;
    }
    public BulletManager(){
        CommonVLs commonVLs = new CommonVLs();
        img = commonVLs.getImage("bullet.png");
    }

    public ArrayList<Bullet> getArrBullet() {
        return arrBullet;
    }

    public void drawAll(Graphics2D g2D){
        for (int i = 0; i < arrBullet.size() ; i++) {
            g2D.drawImage(img,arrBullet.get(i).getX(),arrBullet.get(i).getY(),8,8,null);
        }
    }
    public void addBullet(Tank tank){
        if (tank.getDirection() == CommonVLs.UP)
            arrBullet.add(new Bullet(tank.getCoordinatesX() + 15, tank.getCoordinatesY() - 7, tank.getDirection()));
        else if (tank.getDirection() == CommonVLs.DOWN)
            arrBullet.add(new Bullet(tank.getCoordinatesX() + 15, tank.getCoordinatesY() + 35,tank.getDirection()));
        else if (tank.getDirection() == CommonVLs.LEFT)
            arrBullet.add(new Bullet(tank.getCoordinatesX() - 3, tank.getCoordinatesY() + 15, tank.getDirection()));
        else if (tank.getDirection() == CommonVLs.RIGHT)
            arrBullet.add(new Bullet(tank.getCoordinatesX() + 35, tank.getCoordinatesY() + 15, tank.getDirection()));
    }
    public void moveAll(){
        for (int i = 0; i < arrBullet.size(); i++) {
            getArrBullet().get(i).moveBullet();
        }
    }

}
