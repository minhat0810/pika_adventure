package main;

import entity.NPC_KLL;
import monster.MON_Slime;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_EStone;
import object.OBJ_Fruit;
import object.OBJ_Key;

public class AssetSetter {
   GamePanel gamePanel;
   public AssetSetter(GamePanel gamePanel) {
	   this.gamePanel = gamePanel;
   }
   
   public void setObject() {
	   gamePanel.obj[0] = new OBJ_Key(gamePanel);
	   gamePanel.obj[0].worldX = 23 * gamePanel.tileSize;
	   gamePanel.obj[0].worldY = 7  * gamePanel.tileSize;
	   
	   gamePanel.obj[1] = new OBJ_Key(gamePanel);
	   gamePanel.obj[1].worldX = 23 * gamePanel.tileSize;
	   gamePanel.obj[1].worldY = 40 * gamePanel.tileSize;
	    
	   gamePanel.obj[2] = new OBJ_Key(gamePanel);
	   gamePanel.obj[2].worldX = 37 * gamePanel.tileSize;
	   gamePanel.obj[2].worldY = 7  * gamePanel.tileSize;
	   
//	   gamePanel.obj[20] = new OBJ_Key(gamePanel);
//	   gamePanel.obj[20].worldX = 23 * gamePanel.tileSize;
//	   gamePanel.obj[20].worldY = 23  * gamePanel.tileSize;
//	   
//	   gamePanel.obj[21] = new OBJ_Key(gamePanel);
//	   gamePanel.obj[21].worldX = 23 * gamePanel.tileSize;
//	   gamePanel.obj[21].worldY = 23 * gamePanel.tileSize;
//	    
//	   gamePanel.obj[22] = new OBJ_Key(gamePanel);
//	   gamePanel.obj[22].worldX = 37 * gamePanel.tileSize;
//	   gamePanel.obj[222].worldY = 23  * gamePanel.tileSize;
//	   
	   gamePanel.obj[9] = new OBJ_Key(gamePanel);
	   gamePanel.obj[9].worldX = 39 * gamePanel.tileSize;
	   gamePanel.obj[9].worldY = 7  * gamePanel.tileSize;
	   
	   gamePanel.obj[10] = new OBJ_Key(gamePanel);
	   gamePanel.obj[10].worldX = 20 * gamePanel.tileSize;
	   gamePanel.obj[10].worldY = 20 * gamePanel.tileSize;
	   
	   gamePanel.obj[11] = new OBJ_Key(gamePanel);
	   gamePanel.obj[11].worldX = 19 * gamePanel.tileSize;
	   gamePanel.obj[11].worldY = 20 * gamePanel.tileSize;
	   
	   gamePanel.obj[12] = new OBJ_Key(gamePanel);
	   gamePanel.obj[12].worldX = 17 * gamePanel.tileSize;
	   gamePanel.obj[12].worldY = 65 * gamePanel.tileSize;
	   
	   gamePanel.obj[16] = new OBJ_Key(gamePanel);
	   gamePanel.obj[16].worldX = 54 * gamePanel.tileSize;
	   gamePanel.obj[16].worldY = 38 * gamePanel.tileSize;
	   
	   gamePanel.obj[17] = new OBJ_Key(gamePanel);
	   gamePanel.obj[17].worldX = 63 * gamePanel.tileSize;
	   gamePanel.obj[17].worldY = 17 * gamePanel.tileSize;
	   
	   gamePanel.obj[18] = new OBJ_Key(gamePanel);
	   gamePanel.obj[18].worldX = 59 * gamePanel.tileSize;
	   gamePanel.obj[18].worldY = 18 * gamePanel.tileSize;
	   
	   gamePanel.obj[3] = new OBJ_Door(gamePanel);
	   gamePanel.obj[3].worldX = 10* gamePanel.tileSize;
	   gamePanel.obj[3].worldY = 11 * gamePanel.tileSize;
	   
	   gamePanel.obj[4] = new OBJ_Door(gamePanel);
	   gamePanel.obj[4].worldX = 13* gamePanel.tileSize;
	   gamePanel.obj[4].worldY = 25 * gamePanel.tileSize;
	   
	   gamePanel.obj[5] = new OBJ_Door(gamePanel);
	   gamePanel.obj[5].worldX = 38* gamePanel.tileSize;
	   gamePanel.obj[5].worldY = 13 * gamePanel.tileSize;
	   
	   gamePanel.obj[10] = new OBJ_Door(gamePanel);
	   gamePanel.obj[10].worldX = 16* gamePanel.tileSize;
	   gamePanel.obj[10].worldY = 61 * gamePanel.tileSize;
	   
	   gamePanel.obj[15] = new OBJ_Door(gamePanel);
	   gamePanel.obj[15].worldX = 23 * gamePanel.tileSize;
	   gamePanel.obj[15].worldY = 10 * gamePanel.tileSize;
	   
	   gamePanel.obj[6] = new OBJ_Chest(gamePanel);
	   gamePanel.obj[6].worldX = 10* gamePanel.tileSize;
	   gamePanel.obj[6].worldY = 7 * gamePanel.tileSize;
	   
	   gamePanel.obj[7] = new OBJ_EStone(gamePanel);
	   gamePanel.obj[7].worldX = 35* gamePanel.tileSize;
	   gamePanel.obj[7].worldY = 41 * gamePanel.tileSize;
	   
	   gamePanel.obj[8] = new OBJ_Fruit(gamePanel);
	   gamePanel.obj[8].worldX = 29* gamePanel.tileSize;
	   gamePanel.obj[8].worldY = 40 * gamePanel.tileSize;
	   
	   gamePanel.obj[13] = new OBJ_Fruit(gamePanel);
	   gamePanel.obj[13].worldX = 16* gamePanel.tileSize;
	   gamePanel.obj[13].worldY = 64 * gamePanel.tileSize;
	   
	   gamePanel.obj[14] = new OBJ_Fruit(gamePanel);
	   gamePanel.obj[14].worldX = 8 * gamePanel.tileSize;
	   gamePanel.obj[14].worldY = 34 * gamePanel.tileSize;
	   
	   gamePanel.obj[14] = new OBJ_Fruit(gamePanel);
	   gamePanel.obj[14].worldX = 55 * gamePanel.tileSize;
	   gamePanel.obj[14].worldY = 29 * gamePanel.tileSize;
	   
	   
   }

