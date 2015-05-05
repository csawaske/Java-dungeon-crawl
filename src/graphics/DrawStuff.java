package graphics;
import game.Character;
import inventory.*;

import java.awt.*;
import java.io.*;
import java.util.*;

import dungeons.*;
import enums.*;

public class DrawStuff {

	public static Integer size = 30;
	public static Graphics g;
	public static Character player;
	public static int height;
	public static int width;
	
	public DrawStuff(Graphics gIn, DungeonNode thisNode, Character playerIn) {
		g = gIn;
		player = playerIn;
		size = 720 / thisNode.roomSize;
	}
	

	
	
	public static void drawState(DungeonNode thisNode, ArrayList<String> result) {
		
		// background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 18 * size, 14 * size);
		
		// draw spaces
		for (int i = 0; i < thisNode.roomSize; i++) {
			for (int j = 0; j < thisNode.roomSize; j++) {
				g.setColor(Color.GRAY);
				g.fillRect(280 + j * size, i * size, size, size);
				g.setColor(thisNode.spaces[i][j].color);
				g.fillRect(280 + j * size + 1, i * size + 1, size - 2, size - 2);
			}
		}
		
		
		// draw grid
		g.setColor(Color.GRAY);
		for (int i = 2; i <= thisNode.roomSize; i++) {
			g.drawLine(280 + i * size, 0, 280 + i * size, 720);
		}
		for (int i = 2; i <= thisNode.roomSize; i++) {
			g.drawLine(280,  i * size, 1000, i * size);
		}
		g.setColor(Color.BLACK);
		g.drawRect(280, 0, 720, 720);

		
		
		// draw buttons
		g.setFont(new Font("Monospaced", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		
		// weapons
		g.drawRect(1000, 0, 140, 180);
		g.drawString(player.leftHand.weaponName, 1000 + (int) (140 - xShift(player.leftHand.weaponName)) / 2,
				2 * yShift(player.leftHand.weaponName));

		
		g.drawRect(1140, 0, 140, 180);
		g.drawString(player.rightHand.weaponName, 1140 + (int) (140 - xShift(player.rightHand.weaponName)) / 2,
				2 * yShift(player.rightHand.weaponName));
		
		// hot inventory
		g.drawRect(1000, 180, 140, 90);
		g.drawString(player.hotInventory.get(0).name, 1000 + (int) (140 - xShift(player.hotInventory.get(0).name)) / 2,
				180 + (90 + yShift(player.hotInventory.get(0).name)) / 2);
			
		g.drawRect(1140, 180, 140, 90);
		g.drawString(player.hotInventory.get(1).name, 1140 + (int) (140 - xShift(player.hotInventory.get(0).name)) / 2,
				180 + (90 + yShift(player.hotInventory.get(0).name)) / 2);
		
		g.drawRect(1000, 270, 140, 90);
		g.drawString(player.hotInventory.get(2).name, 1000 + (int) (140 - xShift(player.hotInventory.get(0).name)) / 2,
				270 + (90 + yShift(player.hotInventory.get(0).name)) / 2);
			
		g.drawRect(1140, 270, 140, 90);
		g.drawString(player.hotInventory.get(3).name, 1140 + (int) (140 - xShift(player.hotInventory.get(0).name)) / 2,
				270 + (90 + yShift(player.hotInventory.get(0).name)) / 2);	
		
		
		// others
		g.drawRect(1000,  360, 280, 45);
		g.drawString("Talk", 1000 + (int) (280 - xShift("Talk")) / 2, 360 + (45 + yShift("Talk")) / 2);
		
		g.drawRect(1000, 405, 280, 45);
		g.drawString("Interact", 1000 + (int) (280 - xShift("Interact")) / 2, 405 + (45 + yShift("Interact")) / 2);	
		
		g.drawRect(1000, 450, 280, 45);
		g.drawString("Manage Inventory", 1000 + (int) (280 - xShift("Manage Inventory")) / 2, 450 + (45 + yShift("Manage Inventory")) / 2);			
		
		
		
		// draw characters
		g.setFont(new Font("Monospaced", Font.BOLD, size - 10));
		for (Character character : thisNode.characterList) {
			g.setColor(character.getColor());
			g.drawString(character.getStringRep(), 280 + (character.position.x) * size, (character.position.y + 1) * size - size / 5);
			g.setColor(Color.RED);
			g.fillRect(280 + (character.position.x) * size, (character.position.y + 1) * size, 2, 2);
			if (!character.isDead) {
				g.drawRect(280 + (character.position.x) * size + size / 10, (character.position.y + 1) * size - size / 6, (int)(size * 0.8), size / 8);
				g.fillRect(280 + (character.position.x ) * size + size / 10, (character.position.y + 1) * size - size / 6,
						(int)((size * 0.8) * character.HP / character.maxHP), size / 8);
			}
		}
		
		g.setColor(Color.RED);
		g.fillOval(13 * size, size, size / 4, size / 4);
		
		// draw text
		g.setFont(new Font("Monospaced", Font.BOLD, 15));
		g.setColor(Color.WHITE);
		if (result.size() > 5) {
			for (int i = 0; i < 5; i++) {
				g.drawString(result.get(result.size() - 5 + i), size, (12) * size + (i + 1) * size / 3 + size / 8);
			}
		} else {
			for (int i = 0; i < result.size(); i++) {
				g.drawString(result.get(i), size, (12) * size + (i + 1) * size / 3 + size / 8);
			}
		}
	}

	public static int xShift(String string) {
		return (int) g.getFontMetrics().getStringBounds(string, g).getWidth();
	}
	
	public static int yShift(String string) {
		return (int) g.getFontMetrics().getStringBounds(player.leftHand.weaponName, g).getHeight();
	}
	
}
