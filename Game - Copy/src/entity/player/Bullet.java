package entity.player;

import com.company.main.GamePanel;
import entity.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bullet extends Entity {

    GamePanel gp;
    public BufferedImage bullet;
    public int killed = 0;


    public Bullet(GamePanel gp, int x, int y){
        this.gp = gp;
        this.x=x;
        this.y=y;
        this.speed=6;
        getbulletImage();
    }

    public void getbulletImage(){
        try {
            bullet = ImageIO.read(getClass().getResourceAsStream("/sprites/bulletv1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        y-=speed;
    }

    public void draw(Graphics2D g2){
        //edge();
        BufferedImage image;
        image = bullet;
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }
}