 public void setNPC() {
	 gamePanel.npc[0] = new NPC_KLL(gamePanel);
	 gamePanel.npc[0].WorldX = gamePanel.tileSize * 21;
	 gamePanel.npc[0].WorldY = gamePanel.tileSize * 21;
	 
	 gamePanel.npc[1] = new NPC_KLL(gamePanel);
	 gamePanel.npc[1].WorldX = gamePanel.tileSize * 37;
	 gamePanel.npc[1].WorldY = gamePanel.tileSize * 7;
	 
	 gamePanel.npc[2] = new NPC_KLL(gamePanel);
	 gamePanel.npc[2].WorldX = gamePanel.tileSize * 23;
	 gamePanel.npc[2].WorldY = gamePanel.tileSize * 7;
	 
	 gamePanel.npc[3] = new NPC_KLL(gamePanel);
	 gamePanel.npc[3].WorldX = gamePanel.tileSize * 10;
	 gamePanel.npc[3].WorldY = gamePanel.tileSize * 33;
 }
 
 public void setMonster() {
	 gamePanel.monster[0] = new MON_Slime(gamePanel);
	 gamePanel.monster[0].WorldX = gamePanel.tileSize * 23;
	 gamePanel.monster[0].WorldY = gamePanel.tileSize * 37;
	 
	 gamePanel.monster[1] = new MON_Slime(gamePanel);
	 gamePanel.monster[1].WorldX = gamePanel.tileSize * 25;
	 gamePanel.monster[1].WorldY = gamePanel.tileSize * 37;
	 
	 gamePanel.monster[2] = new MON_Slime(gamePanel);
	 gamePanel.monster[2].WorldX = gamePanel.tileSize * 37;
	 gamePanel.monster[2].WorldY = gamePanel.tileSize * 37;
	 
	 gamePanel.monster[3] = new MON_Slime(gamePanel);
	 gamePanel.monster[3].WorldX = gamePanel.tileSize * 38;
	 gamePanel.monster[3].WorldY = gamePanel.tileSize * 40;
	 
	 gamePanel.monster[4] = new MON_Slime(gamePanel);
	 gamePanel.monster[4].WorldX = gamePanel.tileSize * 25;
	 gamePanel.monster[4].WorldY = gamePanel.tileSize * 39;
	 
	 gamePanel.monster[5] = new MON_Slime(gamePanel);
	 gamePanel.monster[5].WorldX = gamePanel.tileSize * 10;
	 gamePanel.monster[5].WorldY = gamePanel.tileSize * 56;
	 
//	 gamePanel.monster[6] = new MON_Slime(gamePanel);
//	 gamePanel.monster[6].WorldX = gamePanel.tileSize * 11;
//	 gamePanel.monster[6].WorldY = gamePanel.tileSize * 58;
//	 
//	 gamePanel.monster[7] = new MON_Slime(gamePanel);
//	 gamePanel.monster[7].WorldX = gamePanel.tileSize * 25;
//	 gamePanel.monster[7].WorldY = gamePanel.tileSize * 37;
//	 
//	 gamePanel.monster[8] = new MON_Slime(gamePanel);
//	 gamePanel.monster[8].WorldX = gamePanel.tileSize * 8;
//	 gamePanel.monster[8].WorldY = gamePanel.tileSize * 28;
//	 
//	 gamePanel.monster[9] = new MON_Slime(gamePanel);
//	 gamePanel.monster[9].WorldX = gamePanel.tileSize * 14;
//	 gamePanel.monster[9].WorldY = gamePanel.tileSize * 33;
//	 
//	 gamePanel.monster[10] = new MON_Slime(gamePanel);
//	 gamePanel.monster[10].WorldX = gamePanel.tileSize * 13;
//	 gamePanel.monster[10].WorldY = gamePanel.tileSize * 33;
//	 
//	 gamePanel.monster[11] = new MON_Slime(gamePanel);
//	 gamePanel.monster[11].WorldX = gamePanel.tileSize * 10;
//	 gamePanel.monster[11].WorldY = gamePanel.tileSize * 30;
	 
	 gamePanel.monster[12] = new MON_Slime(gamePanel);
	 gamePanel.monster[12].WorldX = gamePanel.tileSize * 11;
	 gamePanel.monster[12].WorldY = gamePanel.tileSize * 32;
	 
	 gamePanel.monster[13] = new MON_Slime(gamePanel);
	 gamePanel.monster[13].WorldX = gamePanel.tileSize * 54;
	 gamePanel.monster[13].WorldY = gamePanel.tileSize * 28;
	 
	 gamePanel.monster[14] = new MON_Slime(gamePanel);
	 gamePanel.monster[14].WorldX = gamePanel.tileSize * 52;
	 gamePanel.monster[14].WorldY = gamePanel.tileSize * 30;
 }
}
