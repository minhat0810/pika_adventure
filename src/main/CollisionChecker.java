package main;

import entity.Entity;

public class CollisionChecker {
	GamePanel gamePanel;
	public CollisionChecker(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
  public void checkTile(Entity entity) {
	  
	  int entityLeftWorldX = entity.WorldX + entity.solidArea.x;
	  int entityRightWorldX = entity.WorldX + entity.solidArea.x + entity.solidArea.width;
	  int entityTopWorldY = entity.WorldY + entity.solidArea.y;
	  int entityBottomWorldY = entity.WorldY + entity.solidArea.y + entity.solidArea.height -10;
	  
	  int entityLeftCol = entityLeftWorldX/gamePanel.tileSize;
	  int entityRightCol = entityRightWorldX/gamePanel.tileSize;
	  int entityTopRow = entityTopWorldY/gamePanel.tileSize;
	  int entityBottomRow = entityBottomWorldY/gamePanel.tileSize;
	  
	  int tileNum1, tileNum2;
	  
	  switch(entity.direction) {
	  case "up":
		  entityTopRow = (entityTopWorldY-entity.speed)/gamePanel.tileSize;
		  tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
		  tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityTopRow];
		  if (gamePanel.tileM.tile[tileNum1].collision == true ||  gamePanel.tileM.tile[tileNum2].collision == true)
		  {
			entity.collisionOn = true;
		  }
		  break;
	  case "down":
		  entityBottomRow = (entityBottomWorldY + entity.speed)/gamePanel.tileSize;
		  tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityBottomRow];
		  tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityBottomRow];
		  if (gamePanel.tileM.tile[tileNum1].collision == true ||  gamePanel.tileM.tile[tileNum2].collision == true)
		  {
			entity.collisionOn = true;
		  }
		  break;
		  
	  case "left":
		  entityLeftCol = (entityLeftWorldX-entity.speed)/gamePanel.tileSize;
		  tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
		  tileNum2 = gamePanel.tileM.mapTileNum[entityLeftCol][entityBottomRow];
		  if (gamePanel.tileM.tile[tileNum1].collision == true ||  gamePanel.tileM.tile[tileNum2].collision == true)
		  {
			entity.collisionOn = true;
		  }
		  break;
		  
