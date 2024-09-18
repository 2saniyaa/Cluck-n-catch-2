package catchegg.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class PlayGround extends JPanel implements ActionListener{
	
	 private static final long  serialVersionUID = 1L;
	 
	 private Timer timer;
	 private Duck duck;
	 private Egg egg;
	 private Egg2 egg2;
	 private final int DELAY = 10;
	 private Image bgimage;
	 private int score = 0;
	 private Clip catchSound;
	 private Clip gameOverSound;
	 
	
	 public static final int WIDTH = 800;  
	 public static final int HEIGHT = 800; 
		
	    
	    PlayGround(){
	    	addKeyListener(new TAdapter());
	 
	        setBackground(Color.black);
	    	
	        setFocusable(true);
	        
	        duck = new Duck("resources/Duck.png");
	        egg = new Egg("resources/Egg.png");
	        egg2 = new Egg2("resources/Egg2.png");
	        timer = new Timer(DELAY, this);
	        timer.start();
	        loadSounds();
	    }
	    
	    
	    PlayGround(String location){
	    	addKeyListener(new TAdapter());
	    	
	        setFocusable(true);
	     
	        bgimage = Toolkit.getDefaultToolkit().getImage(location);
	        duck = new Duck("resources/Duck.png");
	        egg = new Egg("resources/Egg.png");
	        egg2 = new Egg2("resources/Egg2.png");
	        timer = new Timer(DELAY, this);
	        timer.start();
	        loadSounds();
	    }	    
	    
		@Override
		public void actionPerformed(ActionEvent e) {
			
			refresh();	
			duck.move();
		    egg.move();
		    egg2.move();
		    repaint();
		    
		if (isCollision(duck, egg)) {
		        egg.reset();
		        playCatchSound();
		    }
		

		if (egg2.isCollision(duck)) {
			timer.stop();
			playGameOverSound();
			new GameOverWindow();
			
		}
		  	
		}
	    private void refresh() {
	        duck.move();
	        repaint();
	    }
	    
	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if(bgimage != null)
	        g.drawImage(bgimage,0,0,getWidth(),getHeight(),this);
	        draw(g);
	        Font scoreFont = new Font("Arial", Font.BOLD, 30); // Change the font size to 30
	        g.setFont(scoreFont);
	        g.setColor(Color.black);
	        g.drawString("Score: " + score, 40, 40);
	        
	        Toolkit.getDefaultToolkit().sync();
	    }
	    
	    private void draw(Graphics g) {
	        
	        Graphics2D g2d = (Graphics2D) g;
			
	        egg.draw(g);
	        egg2.draw(g);
	        g2d.drawImage(duck.getImage(), duck.getX(), duck.getY(), this);
	       
	    }
	    
	    private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyReleased(KeyEvent e) {
	            duck.keyReleased(e);
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	            duck.keyPressed(e);
	        }
	    }
	    
	   
	    
	    
	    private boolean isCollision(Duck duck, Egg egg) {
	        int duckX = duck.getX();
	        int duckY = duck.getY();
	        int duckWidth = duck.getWidth();
	        int duckHeight = duck.getHeight();

	        int eggX = egg.getX();
	        int eggY = egg.getY();
	        int eggWidth = egg.getWidth();
	        int eggHeight = egg.getImg().getHeight(null);

	        if (duckX < eggX + eggWidth &&
	            duckX + duckWidth > eggX &&
	            duckY < eggY + eggHeight &&
	            duckY + duckHeight > eggY) {
	        	
	            score++;  
	          
	            
	        return true;
	        } 
	        
	       else {
	            return false;
	        }
	  }
	    private void loadSounds() {
	        try {
	            AudioInputStream catchSoundStream = AudioSystem.getAudioInputStream(new File("resources/Catchsound.wav"));
	            catchSound = AudioSystem.getClip();
	            catchSound.open(catchSoundStream);

	            AudioInputStream gameOverSoundStream = AudioSystem.getAudioInputStream(new File("resources/Gameoversound.wav"));
	            gameOverSound = AudioSystem.getClip();
	            gameOverSound.open(gameOverSoundStream);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private void playCatchSound() {
	        catchSound.setFramePosition(0);
	        catchSound.start();
	    }

	    private void playGameOverSound() {
	        gameOverSound.setFramePosition(0);
	        gameOverSound.start();
	    }
	
	        
 } 