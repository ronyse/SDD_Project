package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import view.GamePanel;


/** class added by ekome ey a vann ronyse sprint 1  
 * 
 * @author ronys
 * 
 * this class will create a menu option for the game 
 * 
 * GamePanel aggregate Menu 
 * 
 * 
 * 
 */



public class Menu{
    
    /**change 1 --> C1
     * change all the GameManager to GamePanel 
     * change all the WIDTH to width 
     * 
     */
	/*
	//public Rectangle contButton = new Rectangle(GamePanel.width / 2 + 575, 150, 250, 40); // C1
	public Rectangle playButton = new Rectangle(GamePanel.width / 2 + 320, 150, 250, 40);// C1
	public Rectangle howToPlayButton = new Rectangle(GamePanel.width / 2 + 320, 250, 250, 40);// C1
	public Rectangle settingsButton = new Rectangle( GamePanel.width / 2 + 320, 350, 250, 40);// C1
	public Rectangle quitButton = new Rectangle( GamePanel.width / 2 + 320, 450, 250, 40);// C1
	*/
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.red);
		g.drawString("SPACE INVADERS",GamePanel.WIDTH / 2 + 230, 100);
		/*
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		
                
		if (!GamePanel.getInstance().isGameOver()) {    // C1
			g.setColor(Color.green);
			g.drawString("    CONTINUE", contButton.x + 19,contButton.y + 30 );
			g2d.draw(contButton);
		}
                */
                /*
		g.setColor(Color.red);
		g.drawString("       PLAY", playButton.x + 19,playButton.y + 30 );
		g2d.draw(playButton);
		g.drawString("HOW TO PLAY", howToPlayButton.x + 19,howToPlayButton.y + 30 );
		g2d.draw(howToPlayButton);
		g.drawString("    SETTINGS", settingsButton.x + 19,settingsButton.y + 30 );
		g2d.draw(settingsButton);
		g.drawString("        QUIT", quitButton.x + 19,quitButton.y + 30 );
		g2d.draw(quitButton);
                */
		
	}

}