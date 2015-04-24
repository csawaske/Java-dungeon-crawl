package game;

import java.io.*;
import java.util.*;

public class Armor {
	
	private String armorType;
	private int[] stats = new int[3];
	private boolean foundArmor;
	private int baseDurability;
	private String breakString;

	public Armor(String type) throws FileNotFoundException {
		armorType = type;
		Scanner findArmor = new Scanner(new File("ArmorList.txt"));
		while (foundArmor == false && findArmor.hasNextLine()) {
			String thisLine = findArmor.nextLine();
			if (type.equals(thisLine)) {
				foundArmor = true;
				Scanner armorStats = new Scanner(findArmor.nextLine());
				for (int i = 0; i <= 2; i++) {
					stats[i] = armorStats.nextInt();
				}				
				baseDurability = stats[1];
				breakString = findArmor.nextLine();
				armorStats.close();
			}
		}
		findArmor.close();
	}
	
	public int[] use() {
		stats[1]--;
		return stats;
	}
	
	public String getBreakString() {
		return breakString;
	}
	
	public String modify(Item modifier) {
		String output = "";
		if (modifier.armorMod == true) {
			stats[1] = baseDurability;
			output = "You've repaired " + armorType + " with " + modifier.toString() +".";
		} else {
			output = "You can't repair " + armorType + " with " + modifier.toString() + ".";
		}
		return output;
	}
	
	
	
}
