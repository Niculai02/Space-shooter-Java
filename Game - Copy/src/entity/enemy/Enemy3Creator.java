package entity.enemy;
import com.company.main.GamePanel;
import java.awt.*;
import java.util.LinkedList;
import static com.company.main.GamePanel.LEVEL.LEVEL3;

public class Enemy3Creator{
    public LinkedList<Enemy3> b = new LinkedList<>();
    Enemy3 TempEnemy3;
    GamePanel gp;
    public Enemy3Creator(GamePanel gp){
        this.gp = gp;
    }

    public void update(){
        for (Enemy3 enemy3 : b) {
            TempEnemy3 = enemy3;
            TempEnemy3.update();
        }

        for(int i=0; i<b.size(); i++){
            TempEnemy3=b.get(i);
            if(TempEnemy3.y > 700){
                b.remove(i);
                gp.Lv3Kills+=1;
                gp.Lv3Score+=400;
            }
        }
        if(gp.Level == LEVEL3){
            if(b.size()<3){
                addEnemy3(new Enemy3(gp));
                addEnemy3(new Enemy3(gp));
            }
            if(gp.Lv3Kills>40){
                gp.State= GamePanel.STATE.LEVEL3COMPLETED;
            }
        }



    }

    public void draw(Graphics2D g2){
        for (Enemy3 enemy3 : b) {
            TempEnemy3 = enemy3;
            TempEnemy3.draw(g2);
        }
    }

    public void addEnemy3(Enemy3 block){
        b.add(block);
    }

    public void removeEnemy3(Enemy3 block){
        b.remove(block);
    }


    public LinkedList<Enemy3> getEnemy3(){
        return b;
    }

}
