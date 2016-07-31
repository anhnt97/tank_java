package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import java.util.Random;

/**
 * Created by tuana on 31/07/2016.
 */
public class EnemyTank extends Tank {
    private static final int distanceTime = 1500;
    private Random random = new Random();
    private long previousTime;

    public EnemyTank() {
        CommonVLs commonVLs = new CommonVLs();
        setImageUp(commonVLs.getImage("player_green_1.png"));
        setImageDown(commonVLs.getImage("player_green_2.png"));
        setImageLeft(commonVLs.getImage("player_green_3.png"));
        setImageRight(commonVLs.getImage("player_green_4.png"));

    }

    public void randomRun() {
        previousTime = System.currentTimeMillis();
        int randomInt = random.nextInt(4);
        switch (randomInt) {
            case 0:
                this.setDirection(CommonVLs.UP);
                break;
            case 1:
                this.setDirection(CommonVLs.DOWN);
                break;
            case 2:
                this.setDirection(CommonVLs.LEFT);
                break;
            case 3:
                this.setDirection(CommonVLs.RIGHT);
                break;
        }
    }

    @Override
    public void moveTank() {
        System.out.println(getCoordinatesX() + " " + getCoordinatesY());
        if (!checkImpact()) {
            super.moveTank();
            if (System.currentTimeMillis() - previousTime > distanceTime) {
                randomRun();
            }
        } else {
            int randomInt = random.nextInt(4);
            while (randomInt==getDirection()){
                randomInt = random.nextInt(4);
            }
            setDirection(randomInt);
        }
    }

    public void autoShot(){

    }

}
