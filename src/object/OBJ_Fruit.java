package object;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Fruit extends SuperObject {
  GamePanel gamePanel;
  public OBJ_Fruit(GamePanel gamePanel) {
	  this.gamePanel = gamePanel;
	  name = "Fruit";
	  try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/fruit-hp.png"));
		uTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
	} catch (Exception e) {
		// TODO: handle exception
	}
  }
}
