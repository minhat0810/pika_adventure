package monster;

import java.util.Random;
import java.util.jar.Attributes.Name;

import entity.Entity;
import main.GamePanel;

public class MON_Slime extends Entity {
 public MON_Slime(GamePanel gamePanel) {
	 super(gamePanel);
	 name = "Slime";
	 speed = 1;
	 direction = "down";
	 maxLife = 4;
	 life = maxLife;
	 type = 2;
	 solidArea.x = 3;
	 solidArea.y = 18;
	 solidArea.width = 30;
	 solidArea.height = 30;
	 solidAreaDefaultX = solidArea.x;
	 solidAreaDefaultY = solidArea.y;
	 getImage();
	 setAction();
 }
 public void getImage() {
	 
	 up1 = setup("/monster/greenslime_down_1");
	 up2 = setup("/monster/greenslime_down_2");
//	 up3 =  setup("/monster/greenslime_down_1");
//	 up4 =  setup("/monster/greenslime_down_2");
	 down = setup("/monster/greenslime_down_1");
	 down2 = setup("/monster/greenslime_down_2");
//	 down3 =  setup("/monster/greenslime_down_1");
//	 down4 =  setup("/monster/greenslime_down_2");
	 left1 = setup("/monster/greenslime_down_1");
	 left2 = setup("/monster/greenslime_down_2");
//	 left3 = setup("/monster/greenslime_down_1");
//	 left4 =  setup("/monster/greenslime_down_2");
	 right1 = setup("/monster/greenslime_down_1");
	 right2 = setup("/monster/greenslime_down_2");
//	 right3 =  setup("/monster/greenslime_down_1");
//	 right4 =  setup("/monster/greenslime_down_2");
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
}
