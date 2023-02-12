package entity.player;

import com.company.main.GamePanel;

import java.awt.*;
import java.util.LinkedList;

public class BulletCreator {
    public LinkedList<Bullet> b = new LinkedList<Bullet>();
    Bullet TempBullet;
    GamePanel gp;
    public BulletCreator(GamePanel gp){
        this.gp = gp;
    }

    public void update(){
        for(int i=0; i<b.size(); i++){
            TempBullet = b.get(i);
            TempBullet.update();
            if(TempBullet.y < 0)
                b.remove(i);
        }
    }

    public void draw(Graphics2D g2){
        for(int i=0; i<b.size(); i++){
            TempBullet = b.get(i);
            TempBullet.draw(g2);
        }

    }

    public void addBullet(Bullet block){
        b.add(block);
    }


    public void removeBullet(Bullet block){
        b.remove(block);
    }

    public LinkedList<Bullet> getBullet(){
        return b;
    }

}
