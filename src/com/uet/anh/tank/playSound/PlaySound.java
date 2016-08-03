package com.uet.anh.tank.playSound;

import com.uet.anh.tank.common.CommonVLs;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Created by tuana on 03/08/2016.
 */
public class PlaySound {
    CommonVLs commonVLs = new CommonVLs();
    public void playSound(String soundName)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(commonVLs.getPath(soundName)).getAbsoluteFile( ));
                    Clip clip = AudioSystem.getClip( );
                    clip.open(audioInputStream);
                    clip.start( );
                }
                catch(Exception ex)
                {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace( );
                }
            }
        }).start();

    }
}
