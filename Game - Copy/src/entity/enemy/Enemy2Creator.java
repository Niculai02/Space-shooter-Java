package entity.enemy;

import com.company.main.GamePanel;

import java.awt.*;
import java.util.LinkedList;

import static com.company.main.GamePanel.LEVEL.LEVEL2;

public class Enemy2Creator {
    public LinkedList<Enemy2> b = new LinkedList<>();
    Enemy2 TempEnemy2;
    GamePanel gp;
    public Enemy2Creator(GamePanel gp){
        this.gp = gp;
    }

    public void update(){
        for (Enemy2 enemy2 : b) {
            TempEnemy2 = enemy2;
            TempEnemy2.update();
        }

        for(int i=0; i<b.size(); i++){
            TempEnemy2=b.get(i);
            if(TempEnemy2.y > 700){
                b.remove(i);
                if(gp.Level == LEVEL2){
                    gp.Lv2Kills+=1;
                    gp.Lv2Score+=300;
                }
            }

        }
        if(gp.Level == LEVEL2){
            if(b.size()<2){
                addEnemy2(new Enemy2(gp));
                addEnemy2(new Enemy2(gp));
            }
            if(gp.Lv2Kills>40){
                gp.State= GamePanel.STATE.LEVEL2COMPLETED;
            }
        }

    }

    public void draw(Graphics2D g2){
        for (Enemy2 enemy2 : b) {
            TempEnemy2 = enemy2;
            TempEnemy2.draw(g2);
        }
    }

    public void addEnemy2(Enemy2 block){
        b.add(block);
    }

    public void removeEnemy2(Enemy2 block){
        b.remove(block);
    }


    public LinkedList<Enemy2> getEnemy2(){
        return b;
    }

}
