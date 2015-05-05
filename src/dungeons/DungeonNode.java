package dungeons;
import game.*;
import game.Character;
import enums.*;

import java.util.*;
import java.awt.*;

public class DungeonNode {

	public ArrayList<Character> characterList = new ArrayList<Character>();
	public Space[][] spaces = new Space[12][12];
	public int roomSize = 12;

	public EnumMap<Direction, DungeonNode> nodeMap = new EnumMap<>(Direction.class);
	
	public DungeonNode(int num) {
		roomSize = num;
		spaces = new Space[roomSize][roomSize];
		for (int i = 0; i < roomSize; i++) {
			for (int j = 0; j < roomSize; j++) {
				if ( (i == 0 || i == roomSize - 1) && (j == roomSize / 2 || j == roomSize / 2 - 1)) {
					spaces[i][j] = new Space(SpaceType.DOOR);
				} else if (i == 0 || i == roomSize - 1 || j == 0 || j == roomSize - 1) {
					spaces[i][j] = new Space(SpaceType.WALL);
				} else {
					spaces[i][j] = new Space();
				}
			}
		}
		nodeMap.put(Direction.STAY, this);
	}
	
	public DungeonNode() {
		this(12);
	}
	
	public void charactersToSpaces() {
		for (int i = 0; i < roomSize; i++) {
			for (int j = 0; j < roomSize; j++) {
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
