package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import controller.KeyboardInput;
import entity.Entity;
import entity.NPC_KLL;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	// SETTING SCREEN
//   final int orginalTileSize = 16; //16*16 tile
//   final int scale = 3;
   public final int tileSize = 48; // 48*48tile
   public final int maxScreenCol = 16;
   public final int maxScreenRow = 12;
   public final int screenWitdh = tileSize * maxScreenCol; // 768pixel
   public final int screenHeight = tileSize * maxScreenRow; //576 pixel

   
   
   int playerX = 100;
   int playerY = 100;
   int playerSpeed = 4;
   int FPS = 60; //FPS
   
   //SETTING WORLD MAP
   public final int maxWorldCol = 80;
   public final int maxWorldRow = 80;
   public final int worldWidth = tileSize*maxScreenCol;
   public final int worldHeigth = tileSize*maxScreenRow;

   //SYSTEM
   TileManager tileM = new TileManager(this);
   public KeyboardInput kbI = new KeyboardInput(this);
   Sound music = new Sound();
   Sound se = new Sound();
   public CollisionChecker colCheck = new CollisionChecker(this);
   public UI uI = new UI(this);
   public AssetSetter aSetter = new AssetSetter(this);
   public EventHandler eHandler = new EventHandler(this);
   Thread gameThread;
    
   // ENTITY AND OBJECT
   public SuperObject obj[] = new SuperObject[30];
  public Player player = new Player(this, kbI);
  public Entity npc[] = new Entity[10];
  public Entity monster[] = new Entity[20];
  
  //GAME STATE
  public int gameState;
  public final int titleState = 0;
  public final int playState = 1;
  public final int pauseState = 2;
  public final int dialogueState = 3;
  public final int gameOverState = 4;
  
//  //CHARACTER STATUS
//  public int maxLife;
//  public int life;
  
   public GamePanel() {
	   this.setPreferredSize(new Dimension(screenWitdh,screenHeight));
	   this.setBackground(Color.black);
	   this.setDoubleBuffered(true);
	   this.addKeyListener(kbI);
	   this.setFocusable(true);
   }

   public void startGameLoop()
   {
     gameThread = new Thread(this);
     gameThread.start();
   }
   
   public void retry() {
	   player.setDefaultPotitions();
	   player.setReZero();
	   aSetter.setMonster();
	   aSetter.setNPC();
	   aSetter.setObject();
   }
@Override
//public void run() {
//	// TODO Auto-generated method stub
//	 double timePerFrame = 1000000000.0/FPS; // 1 giaay = 1.000.000.000 nano giay => 0,01666s
//	 double nextDrawTime = System.nanoTime() + timePerFrame;
//	while(gameThread!=null) {		
//		 
//		 //1.update
//		update();
//		//2.draw
//		repaint();
//		try {
//		 double remainingTime = nextDrawTime - System.nanoTime();
//	     remainingTime = remainingTime/1000000;
//	     if(remainingTime<0) {
//	    	 remainingTime = 0;
//	     }
//	    Thread.sleep((long)remainingTime);
//	    nextDrawTime += timePerFrame;
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//}

public void run() {
	double drawInterVal = 1000000000/FPS;
	double delta = 0;
	long lastTime = System.nanoTime();
	long currentTime;
	long timer =0;
	int drawCount = 0;
	while(gameThread != null) {
		currentTime = System.nanoTime();
		delta += (currentTime-lastTime)/drawInterVal;
		timer += (currentTime-lastTime);
		lastTime = currentTime;
		if(delta>=1) {
			update();
			repaint();
			delta--;
			drawCount++;
		}
		if(timer>=1000000000) {
			System.out.println("FPS: "+drawCount);
			drawCount=0;
			timer=0;
		}
	}
}
public void setupGame() {
	aSetter.setObject();
	playMusic(0);
	//stopMusic();
	aSetter.setNPC();
	aSetter.setMonster();
	gameState = titleState;
}
  public void update() {
	  
	  if(gameState == playState) {
		  player.update();
		  
		  // NPC
		  for(int i=0; i< npc.length;i++) {
			  if(npc[i] != null) {
				  npc[i].update();
			  }
		  }
		  for(int i=0; i< monster.length;i++) {
			  if(monster[i] != null) {
				  if(monster[i].alive == true && monster[i].dying == false) {
					  monster[i].update();
				  }
				  if(monster[i].alive == false) {
					  monster[i] = null;
				  }
				// monster[i].update();
			  }
		  }
	  }
	  if(gameState == pauseState) {
		  
	  }
  }
  
  public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 =  (Graphics2D)g;
      //update();
    if(gameState == titleState) {
       uI.draw(g2);
    }
    else {
    	
    	 // TILE
        tileM.draw(g2);
        
        //OBJECT
        for(int i=0; i<obj.length;i++) {
      	  if(obj[i] != null) {
      		  obj[i].draw(g2, this);
      	  }
        }
        
        //NPC
        
        for(int i =0; i<npc.length; i++) {
      	  if(npc[i] != null) {
      		  npc[i].draw(g2);
      	  }
        }
        
        //Monster
        for(int i =0; i<monster.length; i++) {
        	  if(monster[i] != null) {
        		  monster[i].draw(g2);
        	  }
          }
        
        // PLAYER
       player.draw(g2);
       
       //UI
      uI.draw(g2);
      g2.dispose();
    }
      
  }
  public void playMusic(int i) {
	music.setFile(i);
	music.play();
	music.loop();

}
  public void stopMusic() {
	  music.stop();
  }
  public void playSE(int i) {
	  se.setFile(i);
		se.play();
 }
  
//  public void attackMusic(int i) {
//	  music.setFile(i);
//	  music.play();
//  }
}
