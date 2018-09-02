package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainWindow;

public class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == MainWindow.addButton) {
           
            Main.gameData.add(10);
           
           
            
           
           
        }  if (ae.getSource() == MainWindow.quitButton) {
            if (Main.animator.running) {
                Main.animator.running = false;
            } 
else {
                System.exit(0);
            }
       
        }
        if(ae.getSource() == MainWindow.ufoButton){
                Main.gameData.addUFO(1);
             
          
                
            }
        if(ae.getSource() == MainWindow.msButton){
                Main.gameData.addMS(1);
             
          
                
            }
         if(ae.getSource() == MainWindow.newButton){
                Main.gamePanel.NewGame();
                
             
          
                
            }
          if(ae.getSource() == MainWindow.startButton){
                Main.gamePanel.StartGame();
                
             
          
                
            }
    }

}
