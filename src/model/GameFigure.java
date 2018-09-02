package model;

import java.awt.Color;
import java.awt.Graphics2D;
import static javafx.scene.paint.Color.color;

public abstract class GameFigure implements CollisionBox{

    // public for a faster access during animation
    public float x;
    public float y;
    
    public int state;
    
    public static final int STATE_ALIVE = 1;
    public static final int STATE_DYING = 2;
    public static final int STATE_DONE = 0;

    public GameFigure(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // how to render on the canvas
    public abstract void render(Graphics2D g);

    // changes per frame
    public abstract void update();
    
    public abstract void collision();

}
