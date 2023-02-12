package entity.enemy;

import com.company.main.GamePanel;

import java.awt.*;
import java.util.LinkedList;

import static com.company.main.GamePanel.LEVEL.LEVEL1;
import static com.company.main.GamePanel.LEVEL.LEVEL2;

public class EnemyCreator {
    public LinkedList<Enemy> b = new LinkedList<>();
    Enemy TempEnemy;
    GamePanel gp;

    public EnemyCreator(GamePanel gp){
        this.gp = gp;
    }

    public void update(){
        for (Enemy enemy : b) {
            TempEnemy = enemy;
            TempEnemy.update();
        }
        if(gp.Level == LEVEL1){
            if(b.size()<2){
                addEnemy(new Enemy(gp));
                addEnemy(new Enemy(gp));
            }
            if(gp.Lv1Kills>30){
                gp.State= GamePanel.STATE.LEVEL1COMPLETED;
            }

        }

        if(gp.Level == LEVEL2){
            if(b.size()<2){
                addEnemy(new Enemy(gp));
                addEnemy(new Enemy(gp));
            }
            if(gp.Lv2Kills>40){
                gp.State= GamePanel.STATE.LEVEL2COMPLETED;
            }
        }

        for(int i=0; i<b.size(); i++){
            TempEnemy=b.get(i);
            if(TempEnemy.y > 700){
                b.remove(i);
                if(gp.Level == LEVEL1){
                    gp.Lv1Kills+=1;
                    gp.Lv1Score +=100;
                }
                if(gp.Level == LEVEL2){
                    gp.Lv2Kills+=1;
                    gp.Lv2Score+=100;
                }
            }
        }
    }

    public void draw(Graphics2D g2){
        for (Enemy enemy : b) {
            TempEnemy = enemy;
            TempEnemy.draw(g2);
        }
    }

    public void addEnemy(Enemy block){
        b.add(block);
    }

    public void removeEnemy(Enemy block){
        b.remove(block);
    }


    public LinkedList<Enemy> getEnemy(){
        return b;
    }

}
