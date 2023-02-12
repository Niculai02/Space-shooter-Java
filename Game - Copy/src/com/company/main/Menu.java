package com.company.main;

import java.awt.*;


public class Menu {
    public Rectangle playButton = new Rectangle(228, 300, 120, 60);
    public Rectangle infoButton = new Rectangle(228, 400, 120, 60);
    public Rectangle quitButton = new Rectangle(228, 500, 120, 60);

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt1 = new Font("arial", Font.BOLD, 30);

        g.setFont(fnt);
        g.setColor(Color.WHITE);
        g.drawString("*SPACE MADNESS*", 60, 150);

        g.setFont(fnt1);
        g.drawString("PLAY", playButton.x+22, playButton.y+40);
        g2.draw(playButton);

        g.drawString("INFO", infoButton.x+22, infoButton.y+40);
        g2.draw(infoButton);

        g.drawString("QUIT", quitButton.x+22, quitButton.y+40);
        g2.draw(quitButton);


    }
}
