package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class NPC_KLL extends Entity{

	public NPC_KLL(GamePanel gamePanel) {
		super(gamePanel);
		direction = "down";
		speed = 1;
		getImage();
		setDialogue();
	}
	
	public void getImage() {

		
			up1 = setup("/npc/hito_up");
			up2 = setup("/npc/hito_up_2");
			down = setup("/npc/hito_down");
			down2 = setup("/npc/hito_down_2");;
			left1 = setup("/npc/hito_left");
			right1 =setup("/npc/hito_left_2");
			left2 = setup("/npc/hito_left");
			right2 =setup("/npc/hito_left_2");
	}
	
//	public BufferedImage setup(String imageName) {
//		UtilityTool uTool = new UtilityTool();
//		BufferedImage image = null;
//		try {
//			
//			image = ImageIO.read(getClass().getResourceAsStream("/player/"+imageName+".png"));
//			image = uTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
//		} catch (IOException e) {
//			// TODO: handle exception
//		}
//		return image;
//	}
	public void setDialogue() {
		dialogue[0] = "Xin chào, Yasuo";
		dialogue[1] = "Chào mừng đến với hòn đảo \nsiu toa khổng lồ của bà Mhật VÊLOG";
		dialogue[2] = "Yangho đồn vào hàng trăm năm trước\nmột nhà huấn luyện tài ba đã \ncất giấu kho báu lớn nhất lịch sử ở đây";
		dialogue[3] = "Chà, cậu hãy đi tìm nó, \nGút lứt tu du!";
	}
	public void setAction() {
		 actionLockCounter++;
		   if(actionLockCounter==120) {
			   
			   Random random = new Random();
				int i = random.nextInt(100)+1;
				if(i <=25) {
					direction = "up";
				}
				if(i > 25 &&i <=50) {
					direction = "down";
				}
				if(i > 50 &&i <= 75) {
					direction = "left";
				}
				if(i > 75 &&i <=100) {
					direction = "right";
				}
				actionLockCounter=0;
			}
		   }
	public void speak() {
		// Để biết nhân vật nhận cái j đó đặc biệt
		super.speak();
		
	}
}
