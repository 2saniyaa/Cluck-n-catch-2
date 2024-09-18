package catchegg.java;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Duck {
	
	private int dx;
	private int x = 0;
	private int y = 0;
	private int w;
	private int h;
	private Image image;
	
	
	public Duck(String location) {
		loadDuck(location);
		
		x = (PlayGround.WIDTH -w) ;
		y = (PlayGround.HEIGHT -h) ;
				
	}
	
	private void loadDuck(String location) {
		ImageIcon duck = new ImageIcon(location);
		image = duck.getImage();
		w = image.getWidth(null);
		h = image.getHeight(null);
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
	public void move() {
		x += dx;
		
		if (x < 0) {
	        x = 0;
	    }
	    if (x > (PlayGround.WIDTH - w)) {
	        x = PlayGround.WIDTH - w;
	    }
	  
	}
	
	public Image getImage() {
        return image;
    }
	
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -10;  
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 10;
        }

    }


	public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

    } 
}
