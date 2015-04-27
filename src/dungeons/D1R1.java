package dungeons;
import game.Barbarian;
import enums.*;
import java.util.*;
import java.awt.*;
import java.io.*;

public class D1R1 extends DungeonNode {
	
	public D1R1()  {
		characterList.add(new Barbarian("B1"));
		characterList.get(0).position = new Point(4, 4);
		characterList.add(new Barbarian("B2"));
		characterList.get(1).position = new Point(5, 5);
	}

	public void generateUp()  {
		nodeMap.put(Direction.UP, new D1R1());
	}
	
}
