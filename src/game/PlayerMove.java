package game;
import dungeons.*;
import enums.*;
import java.awt.*;


public class PlayerMove {

	static Move move = new Move();
	static boolean moveBuilt = false;
	
	public static void makeMove(int x, int y, Character player, DungeonNode thisNode) {
		if (thisNode.spaces[x][y].character == null) {
			if (Math.abs(player.position.x - x) + Math.abs(player.position. y - y) <= 1) {
				move.point = new Point(x, y);
				move.action = Action.MOVE;
			}
		} else {
			move.action = Action.ATTACK;
			move.target = thisNode.spaces[x][y].character;
			move.weapon = player.rightHand;
		}
		
		System.out.println("hit");
		moveBuilt = true;
	}
	
}
