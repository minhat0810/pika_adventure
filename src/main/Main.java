package main;

import javax.swing.JFrame;



public class Main extends JFrame {

	public Main() {
	
//		jframe.setSize(400, 400);
	    setTitle("CUỘC PHIÊU LƯU CỦA PIKACHU");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    GamePanel gamePanel = new GamePanel();
	    add(gamePanel);
	    
	    setResizable(false);
	   pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
	    gamePanel.setupGame();
		gamePanel.startGameLoop();
	 
	}
  public static void main(String[] args) {
////	JFrame jframe = new JFrame();
//////	jframe.setSize(400, 400);
////    jframe.setTitle("CUỘC PHIÊU LƯU CỦA CHẤN BÉ ĐÙ");
////    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////    GamePanel gamePanel = new GamePanel();
////    jframe.add(gamePanel);
////    
////    jframe.setResizable(false);
////    jframe.pack();
////    jframe.setLocationRelativeTo(null);
////    jframe.setVisible(true);
////    gamePanel.setupGame();
////	gamePanel.startGameLoop();
	  new Main();
  }
}
