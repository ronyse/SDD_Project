package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.Shooter;

public class KeyController implements KeyListener {
//add diagonal movement
    @Override
    public void  keyPressed(KeyEvent e) {
        Shooter shooter = (Shooter) Main.gameData.friendFigures.get(0);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                shooter.setVelX(-5);
                
                break;
            case KeyEvent.VK_RIGHT:
                shooter.setVelX(5);
                break;
            case KeyEvent.VK_UP:
                shooter.setVelY(-5);
                break;
            case KeyEvent.VK_DOWN:
                shooter.setVelY(5);
                break;
                 case KeyEvent.VK_A:
                shooter.setVelX(-5);
                break;
            case KeyEvent.VK_D:
                shooter.setVelX(5);
                break;
            case KeyEvent.VK_W:
                shooter.setVelY(-5);
                break;
            case KeyEvent.VK_S:
               shooter.setVelY(5);
                break;
            case KeyEvent.VK_SPACE:
                
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
     Shooter shooter = (Shooter) Main.gameData.friendFigures.get(0);
         switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                shooter.setVelX(0);
                
                break;
            case KeyEvent.VK_RIGHT:
                shooter.setVelX(0);
                break;
            case KeyEvent.VK_UP:
                shooter.setVelY(0);
                break;
            case KeyEvent.VK_DOWN:
                shooter.setVelY(0);
                break;
                 case KeyEvent.VK_A:
                shooter.setVelX(0);
                break;
            case KeyEvent.VK_D:
                shooter.setVelX(0);
                break;
            case KeyEvent.VK_W:
                shooter.setVelY(0);
                break;
            case KeyEvent.VK_S:
               shooter.setVelY(0);
                break;
        }
    }

}
