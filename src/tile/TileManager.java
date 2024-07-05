package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {

	GamePanel gamePanel;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		
		tile = new Tile[50];
		mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
		getTileImage();
		loadMap("/maps/world01.txt");
	}
	
	public void getTileImage() {
			
//			tile[0] = new Tile();
//			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass4.png"));
////			tile[0].collision = true;
////			BufferedImage scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, tile[0].image.getType());
////			Graphics2D g2 = scaledImage.createGraphics();
////			g2.drawImage(tile[0].image, 0, 0, gamePanel.tileSize, gamePanel.tileSize, null);
////			tile[0].image = scaledImage;
//			
//			
//			tile[1] = new Tile();
//			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
//			tile[1].collision = true;
//			
//			tile[2] = new Tile();
//			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water2.jpg"));
//			tile[2].collision = true;
//			
//			tile[3] = new Tile();
//			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
//			
//			tile[4] = new Tile();
//			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass3.jpg"));
//			tile[4].collision = true;
//				
//			tile[5] = new Tile();
//			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
//			
//			tile[6] = new Tile();
//			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
//			
//			tile[7] = new Tile();
//			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/khunglong.png"));
//			
//			tile[8] = new Tile();
//			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/JQR86G2.png"));
//			

			//tile[9] = new Tile();
			//tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass3.jpg"));
			setup(0, "grass4", false);
			setup(1, "wall", true);
			setup(2, "water2", true);
			setup(3, "earth", false);
			setup(4, "grass3", true);
			setup(5, "sand", false);
			setup(7, "khunglong", false);
			setup(8, "water01", true);
			setup(9, "water00", true);
//			setup(10, "grass00", false);
//			setup(11, "grass01", false);
//			setup(12, "water00", true);
//			setup(13, "water01", true);
//			setup(14, "water02", true);
//			setup(15, "water03", true);
//			setup(16, "water04", true);
//			setup(17, "water05", true);
//			setup(18, "water06", true);
//			setup(19, "water07", true);
//			setup(20, "water08", true);
			setup(21, "water09", true);
			setup(22, "water10", true);
//			setup(23, "water11", true);
//			setup(24, "water12", true);
//			setup(25, "grass01", false);
//			setup(26, "grass01", false);
//			setup(27, "grass01", false);
//			setup(28, "grass01", false);
//			setup(29, "grass01", false);
//			setup(30, "grass01", false);
//			setup(11, "grass01", false);
			
			
			
	}
	
	public void setup(int index, String imagePath, boolean collision) {
		UtilityTool uTool = new UtilityTool();
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imagePath+".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gamePanel.tileSize, gamePanel.tileSize);
		    tile[index].collision = collision;
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			
			int col =0;
			int row = 0;
			while(col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
				String line = bf.readLine();
				while(col<gamePanel.maxWorldCol) {
					String numbers[] = line.split(" ");
					// thay đổi string thành int
					int num = Integer.parseInt(numbers[col]);
				  mapTileNum[col][row] = num;
				  col++;
				}
				if(col == gamePanel.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			bf.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage(); 
		}
	}
	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;
//		int x = 0;
//		int y = 0;
		while(worldCol<gamePanel.maxWorldCol && worldRow <gamePanel.maxWorldRow) {
			int tileNum = mapTileNum[worldCol][worldRow];
			int worldX = worldCol * gamePanel.tileSize;
			int worldY = worldRow * gamePanel.tileSize;
			int screenX = worldX - gamePanel.player.WorldX + gamePanel.player.screenX;
			//nếu tọa độ WorlCol = 23: 23*48    -  1104  px                 + 384 px
			int screenY = worldY - gamePanel.player.WorldY + gamePanel.player.screenY;

//			if( worldX + gamePanel.tileSize > gamePanel.player.WorldX - gamePanel.player.screenX &&
//					worldX - gamePanel.tileSize < gamePanel.player.WorldX + gamePanel.player.screenX &&
//					worldY + gamePanel.tileSize> gamePanel.player.WorldY - gamePanel.player.screenY &&
//					worldY - gamePanel.tileSize  < gamePanel.player.WorldY + gamePanel.player.screenY) {
//				
//			}
			g2.drawImage(tile[tileNum].image, screenX, screenY,null);
			worldCol++;
			//x += gamePanel.tileSize;
			if(worldCol==gamePanel.maxWorldCol) {
				worldCol = 0;
				//x = 0;
				worldRow++;
				//y += gamePanel.tileSize;
			}
		}
	}
}
