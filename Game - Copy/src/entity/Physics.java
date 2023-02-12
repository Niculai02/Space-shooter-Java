package entity;
import entity.enemy.*;
import entity.player.Bullet;
import entity.player.Player;

import java.util.LinkedList;

public class Physics {
    public static boolean Collision(Bullet bullet, LinkedList<Enemy> enemy){
        for (Enemy n : enemy) {
            if (bullet.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
        }

    public static boolean Collision(Enemy enemy1, LinkedList<Bullet> bullet){
        for (Bullet n : bullet) {
            if (enemy1.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
    }

    public static boolean Collision1(Bullet bullet, LinkedList<Enemy1> enemy1){
        for (Enemy1 n : enemy1) {
            if (bullet.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
    }

    public static boolean Collision1(Enemy1 enemy1, LinkedList<Bullet> bullet){
        for (Bullet n : bullet) {
            if (enemy1.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
    }

    public static boolean Collision2(Bullet bullet, LinkedList<Enemy2> enemy2){
        for (Enemy2 n : enemy2) {
            if (bullet.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
    }

    public static boolean Collision2(Enemy2 enemy2, LinkedList<Bullet> bullet){
        for (Bullet n : bullet) {
            if (enemy2.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
    }

    public static boolean Collision3(Bullet bullet, LinkedList<Enemy3> enemy3){
        for (Enemy3 n : enemy3) {
            if (bullet.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
    }

    public static boolean Collision3(Enemy3 enemy3, LinkedList<Bullet> bullet){
        for (Bullet n : bullet) {
            if (enemy3.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
    }

    public static boolean Collision4(Bullet bullet, LinkedList<Enemy4> enemy4){
        for (Enemy4 n : enemy4) {
            if (bullet.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
    }

    public static boolean Collision4(Enemy4 enemy4, LinkedList<Bullet> bullet){
        for (Bullet n : bullet) {
            if (enemy4.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
    }

    public static boolean Collision5(Player player, LinkedList<EnemyBullet> bullet){
        for (EnemyBullet n : bullet) {
            if (player.getBounds().intersects(n.getBounds()))
                return true;
        }
        return false;
    }

    public static boolean Collision5(EnemyBullet bullet, Player player){
            if (bullet.getBounds().intersects(player.getBounds()))
                return true;
        return false;
    }


}
