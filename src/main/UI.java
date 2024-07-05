package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import object.OBJ_EStone;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.SuperObject;

public class UI {

	BufferedImage keyImage, heart_full, heart_half, heart_blank;
	 GamePanel gamePanel;
	 Graphics2D g2;
	 //Font aria_80;
	 public boolean messageOn = false;
	 public String message = "";
	 public int messCount;
	 public boolean gameFinished = false;
	 public boolean gameLose = false;
	 public String currentDialogue="";
	 double playTime;
	 public int commandNum=0;
	 public int titleScreenState=0; // 0: option, 1: guide
	 
	 
	 DecimalFormat dFormat = new DecimalFormat("#0.00");
	 public UI(GamePanel gamePanel) {
		 this.gamePanel = gamePanel;
		 
		 OBJ_Key key = new OBJ_Key(gamePanel);
		 keyImage = key.image;
		 
		 //TẠO OBJECT TRÁI TYM
		 
		 SuperObject heart = new OBJ_Heart(gamePanel);
		 heart_full = heart.image;
		 heart_half = heart.image2;
		 heart_blank = heart.image3;
	 }
	 
	 public void showMessage(String text) {
		// TODO Auto-generated method stub
		 message = text;
		 messageOn = true;
	}
	 
	 public void draw(Graphics2D g2) {
		 
		 if(gameFinished==true) {
			 g2.setColor(Color.WHITE);
		      g2.setFont(new Font("ASIA",1,20));
			 String text;
			 int textLength;
			 int x;
			 int y;
			 text = "Bạn đã tìm thấy rương báu!";
			 textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			 
			 x = gamePanel.screenWitdh/2 -textLength/2;
			 y = gamePanel.screenHeight/2 -(gamePanel.tileSize*3);
			 g2.drawString(text,x,y+50);
			 
			 g2.setColor(Color.WHITE);
		      g2.setFont(new Font("ASIA",1,80));
			 text = "CHÚC MỪNG!";
			 textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			 
			 x = gamePanel.screenWitdh/2 -textLength/2;
			 y = gamePanel.screenHeight/2 -(gamePanel.tileSize*3);
			 g2.drawString(text,x,y);
			 gamePanel.gameThread = null;
		 } 
//		 else 
//			 if(gameLose==true) {
//				 g2.setColor(Color.WHITE);
//			      g2.setFont(new Font("ASIA",1,80));
//				 String text;
//				 int textLength;
//				 int x;
//				 int y;
//				 text = "THẤT BẠI";
//				 textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//				 
//				 x = gamePanel.screenWitdh/2 -textLength/2;
//				 y = gamePanel.screenHeight/2 -(gamePanel.tileSize*3);
//				 g2.drawString(text,x,y+50);
//				 gamePanel.gameThread = null;
//			 }
		 else {
			 //PLAY
//		if(gamePanel.gameState == gamePanel.playState) {
//			drawPlayerLife();
//			 g2.setColor(Color.YELLOW);
//		      g2.setFont(new Font("ASIA",1,20));
//		      g2.drawImage(keyImage,gamePanel.tileSize/2, gamePanel.tileSize/2+20,gamePanel.tileSize,gamePanel.tileSize,null);
//		      g2.drawString("x "+gamePanel.player.hasKey, 74, 70);
//		      
//		      playTime += (double)1/60;
//		      g2.drawString("Time: "+dFormat.format(playTime), gamePanel.tileSize*11, 65);
//		      
//		      if(messageOn == true) {
//		    	  g2.drawString(message, gamePanel.tileSize, gamePanel.screenHeight/2-24);
//		      }
//		      
//		     
//		}
//		 messCount++;
//	      if(messCount>200) {
//	    	  messCount = 0;
//	    	  messageOn = false;
//	      }
		 		this.g2 = g2; 
				 g2.setColor(Color.WHITE);
			      g2.setFont(new Font("Cambria",Font.PLAIN,40));
			      if(gamePanel.gameState == gamePanel.playState) {
			    	  drawPlayerLife();
						drawPlayerLife();
						 g2.setColor(Color.YELLOW);
					      g2.setFont(new Font("ASIA",1,20));
					      g2.drawImage(keyImage,gamePanel.tileSize/2, gamePanel.tileSize+20,gamePanel.tileSize,gamePanel.tileSize,null);
					      g2.drawString("x "+gamePanel.player.hasKey, 70, 100);
					      
					      playTime += (double)1/60;
					      g2.drawString("Time: "+dFormat.format(playTime), gamePanel.tileSize*11, 65);
					      
					      if(messageOn == true) {
					    	  g2.drawString(message, gamePanel.tileSize, gamePanel.screenHeight/2-24);
					      }
			      }
					 messCount++;
			      if(messCount>200) {
			    	  messCount = 0;
			    	  messageOn = false;
			      }
			      //PAUSE
			      	if(gamePanel.gameState == gamePanel.pauseState) {
			      	//	drawPlayerLife();
			      		drawPauseScreen();
			    	  gamePanel.stopMusic();
			      }
			      	// DIALOGUE STATE
			      	if(gamePanel.gameState == gamePanel.dialogueState) {
			      		drawPlayerLife();
			      		drawDialogueScreen();
			      	}
			      	if(gamePanel.gameState == gamePanel.titleState) {
			      		drawTitleScreen();
			      	}
			      	
			      	//GAME OVER STATE
			      	if(gamePanel.gameState == gamePanel.gameOverState) {
			      		drawGameOverScreen();
			      	}
			      
	 }
}		 
	 public  void drawDialogueScreen() {
		 
		 int x = gamePanel.tileSize*2;
		 int y = gamePanel.tileSize/2;
		 int width =  gamePanel.screenWitdh - (gamePanel.tileSize*4);
		 int height = gamePanel.tileSize*5;
		 drawSubWindow(x, y, width, height);
		 g2.setFont(new Font("ASIA",1,20));
		 x +=gamePanel.tileSize;
		 y +=gamePanel.tileSize;
		for(String line: currentDialogue.split("\n")) {
			 g2.drawString(line, x, y);
			 y +=40;
		}
		 
	 }
	 public void drawSubWindow(int x, int y, int witdth, int height) {
		Color c = new Color(0,0,0,100);
		 g2.setColor(c);
		 g2.fillRoundRect(x, y, witdth, height, 45, 45);
		 
		 c = new Color(255,255,255);
		 g2.setColor(c);
		 g2.setStroke(new BasicStroke(5));
		 g2.drawRoundRect(x+5, y+5, witdth-10, height-10, 30, 30);
	 }
	 public void drawPauseScreen() {
		 String text = "PAUSED";
		 int x= gamePanel.screenWitdh/2-gamePanel.tileSize;
		 int y = gamePanel.screenHeight/2;
		 
		 
		 g2.drawString(text, x, y);
	 }
	 public int getXforCenterText(String text) {
		 int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 int x = gamePanel.screenWitdh/2 - length/2;
		 return x;
	 }
	 public void drawTitleScreen() {
		 
		 
	///	 g2.setColor(new Color(70,100,80));
	//	 g2.fillRect(0, 0, gamePanel.screenWitdh, gamePanel.screenHeight);
		 if(gamePanel.uI.titleScreenState==0) {
			 
			 BufferedImage bgr = null;
			 BufferedImage startImage  = null;
			 try {
				bgr = ImageIO.read(getClass().getResourceAsStream("/background/bgr_1.png"));
				startImage = ImageIO.read(getClass().getResourceAsStream("/background/pikachu_hi_pokemon.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 g2.drawImage(bgr, 0, 0,  gamePanel.worldWidth, gamePanel.worldHeigth,null);
			 //TITLE NAME
			 g2.setFont(new Font("ASIA",Font.BOLD,30));
			 String text = "CUỘC PHIÊU LƯU CỦA PIKACHU";
			 int x = getXforCenterText(text); 
			 int y= gamePanel.tileSize*3;
			 
			 //SHADOW
			 g2.setColor(Color.BLACK);
			 g2.drawString(text,x+4,y+4);
			 
			 //MAIN TITLE
			 g2.setColor(Color.WHITE);
			 g2.drawString(text,x,y);
			 
			 //PIKACHU IMAGE
			 x = gamePanel.screenWitdh/2-gamePanel.tileSize+10;
			 y += gamePanel.tileSize*2;
			 g2.drawImage(startImage, x, y, 80, 80, null);
			 
			 g2.setColor(Color.BLACK);
			 //MENU
			 text = "CHƠI MỚI";
			 x = getXforCenterText(text); 
			 y += gamePanel.tileSize*3;
			 g2.drawString(text,x,y);
			 if(commandNum == 0) {
				 g2.drawString(">>", x-gamePanel.tileSize, y);
			 }
			 
			 text = "HƯỚNG DẪN";
			 x = getXforCenterText(text); 
			 y += gamePanel.tileSize;
			 g2.drawString(text,x,y);
			 if(commandNum == 1) {
				 g2.drawString(">>", x-gamePanel.tileSize, y);
			 }
			 
			 text = "THOÁT";
			 x = getXforCenterText(text); 
			 y += gamePanel.tileSize;
			 g2.drawString(text,x,y);
			 if(commandNum == 2) {
				 g2.drawString(">>", x-gamePanel.tileSize, y);
			 }
		 }
		 else if(gamePanel.uI.titleScreenState == 1) {
			 g2.setColor(Color.WHITE);
			 String text = "HƯỚNG DẪN:";
			 int x = getXforCenterText(text);
			 int y = gamePanel.tileSize;
			 g2.drawString(text , x, y);
			 
			 g2.setFont(new Font("Asia",1,24));
			 text = "1.Di chuyển bằng phím A,W,S,D.";
			  x = gamePanel.tileSize;
			  y = gamePanel.tileSize*3;
			 g2.drawString(text , x, y);
			 
			 text = "2.Tấn công bằng A/W/S/D + Enter để chọn hướng tấn công.";
			  x = gamePanel.tileSize;
			  y = gamePanel.tileSize*4;
			 g2.drawString(text , x, y);
			 
			 text = "3. Hồi phục HP bằng hồ nước và quả dại.";
			  x = gamePanel.tileSize;
			  y = gamePanel.tileSize*5;
			 g2.drawString(text , x, y);
			 
			 text = "4. Bấm nút space để tạm dừng game.";
			  x = gamePanel.tileSize;
			  y = gamePanel.tileSize*6;
			 g2.drawString(text , x, y);
			 
			 text = "Quay lại.";
			 x = getXforCenterText(text); 
			 y += gamePanel.tileSize*4;
			 g2.drawString(text,x,y);
			 if(commandNum == 0) {
				 g2.drawString(">>", x-gamePanel.tileSize, y);
			 }
			 
		 }	
	 }
	 
	 public void drawPlayerLife() {
	 //	 gamePanel.player.life = 3;
		 // HP RỖNG
		 int x = gamePanel.tileSize/2;
		 int y = gamePanel.tileSize/2;
		 int i=0;
		 while(i<gamePanel.player.maxLife/2) {
			 g2.drawImage(heart_blank, x, y,null);
			 i++;
			 x += gamePanel.tileSize;
		 }
		  
		 // RESET
		  x = gamePanel.tileSize/2;
		  y = gamePanel.tileSize/2;
		  i=0;
		  
		  // HP HIỆN TẠI
		  while(i<gamePanel.player.life) {
			  g2.drawImage(heart_half, x, y,null);
				 i++;
				 if(i<gamePanel.player.life) {
					 g2.drawImage(heart_full, x, y,null);
				 }
				 i++;
				 x += gamePanel.tileSize;
		  }
	 }
	 public void drawGameOverScreen() {
		 g2.setColor(Color.WHITE);
	      g2.setFont(new Font("ASIA",1,80));
		 String text;
		 int textLength;
		 int x;
		 int y;
		 text = "THẤT BẠI";
		 textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 
		 x = gamePanel.screenWitdh/2 -textLength/2;
		 y = gamePanel.screenHeight/2 -(gamePanel.tileSize*3);
		 g2.drawString(text,x,y+50);
		 
		 
		 g2.setFont(new Font("ASIA",1,30));

		 text = "CHƠI LẠI";
		 textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 
		 x = gamePanel.screenWitdh/2 -textLength/2;
		 y += gamePanel.tileSize*4;
		 g2.drawString(text,x,y);
		 if(commandNum == 0) {
			 g2.setColor(Color.black);
			 g2.drawString(">", x-40,y);
		 }
		 
		 g2.setFont(new Font("ASIA",1,30));

		 text = "THOÁT GAME";
		 textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		 
		 x = gamePanel.screenWitdh/2 -textLength/2;
		 y += 55;
		 g2.drawString(text,x,y);
		 if(commandNum == 1) {
			 g2.drawString(">", x-40,y);
		 }
		 //gamePanel.gameThread = null;
	 }
}
