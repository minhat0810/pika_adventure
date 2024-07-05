package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
   public int WorldX,WorldY;
   public int speed;
   public String name;
   GamePanel gamePanel;
   public boolean invincible =false;
   public int invincibleCount = 0;
   
   public BufferedImage start,up1,up2,up3,up4,down,down2,down3,down4,left1,left2,left3,left4,right1,right2,right3,right4;
   public BufferedImage attack1,attack2,attackl1,attackl2;   
   public BufferedImage thunder1,thunder2,thunder3,thunder4,thunder5,thunderd1,thunderd2;
   public String direction="down";
   
   public int spriteCounter=0;
   public int spriteNum =1;
   int dyingCounter = 0;
   
   public Rectangle solidArea = new Rectangle(0,0,48,48);
   public Rectangle attackArea = new Rectangle(0,0,48,48);
   public int solidAreaDefaultX,solidAreaDefaultY;
   public boolean collisionOn = false;
   public int actionLockCounter = 0;
   String dialogue[] = new String[20];
   int dialogueIndex = 0;
   public int type; // 0= player, 1= npc, 2 = monster
   public boolean attacking = false;
   public boolean alive = true;
   public boolean dying = false;
   
 //CHARACTER STATUS
   public int maxLife;
   public int life;

   public Entity(GamePanel gamePanel) {
	   this.gamePanel = gamePanel;
   }
   public void speak() {
	   if(dialogue[dialogueIndex] == null) {
			dialogueIndex = 0;
			gamePanel.aSetter.setObject();
		}
		gamePanel.uI.currentDialogue = dialogue[dialogueIndex];
		dialogueIndex++;
		
		switch (gamePanel.player.direction) {
			case "up":
				direction = "down";
				break;
			case "down":
				direction = "up";
				break;
			case "left":
				direction = "right";
				break;
			case "right":
				direction = "left";
				break;
		}
   }
   public void setAction() {  
   }
  public void update() {
	   setAction();
	   collisionOn = false;
	   gamePanel.colCheck.checkTile(this);
	   boolean contactPlayer = gamePanel.colCheck.checkPlayer(this);
	 //  gamePanel.colCheck.checkEntity(this, gamePanel.monster);
	   
	   //gamePanel.colCheck.checkEntity(this, gamePanel.monster);
	   if(this.type == 2 && contactPlayer == true) {
		   if(gamePanel.player.invincible==false) {
			   gamePanel.player.life -=1;
			   gamePanel.player.invincible = true;
		   }
	   }
		if(collisionOn == false) {
			switch(direction) {
			case "up": WorldY -= speed;
				break;
			case "down": WorldY += speed;
				break;
			case "left": WorldX -= speed;
				break;
			case "right": WorldX += speed;
				break;	
			}
		}
		
		spriteCounter++;
		if(spriteCounter>15) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		 if(invincible == true) {
			  invincibleCount++;
			  if(invincibleCount>40) {
				  invincible = false;
				  invincibleCount = 0;
			  }
		  }
		 
   }
   public void draw(Graphics2D g2) {
	   BufferedImage image = null;
   
	   int screenX = WorldX - gamePanel.player.WorldX + gamePanel.player.screenX;
		//nếu tọa độ WorlCol = 23: 23*48    -  1104  px                 + 384 px
		int screenY = WorldY - gamePanel.player.WorldY + gamePanel.player.screenY;

		if( WorldX + gamePanel.tileSize > gamePanel.player.WorldX - gamePanel.player.screenX &&
				WorldX - gamePanel.tileSize < gamePanel.player.WorldX + gamePanel.player.screenX &&
				WorldY + gamePanel.tileSize> gamePanel.player.WorldY - gamePanel.player.screenY &&
				WorldY - gamePanel.tileSize  < gamePanel.player.WorldY + gamePanel.player.screenY) {
			switch (direction) {
			case "up":
				if(spriteNum==1) {
					image = up1;
				}
				if(spriteNum==2) {
					image = up2;
				}
				break;
			case "down":
				if(spriteNum==1) {
					image = down;
				}
				if(spriteNum==2) {
					image = down2;
				}
				break;
			case "left":
				if(spriteNum==1) {
					image = left1;
				}
				if(spriteNum==2) {
					image = left2;
				}
				break;
			case "right":
				if(spriteNum==1) {
					image = right1;
				}
				if(spriteNum==2) {
					image = right2;
				}
				break;		
		}
			
			//MONSTER HP
			 if(type == 2) {
				 
				 double oneScale = (double) gamePanel.tileSize/maxLife;
				 double hpBarValue = oneScale*life;
				 
				 g2.setColor(new Color(35,35,35));
					g2.fillRect(screenX-1, screenY-16, gamePanel.tileSize, 9);
				 
				 g2.setColor(new Color(255,0,30));
					g2.fillRect(screenX, screenY-15,(int) hpBarValue, 7);
			 }
			
			if(invincible ==true) {
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
			}
			if(dying == true) {
				 dyingAnimation(g2);
			 }
			g2.drawImage(image, screenX, screenY,gamePanel.tileSize,gamePanel.tileSize,null);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}			
}
   public BufferedImage setup(String imagePath) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
			image = uTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return image;
	}
   public BufferedImage setup2(String imagePath) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
			image = uTool.scaleImage(image,gamePanel.tileSize*2, gamePanel.tileSize);
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		return image;
	}
   public BufferedImage setup3(String imagePath) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
			image = uTool.scaleImage(image,gamePanel.tileSize, gamePanel.tileSize*2);
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		return image;
	}
	public void dyingAnimation(Graphics2D g2) {
		dyingCounter++;
		if(dyingCounter <= 5) {
			  g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0f));

		}
		if(dyingCounter >5 && dyingCounter<=10) {
			 g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
		}
		
		if(dyingCounter >10 && dyingCounter<=15) {
			  g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0f));

		}
		if(dyingCounter >15 && dyingCounter<=20) {
			 g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
		}
		
		if(dyingCounter >20 && dyingCounter<=35) {
			  g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0f));

		}
		if(dyingCounter >35 && dyingCounter<=40) {
			 g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
		}
		if(dyingCounter > 40) {
			dying = false;
			alive = false;
		}
	}
}

