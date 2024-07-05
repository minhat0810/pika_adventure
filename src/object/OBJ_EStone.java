package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_EStone extends SuperObject{
	GamePanel gamePanel;
  public OBJ_EStone(GamePanel gamePanel) {
	  this.gamePanel = gamePanel;
	  name = "EStone";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/electrostone4.png"));
			uTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);

		} catch (IOException e) {
			// TODO: handle exception
		}
		//collision = true;
  }
}
