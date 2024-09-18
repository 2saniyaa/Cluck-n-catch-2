package catchegg.java;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Egg {

	private int x;
	private int y;
	private int width;
	private Image img;
	private static final int speed= 10;
	private static final int maxY = PlayGround.HEIGHT;	
	
	
	public Egg(String imagePath) {
        loadEgg(imagePath);
        x = new Random().nextInt(PlayGround.WIDTH);
        y = 0;
        width = img.getWidth(null);
    }
	
	public void reset() {
	    x = new Random().nextInt(PlayGround.WIDTH);
	    y = 0;
	}

	
    private void loadEgg(String imagePath) {
        ImageIcon eggIcon = new ImageIcon("resources/Egg.png");
        img = eggIcon.getImage();
    }

    public void move() {
        y += speed;  
        if (y > maxY) {
            x = new Random().nextInt(PlayGround.WIDTH);
            y = 0;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Image getImg() {
		return img;
	}

	public int getWidth() {
		return width;
	}
	
}