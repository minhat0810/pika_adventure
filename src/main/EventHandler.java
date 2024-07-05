package main;

import java.awt.Rectangle;

public class EventHandler {
	GamePanel gamePanel;
	Rectangle eventRect;
	int eventRectDefaultX, eventRectDefaultY;
	public EventHandler(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		eventRect = new Rectangle();
		eventRect.x = 23;
		eventRect.y = 23;
		eventRect.width = 10;
		eventRect.height = 10;
		eventRectDefaultX = eventRect.x;
		eventRectDefaultY = eventRect.y;
	}
	public void checkEvent() {
		if(hit(25, 15, "right") == true) {
			damagePit(gamePanel.dialogueState);
		}
		if(hit(23, 7, "up") == true) {
			healing(gamePanel.dialogueState);
		}
	}
	public boolean hit(int eventCol, int eventRow, String reqDirection) {
		boolean hit = false;
		gamePanel.player.solidArea.x = gamePanel.player.WorldX + gamePanel.player.solidArea.x;
		gamePanel.player.solidArea.y = gamePanel.player.WorldY + gamePanel.player.solidArea.y;
		eventRect.x = eventCol*gamePanel.tileSize + eventRect.x;
	    eventRect.y = eventRow*gamePanel.tileSize + eventRect.y;
		if(gamePanel.player.solidArea.intersects(eventRect)) {
			if(gamePanel.player.direction.contentEquals(reqDirection)|| reqDirection.contentEquals("any")) {
				hit = true;
			} 
		}
		gamePanel.player.solidArea.x = gamePanel.player.solidAreaDefaultX;
		gamePanel.player.solidArea.y = gamePanel.player.solidAreaDefaultY;
		eventRect.x = eventRectDefaultX;
		eventRect.y = eventRectDefaultY;
		return hit;
	}
	public void damagePit(int gameState) {
		gamePanel.gameState = gameState;
		gamePanel.uI.currentDialogue= "Bạn bị rơi vào bẫy!";
		gamePanel.player.life -= 1;
		
	}
	public void healing(int gameState) {
		if(gamePanel.kbI.enterPressed == true) {
			gamePanel.gameState = gameState;
			gamePanel.uI.currentDialogue= "Bạn đã uống nước. Hồi đầy HP " ;
			gamePanel.player.life = gamePanel.player.maxLife;
		}
		
	}
}
