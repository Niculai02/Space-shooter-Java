package entity.enemy;

import com.company.main.GamePanel;
import entity.Entity;
import entity.Physics;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static javax.imageio.ImageIO.read;


public class Enemy4 extends Entity {
    GamePanel gp;
    int k;
    Random r = new Random();
    public BufferedImage enemy;

    public Enemy4(GamePanel gp){
        this.gp=gp;
        this.x = r.nextInt(350);
        this.y = r.nextInt(372);
        this.speed = 3;
        getEnemy4Image();
        k=0;
    }

    public void getEnemy4Image(){
        try {
            enemy = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/enemy5.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Rectangle getBounds(){
        return new Rectangle(x, y, 24, 24);
    }

    public void update(){
        //edge();
        counter++;
        movement2();
        if(Physics.Collision4(this, gp.llb)){
            //this.x=-50;
            this.y=800;
        }
    }
    public void draw(Graphics2D g2){
        //edge();
        BufferedImage image;
        image = enemy;
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }

}

