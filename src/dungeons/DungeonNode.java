package dungeons;
import game.*;
import game.Character;
import enums.*;

import java.util.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class DungeonNode {

	public ArrayList<Character> characterList = new ArrayList<Character>();
	public int x = 10;
	public int y = 10;
	
	public EnumMap<Direction, DungeonNode> nodeMap = new EnumMap<>(Direction.class);
	
	
	public void generateUp() {
		// TODO Auto-generated method stub
		
	}
	
}
