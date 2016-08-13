package com.uet.anh.tank.object;

import com.uet.anh.tank.common.CommonVLs;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by tuana on 10/08/2016.
 */
public class AnimationManager
{
    private ArrayList<Animation>  animArr;
    public AnimationManager(){
        this.animArr = new ArrayList<>();
    }
    public void addAnim(int type,int x, int y){
        Animation anim = new Animation(type,x,y, CommonVLs.ANIMATION_SIZE);
        animArr.add(anim);
    }
    public void drawAll(Graphics2D g2D){
        for (int i = 0; i < animArr.size() ; i++) {
            Animation amin = animArr.get(i);
            if (!amin.draw(g2D)){
                animArr.remove(i);
                i--;
            }
        }
    }

}
