package view;

import controller.Main;
import model.GameFigure;

/*
 * Participant: ConcreteObserver
 */

public class ScoreObserver implements Observer {

    @Override
    public void update(Event e) {
        
        if(e.getSubject() == model.Bomb.bomb && Main.animator.friendString.startsWith("model.Shooter")){
            
            Main.animator.health = Main.animator.health - 5;
        }
        if(e.getSubject() == model.FlyingSaucer.fs && Main.animator.friendString.startsWith("model.Shooter")){
            
             Main.animator.health = Main.animator.health - 10;
        }
        if(e.getSubject() == model.MotherShip.ms && Main.animator.friendString.startsWith("model.Shooter")){
            
             Main.animator.health = Main.animator.health - 25;
        }
        
    }
}
