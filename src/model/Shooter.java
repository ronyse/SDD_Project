package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Shooter extends GameFigure {

    private Image launcherImage;
    private double VelX = 0;
    private double VelY = 0;

    public Shooter(int x, int y) {
        super(x, y);
        super.state = STATE_ALIVE;
        
        launcherImage = null;
        
        try {
            launcherImage = ImageIO.read(getClass().getResource("shooter.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(launcherImage, (int)super.x, (int)super.y, 
                45, 45, null);
    }

    @Override
    public void update() {
        x+=VelX;
        y+=VelY;
    }

    public void translate(int dx, int dy) {
        super.x += dx;
        super.y += dy;
    }
    
    // Missile shoot location: adjut x and y to the image
    public float getXofMissileShoot() {
        return super.x+15;
    }
    
    public float getYofMissileShoot() {
        return super.y;
    }
    public void setVelX(double VelX){
        this.VelX = VelX;
    }
    public void setVelY(double VelY){
        this.VelY = VelY;
    }
    @Override
    public Rectangle2D getCollisionBox() {
        return new Rectangle2D.Double (x, y, 35, 40);
        
    }

    @Override
    public void collision() {
        
    }

}
