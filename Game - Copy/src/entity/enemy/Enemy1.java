package entity.enemy;
import com.company.main.GamePanel;
import entity.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import static javax.imageio.ImageIO.*;


public class Enemy1 extends Entity {
    GamePanel gp;
    int k;
    int dead = 0;
    Random r = new Random();
    public BufferedImage enemy;
    EnemyBulletCreator b;

    public Enemy1(GamePanel gp){
        this.gp=gp;
        this.x = r.nextInt(350);
        this.y = r.nextInt(372);
        this.speed = 3;
        getEnemy1Image();
        k=0;
        b=new EnemyBulletCreator(gp);
    }

    public void getEnemy1Image(){
        try {
            enemy = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/enemy2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Rectangle getBounds(){
        return new Rectangle(x, y, 24, 24);
    }

    public void update(){
        int m = r.nextInt(2);
        counter++;
        movement2();
        if(Physics.Collision1(this, gp.llb)){
            this.dead=1;
        }

    }
    public void draw(Graphics2D g2){
        BufferedImage image;
        image = enemy;
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }

}
