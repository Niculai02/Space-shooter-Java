package entity.player;

import com.company.main.GamePanel;
import com.company.main.KeyHandler;
import entity.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static javax.imageio.ImageIO.read;

public class Player extends Entity {
    public GamePanel gp;
    public KeyHandler keyH;
    public BulletCreator c;
    public int Health = 3;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        c = new BulletCreator(gp);
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 200;
        y= 450;
        speed = 4;
    }

    public BufferedImage jon, health1, health2, health3;

    public void getPlayerImage(){
        try {
            jon = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/navajon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            health1 = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/1health.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            health2 = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/2health.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            health3 = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/3health.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, 24, 24);
    }

    public void update(){
        edge();
        if(keyH.upPressed){
            y -= speed;

            if(keyH.leftPressed) {
                x -= speed;
            }
            if(keyH.rightPressed)
                x +=speed;
        }

        else if(keyH.downPressed){
            y += speed;

            if(keyH.leftPressed)
                x-=speed;

            if(keyH.rightPressed)
                x +=speed;
        }

        else if(keyH.leftPressed){
            x-=speed;
        }

        else if(keyH.rightPressed){
            x += speed;
        }

    }

    public void draw(Graphics2D g2){
        BufferedImage image;
        image = jon;
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        if(Health == 3)
            g2.drawImage(health3, 10, 10, gp.tileSize+20, gp.tileSize+20, null);
        else if(Health == 2)
            g2.drawImage(health2, 10, 10, gp.tileSize+20, gp.tileSize+20, null);
        else
            g2.drawImage(health1, 10, 10, gp.tileSize+20, gp.tileSize+20, null);

    }
}
