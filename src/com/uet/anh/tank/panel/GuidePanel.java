package com.uet.anh.tank.panel;

import com.uet.anh.tank.GUI.GUI;
import com.uet.anh.tank.common.CommonVLs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by tuana on 18/08/2016.
 */
public class GuidePanel extends JPanel {
    private GUI gui;
    private CommonVLs commonVLs;
    private Graphics2D g2D;
    private Image img;
    private JButton btnBackMenu;

    public GuidePanel(){
        setLayout(null);
        commonVLs = new CommonVLs();
        setBounds(1, 1, CommonVLs.WIDTH_SCREEN, CommonVLs.HEGHT_SCREEN);
        img = commonVLs.getImage("guide.png");

        btnBackMenu = new JButton();
        btnBackMenu.setBounds(200,350,180,50);
        add(btnBackMenu);
        backMenu();
    }

    private void backMenu() {
        btnBackMenu.setIcon(new ImageIcon(commonVLs.getImage("bt_back0.png")));
        btnBackMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnBackMenu.setFocusable(false);
                gui.backMenu();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnBackMenu.setIcon(new ImageIcon(commonVLs.getImage("bt_back1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnBackMenu.setIcon(new ImageIcon(commonVLs.getImage("bt_back0.png")));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2D = (Graphics2D) g;
        g2D.drawImage(img, 1, 1, CommonVLs.WIDTH_SCREEN, CommonVLs.HEGHT_SCREEN, null);
    }


    public void setGui(GUI gui) {
        this.gui = gui;
    }


}
