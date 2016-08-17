package com.uet.anh.tank.object;


/**
 * Created by tuana on 27/07/2016.
 */
public class PlayerTank extends Tank {

    public PlayerTank(int x,int y) {
        super(x,y);
        this.setSpeed(SPEED_LOW);
    }
}
