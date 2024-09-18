package catchegg.java;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameOverWindow extends JFrame {
	
    private static final long serialVersionUID = 1L;

    private Image gameOverImage;

    GameOverWindow() {
    	
        setTitle("GameOver");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        gameOverImage = Toolkit.getDefaultToolkit().getImage("resources/GameOver.jpeg");       
        JPanel gameOverPanel = new JPanel() {

	private static final long serialVersionUID = 1L;

	@Override
        protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
        g.drawImage(gameOverImage, 0, 0, getWidth(), getHeight(), this);
        
       }
   };

        add(gameOverPanel);
        setVisible(true);
    }
}