package game;
import java.awt.*;
import java.io.*;
import java.util.*;

public class BattleTest {
	
	static ArrayList<Character> characters = new ArrayList<Character>();

	public static void main(String[] args) throws FileNotFoundException {
		Random rand = new Random();
		characters.add(new SamplePlayer("Connor"));
		characters.add(new Barbarian("Tex"));
		characters.add(new Barbarian("Mary"));
		characters.get(2).position = new Point(100, 300);
		Scanner console = new Scanner(System.in);
		boolean running = true;
		int moveCount = 0;
		characters.get(0).position = new Point(100, 100);
		DrawingPanel panel = new DrawingPanel(400, 400);
		Graphics g = panel.getGraphics();
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
		while (running = true) {
			drawState(g);
			for (Character character : characters) {
				Move thisMove = character.getMove();
				if (thisMove.action.equals(Action.MOVE)) {
					switch (thisMove.dir) {
					case UP: character.position.translate(0, -20);
						break;
					case DOWN: character.position.translate(0, 20);
						break;
					case LEFT: character.position.translate(-20, 0);
						break;
					case RIGHT: character.position.translate(20, 0);
						break;
					default: break;
					}
				}

				if (thisMove.action.equals(Action.ATTACK)) {
					Character target = null;
					for (int i = 0; i < characters.size(); i++) {
						if (characters.get(i).getStringRep().equals(thisMove.target)) {
							target = characters.get(i);
						}
					}
					if (target == null) {
						System.out.println("No target by that name. You miss!");
						break;
					}
					int blockChance = rand.nextInt(100);
					int evadeChance = rand.nextInt(100);
					if (Math.pow(Math.pow(character.position.x - target.position.x, 2) +
							Math.pow(character.position.y - target.position.y, 2), 0.5) > 30 * character.primaryWeapon.range) {
						System.out.println("Enemy " + target + " is too far away!");
						System.out.println(Math.pow(Math.pow(character.position.x - target.position.x, 2) +
							Math.pow(character.position.y - target.position.y, 2), 0.5));
						System.out.println(character.primaryWeapon.range);
					} else if (evadeChance < target.evade) {
						System.out.println("Enemy " + target + " evaded your attack!");
						
					} else if (blockChance < target.primaryWeapon.stats[3]) {
						System.out.println("Enemy " + target + " blocked your attack with " + target.primaryWeapon);
					} else {
						int damage = character.primaryWeapon.stats[1] - target.totalDefense;
						target.HP -= damage;
						System.out.println(character + " did " + damage + " damage to " + target + "!");
					}
					if (target.HP <= 0) {
						System.out.println("Enemy " + target + " was killed by your" + character.primaryWeapon + "!");
						target.die();
					}
				}
				
				
				
				drawState(g);
			}
			moveCount++;
		}
	}
	
	
	public static void drawState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 400, 400);
		for (Character character : characters) {
			g.setColor(character.getColor());
			g.drawString(character.getStringRep(), character.position.x - 5, character.position.y + 8);
		}
	}
}
