package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by tuana on 10/08/2016.
 */
public class Animation {
    private int type;
    private int x;
    private int y;
    private ArrayList<Image> imgArr;
    private int size;
    private CommonVLs common = new CommonVLs();

    //private int state;
    public Animation(int type, int x, int y, int size) {
        this.type = type;
        this.size = size;
        this.x = x;
        this.y = y;

        imgArr = new ArrayList<>();
        initImageFromType(type);
    }

    private void initImageFromType(int type) {
        if (type == CommonVLs.TANK_EXPLORE) {
            // Lay tank cho vao array list
            if (type == CommonVLs.TANK_EXPLORE) {
                String tankName = "tank_exp";
                for (int i = 1; i < 6; i++) {
                    Image imgTank = common.getImage(tankName + i + ".png");
                    imgArr.add(imgTank);
                }
            }
        } else if (type == CommonVLs.BULLET_EXPLORE) {
            Image imgBullet = common.getImage("explosion.png");
            imgArr.add(imgBullet);
        }
    }

    public boolean draw(Graphics2D g2D) {
        Image img = imgArr.get(0);
        imgArr.remove(0);
        g2D.drawImage(img, this.x, this.y, 30, 30, null);
        //state++;
        if (imgArr.isEmpty())
            return false;
        return true;
    }

}
