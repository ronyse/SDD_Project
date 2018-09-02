
package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import static model.Bomb.bomb;
import static model.Bomb.o;
import view.GamePanel;
import view.EnemyScore;
import view.ScoreObserver;

public class FlyingSaucer extends GameFigure {
    Color colorUFO = new Color(0x8636ff);
    private Image launcherImage;
    private final int WIDTH = 50;
    private final int HEIGHT = 15;
    private final Color color = colorUFO;
    private final int UNIT_TRAVEL = 3; // per frame
    private FSState state;
     public static EnemyScore fs;
    public static ScoreObserver o;
    
    private int direction = 1; // +1: to the right; -1 to the left
    
    public FlyingSaucer(float x, float y) {
        super(x, y);
        super.state = STATE_ALIVE;
        launcherImage = null;
        state = (FSState) new FSAlive();
        
        try {
            launcherImage = ImageIO.read(getClass().getResource("UFO.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
        fs = new EnemyScore();
        o = new ScoreObserver();
        fs.addObserver(o);
    }

    @Override
    public void render(Graphics2D g) {
       g.drawImage(launcherImage, (int)super.x, (int)super.y, 
                50, 15, null);
    }

    @Override
    public void update() {
        if(state.theState() == 1){
        if (direction > 0) {
            // moving to the right
            super.y += UNIT_TRAVEL;
            if (super.y + HEIGHT/2 > GamePanel.height -30) {
                direction = -1;
            }
        } else {
            // moving to the left
            super.y -= UNIT_TRAVEL;
            if (super.y - ((HEIGHT/2)-10) <= 0) {
                direction = 1;
            }
        }
        }
       if(state.theState() == 2){
        if (direction > 0) {
            // moving to the right
            super.x += UNIT_TRAVEL;
            if (super.x + WIDTH/2 > GamePanel.width -50) {
                direction = 1;
                
            }
        }else {
            // moving to the left
            super.x += UNIT_TRAVEL;
            if (super.x - ((WIDTH/2)-25) <= 0) {
                direction = 1;
            }
        } 
        } 
    }
    @Override
    public Rectangle2D getCollisionBox() {
       
        return new Rectangle2D.Float(x - 20.0F, y - 5.0F, 40.0F, 10.0F);
        
        
   
    }

    @Override
    public void collision() {
        goNextState();
    }

    void setState(FSState state) {
        this.state = state;
    }

    private void goNextState() {
         state.goNext(this);
    }
    
}
