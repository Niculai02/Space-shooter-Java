package com.company.main;

import entity.enemy.*;
import entity.player.Bullet;
import entity.player.BulletCreator;
import entity.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

import static javax.imageio.ImageIO.read;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 3;
    public int count=0;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenColumn = 12;
    final int maxScreenRow = 14;
    final int screenWidth = tileSize * maxScreenColumn;
    final int screenHeight= tileSize * maxScreenRow;
    private BufferedImage background = null;
    private BufferedImage lv1 = null;
    private BufferedImage lv2 = null;
    private BufferedImage lv3 = null;
    private BufferedImage backgroundINFO = null;
    double FPS = 60;
    public KeyHandler keyH = new KeyHandler();
    public Thread gameThread;
    public Player player = new Player(this, keyH);
    public BulletCreator controller = new BulletCreator(this);
    public EnemyCreator enemyCreator = new EnemyCreator((this));
    public Enemy1Creator enemy1Creator = new Enemy1Creator((this));
    public Enemy2Creator enemy2Creator = new Enemy2Creator(this);
    public Enemy3Creator enemy3Creator = new Enemy3Creator(this);
    public Enemy4Creator enemy4Creator = new Enemy4Creator(this);
    public EnemyBulletCreator enemyBulletCreator = new EnemyBulletCreator(this);
    public LinkedList<Bullet> llb = controller.b;
    public LinkedList<Enemy> lle1 = enemyCreator.b;
    public int Lv1Kills=0;
    public int Lv2Kills=0;
    public int Lv3Kills=0;
    public int Lv1Score=0;
    public int Lv2Score=0;
    public int Lv3Score=0;

    public static int Lv1Done=0;
    public static int Lv2Done=0;
    private final Menu menu;
    private final PlayMenu playMenu;
    public static DataBase db1 = DataBase.GetInstance();

    public enum STATE{
        MENU,
        PLAYMENU,
        GAME,
        INFO,
        LEVEL1COMPLETED,
        LEVEL2COMPLETED,
        LEVEL3COMPLETED
    }
    public enum LEVEL{
        LEVEL1,
        LEVEL2,
        LEVEL3
    }
    public static LEVEL Level;
    public static STATE State = STATE.MENU;
    public GamePanel(){
        this.setPreferredSize( new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        try {
            background = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/bg.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            backgroundINFO = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/info.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            lv1 = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/lv1completed.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            lv2 = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/level2completed.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            lv3 = read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/level3completed.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        playMenu = new PlayMenu();
        menu = new Menu();
        this.addMouseListener(new MouseInput());
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1 ){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        if(State == STATE.GAME){
            player.update();
            count++;
            if(keyH.spacePressed){
                if(count%15==0)
                    controller.addBullet(new Bullet(this, player.x, player.y));
            }
            enemyCreator.update();
            enemy1Creator.update();
            enemyBulletCreator.update();
            enemy2Creator.update();
            enemy3Creator.update();
            enemy4Creator.update();
            controller.update();
            for(Enemy1 enemy1 : enemy1Creator.b){
                if(count%40==0)
                    enemyBulletCreator.addEnemyBullet(new EnemyBullet(this, enemy1.x, enemy1.y,5));
            }
            for(Enemy enemy : enemyCreator.b){
                if(count%60==0)
                    enemyBulletCreator.addEnemyBullet(new EnemyBullet(this, enemy.x, enemy.y,4));
            }
            for(Enemy2 enemy2 : enemy2Creator.b){
                if(count%60==0)
                    enemyBulletCreator.addEnemyBullet(new EnemyBullet(this, enemy2.x, enemy2.y,4));
            }
            for(Enemy3 enemy3 : enemy3Creator.b){
                if(count%50==0)
                    enemyBulletCreator.addEnemyBullet(new EnemyBullet(this, enemy3.x, enemy3.y,5));
            }
            for(Enemy4 enemy4 : enemy4Creator.b){
                if(count%40==0)
                    enemyBulletCreator.addEnemyBullet(new EnemyBullet(this, enemy4.x, enemy4.y,5));
            }
        }

        else if (State == STATE.MENU){
            reset();
        }

    }

    public void paintComponent(Graphics g){
        g.drawImage(background,0,0, null);
        if(State == STATE.GAME) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(background,0,0, null);
            player.draw(g2);
            controller.draw(g2);
            enemyCreator.draw(g2);
            enemy1Creator.draw(g2);
            enemyBulletCreator.draw(g2);
            enemy2Creator.draw(g2);
            enemy3Creator.draw(g2);
            enemy4Creator.draw(g2);
            g2.dispose();
        }
        else if(State == STATE.PLAYMENU){
            playMenu.draw(g, this);
            drawBacktoMenu(g);
        }
        else if(State == STATE.MENU)
            menu.draw(g);
        else if(State == STATE.INFO){
            g.drawImage(backgroundINFO,0,0, null);
            drawBacktoMenu(g);
        }
        else if (State == STATE.LEVEL1COMPLETED){
            g.drawImage(lv1, -30, -30, null);
            drawBacktoMenu(g);
            showScores(g);
            Lv1Done = 1;
            db1.setScore(Lv1Score,1);
        }
        else if (State == STATE.LEVEL2COMPLETED){
            g.drawImage(lv2, -30, -30, null);
            drawBacktoMenu(g);
            showScores(g);
            Lv2Done = 1;
            db1.setScore(Lv2Score,2);
        }
        else if (State == STATE.LEVEL3COMPLETED){
            g.drawImage(lv3, -8, -30, null);
            drawBacktoMenu(g);
            showScores(g);
            db1.setScore(Lv3Score,3);
            //JOptionPane.showMessageDialog(null, "Level 1: "+db1.getScore(1)+"\nLevel 2: "+db1.getScore(2)+"\nLevel 3: "+db1.getScore(3), "Your Scores", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void drawBacktoMenu(Graphics g){
        Font f = new Font("arial", Font.BOLD, 10);
        g.setFont(f);
        g.setColor(Color.WHITE);
        g.drawString("Q - MENU ", 15, 20);

    }

    public void showScores(Graphics g){
        Font f = new Font("arial", Font.BOLD, 10);
        g.setFont(f);
        g.setColor(Color.WHITE);
        g.drawString("X - SHOW SCORES ", 15, 35);
    }

    public void reset(){
        player = new Player(this, keyH);
        controller = new BulletCreator(this);
        enemyCreator = new EnemyCreator(this);
        enemy1Creator = new Enemy1Creator(this);
        enemy2Creator = new Enemy2Creator(this);
        enemy3Creator = new Enemy3Creator(this);
        enemy4Creator = new Enemy4Creator(this);
        enemyBulletCreator = new EnemyBulletCreator(this);
        llb = controller.b;
        lle1 = enemyCreator.b;
        Lv1Kills=0;
        Lv2Kills=0;
        Lv3Kills=0;
        Lv1Score=0;
        Lv2Score=0;
        Lv3Score=0;

    }
}
