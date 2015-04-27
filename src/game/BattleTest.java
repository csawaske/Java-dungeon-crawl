package game;
import inventory.*;

import java.awt.*;
import java.io.*;
import java.util.*;

import dungeons.*;
import enums.*;




public class BattleTest  {
	
	public static final int OFFSET = 46;

	static	DungeonNode thisNode;
	static Dungeon thisDungeon;

	public static void main(String[] args) {
		new TotalInventory();
		new TotalDungeons();
		Character player = new Character("Connor");
		thisDungeon = TotalDungeons.getDungeon("The First Dungeon");
		thisNode = thisDungeon.firstRoom;
		Random rand = new Random();
		player.rightHand = TotalInventory.getWeapon("Iron Sword");
		thisNode.characterList.add(player);
		boolean running = true;
		int moveCount = 0;
		DrawingPanel panel = new DrawingPanel((thisNode.x + 8) * OFFSET, (thisNode.y + 4) * OFFSET);
		Graphics g = panel.getGraphics();
		g.setFont(new Font("Monospaced", Font.BOLD, 40));
		drawState(g, thisNode, player, new ArrayList<String>());
		while (running == true) {
			ArrayList<String> result = new ArrayList<String>();
			for (int i = 0; i < thisNode.characterList.size(); i++) {
				Character character = thisNode.characterList.get(i);
				if (running == false || character.isDead) {
				} else {
					character.currentNode = thisNode;
					Move thisMove = character.getMove();
					
					// process movement
					if (thisMove.action.equals(Action.MOVE)) {
						BattleCalculator.move(character, thisMove, thisNode);
					}
					// process attacks
					if (thisMove.action.equals(Action.ATTACK)) {
						result.add(BattleCalculator.attack(character, thisMove.target, thisMove));
					}
				}
			}
			drawState(g, thisNode, player, result);
			moveCount++;
			if (player.isDead) {
				running = false;
				System.out.println("Game over!");
			}

		}
	}
	
	
	public static void drawState(Graphics g, DungeonNode thisNode, Character player, ArrayList<String> result) {
		
		// draw borders
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, (thisNode.x + 8) * OFFSET, (thisNode.y + 4) * OFFSET);
		g.setColor(Color.GRAY);
		g.fillRect(0,  0,  (thisNode.x + 2) * OFFSET,  OFFSET);
		g.fillRect(0,  (thisNode.y + 1) * OFFSET,  (thisNode.x + 2) * OFFSET,  OFFSET);
		g.fillRect(0,  0, OFFSET, (thisNode.y + 2) * OFFSET);
		g.fillRect((thisNode.x +1) * OFFSET, 0, OFFSET, (thisNode.y + 2) * OFFSET);
		
		// draw grid
		for (int i = 2; i <= thisNode.x; i++) {
			g.drawLine(i * OFFSET, 0, i * OFFSET, (thisNode.y + 1) * OFFSET);
		}
		for (int i = 2; i <= thisNode.y; i++) {
			g.drawLine(0,  i * OFFSET, (thisNode.x + 1) * OFFSET, i * OFFSET);
		}
		
		// draw doors
		g.setColor(Color.BLACK);
		if (thisNode.nodeMap.get(Direction.UP) != null) {
			g.fillRect((thisNode.x / 2) * OFFSET, 0, 2 * OFFSET, OFFSET);
		}
		
		// draw characters
		g.setFont(new Font("Monospaced", Font.BOLD, OFFSET - 10));
		for (Character character : thisNode.characterList) {
			g.setColor(character.getColor());
			g.drawString(character.getStringRep(), (character.position.x + 1) * OFFSET, (character.position.y + 1) * OFFSET - OFFSET / 5);
			g.setColor(Color.RED);
			g.fillRect((character.position.x + 1) * OFFSET, (character.position.y + 1) * OFFSET, 2, 2);
			if (!character.isDead) {
				g.drawRect((character.position.x + 1) * OFFSET + OFFSET / 10, (character.position.y + 1) * OFFSET - OFFSET / 6, (int)(OFFSET * 0.8), OFFSET / 8);
				g.fillRect((character.position.x + 1) * OFFSET + OFFSET / 10, (character.position.y + 1) * OFFSET - OFFSET / 6,
						(int)((OFFSET * 0.8) * character.HP / character.maxHP), OFFSET / 8);
			}
		}	
		g.setFont(new Font("Monospaced", Font.BOLD, 15));
		g.setColor(Color.WHITE);
		for (int i = 0; i < result.size(); i++) {
			g.drawString(result.get(i), OFFSET, (thisNode.y + 2) * OFFSET + (i + 1) * OFFSET / 3);
		}

	}


}
