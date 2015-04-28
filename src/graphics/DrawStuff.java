package graphics;
import game.Character;
import inventory.*;

import java.awt.*;
import java.io.*;
import java.util.*;

import dungeons.*;
import enums.*;

public class DrawStuff {

	static final int SIZE = 50;

	
	
	
	
	public static void drawState(Graphics g, DungeonNode thisNode, Character player, ArrayList<String> result) {
		
		// background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 18 * SIZE, 14 * SIZE);
		
		// draw spaces
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				g.setColor(Color.GRAY);
				g.fillRect(j * SIZE, i * SIZE, SIZE, SIZE);
				g.setColor(thisNode.spaces[i][j].color);
				g.fillRect(j * SIZE + 1, i * SIZE + 1, SIZE - 2, SIZE - 2);
			}
		}
		
		
		// draw grid
		for (int i = 2; i <= 12; i++) {
			g.drawLine(i * SIZE, 0, i * SIZE, (12) * SIZE);
		}
		for (int i = 2; i <= 12; i++) {
			g.drawLine(0,  i * SIZE, (12) * SIZE, i * SIZE);
		}

		
		// draw characters
		g.setFont(new Font("Monospaced", Font.BOLD, SIZE - 10));
		for (Character character : thisNode.characterList) {
			g.setColor(character.getColor());
			g.drawString(character.getStringRep(), (character.position.x) * SIZE, (character.position.y + 1) * SIZE - SIZE / 5);
			g.setColor(Color.RED);
			g.fillRect((character.position.x) * SIZE, (character.position.y + 1) * SIZE, 2, 2);
			if (!character.isDead) {
				g.drawRect((character.position.x) * SIZE + SIZE / 10, (character.position.y + 1) * SIZE - SIZE / 6, (int)(SIZE * 0.8), SIZE / 8);
				g.fillRect((character.position.x ) * SIZE + SIZE / 10, (character.position.y + 1) * SIZE - SIZE / 6,
						(int)((SIZE * 0.8) * character.HP / character.maxHP), SIZE / 8);
			}
		}
		
		g.setColor(Color.RED);
		g.fillOval(13 * SIZE, SIZE, SIZE / 4, SIZE / 4);
		
		// draw text
		g.setFont(new Font("Monospaced", Font.BOLD, 15));
		g.setColor(Color.WHITE);
		if (result.size() > 5) {
			for (int i = 0; i < 5; i++) {
				g.drawString(result.get(result.size() - 5 + i), SIZE, (12) * SIZE + (i + 1) * SIZE / 3 + SIZE / 8);
			}
		} else {
			for (int i = 0; i < result.size(); i++) {
				g.drawString(result.get(i), SIZE, (12) * SIZE + (i + 1) * SIZE / 3 + SIZE / 8);
			}
		}
	}

	
	
	
	
}
