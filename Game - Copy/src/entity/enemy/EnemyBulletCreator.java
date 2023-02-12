package entity.enemy;

import com.company.main.GamePanel;

import java.awt.*;
import java.util.LinkedList;


public class EnemyBulletCreator {
    public LinkedList<EnemyBullet> b = new LinkedList<EnemyBullet>();
    EnemyBullet temp;
    GamePanel gp;

    public EnemyBulletCreator(GamePanel gp){
        this.gp=gp;
    }

    public void update(){
        for(EnemyBullet temp:b){
            temp.update();
        }
        for(int i=0; i<b.size(); i++){
            temp=b.get(i);
            if(temp.y > 900){
                b.remove(i);
            }
        }
    }

    public void draw(Graphics2D g2){
        for(EnemyBullet temp:b){
            temp.draw(g2);
        }
    }

    public void addEnemyBullet(EnemyBullet block){
        b.add(block);
    }

    public void removeEnemyBullet(EnemyBullet block){
        b.remove(block);
    }
}
