package inventory;
import enums.*;

import java.util.*;
import java.io.*;

public class TotalInventory {

	public String nullString;

	public static HashMap<String, String> weaponHash = new HashMap<>();
	public static HashMap<String, Armor> armorHash = new HashMap<>();
	
	public TotalInventory() {
		

		Scanner scan;
		try {
			
			// weapon load-in
			scan = new Scanner(new File("WeaponList.txt"));
			nullString = scan.nextLine();
			while (scan.hasNextLine()) {
				String statLine = scan.nextLine();
				Scanner nameScan = new Scanner(statLine);
				nameScan.useDelimiter("\t");
				String name = nameScan.next();
				weaponHash.put(name, statLine);
			}
			
			// armor load-in
			scan = new Scanner(new File("ArmorList.txt"));
			nullString = scan.nextLine();
			while (scan.hasNextLine()) {
				Armor thisArmor = new Armor();
				String name = scan.nextLine();
				thisArmor.armorName = name;
				String statLine = scan.nextLine();
				Scanner statScan = new Scanner(statLine);
				for (int i = 0; i < 2; i++) {
					thisArmor.stats[i] = statScan.nextInt();
				}
				String element = statScan.next();
				switch (element) {
					case "fire": thisArmor.element = Element.FIRE; break;
					case "poison": thisArmor.element = Element.POISON; break;
					case "physical": thisArmor.element = Element.PHYSICAL; break;
					case "mystic": thisArmor.element = Element.MYSTIC; break;
					default: break;
				}
				statScan.close();
				nullString = scan.nextLine();
				armorHash.put(name, thisArmor);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Armor getArmor(String armorName) {
		Armor toReturn = armorHash.get(armorName);
		return toReturn;
	}
	
	public static Weapon getWeapon(String weaponName) {
		String next = "";
		Weapon toReturn = new Weapon();
		Scanner statLine = new Scanner(weaponHash.get(weaponName));
		statLine.useDelimiter("\t");
		toReturn.weaponName = statLine.next();
		do {
			next = statLine.next();
		} while (next.equals(""));
		String classToken = next;
		switch (classToken) {
			case "sword": toReturn.weaponClass = WeaponClass.SWORD; break;
			case "fist": toReturn.weaponClass = WeaponClass.FIST; break;
			case "knife": toReturn.weaponClass = WeaponClass.KNIFE; break;
			case "bow": toReturn.weaponClass = WeaponClass.BOW; break;
			case "staff": toReturn.weaponClass = WeaponClass.STAFF; break;
			default: break;
		}
		while (!statLine.hasNextInt()) {
			statLine.next();
		}
		for (int i = 0; i < 4; i++) {
			while (!statLine.hasNextInt()) {
				statLine.next();
			}
			toReturn.stats[i] = statLine.nextInt();
		}
		do {
			next = statLine.next();
		} while (next.equals(""));
		String statType = next;
		switch (statType) {
			case "strength": toReturn.statType = Stat.STRENGTH; break;
			case "dexterity": toReturn.statType = Stat.DEXTERITY; break;
			case "intelligence": toReturn.statType = Stat.INTELLIGENCE; break;
			case "constitution": toReturn.statType = Stat.CONSTITUTION; break;
			case "wisdom": toReturn.statType = Stat.WISDOM; break;
			case "charisma": toReturn.statType = Stat.CHARISMA;
			default: break;
		}
		do {
			next = statLine.next();
		} while (next.equals(""));
		String element = next;
		switch (element) {
			case "fire": toReturn.element = Element.FIRE; break;
			case "poison": toReturn.element = Element.POISON; break;
			case "physical": toReturn.element = Element.PHYSICAL; break;
			case "mystic": toReturn.element = Element.MYSTIC; break;
			default: break;
		}
		while (!statLine.hasNextInt()) {
			statLine.next();
		}
		toReturn.modChance = statLine.nextInt();
		do {
			next = statLine.next();
		} while (next.equals(""));
		toReturn.breakString = next;
		toReturn.finalize();
		statLine.close();
		return toReturn;
	}
	
}
