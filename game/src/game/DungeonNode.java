package game;
import java.util.*;
import java.awt.*;

public class DungeonNode {

	public ArrayList<Character> characterList = new ArrayList<Character>();
	public DungeonNode up;
	public DungeonNode down;
	public DungeonNode right;
	public DungeonNode left;
	public Point size = new Point(100, 100);
	
}
