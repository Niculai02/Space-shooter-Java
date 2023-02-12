package com.company.main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.company.main.GamePanel.db1;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed, xpressed;
    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_X) {
            xpressed = true;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }

        if (code == KeyEvent.VK_SPACE){
            spacePressed = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

        if (code == KeyEvent.VK_Q) {
            GamePanel.State= GamePanel.STATE.MENU;
        }

        if (code == KeyEvent.VK_X) {
            if(GamePanel.State == GamePanel.STATE.LEVEL1COMPLETED || GamePanel.State == GamePanel.STATE.LEVEL2COMPLETED || GamePanel.State == GamePanel.STATE.LEVEL3COMPLETED )
            JOptionPane.showMessageDialog(null, "Level 1: "+db1.getScore(1)+"\nLevel 2: "+db1.getScore(2)+"\nLevel 3: "+db1.getScore(3), "Your Scores", JOptionPane.INFORMATION_MESSAGE);
        }



        if (code == KeyEvent.VK_SPACE) {
            spacePressed = false;
        }
    }
}


