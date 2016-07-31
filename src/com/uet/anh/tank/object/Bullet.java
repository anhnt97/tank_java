package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import java.awt.*;

/**
 * Created by tuana on 27/07/2016.
 */
public class Bullet {
    private int x;
    private int y;
    Image img ;
    private int direction = CommonVLs.UP;
    private int speed;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bullet(){
        CommonVLs commonVLs = new CommonVLs();
        img = commonVLs.getImage("bullet.png");
    }
    public Bullet(int x,int y,int direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
        CommonVLs commonVLs = new CommonVLs();
        img = commonVLs.getImage("bullet.png");
    }
    /**
     * Draw bullet
     */
    public void drawBullet(Graphics2D g2D){
        g2D.drawImage(img,x,y,8,8,null);
    }
    /**
     * Move bullet
     */
    public void moveBullet(){
        switch (direction){
            case CommonVLs.UP:
                y--;
                break;
            case CommonVLs.DOWN:
                y++;
                break;
            case CommonVLs.LEFT:
                x--;
                break;
            case CommonVLs.RIGHT:
                x++;
                break;
        }
    }
}
