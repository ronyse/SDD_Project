package view;

import controller.Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import model.GameFigure;
import model.Missile;
import static view.MainWindow.addButton;
import static view.MainWindow.msButton;
import static view.MainWindow.quitButton;
import static view.MainWindow.startButton;
import static view.MainWindow.ufoButton;


public class GamePanel extends JPanel {
    
    // size of the canvas - determined at runtime once rendered
    public static int width;
    public static int height;
    public boolean gameStart;
    public int addBossCounter = 0;
    Color color3 = new Color(0x1f1f1f);
    Color color4 = new Color(0x293349);
    Color color5 = new Color(0x00ba39);

    // off screen rendering
    private Graphics2D g2;
    private Image dbImage = null; // double buffer image

    public void gameRender() {
        width = getSize().width;
        height = getSize().height;
        if (dbImage == null) {
            // Creates an off-screen drawable image to be used for double buffering
            dbImage = createImage(width, height);
            if (dbImage == null) {
                System.out.println("Critical Error: dbImage is null");
                System.exit(1);
            } else {
                g2 = (Graphics2D) dbImage.getGraphics();
            }
        }

        g2.clearRect(0, 0, width, height);
        g2.setBackground(color3);
         if(Main.animator.enemyCounter >= 500){
         g2.setBackground(color4);
         }

        if (Main.animator.running) {
                        
            synchronized (Main.gameData.enemyFigures) {
                
                for (GameFigure f : Main.gameData.enemyFigures) {
                    f.render(g2);
                }
            
               
                
            }
            
             synchronized (Main.gameData.friendFigures) {
                for (GameFigure f : Main.gameData.friendFigures) {
                    f.render(g2);
                }
             }
        }
    }

    // use active rendering to put the buffered image on-screen
    public synchronized void printScreen() {
        Graphics g;
        try {
            g = this.getGraphics();
            if ((g != null) && (dbImage != null)) {
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync();  // sync the display on some systems
            if (g != null) {
                g.dispose();
            }
        } catch (Exception e) {
            System.out.println("Graphics error: " + e);
        }
    }
public void NewGame() {
    gameStart = false;    
    addButton.setEnabled(true);
        quitButton.setEnabled(true);
        ufoButton.setEnabled(true);
        msButton.setEnabled(true);
        startButton.setEnabled(true);
        Main.gameData.setKilledEnemies(0);
        Main.gameData.setTotalEnemies(0);
        Main.animator.health = 1000;
        addBossCounter = 0;
        Main.animator.bossCounter = 0;
        
        Main.animator.enemyCounter = 0;
       for (GameFigure enemyFigure : Main.gameData.enemyFigures) {
              GameFigure enemy = (GameFigure) enemyFigure;
        enemy.state = 0;
        
       }

    }
public void StartGame(){
   gameStart = true;
    
    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
exec.scheduleAtFixedRate(new Runnable() {
  @Override
  public void run() {
      
     if(gameStart == true){
      Main.gameData.add(20);
    Main.gameData.addUFO(5);
    
    startButton.setEnabled(false);
    if(Main.animator.enemyCounter >= 500){
         g2.setBackground(color4);
        Main.gameData.add(25);
    Main.gameData.addUFO(7);
    if(addBossCounter == 0){
       Main.gameData.addMS(1); 
       addBossCounter++;
    }
    
    startButton.setEnabled(false);
    Missile.colorM = color5;
    
    
    
    }
  }
  }
}, 0, 10, TimeUnit.SECONDS);
   } 
   
    
   } 

        
    


