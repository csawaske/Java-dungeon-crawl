package dungeons;
import game.Character;

import java.util.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class DungeonNode {

	public ArrayList<Character> characterList = new ArrayList<Character>();
	public DungeonNode up;
	public DungeonNode down;
	public DungeonNode right;
	public DungeonNode left;
	public DungeonNode above;
	public DungeonNode below;
	public DungeonNode ether;
	public int x = 10;
	public int y = 10;
	
	public void generateUp() {
		// TODO Auto-generated method stub
		
	}
	
}
