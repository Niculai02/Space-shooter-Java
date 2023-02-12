package com.company.main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.company.main.GamePanel.LEVEL.*;
import static com.company.main.GamePanel.STATE.*;

public class MouseInput implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        /*
        public Rectangle newGameButton = new Rectangle(228, 200,120,60);
        public Rectangle playButton = new Rectangle(228, 300, 120, 60);
        public Rectangle infoButton = new Rectangle(228, 400, 120, 60);
        public Rectangle quitButton = new Rectangle(228, 500, 120, 60);
        */
        if(GamePanel.State==MENU){
            if(mx >= 228 && mx <= 348){
                if(my >= 300 && my <= 360) {
                    GamePanel.State = PLAYMENU;
                }
            }

            if(mx >= 228 && mx <= 348){
                if(my >= 400 && my <= 460) {
                    GamePanel.State = INFO;
                }
            }


            if(mx >= 228 && mx <= 348){
                if(my >= 500 && my <= 560) {
                    System.exit(1);
                }
            }
        }
        else if(GamePanel.State==PLAYMENU){

            if(mx >= 228 && mx <= 348){
                if(my >= 200 && my <= 260) {
                    GamePanel.Lv1Done=0;
                    GamePanel.Lv2Done=0;
                }
            }

            if(mx >= 228 && mx <= 348){
                if(my >= 300 && my <= 360) {
                    System.out.println("JUCATI LEVEL1");
                    GamePanel.State = GAME;
                    GamePanel.Level = LEVEL1;
                }
            }
            if(mx >= 228 && mx <= 348){
                if(my >= 400 && my <= 460) {
                    if(GamePanel.Lv1Done == 1){
                        System.out.println("JUCATI LEVEL2");
                        GamePanel.State = GAME;
                        GamePanel.Level = LEVEL2;
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Complete level 1 first !!", "Ooops...", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(mx >= 228 && mx <= 348){
                if(my >= 500 && my <= 560) {
                    if(GamePanel.Lv2Done == 1){
                        System.out.println("JUCATI LEVEL3");
                        GamePanel.State = GAME;
                        GamePanel.Level = LEVEL3;
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Complete level 2 first !!", "Ooops...", JOptionPane.INFORMATION_MESSAGE);
                }
            }


        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
