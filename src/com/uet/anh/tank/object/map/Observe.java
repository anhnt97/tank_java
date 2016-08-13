package com.uet.anh.tank.object.map;

import com.uet.anh.tank.common.CommonVLs;

import java.awt.*;

/**
 * Created by tuana on 07/08/2016.
 */
public class Observe {
    private int x;
    private int y;
    private int size = 20;
    private int type;
    private Image img;

    public Observe(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;

        if (this.type == CommonVLs.BRICK_TYPE){
            CommonVLs commonVLs = new CommonVLs();
            img = commonVLs.getImage("brick1.png");
        }
    }

   public void draw (Graphics2D g2D){
       g2D.drawImage(this.img,x*size,y*size,this.size,this.size,null);
   }

    /**
     * Check 1 điểm trong tank vs gạch
     */
    private boolean isPointInside(int xObj, int yObj, int x, int y, int size) {
        int bottomPoint = y + size;
        int rightPoint = x + size;
        if (xObj > x && yObj > y && xObj < rightPoint && yObj < bottomPoint) {
            return true;
        }
        return false;
    }
    /**
     * Check 4 góc trong tank vs gạch
     */
    public boolean isObjInside(int xObj, int yObj, int sizeObj) {
        int x = this.x * this.size;
        int y = this.y * this.size;

        if (isPointInside(xObj, yObj, x, y, this.size)
                || isPointInside(xObj + sizeObj, yObj, x, y, this.size)
                || isPointInside(xObj, yObj + sizeObj, x, y, this.size)
                || isPointInside(xObj + sizeObj, yObj + sizeObj, x, y, this.size)) {
            return true;
        }
        if (isPointInside(x, y, xObj, yObj, sizeObj)
                || isPointInside(x, y + this.size, xObj, yObj, sizeObj)
                || isPointInside(x + this.size, y, xObj, yObj, sizeObj)
                || isPointInside(x + this.size, y + this.size, xObj, yObj, sizeObj)) {
            return true;
        }
        return false;
    }
}
