package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.UtilityTool;

public class SuperObject  {
	public BufferedImage image, image2, image3;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea= new Rectangle(0,0,48,48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	UtilityTool uTool = new UtilityTool();
	
	public void draw(Graphics2D g2, GamePanel gamePanel) {
		int screenX = worldX - gamePanel.player.WorldX + gamePanel.player.screenX;
		//nếu tọa độ WorlCol = 23: 23*48    -  1104  px                 + 384 px
		int screenY = worldY - gamePanel.player.WorldY + gamePanel.player.screenY;

		if( worldX + gamePanel.tileSize > gamePanel.player.WorldX - gamePanel.player.screenX &&
				worldX - gamePanel.tileSize < gamePanel.player.WorldX + gamePanel.player.screenX &&
				worldY + gamePanel.tileSize> gamePanel.player.WorldY - gamePanel.player.screenY &&
				worldY - gamePanel.tileSize  < gamePanel.player.WorldY + gamePanel.player.screenY) {
			g2.drawImage(image, screenX, screenY,gamePanel.tileSize,gamePanel.tileSize,null);
		}
	}
}
