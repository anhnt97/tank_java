package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import java.awt.*;
import java.util.Random;

import static com.uet.anh.tank.common.CommonVLs.*;

/**
 * Created by tuana on 31/07/2016.
 */
public class EnemyTank extends Tank {
    private static final int distanceTime = 1500;
    private Random random = new Random();
    public long previousTime;
    public EnemyTank() {
        //super(x, y);
        setX(random.nextInt(300));
        setY(random.nextInt(300));
        CommonVLs commonVLs = new CommonVLs();

        setImageUp(commonVLs.getImage("player_green_1.png"));
        setImageDown(commonVLs.getImage("player_green_2.png"));
        setImageLeft(commonVLs.getImage("player_green_3.png"));
        setImageRight(commonVLs.getImage("player_green_4.png"));
        setSpeed(2);
    }

    public void randomRun() {
        previousTime = System.currentTimeMillis();
        int randomInt = random.nextInt(4) + 1;
        switch (randomInt) {
            case CommonVLs.UP:
                this.setDirection(CommonVLs.UP);
                break;
            case CommonVLs.DOWN:
                this.setDirection(CommonVLs.DOWN);
                break;
            case CommonVLs.LEFT:
                this.setDirection(CommonVLs.LEFT);
                break;
            case CommonVLs.RIGHT:
                this.setDirection(CommonVLs.RIGHT);
                break;
        }
    }

    @Override
    public void moveTank() {
        if (!checkImpact()) {
            super.moveTank();
            if (System.currentTimeMillis() - previousTime > distanceTime) {
                randomRun();
            }
        } else {

            int randomInt = random.nextInt(4) + 1;
            while (randomInt == getDirection()) {
                randomInt = random.nextInt(4) + 1;
            }
            setDirection(randomInt);
        }
    }

    public void luiTank() {
        if (this.getDirection() == CommonVLs.UP) {
            this.setY(this.getY() + this.getSpeed() + OBSERVE_SIZE);
            this.setDirection(DOWN);
        }

        if (this.getDirection() == CommonVLs.DOWN) {
            this.setY(this.getY() - this.getSpeed() - OBSERVE_SIZE);
            this.setDirection(UP);
        }

        if (this.getDirection() == CommonVLs.LEFT) {
            this.setX(this.getX() + this.getSpeed() + OBSERVE_SIZE );
            this.setDirection(RIGHT);
        }

        if (this.getDirection() == CommonVLs.RIGHT){
            this.setX(this.getX() - this.getSpeed() - OBSERVE_SIZE);
            this.setDirection(LEFT);
        }

    }
}
