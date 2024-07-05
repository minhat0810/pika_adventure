package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.KeyboardInput;
import main.GamePanel;
import main.UtilityTool;

public class Player extends Entity {
//	GamePanel gamePanel;
	KeyboardInput kbI;
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	
	public Player(GamePanel gamePanel, KeyboardInput kbI) {
		super(gamePanel);
	//	this.gamePanel = gamePanel;
		this.kbI = kbI;
		screenX = gamePanel.screenWitdh/2-(gamePanel.tileSize/2);
		screenY = gamePanel.screenHeight/2-(gamePanel.tileSize/2);
		
		solidArea = new Rectangle(/*0,0,gamePanel.tileSize-18,gamePanel.tileSize-18*/);
		solidArea.x = 9;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 30;
		solidArea.height = 30;
		
		attackArea.width = 32; //gamePanel.tileSize*3;
		attackArea.height = 32;///gamePanel.tileSize*2;
		
		setDefaultValues();
		getPlayerImage();
		getPlayerAttack();
	}
	
	public void setDefaultValues() {
		WorldX = gamePanel.tileSize*23;
		WorldY =gamePanel.tileSize*21;
		speed = 4;
		direction="start";
		
		//PLAYER STATUS
		maxLife = 6;
		life = maxLife;
	}
	public void getPlayerImage() {
//		try {
//		    start = ImageIO.read(getClass().getResourceAsStream("/player/pika_start2.png"));
//			up1 = ImageIO.read(getClass().getResourceAsStream("/player/pika_up_1.png"));
//			up2 = ImageIO.read(getClass().getResourceAsStream("/player/pika_up_2.png"));
//			up3 = ImageIO.read(getClass().getResourceAsStream("/player/pika_up_1.png"));
//			up4 = ImageIO.read(getClass().getResourceAsStream("/player/pika_up_2.png"));
//			down = ImageIO.read(getClass().getResourceAsStream("/player/pika_down_1.png"));
//			down2 = ImageIO.read(getClass().getResourceAsStream("/player/pika_down_2.png"));
//			down3 = ImageIO.read(getClass().getResourceAsStream("/player/pika_down4.png"));
//			down4 = ImageIO.read(getClass().getResourceAsStream("/player/pika_down_3.png"));
//			left1 = ImageIO.read(getClass().getResourceAsStream("/player/pika_left1.png"));
//			right1 = ImageIO.read(getClass().getResourceAsStream("/player/pika_move1_1.png"));
//			left2 = ImageIO.read(getClass().getResourceAsStream("/player/pika_left2.png"));
//			right2 = ImageIO.read(getClass().getResourceAsStream("/player/pika_move2_1.png"));
//			left3 = ImageIO.read(getClass().getResourceAsStream("/player/pika_left3.png"));
//			right3 = ImageIO.read(getClass().getResourceAsStream("/player/pika_move3_1.png"));
//			left4 = ImageIO.read(getClass().getResourceAsStream("/player/pika_left4.png"));
//			right4 = ImageIO.read(getClass().getResourceAsStream("/player/pika_move4.png"));
//		}catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		  start =   setup("/player/pika_start2");
			up1 =   setup("/player/pika_up_1");
			up2 =   setup("/player/pika_up_2");
			up3 =   setup("/player/pika_up_1");
			up4 =   setup("/player/pika_up_2");
			down =  setup("/player/pika_down_1");
			down2 = setup("/player/pika_down_2");
			down3 = setup("/player/pika_down4");
			down4 = setup("/player/pika_down_3");
			left1 = setup("/player/pika_left1");
			right1 =setup("/player/pika_move1_1");
			left2 = setup("/player/pika_left2");
			right2 =setup("/player/pika_move2_1");
			left3 = setup("/player/pika_left3");
			right3 = setup("/player/pika_move3_1");
			left4 = setup("/player/pika_left4");
			right4 = setup("/player/pika_move4");
	}
//	public BufferedImage setup(String imageName) {
//		UtilityTool uTool = new UtilityTool();
//		BufferedImage image = null;
//		try {
//			
//			image = ImageIO.read(getClass().getResourceAsStream(imageName+".png"));
//			image = uTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
//		} catch (IOException e) {
//			// TODO: handle exception
//		}
//		return image;
//	}
	public void getPlayerAttack() {
		attack1 = setup("/player/pika_attack_r1");
		attack2 = setup("/player/pika_attack_end_2");
		attackl1 = setup("/player/pika_attack_l1");
		attackl2 = setup("/player/pika_attack_end");
		thunder1 = setup2("/player/attack_right_end");
		thunder2 = setup2("/player/attack_left_end");
		
		thunder3 = setup3("/player/attack_up_end");
		thunder4 = setup3("/player/attack_down_end");
//		thunder5 = setup2("/player/thunder5");
		
//		thunderd1 = setup3("/player/thunder3");
//		thunderd2 = setup3("/player/thunder5");
	}
	public void update() {
		
		if(attacking==true) {
			attacking();
			//attacking = false;
		} else
		if(kbI.upP==true || kbI.downP==true || kbI.leftP==true|| kbI.rightP==true || kbI.enterPressed == true) {
			
			if(kbI.upP==true) {
				direction="up";
//				WorldY -= speed;
			//	attacking = false;
			  }
			  else if(kbI.downP==true) {
				  direction="down";
//				  WorldY += speed;
				//  attacking = false;
			  }
			  else  if(kbI.leftP==true) {
				  direction="left";
//				  WorldX -= speed;
				 // attacking = false;
			  }
			  else  if(kbI.rightP==true) {
				  direction="right";
				//  attacking = false;
			  }
//				  WorldX += speed;
//			  } else if(kbI.enterPressed==true) {
//				  attacking = true;
//			  }
//			if(attacking==true) {
//				attacking();
//			}
			//check va cham
			collisionOn = false;
			gamePanel.colCheck.checkTile(this);
			
			//check event
			gamePanel.eHandler.checkEvent();
			
			 
			
			// check va chạm object
			int ObjIndex = gamePanel.colCheck.checkObject(this, true);
			pickupObject(ObjIndex);
			
			//check chạm npc
			int npcIndex = gamePanel.colCheck.checkEntity(this, gamePanel.npc);
			interactNPC(npcIndex);
			
			//check monster
			int monsterIndex = gamePanel.colCheck.checkEntity(this, gamePanel.monster);
			interactMonster(monsterIndex);
			
			// neu khong va cham thi co the di chuyen
			if(collisionOn == false &&  gamePanel.kbI.enterPressed == false) {
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
			
			gamePanel.kbI.enterPressed = false;
			
			spriteCounter++;
			if(spriteCounter>10) {
				if(spriteNum==1) {
					spriteNum = 2;
				}
				else if(spriteNum ==2) {
					spriteNum =3;
				}
				else if(spriteNum == 3) {
					spriteNum = 4;
				}
				else if(spriteNum == 4) {
					spriteNum = 1;
				}
				spriteCounter =0;
			}
		}else {
			direction = "start";
		}
	  if(invincible == true) {
		  invincibleCount++;
		  if(invincibleCount>60) {
			  invincible = false;
			  invincibleCount = 0;
		  }
	  }
	  if(gamePanel.player.life <=0) {
//			gamePanel.uI.gameLose = true;
//			gamePanel.stopMusic();
//			gamePanel.playSE(8);
		 // dyingAnimation();
		  dying = true;
		  gamePanel.gameState = gamePanel.gameOverState;
			gamePanel.stopMusic();
			gamePanel.playSE(8);
		}
//	  if(attacking == true) {
//		  invincibleCount++;
//		  if(invincibleCount>60) {
//			  attacking = false;
//			  invincibleCount = 0;
//		  }
//	  }
	  
	}
	
	public void setDefaultPotitions() {
		WorldX = gamePanel.tileSize*23;
		WorldY = gamePanel.tileSize*21;
		direction = "start";
	}
	public void setReZero() {
		life = maxLife;
		hasKey = 0;
		invincible = false;
	}
	
	public void attacking() {
		spriteCounter++;
		if(spriteCounter<=15) {
			spriteNum = 1;
		}
		if(spriteCounter>15 && spriteCounter <=30) {
			spriteNum = 2;
		}
		if(spriteCounter>30 && spriteCounter <=45) {
			spriteNum = 3;
			int currentWorldX = WorldX;
			int currentWorldY = WorldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHeight = solidArea.height;
			
			switch (direction) {
			case "up": WorldY -= attackArea.height; break;
			case "down": WorldY += attackArea.height; break;
			case "left": WorldX -= attackArea.width; break;
			case "right": WorldX += attackArea.width; break;
		}
//		if(spriteCounter>45 && spriteCounter <=60) {
//			spriteNum = 4;
			
			// Luu wordx, wordY, solidArea hien tai
//			int currentWorldX = WorldX;
//			int currentWorldY = WorldY;
//			int solidAreaWidth = solidArea.width;
//			int solidAreaHeight = solidArea.height;
//			
//			switch (direction) {
//			//case "up": WorldY -= attackArea.height; break;
//			case "down": WorldY += attackArea.height; break;
//			//case "left": WorldX -= attackArea.width; break;
//			case "right": WorldX += attackArea.width; break;
					
		  //  }
			
			solidArea.width = attackArea.width;
			solidArea.height = attackArea.height;
			// check va chamj
			int monsterIndex = gamePanel.colCheck.checkEntity(this, gamePanel.monster);
		    damageMonster(monsterIndex);
			
		   // reset sau va chạm
			WorldX = currentWorldX;
			WorldY = currentWorldY;
			solidArea.width = solidAreaWidth;
			solidArea.height = solidAreaHeight;
		}	
		if(spriteCounter>45) {
			spriteNum = 1;
			spriteCounter = 0;
			attacking = false;
		}
	}
	
	public void pickupObject(int i) {
		if(i != 999) {

			String objectName = gamePanel.obj[i].name;
			switch(objectName) {
			case "Key":
				gamePanel.playSE(1);
				hasKey++;
				gamePanel.obj[i] = null;
				gamePanel.uI.showMessage("Bạn nhận được 1 quả cầu poke!");
				break;
			case "Door":
				if(hasKey>0) {
					gamePanel.playSE(4);
					gamePanel.obj[i] = null;
					hasKey--;
					gamePanel.uI.showMessage("Bạn đã mở cửa!");
				}
				else {
					gamePanel.uI.showMessage("Bạn cần có chìa khóa!");
					//life  = -1;
				}
					break;
				
			case "EStone":
				gamePanel.playSE(3);
				speed +=1;
				gamePanel.obj[i] = null;
				gamePanel.uI.showMessage("Tăng tốc!");
				break;
			case "Chest":
				gamePanel.uI.gameFinished = true;
				gamePanel.stopMusic();
				gamePanel.playSE(2);
				break;
			case "Fruit":
				gamePanel.uI.showMessage("HP +1!");
				if(gamePanel.player.life < maxLife-1) {
					gamePanel.player.life +=2;	
				} else 
					if(gamePanel.player.life < maxLife) {
						gamePanel.player.life +=1;	
					}
				gamePanel.obj[i] = null;
				break;
			}
		}
	}
	
  	public void interactNPC(int i) {
  		//gamePanel.kbI.enterPressed = true;
  		if(gamePanel.kbI.enterPressed == true) {
  		 if(i!= 999) {
  		//	if(gamePanel.kbI.enterPressed == true) {
  				System.out.println("Bạn đang đấm NPC!!");
  	  			 gamePanel.gameState = gamePanel.dialogueState;
  	  			 gamePanel.npc[i].speak();
  			 }
  		 else {
  			 attacking = true;
  			gamePanel.playSE(7);
  		      }
  		//gamePanel.kbI.enterPressed = false;
            }
  		
//  		 else if(gamePanel.kbI.enterPressed == true) {
//  			 attacking = true;
//  		 }
//  		 
//  		 else {
//  			 if(gamePanel.kbI.enterPressed == true) {}
//  		 }
    }
  	
  	public void interactMonster(int i) {
  		if(i!=999) {
  			if(invincible == false) {
  				life -=1;			
  				invincible = true;
  			}
  		}
  	}
  	public void damageMonster(int i) {
  		if(i!=999) {
  			System.out.println("Hit");
  			if(gamePanel.monster[i].invincible==false) {
  				direction = gamePanel.player.direction  ;
  				gamePanel.monster[i].life -=1;
  				gamePanel.monster[i].invincible = true;
  				if(gamePanel.monster[i].life  <=0 ) {
  					
  					//dying = true;
  					gamePanel.monster[i].dying = true;
  					//gamePanel.monster[i] = null;
  					//gamePanel.player.life += 1;
  					
  					gamePanel.uI.showMessage("Bạn vừa tiêu diệt Slime.");;
  				}
  			}
  			
  		} else 
  		{
  			System.out.println("Miss");
  		}
  	}
public void draw(Graphics2D g2) {
//		 g2.setColor(Color.white);
//	      g2.fillRect(x,y, gamePanel.tileSize, gamePanel.tileSize);
		BufferedImage image = null;
		int tempScreenX = screenX;
		int tempScreenY = screenY;
		switch (direction) {
		case "up":
			//tempScreenY = screenY + gamePanel.tileSize;
			if(attacking==false) {
				if(spriteNum==1) {
					image = up1;
				}
				if(spriteNum==2) {
					image = up2;
				}
				if(spriteNum==3) {
					image = up3;
				}
				if(spriteNum==4) {
					image = up4;
				}
			}
			if(attacking == true) {
				//
				if(spriteNum==1) {
					image = attack1;
				}
				if(spriteNum==2) {
					image = attack2;
				}
				if(spriteNum==3) {
					tempScreenY = screenY - gamePanel.tileSize;
					image = thunder3;
				}
//				if(spriteNum==4) {
//					image = thunder5;
//				}
			}
			
			break;
		case "down":
			if(attacking == false) {
				if(spriteNum==1) {
					image = down;
				}
				if(spriteNum==2) {
					image = down2;
				}
				if(spriteNum==3) {
					image = down4;
				}
				if(spriteNum==4) {
					image = down3;
				}
			}
			if(attacking == true) {
				//gamePanel.playSE(7);;
				if(spriteNum==1) {
					image = attack1;
				}
				if(spriteNum==2) {
					image = attack2;
				}
				if(spriteNum==3) {
					image = thunder4;
				}
//				if(spriteNum==4) {
//					image = thunderd2;
//				}
			}
			break;
		case "left":
			
			if(attacking==false) {
				if(spriteNum==1) {
					image = left1;
				}
				if(spriteNum==2) {
					image = left2;
				}
				if(spriteNum==3) {
					image = left3;
				}
				if(spriteNum==4) {
					image = left4;
				}
			}
			if(attacking == true) {
				
				if(spriteNum==1) {
					image = attackl1;
				}
				if(spriteNum==2) {
					image = attackl2;
				}
				if(spriteNum==3) {
					tempScreenX = screenX - gamePanel.tileSize;
					image = thunder2;
				}
//				if(spriteNum==4) {
//					image = thunder5;
//				}
			}
			break;
		case "right":
			if(attacking == false) {
				if(spriteNum==1) {
					image = right1;
				}
				if(spriteNum==2) {
					image = right2;
				}
				if(spriteNum==3) {
					image = right3;
				}
				if(spriteNum==4) {
					image = right4;
				}
			}
			if(attacking == true) {
				
				//gamePanel.playSE(7);
				if(spriteNum==1) {
					image = attack1;
				}
				if(spriteNum==2) {
					image = attack2;
				}
				if(spriteNum==3) {
					
					image = thunder1;
				}
//				if(spriteNum==4) {
//					image = thunder5;
				}
			
			break;
		case "start": 
			image = start;
			break;
		}
		 if(invincible == true) {
			  g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f));
		  }
		 if(dying == true) {
			 dyingAnimation(g2);
		 }
		g2.drawImage(image,tempScreenX,tempScreenY,null);	
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
	}


}