	  case "right":
		  entityRightCol = (entityRightWorldX + entity.speed)/gamePanel.tileSize;
		  tileNum1 = gamePanel.tileM.mapTileNum[entityRightCol][entityTopRow];
		  tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityBottomRow];
		  if (gamePanel.tileM.tile[tileNum1].collision == true ||  gamePanel.tileM.tile[tileNum2].collision == true)
		  {
			entity.collisionOn = true;
		  }
		  break;	    	  
	  }
  }
  public int checkObject(Entity entity, boolean player) {
	  
	  int index = 999;
	  for(int i=0; i<gamePanel.obj.length;i++) {
		  if(gamePanel.obj[i] != null) {
			  // nhận địa điểm solid của thuewwcj thể
			  entity.solidArea.x = entity.WorldX + entity.solidArea.x;
			  entity.solidArea.y = entity.WorldY + entity.solidArea.y;
			  
			  // nhận dd solid của object
			  gamePanel.obj[i].solidArea.x =  gamePanel.obj[i].solidArea.x + gamePanel.obj[i].worldX;
			  gamePanel.obj[i].solidArea.y =  gamePanel.obj[i].solidArea.y + gamePanel.obj[i].worldY;
			  switch(entity.direction) {
			  case "up":
				  entity.solidArea.y -= entity.speed;
				  if(entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
					 // System.out.println("up collision");
					  if(gamePanel.obj[i].collision == true) {
						  entity.collisionOn= true;
					  }
					  if(player == true) {
						  index = i;
					  }
				  }
				  break;
			  case "down":
				  entity.solidArea.y += entity.speed;
				  if(entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
					 // System.out.println("down collision");
					  if(gamePanel.obj[i].collision == true) {
						  entity.collisionOn = true;
					  }
					  if(player == true) {
						  index = i;
					  }
				  }
				  break;
			  case "left":
				  entity.solidArea.x -= entity.speed;
				  if(entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
					//  System.out.println("left collision");
					  if(gamePanel.obj[i].collision == true) {
						  entity.collisionOn = true;
					  }
					  if(player == true) {
						  index = i;
					  }
				  }
				  break;
			  case "right":
				  entity.solidArea.x += entity.speed;
				  if(entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
					//  System.out.println("right collision");
					  if(gamePanel.obj[i].collision == true) {
						  entity.collisionOn = true;
					  }
					  if(player == true) {
						  index = i;
					  }
				  }
				  break;
			  }
			  entity.solidArea.x = entity.solidAreaDefaultX;
			  entity.solidArea.y = entity.solidAreaDefaultY;
			  
			  gamePanel.obj[i].solidArea.x = gamePanel.obj[i].solidAreaDefaultX;
			  gamePanel.obj[i].solidArea.y = gamePanel.obj[i].solidAreaDefaultY;

		  }
	  }
	  return index;
  }
  public int checkEntity(Entity entity, Entity[] target) {
	  int index = 999;
	  for(int i=0; i<target.length;i++) {
		  if( target[i] != null) {
			  // nhận địa điểm solid của thuewwcj thể
			  entity.solidArea.x = entity.WorldX + entity.solidArea.x;
			  entity.solidArea.y = entity.WorldY + entity.solidArea.y;
			  
			  // nhận dd solid của object
			  target[i].solidArea.x =   target[i].solidArea.x +  target[i].WorldX;
			  target[i].solidArea.y =   target[i].solidArea.y +  target[i].WorldY;
			  switch(entity.direction) {
			  case "up":
				  entity.solidArea.y -= entity.speed;
				  if(entity.solidArea.intersects(target[i].solidArea)) {
					 // System.out.println("up collision");
					  entity.collisionOn = true;
					  index = i;
				  }
				  break;
			  case "down":
				  entity.solidArea.y += entity.speed;
				  if(entity.solidArea.intersects(target[i].solidArea)) {
					 // System.out.println("down collision");
					  entity.collisionOn = true;
					  index = i;
				  }
				  break;
			  case "left":
				  entity.solidArea.x -= entity.speed;
				  if(entity.solidArea.intersects(target[i].solidArea)) {
					//  System.out.println("left collision");
					  entity.collisionOn = true;
					  index = i;
				  }
				  break;
			  case "right":
				  entity.solidArea.x += entity.speed;
				  if(entity.solidArea.intersects(target[i].solidArea)) {
					//  System.out.println("right collision");
					entity.collisionOn = true;
					 index = i;
				  }
				  break;
			  }
			  entity.solidArea.x = entity.solidAreaDefaultX;
			  entity.solidArea.y = entity.solidAreaDefaultY;
			  
			  target[i].solidArea.x =  target[i].solidAreaDefaultX;
			  target[i].solidArea.y =  target[i].solidAreaDefaultY;

		  }
	  }
	  return index;
  }
  public boolean checkPlayer(Entity entity) {
	  boolean contactPlayer = false;
	  int index = 999;
	  for(int i=0; i<gamePanel.obj.length;i++) {
		  if(gamePanel.obj[i] != null) {
			  // nhận địa điểm solid của thuewwcj thể
			  entity.solidArea.x = entity.WorldX + entity.solidArea.x;
			  entity.solidArea.y = entity.WorldY + entity.solidArea.y;
			  
			  // nhận dd solid của object
			  gamePanel.player.solidArea.x =  gamePanel.player.solidArea.x + gamePanel.player.WorldX;
			  gamePanel.player.solidArea.y =  gamePanel.player.solidArea.y + gamePanel.player.WorldY;
			 
			  switch(entity.direction) {
			  case "up":
				  entity.solidArea.y -= entity.speed;
				 
				  break;
			  case "down":
				  entity.solidArea.y += entity.speed;
//				  if(entity.solidArea.intersects(gamePanel.player.solidArea)) {
//					 // System.out.println("down collision");
//						  entity.collisionOn = true;
//				  }
				  break;
			  case "left":
				  entity.solidArea.x -= entity.speed;
//				  if(entity.solidArea.intersects(gamePanel.player.solidArea)) {
//					//  System.out.println("left collision");
//						  entity.collisionOn = true;
//				  }
				  break;
			  case "right":
				  entity.solidArea.x += entity.speed;
//				  if(entity.solidArea.intersects(gamePanel.player.solidArea)) {
//					//  System.out.println("right collision");
//						  entity.collisionOn = true;
//				  }
				  break;
			  }
			  if(entity.solidArea.intersects(gamePanel.player.solidArea)) {
					 // System.out.println("up collision");
						  entity.collisionOn= true;
						  contactPlayer = true;

				  }
			  entity.solidArea.x = entity.solidAreaDefaultX;
			  entity.solidArea.y = entity.solidAreaDefaultY;
			  
			  gamePanel.player.solidArea.x = gamePanel.player.solidAreaDefaultX;
			  gamePanel.player.solidArea.y = gamePanel.player.solidAreaDefaultY;

		  }
	  }
	  return contactPlayer;
  }  
  
}
