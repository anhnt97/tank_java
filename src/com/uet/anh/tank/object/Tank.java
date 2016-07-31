package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tuana on 27/07/2016.
 */
public class Tank {
    private static final int SIZE_TANK = 40;
    private int coordinatesX = 1;
    private int coordinatesY = 100;
    private Image imageUp, imageDown, imageLeft, imageRight;
    private int direction = CommonVLs.UP;
    private int speed = 100;

    public Tank() {
        CommonVLs commonVLs = new CommonVLs();
        imageUp = commonVLs.getImage("bossyellow_1.png");
        imageDown = commonVLs.getImage("bossyellow_2.png");
        imageLeft = commonVLs.getImage("bossyellow_3.png");
        imageRight = commonVLs.getImage("bossyellow_4.png");
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public int getCoordinatesY() {
        return coordinatesY;
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

    public Tank(int x, int y, int speed) {
        CommonVLs commonVLs = new CommonVLs();
        imageUp = commonVLs.getImage("bossyellow_1.png");
        imageDown = commonVLs.getImage("bossyellow_2.png");
        imageLeft = commonVLs.getImage("bossyellow_3.png");
        imageRight = commonVLs.getImage("bossyellow_4.png");
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.speed = speed;
    }

    /**
     * Draw tank
     */

    public void drawTank(Graphics2D g2d) {
        if (direction == CommonVLs.UP)
            g2d.drawImage(imageUp, coordinatesX, coordinatesY, SIZE_TANK, SIZE_TANK, null);
        else if (direction == CommonVLs.DOWN)
            g2d.drawImage(imageDown, coordinatesX, coordinatesY, SIZE_TANK, SIZE_TANK, null);
        else if (direction == CommonVLs.LEFT)
            g2d.drawImage(imageLeft, coordinatesX, coordinatesY, SIZE_TANK, SIZE_TANK, null);
        else if (direction == CommonVLs.RIGHT)
            g2d.drawImage(imageRight, coordinatesX, coordinatesY, SIZE_TANK, SIZE_TANK, null);
        else g2d.drawImage(imageRight, 100, 100, SIZE_TANK, SIZE_TANK, null);
    }

    /**
     * Move tank
     */
    public void moveTank() {
            switch (direction) {
                case CommonVLs.UP:
                    coordinatesY--;
                    break;
                case CommonVLs.DOWN:
                    coordinatesY++;
                    break;
                case CommonVLs.LEFT:
                    coordinatesX--;
                    break;
                case CommonVLs.RIGHT:
                    coordinatesX++;
                    break;
            }
    }

    /**
     * check impact
     */
    public boolean checkImpact() {
//        System.out.println(coordinatesX + " " + coordinatesY);
        if(coordinatesX <= 0){
            coordinatesX = 1;
            return true;
        }
        if(coordinatesY <= 0){
            coordinatesY = 1;
            return true;
        }

        if(coordinatesX >= CommonVLs.WIDTH_PLAY - SIZE_TANK){
            coordinatesX = CommonVLs.WIDTH_PLAY - SIZE_TANK - 1;
            return true;
        }
        if(coordinatesY >= CommonVLs.HEGHT_PLAY - SIZE_TANK){
            coordinatesY = CommonVLs.HEGHT_PLAY - SIZE_TANK - 1;
            return true;
        }
       return false;
    }
}
