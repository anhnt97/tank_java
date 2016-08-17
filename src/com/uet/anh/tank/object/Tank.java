package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tuana on 27/07/2016.
 */
public class Tank {
    public static final int SIZE_TANK = 30;
    private int x ;
    private int y ;
    private Image imageUp, imageDown, imageLeft, imageRight;
    private int direction = CommonVLs.UP;
    private int speed;
    public static final int SPEED_HIGH = 5;
    public static final int SPEED_LOW = 3;

    public Tank() {
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImageUp(Image imageTank) {
        this.imageUp = imageTank;
    }

    public void setImageDown(Image imageDown) {
        this.imageDown = imageDown;
    }

    public void setImageLeft(Image imageLeft) {
        this.imageLeft = imageLeft;
    }

    public void setImageRight(Image imageRight) {
        this.imageRight = imageRight;
    }

    public void setSpeed(int speeed) {
        this.speed = speeed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public Tank(int x, int y) {
        CommonVLs commonVLs = new CommonVLs();
        imageUp = commonVLs.getImage("bossyellow_1.png");
        imageDown = commonVLs.getImage("bossyellow_2.png");
        imageLeft = commonVLs.getImage("bossyellow_3.png");
        imageRight = commonVLs.getImage("bossyellow_4.png");
        this.x = x;
        this.y = y;
        this.speed = 0;
    }

    /**
     * Draw tank
     */

    public void drawTank(Graphics2D g2d) {
        switch (direction) {
            case CommonVLs.UP:
                g2d.drawImage(imageUp, x, y, SIZE_TANK, SIZE_TANK, null);
                break;
            case CommonVLs.DOWN:
                g2d.drawImage(imageDown, x, y, SIZE_TANK, SIZE_TANK, null);
                break;
            case CommonVLs.LEFT:
                g2d.drawImage(imageLeft, x, y, SIZE_TANK, SIZE_TANK, null);
                break;
            case CommonVLs.RIGHT:
                g2d.drawImage(imageRight, x, y, SIZE_TANK, SIZE_TANK, null);
                break;
        }
    }

    /**
    * Move tank
    */
    public void moveTank() {
        switch (direction) {
            case CommonVLs.UP:
                this.y-= speed;
                break;
            case CommonVLs.DOWN:
                this.y+= speed;
                break;
            case CommonVLs.LEFT:
                this.x-= speed;
                break;
            case CommonVLs.RIGHT:
                this.x+= speed;
                break;
        }

    }

    /**
     * Move tank 2
     */
    public void moveTank(int direction) {
        this.direction = direction;
        switch (direction) {
            case CommonVLs.UP:
               y-= speed;
                break;
            case CommonVLs.DOWN:
                y+= speed;
                break;
            case CommonVLs.LEFT:
                x-= speed;
                break;
            case CommonVLs.RIGHT:
                x+= speed;
                break;
        }
    }

    /**
     * Check 1 điểm trong tank
     */
    private boolean isPointInside(int xObj, int yObj, int x, int y) {
        int bottomPoint = y + this.SIZE_TANK;
        int rightPoint = x + this.SIZE_TANK;
        if (xObj > x && yObj > y && xObj < rightPoint && yObj < bottomPoint) {
            return true;
        }
        return false;
    }
    /**
     * Check 4 góc trong tank
     */
    public boolean isObjInside(int xObj, int yObj) {
        int x = this.getX();
        int y = this.getY();

        if (isPointInside(xObj, yObj, x, y)
                || isPointInside(xObj + this.SIZE_TANK, yObj, x, y)
                || isPointInside(xObj, yObj + this.SIZE_TANK, x, y)
                || isPointInside(xObj + this.SIZE_TANK, yObj + this.SIZE_TANK, x, y)) {
            return true;
        }
        if (isPointInside(x, y, xObj, yObj)
                || isPointInside(x, y + this.SIZE_TANK, xObj, yObj)
                || isPointInside(x + this.SIZE_TANK, y, xObj, yObj)
                || isPointInside(x + this.SIZE_TANK, y + this.SIZE_TANK, xObj, yObj)) {
            return true;
        }
        return false;
    }

}
