package entity.enemy;

import com.company.main.GamePanel;

import java.awt.*;
import java.util.LinkedList;

import static com.company.main.GamePanel.LEVEL.LEVEL3;

public class Enemy4Creator{
    public LinkedList<Enemy4> b = new LinkedList<>();
    Enemy4 TempEnemy4;
    GamePanel gp;
    public Enemy4Creator(GamePanel gp){
        this.gp = gp;
    }

    public void update(){
        for (Enemy4 enemy4 : b) {
            TempEnemy4 = enemy4;
            TempEnemy4.update();
        }

        for(int i=0; i<b.size(); i++){
            TempEnemy4=b.get(i);
            if(TempEnemy4.y > 700){
                b.remove(i);
                gp.Lv3Kills+=1;
                gp.Lv3Score+=500;
            }
        }

        if(gp.Level == LEVEL3){
            if(b.size()<3){
                addEnemy4(new Enemy4(gp));
                addEnemy4(new Enemy4(gp));
            }
            if(gp.Lv3Kills>40){
                gp.State= GamePanel.STATE.LEVEL3COMPLETED;
            }
        }

    }

    public void draw(Graphics2D g2){
        for (Enemy4 enemy4 : b) {
            TempEnemy4 = enemy4;
            TempEnemy4.draw(g2);
        }
    }

    public void addEnemy4(Enemy4 block){
        b.add(block);
    }

    public void removeEnemy4(Enemy4 block){
        b.remove(block);
    }


    public LinkedList<Enemy4> getEnemy4(){
        return b;
    }

}
