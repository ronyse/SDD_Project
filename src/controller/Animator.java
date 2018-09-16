package controller;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import model.Bomb;
import model.GameData;

import model.GameFigure;
import model.MotherShip;


public class Animator implements Runnable {

    public boolean running = true;
    private final int FRAMES_PER_SECOND =60;
    public  model.MotherShip motherShip;
    private  model.Bomb bomb;
    private  model.FlyingSaucer ufo;
    private int i = 0;
    public int enemyCounter = 0;
    public int health = 100;
    public int bossCounter = 0;
    public GameFigure enemy;
    public GameFigure friend;
    public String friendString;
    
   
    Color color;
    
    
   
    @Override
    public void run() {

        while (running) {
            long startTime = System.currentTimeMillis();

           

            Main.gameData.update();                   
            Main.gamePanel.gameRender();              
            Main.gamePanel.printScreen();             
            
            processCollisions();

            long endTime = System.currentTimeMillis();
            int sleepTime = (int) (1.0 / FRAMES_PER_SECOND * 1000)
                    - (int) (endTime - startTime);

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime); // ms
                } catch (InterruptedException e) {

                }
            }
        }
        System.exit(0);
        
    }

    private synchronized void processCollisions() {
     int killed = Main.gameData.getKilledEnemies();
                              
        for (GameFigure friendFigure : Main.gameData.friendFigures) {
            Rectangle2D friendlyBox = ((GameFigure) friendFigure).getCollisionBox();
          for (GameFigure enemyFigure : Main.gameData.enemyFigures) {
              enemy = (GameFigure) enemyFigure;
                friend = (GameFigure) friendFigure;
              if(friendlyBox.intersects(enemy.getCollisionBox())){
                 
                  enemy.collision();
                  friend.collision();
                  
                  String enemyString = enemy.toString();
                  friendString = friend.toString();
                  
                  if(enemyString.startsWith("model.Mother")){
                      bossCounter++;
                      if(bossCounter >= 250){
                            
                            bossCounter = 250;
                           killed = killed + 10;  
                           Main.gameData.setKilledEnemies(killed);
                      }
                     
                       
                           
                       
                    if(health > 0 && friendString.startsWith("model.Shooter")){
                           enemyCounter++;
                           
                      
                   
                  }
                     
                    
                  
                      
            
              }if(enemyString.startsWith("model.Bomb")){
                  if(health > 0 && friendString.startsWith("model.Shooter")){  
                  //health = health - 5;
                  
                  }
                  
                  
                  
                  
                
                 // enemy.state = 0;
                       killed++;
                       enemyCounter++;
                       
                  Main.gameData.setKilledEnemies(killed);
                  }if(enemyString.startsWith("model.Fly")){
                     if(health > 0 && friendString.startsWith("model.Shooter")){
                      //health = health - 10;
                     }
                     
                      //enemy.state = 0;
                       killed = killed + 5;
                       enemyCounter++;
                       
                  Main.gameData.setKilledEnemies(killed);
                  }
                  
          }
        
                          }
        

    }

}
}


