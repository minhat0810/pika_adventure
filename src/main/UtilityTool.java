package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UtilityTool {
	GamePanel gp;
  public BufferedImage scaleImage(BufferedImage original,int width, int height) {
	  BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
		Graphics2D g2 = scaledImage.createGraphics();
		g2.drawImage(original, 0, 0, width, height, null);
		return scaledImage;
  }
  public BufferedImage scaleImage2(BufferedImage original,int width, int height) {
	  BufferedImage scaledImage2 = new BufferedImage(width, height, original.getType());
		Graphics2D g2 = scaledImage2.createGraphics();
		g2.drawImage(original,0,0,width,height,null);
		return scaledImage2;
  }
}
