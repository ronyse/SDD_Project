package model;

import controller.Main;
import view.GamePanel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import view.MainWindow;
import static view.MainWindow.addButton;
import static view.MainWindow.msButton;
import static view.MainWindow.ufoButton;

public class GameData {

    private int totalEnemies = 0;
    private int killedEnemies = 0;
    private int bossCounter = 0;

    private final int RADIUS = 6;
    public final List<GameFigure> enemyFigures;
    public final List<GameFigure> friendFigures;
    public static Shooter shooter;

    public GameData() {
        enemyFigures = Collections.synchronizedList(
                new ArrayList<GameFigure>());

        friendFigures = Collections.synchronizedList(
                new ArrayList<GameFigure>());

        // GamePanel.width, height are known when rendered. 
        // Thus, at this moment,
        // we cannot use GamePanel.width and height.
        shooter = new Shooter(Main.WIN_WIDTH / 2, Main.WIN_HEIGHT - 130);

        friendFigures.add(shooter);

        //enemyFigures.add(new FlyingSaucer(50, 60));
        //enemyFigures.add(new FlyingSaucer(400, 20));
    }

    public void add(int n) {
        Main.gameData.getTotalEnemies();
        totalEnemies += n;
        Main.gameData.setTotalEnemies(totalEnemies);

        synchronized (enemyFigures) {
            for (int i = 0; i < n; i++) {
                float red = (float) Math.random();
                float green = (float) Math.random();
                float blue = (float) Math.random();
                // adjust if too dark since the background is black
                if (red < 0.5) {
                    red += 0.2;
                }
                if (green < 0.5) {
                    green += 0.2;
                }
                if (blue < 0.5) {
                    blue += 0.2;
                }
                enemyFigures.add(new Bomb(
                        (int) (Math.random() * GamePanel.width),
                        (int) (Math.random() * GamePanel.height),
                        RADIUS,
                        new Color(red, green, blue)));

            }

        }
    }

    public void addUFO(int n) {
        Main.gameData.getTotalEnemies();
        totalEnemies += n;
        Main.gameData.setTotalEnemies(totalEnemies);

        synchronized (enemyFigures) {
            for (int i = 0; i < n; i++) {
                enemyFigures.add(new FlyingSaucer(
                        (float) (Math.random() * GamePanel.width),
                        (float) (Math.random() * GamePanel.height)));

            }
        }
    }

    public void addMS(int n) {
        Main.gameData.getTotalEnemies();
        totalEnemies += n;
        Main.gameData.setTotalEnemies(totalEnemies);

        synchronized (enemyFigures) {
            for (int i = 0; i < n; i++) {
                enemyFigures.add(new MotherShip(
                        (float) (Math.random() * GamePanel.width),
                        45));

            }
        }
    }
    ArrayList remove = new ArrayList();

    public void update() {

        // no enemy is removed in the program
        // since collision detection is not implemented yet.
        // However, if collision detected, simply set
        // f.state = GameFigure.STATE_DONE
        int i;
        synchronized (enemyFigures) {

            for (i = 0; i < enemyFigures.size(); i++) {
                GameFigure f = enemyFigures.get(i);

                if (f.state == 0) {
                    remove.add(f);
                }
            }
            enemyFigures.removeAll(remove);

            for (GameFigure g : enemyFigures) {
                g.update();
                
            }
        }

        synchronized (friendFigures) {
            ArrayList remove = new ArrayList();

            for (i = 0; i < friendFigures.size(); i++) {
                GameFigure f = (GameFigure) friendFigures.get(i);
                if (f.state == 0) {
                    remove.add(f);

                }
            }
            friendFigures.removeAll(remove);

            for (GameFigure g : friendFigures) {
                g.update();
            }

        }
        int totalEnemies = Main.gameData.getTotalEnemies();

        int killedEnemies = Main.gameData.getKilledEnemies();
        int aliveEnemies = totalEnemies - killedEnemies;
         MainWindow.message
                .setText("Stats: Total Enemies Spawned = " + totalEnemies
                        + ", Score = " + killedEnemies + ", Health: " + Main.animator.health + ", Level: 1"+ " Boss Health: " + (250 - Main.animator.bossCounter));
        if(Main.animator.enemyCounter >= 500){
             MainWindow.message
                .setText("Stats: Total Enemies Spawned = " + totalEnemies
                        + ", Score = " + killedEnemies + ", Health: " + Main.animator.health +", Level: 2," + " Boss Health: " + (250 - Main.animator.bossCounter));
        }
        if (Main.animator.health <= 0) {
            MainWindow.message
                    .setText("Stats: Total Enemies Spawned = " + totalEnemies
                            + ", Score = " + killedEnemies + ", GAME OVER!!!!");
            addButton.setEnabled(false);

            ufoButton.setEnabled(false);
            msButton.setEnabled(false);
            Main.gamePanel.gameStart = false;
            for (GameFigure enemyFigure : Main.gameData.enemyFigures) {
                GameFigure enemy = (GameFigure) enemyFigure;
                enemy.state = 0;
            }
        }
    }

    public synchronized void increaseKilled(int killed) {

        killed = Main.gameData.getKilledEnemies();
        killed++;

        Main.gameData.setKilledEnemies(killed);

       

    }

    public int getTotalEnemies() {
        return totalEnemies;
    }

    public void setTotalEnemies(int totalEnemies) {
        this.totalEnemies = totalEnemies;
    }

    public int getKilledEnemies() {
        return killedEnemies;
    }

    public void setKilledEnemies(int killedEnemies) {
        this.killedEnemies = killedEnemies;
    }
    public int getBossHealth() {
        
        return bossCounter;
    }
    
    public void setBossHealth(int bossCounter){
    this.bossCounter = bossCounter;
}

}
