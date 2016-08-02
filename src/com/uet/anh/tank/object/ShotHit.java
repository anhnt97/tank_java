package com.uet.anh.tank.object;

import java.awt.*;

/**
 * Created by tuana on 02/08/2016.
 */
public class ShotHit {
  public void shotBullet(EnemyTank enemy , PlayerTank player){
      Rectangle rect1 = new Rectangle(player.getCoordinatesX(), player.getCoordinatesY(), player.SIZE_TANK, player.SIZE_TANK);

      Rectangle rect2 = new Rectangle(enemy.getCoordinatesX(), enemy.getCoordinatesY(), enemy.SIZE_TANK, enemy.SIZE_TANK);

//detects when the two rectangles hit
      if(rect1.intersects(rect2))
      {
          System.out.println("game over, g");
      }
  }
}
