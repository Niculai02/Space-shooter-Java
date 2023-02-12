package entity.enemy;

import com.company.main.GamePanel;

import java.awt.*;
import java.util.LinkedList;

import static com.company.main.GamePanel.LEVEL.LEVEL1;
import static com.company.main.GamePanel.LEVEL.LEVEL2;

public class Enemy1Creator {
    public LinkedList<Enemy1> b = new LinkedList<>();
    Enemy1 TempEnemy1;
    GamePanel gp;
    public Enemy1Creator(GamePanel gp){
        this.gp = gp;
    }

    public void update(){
        for (Enemy1 enemy1 : b) {
            TempEnemy1 = enemy1;
            TempEnemy1.update();
        }

        if(gp.Level == LEVEL1){
                if(b.size()<2){
                    addEnemy1(new Enemy1(gp));
                    addEnemy1(new Enemy1(gp));
                }
            if(gp.Lv1Kills>30){
                gp.State= GamePanel.STATE.LEVEL1COMPLETED;
            }

        }
        else if(gp.Level == LEVEL2){
            if(b.size()<2){
                addEnemy1(new Enemy1(gp));
                addEnemy1(new Enemy1(gp));
            }
            if(gp.Lv2Kills>40){
                gp.State= GamePanel.STATE.LEVEL2COMPLETED;
            }
        }

        for(int i=0; i<b.size(); i++){
            TempEnemy1=b.get(i);
            if(TempEnemy1.dead == 1){
                b.remove(i);
                if(gp.Level == LEVEL1){
                    gp.Lv1Kills+=1;
                    gp.Lv1Score+=200;
                }
                if(gp.Level == LEVEL2){
                    gp.Lv2Kills+=1;
                    gp.Lv2Score+=200;
                }
            }
        }
        //System.out.println(b.size());
    }

    public void draw(Graphics2D g2){
        for (Enemy1 enemy1 : b) {
            TempEnemy1 = enemy1;
            TempEnemy1.draw(g2);
        }
    }

    public void addEnemy1(Enemy1 block){
        b.add(block);
    }

    public void removeEnemy1(Enemy1 block){
        b.remove(block);
    }


    public LinkedList<Enemy1> getEnemy1(){
        return b;
    }

}
