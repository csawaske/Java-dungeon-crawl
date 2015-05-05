package game;
import inventory.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import graphics.*;
import dungeons.*;
import enums.*;




public class BattleTest  {
	
	public static final int SIZE = 40;

	static	DungeonNode thisNode;
	static Dungeon thisDungeon;
	static boolean moveBuilt;
	
	public static void main(String[] args) {
		new TotalInventory();
		new TotalDungeons();
		final Character player = new Character("Connor");
		new PlayerMove(player);
		thisDungeon = TotalDungeons.getDungeon("The First Dungeon");
		thisNode = thisDungeon.firstRoom;
		Random rand = new Random();
		player.rightHand = TotalInventory.getWeapon("Iron Sword");
		thisNode.characterList.add(player);
		boolean running = true;
		int moveCount = 0;
		final DrawingPanel panel = new DrawingPanel(1280, 720);
		Graphics g = panel.getGraphics();
		g.setFont(new Font("Monospaced", Font.BOLD, 40));
		new DrawStuff(g, thisNode, player);
		
		ArrayList<String> result = new ArrayList<String>();
		DrawStuff.drawState(thisNode, result);

		 panel.addKeyListener(new KeyListener() {
		        @Override
		        public void keyTyped(KeyEvent e) {
		        }

		        @Override
		        public void keyPressed(KeyEvent e) {
		            System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
		        }

		        @Override
		        public void keyReleased(KeyEvent e) {
		        }
		    });		
		
		panel.addMouseListener((MouseListener) new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	PlayerMove.getMove(e.getX(), e.getY(), thisNode);
            }
        });
		

		while (running == true) {

			for (int i = 0; i < thisNode.characterList.size(); i++) {	
				Character character = thisNode.characterList.get(i);
				thisNode.charactersToSpaces();
				if (running == false || character.isDead) {
				} else {
					try {
					    Thread.sleep(100);                 // pause for each turn
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					Move thisMove = new Move();
					character.currentNode = thisNode;
					if (!character.equals(player)) {
						thisMove = character.getMove();
					} else {
						System.out.println(result);
						DrawStuff.drawState(thisNode, result); // draw state at end of turn
						g.setColor(Color.GREEN);
						g.fillOval(13 * SIZE, SIZE, SIZE / 4, SIZE / 4);
						PlayerMove.moveBuilt = false;
						while (!PlayerMove.moveBuilt) {
							try {
							    Thread.sleep(10);                 // pause for mouse
							} catch(InterruptedException ex) {
							    Thread.currentThread().interrupt();
							}
							thisMove = PlayerMove.move;
						}
						PlayerMove.moveBuilt = false;

					}
					// process movement
					if (thisMove.action.equals(Action.MOVE)) {
						DungeonNode newNode = thisNode.nodeMap.get((BattleCalculator.move(character, thisMove, thisNode)));
						if (!newNode.equals(thisNode)) {
							thisNode = newNode;
							thisNode.characterList.add(player);
						}
					}
					// process attacks
					if (thisMove.action.equals(Action.ATTACK)) {
						result.add(BattleCalculator.attack(character, thisMove.target, thisMove));
						if (thisMove.target.HP <= 0) {
							result.add(thisMove.target + " was killed by " + character);
							thisMove.target.die();
						}
					}
				}
				if (result.size() > 5) {
					
				}
			}
			DrawStuff.drawState(thisNode, result);
			moveCount++;
			if (player.isDead) {
				running = false;
				System.out.println("Game over!");
			}
		}
	}
	


	


}
