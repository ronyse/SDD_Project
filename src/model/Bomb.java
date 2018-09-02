package model;

import view.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import view.EnemyScore;
import view.ScoreObserver;



public class Bomb extends GameFigure {

    private final int radius;
    private final Color color;
    public int dx = 1;
    public int dy = 1;
    private BombState state;
    public static int rBomb;
    public static int xBomb;
    public static int yBomb;
    public static int isDying = 0;
    public static EnemyScore bomb;
    public static ScoreObserver o;
   
    
    
    
    
    

    public Bomb(float x, float y, int radius, Color color) {
        super(x, y);
        super.state = STATE_ALIVE;
        //this.x = xBomb;
        //this.y = yBomb;
        this.radius = rBomb;
        this.rBomb = radius;
        this.color = color;
        state = (BombState) new BombAlive();
        bomb = new EnemyScore();
        o = new ScoreObserver();
        bomb.addObserver(o);
        
        
        
        
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(color);
        
        // Note: use drawOval() to draw outline only
        if(state.theState() == 1){
        g.drawOval((int)(x - rBomb), (int)(y - rBomb), 
                rBomb * 2, rBomb * 2);
        }
    if(state.theState() == 2){
        
        g.fillOval((int)(x - rBomb), (int)(y - rBomb), 
                rBomb * 2, rBomb * 2);
        bomb.notifyObservers();
        }
        
       
        
    }
    
        

    @Override
    public void update() {
       if(state.theState() == 1){
       Bounce();
        
       }   else {
           DoNotBounce();
       }
    }
    public void setState(BombState state) {
        this.state = state;
    }
    public void goNextState() {
        state.goNext(this);
    }
   public void Bounce(){
       super.x += dx;
        super.y += dy;

        if (super.x + rBomb > GamePanel.width) {
            dx = -dx;
            super.x = GamePanel.width - radius;
        } else if (super.x - rBomb < 0) {
            dx = -dx;
            super.x = rBomb;
        }

        if (super.y + rBomb > GamePanel.height) {
            dy = -dy;
            super.y = GamePanel.height - rBomb;
        } else if (super.y - rBomb < 0) {
            dy = -dy;
            super.y = rBomb;
        }
       } 
   public void DoNotBounce(){
       super.x += dx;
        super.y += dy;
   }
    @Override
    public Rectangle2D getCollisionBox() {
        return new Rectangle2D.Float(x - rBomb, y - rBomb, rBomb * 2, rBomb * 2);
       
    }

    @Override
    public void collision() {
        goNextState();
    }

    
}
