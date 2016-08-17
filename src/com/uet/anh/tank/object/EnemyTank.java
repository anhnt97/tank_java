package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import java.awt.*;
import java.util.Random;

import static com.uet.anh.tank.common.CommonVLs.*;

/**
 * Created by tuana on 31/07/2016.
 */
public class EnemyTank extends Tank {
    private Random random = new Random();
    public EnemyTank() {
        setX(random.nextInt(300));
        setY(random.nextInt(300));
        CommonVLs commonVLs = new CommonVLs();

        setImageUp(commonVLs.getImage("player_green_1.png"));
        setImageDown(commonVLs.getImage("player_green_2.png"));
        setImageLeft(commonVLs.getImage("player_green_3.png"));
        setImageRight(commonVLs.getImage("player_green_4.png"));
        setSpeed(2);
    }
    public EnemyTank(int x,int y) {
        setX(x);
        setY(y);
        CommonVLs commonVLs = new CommonVLs();

        setImageUp(commonVLs.getImage("player_green_1.png"));
        setImageDown(commonVLs.getImage("player_green_2.png"));
        setImageLeft(commonVLs.getImage("player_green_3.png"));
        setImageRight(commonVLs.getImage("player_green_4.png"));
        setSpeed(2);
    }

    public void randomRun() {
        int randomInt = random.nextInt(4) + 1;
        this.setDirection(randomInt);
    }


}
