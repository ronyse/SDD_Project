package model;

import controller.Main;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Missile extends GameFigure {

    // missile size
    private static final int SIZE = 5;
    private static final int MAX_EXPLOSION_SIZE = 50;
    
    private float dx; // displacement at each frame
    private float dy; // displacement at each frame
    public static Color colorM = new Color(0xe400ff);
    public static Color colorM2 = new Color(0x00ba39);

    // public properties for quick access
    //public Color color;
    public Point2D.Float target;

    private static final int UNIT_TRAVEL_DISTANCE = 4; // per frame move

    private int size = SIZE;

    /**
     *
     * @param sx start x of the missile
     * @param sy start y of the missile
     * @param tx target x of the missile
     * @param ty target y of the missile
     * @param color color of the missile
     */
    public Missile(float sx, float sy, float tx, float ty, Color color) {
        super(sx, sy);
        super.state = STATE_ALIVE;
        target = new Point2D.Float(tx, ty);
        this.colorM = color;
        double angle = Math.atan2(Math.abs(ty - sy), Math.abs(tx - sx));
        dx = (float) (UNIT_TRAVEL_DISTANCE * Math.cos(angle));
        dy = (float) (UNIT_TRAVEL_DISTANCE * Math.sin(angle));
        
        if (tx > sx && ty < sy) { // target is upper-right side
            dy = -dy; // dx > 0, dx < 0
        } else if (tx < sx && ty < sy) { // target is upper-left side
            dx = -dx;
            dy = -dy;
        } else if (tx < sx && ty > sy) { // target is lower-left side
            dx = -dx;
        } else { // target is lower-right side
            // dx > 0 , dy > 0
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(Main.animator.enemyCounter >= 500){
            g.setColor(colorM2);
        }
        if(Main.animator.enemyCounter < 500){
            g.setColor(colorM);
        }
        
        g.drawOval((int) (super.x - size / 2),
                (int) (super.y - size / 2),
                size, size);
    }

    @Override
    public void update() {
        updateState();
        if (state == STATE_ALIVE) {
            updateLocation();
        } else if (state == STATE_DYING) {
            updateSize();
        }
    }

    public void updateLocation() {
        
        super.x += dx;
        super.y += dy;
    }

    public void updateSize() {
        size += 1;
    }

    public void updateState() {
        if (state == STATE_ALIVE) {
            double distance = target.distance(super.x, super.y);
            boolean targetReached = distance <= 2.0;
            if (targetReached) {
                state = STATE_DYING;
            }
        } else if (state == STATE_DYING) {
            if (size >= MAX_EXPLOSION_SIZE) {
                state = STATE_DONE;
            }
        }
    }
    
    @Override
    public Rectangle2D getCollisionBox() {
       return new Rectangle2D.Double (x - size / 2, y - size/2, size, size);
        
    }

    @Override
    public void collision() {
        
    }

}
