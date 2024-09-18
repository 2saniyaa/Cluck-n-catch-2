package catchegg.java;

import javax.swing.JFrame;

public class GameWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	GameWindow() {
		add(new PlayGround("resources/Background.jpeg"));
		setTitle("Cluck n catch");
		setSize(800,1000);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
				
	}
}