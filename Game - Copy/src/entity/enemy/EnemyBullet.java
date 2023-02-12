package entity.enemy;
import com.company.main.GamePanel;
import entity.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class EnemyBullet extends Entity {
    public GamePanel gp;
    public BufferedImage enemyBullet;

    public EnemyBullet(GamePanel gp, int x, int y, int speed){
        this.gp=gp;
        this.x=x;
        this.y=y;
        this.speed=speed;
        getEnemyBulletImage();
    }

    public void getEnemyBulletImage(){
        try {
            enemyBullet = ImageIO.read(getClass().getResourceAsStream("/sprites/enbull.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        y+=speed;
        if(Physics.Collision5(this, gp.player)){
            this.y=800;
            gp.player.Health -=1;
            if(gp.player.Health == 0)
                gp.State = GamePanel.STATE.MENU;
        }

    }

    public void draw(Graphics2D g2){
    BufferedImage image;
    image = enemyBullet;
    g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }
}
