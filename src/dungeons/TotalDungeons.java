package dungeons;
import dungeons.*;

import java.util.*;
import java.io.*;


public class TotalDungeons {

	static HashMap<String, Dungeon> dungeonHash = new HashMap<>();
	
	public TotalDungeons() {
		File path = new File("./src/dungeons");
		File[] files = path.listFiles();
		for (int i = 0; i < files.length; i++) {
			String thisFile = files[i].getName();
			int index = thisFile.indexOf('.');
			String thisFileName = thisFile.substring(0, index);
			if (thisFileName.startsWith("The")) {
				try {
					Class<?> thisDungeonClass = Class.forName("dungeons."+thisFileName);
					try {
						Dungeon thisDungeon = (Dungeon) thisDungeonClass.newInstance();
						dungeonHash.put(thisDungeon.dungeonName, thisDungeon);
					} catch (InstantiationException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Dungeon getDungeon(String dungeonName) {
		return dungeonHash.get(dungeonName);
	}
	
}
