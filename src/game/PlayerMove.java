package game;
import dungeons.*;
import enums.*;
import graphics.DrawStuff;

import java.awt.*;

import inventory.*;


public class PlayerMove {

	static Move move = new Move();
	static boolean moveBuilt = false;
	static Character player;
	
	public PlayerMove(Character character) {
		player = character;
	}
	
	
	public static void getMove(int x, int y, DungeonNode thisNode) {
    	// right panel clicks
    	if (x >= 1000) {
    		if (y <= 180) {
    			if (x <= 1140) {
    				PlayerMove.setWeapon(player.leftHand);
    			} else {
    				PlayerMove.setWeapon(player.rightHand);
    			}
    		} else if (y <= 270) {
    			if (x <= 1140) {
    				PlayerMove.setItem(player.hotInventory.get(0));
    			} else {
    				PlayerMove.setItem(player.hotInventory.get(1));
    			}	
    		} else if (y <= 360) {
    			if (x <= 1140) {
    				PlayerMove.setItem(player.hotInventory.get(2));
    			} else {
    				PlayerMove.setItem(player.hotInventory.get(3));
    			}		
    		} else if ( y <= 405) {
    			PlayerMove.setTalk();
    		} else if (y <= 450) {
    			PlayerMove.setInteract();
    		} else if (y <= 495) {
    			PlayerMove.setManage();
    		}
		
    	}
    	
    	
    	// map clicks
    	if (x >= 280 && x <= 1000) {
            int xSquare = (x - 280) / DrawStuff.size;
            int ySquare = y / DrawStuff.size;
            System.out.println(x + ", " + y);
            if (0 <= xSquare && xSquare < thisNode.roomSize && 0 <= ySquare && ySquare < thisNode.roomSize) {
            	PlayerMove.makeMove(xSquare, ySquare, thisNode);
            }
    	}
		
	}
	
	public static void makeMove(int x, int y, DungeonNode thisNode) {
		if (thisNode.spaces[x][y].character == null && thisNode.spaces[x][y].canMove == true) {
			if (Math.abs(player.position.x - x) + Math.abs(player.position. y - y) <= 1) {
				move.point = new Point(x, y);
				move.action = Action.MOVE;
			}
		} else {
			move.target = thisNode.spaces[x][y].character;
		}
		
		System.out.println("hit");
		moveBuilt = true;
	}
	
	public static void setWeapon(Weapon weapon) {
		move = new Move();
		move.weapon = weapon;
		move.action = Action.ATTACK;
	}
	
	public static void setItem(Item item) {
		move = new Move();
		move.action = Action.USE;
		move.item = item;
	}
	
	public static void setInteract() {
		move = new Move();
		move.action = Action.INTERACT;
	}
	
	public static void setTalk() {
		move = new Move();
		move.action = Action.TALK;
	}
	
	public static void setManage() {
		move = new Move();
		move.action = Action.MANAGE;
	}
	
}
