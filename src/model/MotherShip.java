
package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import static model.FlyingSaucer.fs;
import static model.FlyingSaucer.o;
import static model.GameFigure.STATE_ALIVE;
import view.EnemyScore;
import view.GamePanel;
import view.ScoreObserver;

public class MotherShip extends GameFigure {
    Color colorUFO = new Color(0x8636ff);
    private Image launcherImage;
    private final int WIDTH = 70;
    private final int HEIGHT = 30;
    private final Color color = colorUFO;
    private int UNIT_TRAVEL;// per frame
    private MSState state;
    public static EnemyScore ms;
    public static ScoreObserver o;
    
    private int direction = 1; // +1: to the right; -1 to the left
    
    public MotherShip(float x, float y) {
        super(x, y);
        super.state = STATE_ALIVE;
        launcherImage = null;
        state = (MSState) new MSAlive();
        if(state.theState() == 0){
            UNIT_TRAVEL = 15;
        } else { UNIT_TRAVEL = 3;}
        try {
            launcherImage = ImageIO.read(getClass().getResource("MS.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
     ms = new EnemyScore();
        o = new ScoreObserver();
        ms.addObserver(o);
    }
        
    
    
    @Override
    public void render(Graphics2D g) {
       g.drawImage(launcherImage, (int)super.x, (int)super.y, 
                140, 60, null);
    }

    @Override
    public void update() {
        if(state.theState() == 1){
        if (direction > 0) {
            // moving to the right
            super.x += UNIT_TRAVEL;
            if (super.x + WIDTH/2 > GamePanel.width-110) {
                direction = -1;
            }
        } else {
            // moving to the left
            super.x -= UNIT_TRAVEL;
            if (super.x - ((WIDTH/2)-35) <= 0) {
                direction = 1;
            }
        }
        }
    if(state.theState() == 2){
        if (direction > 0) {
            // moving to the right
            super.y += UNIT_TRAVEL;
            if (super.y + HEIGHT/2 > GamePanel.height-110) {
                direction = -1;
            }
        } else {
            // moving to the left
            super.y -= UNIT_TRAVEL;
            if (super.y - ((HEIGHT/2)-35) <= 0) {
                direction = 1;
            }
        }
        }
    if(state.theState() == 0){
        if (direction > 0) {
            // moving to the right
            super.y += UNIT_TRAVEL;
            if (super.y + HEIGHT/2 > GamePanel.height-110) {
                direction = 1;
            }
        } else {
            // moving to the left
            super.y -= UNIT_TRAVEL;
            if (super.y - ((HEIGHT/2)-35) <= 0) {
                direction = 1;
                
            }
        }
        }
    }
    
    @Override
    public Rectangle2D getCollisionBox() {
        return new Rectangle2D.Float(x - 20.0F, y - 5.0F, 140.0F, 60.0F);
        
    }

    @Override
    public void collision() {
        goNextState();
    }

    void setState(MSState state) {
        this.state = state;
    }

    private void goNextState() {
       state.goNext(this);
    }
    
}