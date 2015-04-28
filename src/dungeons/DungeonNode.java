package dungeons;
import game.*;
import game.Character;
import enums.*;

import java.util.*;
import java.awt.*;

public class DungeonNode {

	public ArrayList<Character> characterList = new ArrayList<Character>();
	public Space[][] spaces = new Space[12][12];

	public EnumMap<Direction, DungeonNode> nodeMap = new EnumMap<>(Direction.class);
	
	public DungeonNode() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				if ( (i == 0 || i == 11) && (j == 5 || j == 6)) {
					spaces[i][j] = new Space(SpaceType.DOOR);
				} else if (i == 0 || i == 11 || j == 0 || j == 11) {
					spaces[i][j] = new Space(SpaceType.WALL);
				} else {
					spaces[i][j] = new Space();
				}
			}
		}
		nodeMap.put(Direction.STAY, this);
	}
	
	public void charactersToSpaces() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				spaces[i][j].character = null;
			}
		}
		for (Character character : characterList) {
			spaces[character.position.x][character.position.y].character = character;
		}
	}
	
	
	public void generateUp() {
		// TODO Auto-generated method stub
		
	}
	
}
