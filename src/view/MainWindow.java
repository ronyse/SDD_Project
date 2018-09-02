package view;

import controller.ButtonListener;
import controller.KeyController;
import controller.Main;
import static controller.Main.gamePanel;
import controller.MouseController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

    public static JTextField message;

    public static JButton addButton;
    public static JButton quitButton;
    public static JButton ufoButton;
    public static JButton msButton;
    public static JButton newButton;
    public static JButton startButton;
    
    Color color = new Color(0x6f36ff);
    Color color2 = new Color(0x8d0081);
    Color color3 = new Color(0x454545);
        
    
    

    public MainWindow() {

        Container c = getContentPane();

        message = new JTextField(" ");
        message.setBackground(color);
        message.setForeground(Color.WHITE);

        message.setFont(new Font("Courier New", Font.BOLD, 16));
        message.setEditable(false);
        c.add(message, "North");
        message.setHorizontalAlignment(JTextField.CENTER);
        
        c.setBackground(color2);
        gamePanel.setBackground(color3);
        
        
        c.add(Main.gamePanel, "Center");
        
        
        

        JPanel southPanel = new JPanel();
        southPanel.setBackground(color);
        startButton = new JButton("Start Game");
        startButton.setBackground(color2);
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);
        startButton.setForeground(Color.WHITE);
        southPanel.add(startButton);
        newButton = new JButton("New Game");
        newButton.setBackground(color2);
        newButton.setOpaque(true);
        newButton.setBorderPainted(false);
        newButton.setForeground(Color.WHITE);
        southPanel.add(newButton);
        addButton = new JButton("Add 10");
        addButton.setBackground(color2);
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);
        addButton.setForeground(Color.WHITE);
        southPanel.add(addButton);
        ufoButton = new JButton("Add UFO");
        ufoButton.setBackground(color2);
        ufoButton.setOpaque(true);
        ufoButton.setBorderPainted(false);
        ufoButton.setForeground(Color.WHITE);
        southPanel.add(ufoButton);
        msButton = new JButton("Add MS");
        msButton.setBackground(color2);
        msButton.setOpaque(true);
        msButton.setBorderPainted(false);
        msButton.setForeground(Color.WHITE);
        southPanel.add(msButton);
        quitButton = new JButton("Quit");
        quitButton.setBackground(color2);
        quitButton.setOpaque(true);
        quitButton.setBorderPainted(false);
        quitButton.setForeground(Color.WHITE);
        southPanel.add(quitButton);

        c.add(southPanel, "South");

        ButtonListener buttonListener = new ButtonListener();
        addButton.addActionListener(buttonListener);
        quitButton.addActionListener(buttonListener);
        ufoButton.addActionListener(buttonListener);
        msButton.addActionListener(buttonListener);
        newButton.addActionListener(buttonListener);
        startButton.addActionListener(buttonListener);
        
        addButton.setEnabled(false);
        startButton.setEnabled(false);
        ufoButton.setEnabled(false);
        msButton.setEnabled(false);

        MouseController mouseController = new MouseController();
        Main.gamePanel.addMouseListener(mouseController);
        Main.gamePanel.addMouseMotionListener(mouseController);

        KeyController keyListener = new KeyController();
        Main.gamePanel.addKeyListener(keyListener);

        // have ONLY ONE Component "true", the rest must be "false"
        Main.gamePanel.setFocusable(true);
        addButton.setFocusable(false);
        quitButton.setFocusable(false);
        ufoButton.setFocusable(false);
        msButton.setFocusable(false);
        message.setFocusable(false);
        newButton.setFocusable(false);
        startButton.setFocusable(false);

    }

}
