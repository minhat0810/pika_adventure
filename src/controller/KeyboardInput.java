/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import main.GamePanel;

/**
 *
 * @author PC
 */
public class KeyboardInput implements KeyListener{
  private GamePanel gamePanel;
  public boolean upP,downP,leftP,rightP,enterPressed,attackP;
    public KeyboardInput(GamePanel gamePanel){
       this.gamePanel = gamePanel;
    }
    public KeyboardInput() {
		
	}
    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
    		int code = e.getKeyCode(); 
    	//TITLE STATE
    		if(gamePanel.gameState == gamePanel.titleState){
    		 if(gamePanel.uI.titleScreenState == 0) {
    			 if(code==KeyEvent.VK_UP) {
    		    	   gamePanel.uI.commandNum--;
    		    	   if(gamePanel.uI.commandNum<0) {
    		    		   gamePanel.uI.commandNum=2;
    		    	   }
    		       }
    		       if(code==KeyEvent.VK_DOWN) {
    		    	   gamePanel.uI.commandNum++;
    		    	   if(gamePanel.uI.commandNum>2) {
    		    		   gamePanel.uI.commandNum=0;
    		    	   }
    		       }
    		     if(code== KeyEvent.VK_ENTER) {
         			if(gamePanel.uI.commandNum ==0) {
         				
         				gamePanel.gameState = gamePanel.playState;
         				//gamePanel.playMusic(0);
         			}
         			
         			if(gamePanel.uI.commandNum ==1 ) {
         				//          				
         				gamePanel.uI.titleScreenState=1;
         				
         			}
         			
         			if(gamePanel.uI.commandNum ==2) {
         				System.exit(0);
         			}    			 
       		      }
    		 }	
    		
      		
    		else if(gamePanel.uI.titleScreenState == 1) {
    			 if(code==KeyEvent.VK_UP) {
    		    	   gamePanel.uI.commandNum--;
    		    	   if(gamePanel.uI.commandNum<0) {
    		    		   gamePanel.uI.commandNum=0;
    		    	   }
    		       }
    		       if(code==KeyEvent.VK_DOWN) {
    		    	   gamePanel.uI.commandNum++;
    		    	   if(gamePanel.uI.commandNum>0) {
    		    		   gamePanel.uI.commandNum=0;
    		    	   }
    		       }
    		     if(code== KeyEvent.VK_ENTER) {
         			if(gamePanel.uI.commandNum ==0) {
         				//gamePanel.uI.titleScreenState=1;
         				//gamePanel.gameState = gamePanel.titleState;
         				//gamePanel.playMusic(0);
         				//gamePanel.gameState = 1;
         				gamePanel.uI.titleScreenState = 0;
         			}
         			
         			
         			if(gamePanel.uI.commandNum ==1 ) {
         				//          				
         				//gamePanel.uI.titleScreenState = 1;
         				
         			}
         		
       		}
    	}
   }	
    		//PLAY STATE
    		else  if(gamePanel.gameState == gamePanel.playState) {
       if(code==KeyEvent.VK_W) {
    	   upP = true;
       }
       if(code==KeyEvent.VK_S) {
    	   downP = true;
       }
       if(code==KeyEvent.VK_A) {
    	   leftP = true;
       }
       if(code==KeyEvent.VK_D) {
    	   rightP = true;
       }
       if(code == KeyEvent.VK_SPACE) {
    	   gamePanel.gameState = gamePanel.pauseState;
//    	   if(gamePanel.gameState == gamePanel.playState) {
//    		   
//    	   }else if(gamePanel.gameState == gamePanel.pauseState) {
//    		   gamePanel.gameState = gamePanel.playState;
//    	   }
          }
       if(code == KeyEvent.VK_ENTER) {
    	   enterPressed = true; 
    	   //gamePanel.player.attacking = true;
    	   if(enterPressed==true) {
    		   System.out.println("Enter");
    	   }
          }
//        if(code == KeyEvent.VK_1) {
//        	attackP = true;
//        	
//        	 if(attackP==true) {
//        		 gamePanel.player.attacking = true;
//      		   System.out.println("Attack");
//      	   }
//        }
   	
 }
    		//PAUSE STATE
    		else	if(gamePanel.gameState == gamePanel.pauseState) {
    			if(code == KeyEvent.VK_SPACE) {
    				gamePanel.gameState = gamePanel.playState;
    				gamePanel.playMusic(0);
    			}
    			
    		}
    		else	 if(gamePanel.gameState == gamePanel.dialogueState) {
    			 if(code == KeyEvent.VK_ENTER) {
    				// enterPressed = true;
    				 
     				gamePanel.gameState = gamePanel.playState;
     			}
    		 }
    		
    		//GAME OVER STATE
    		else if(gamePanel.gameState == gamePanel.gameOverState) {
    			 if(code==KeyEvent.VK_UP) {
  		    	   gamePanel.uI.commandNum--;
  		    	   if(gamePanel.uI.commandNum<0) {
  		    		   gamePanel.uI.commandNum=1;
  		    	   }
  		       }
  		       if(code==KeyEvent.VK_DOWN) {
  		    	   gamePanel.uI.commandNum++;
  		    	   if(gamePanel.uI.commandNum>1) {
  		    		   gamePanel.uI.commandNum=0;
  		    	   }
  		       }
  		     if(code== KeyEvent.VK_ENTER) {
       			if(gamePanel.uI.commandNum ==0) {
       				//gamePanel.uI.titleScreenState=1;
       				//gamePanel.gameState = gamePanel.titleState;
       				//gamePanel.playMusic(0);
       				//gamePanel.gameState = 1;
       				gamePanel.gameState = gamePanel.playState;
       				gamePanel.retry();
       				gamePanel.playMusic(0);
       			}
       			
       			
       			if(gamePanel.uI.commandNum ==1 ) {
       				//          				
       				System.exit(0);
       				
       			 }
  		      }
    		}
    	
 }
    
    
    

    @Override
    public void keyReleased(KeyEvent e) {
    	int code = e.getKeyCode(); 
        if(code==KeyEvent.VK_W) {
     	   upP = false;
        }
        if(code==KeyEvent.VK_S) {
     	   downP = false;
        }
        if(code==KeyEvent.VK_A) {
     	   leftP = false;
        }
        if(code==KeyEvent.VK_D) {
     	   rightP = false;
        }
    } 
}
