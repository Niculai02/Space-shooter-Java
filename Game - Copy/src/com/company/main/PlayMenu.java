package com.company.main;

import java.awt.*;

public class PlayMenu {
    public Rectangle newGameButton = new Rectangle(228, 200,120,60);
    public Rectangle level1Button = new Rectangle(228, 300, 120, 60);
    public Rectangle level2Button = new Rectangle(228, 400, 120, 60);
    public Rectangle level3Button = new Rectangle(228, 500, 120, 60);

    public void draw(Graphics g, GamePanel gp) {
        Graphics2D g2 = (Graphics2D) g;
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt1 = new Font("arial", Font.BOLD, 20);

        g.setFont(fnt);
        g.setColor(Color.WHITE);
        g.drawString("SELECT A LEVEL", 60, 150);
        g.setFont(fnt1);
        g.drawString("New Game", newGameButton.x+12, newGameButton.y+37);
        g2.draw(newGameButton);

        if(gp.Lv1Done == 0){
            g.setColor(Color.GREEN);
            g.drawString("LEVEL 1", level1Button.x+22 , level1Button.y + 40);
            g2.draw(level1Button);

            g.setColor(Color.WHITE);
            g.drawString("LEVEL 2", level2Button.x + 22, level2Button.y + 40);
            g2.draw(level2Button);

            g.drawString("LEVEL 3", level3Button.x + 22, level3Button.y + 40);
            g2.draw(level3Button);
        }
        else if(gp.Lv1Done == 1){
            g.setColor(Color.GREEN);
            g.drawString("LEVEL 1", level1Button.x + 22, level1Button.y + 40);
            g2.draw(level1Button);

            g.drawString("LEVEL 2", level2Button.x + 22, level2Button.y + 40);
            g2.draw(level2Button);

            g.setColor(Color.WHITE);
            g.drawString("LEVEL 3", level3Button.x + 22, level3Button.y + 40);
            g2.draw(level3Button);
        }
        if(gp.Lv2Done==1){
            g.setColor(Color.GREEN);
            g.drawString("LEVEL 1", level1Button.x + 22, level1Button.y + 40);
            g2.draw(level1Button);

            g.drawString("LEVEL 2", level2Button.x + 22, level2Button.y + 40);
            g2.draw(level2Button);

            g.drawString("LEVEL 3", level3Button.x + 22, level3Button.y + 40);
            g2.draw(level3Button);
        }
    }
}
