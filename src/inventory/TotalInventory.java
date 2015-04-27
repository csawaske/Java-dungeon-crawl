package inventory;
import enums.*;

import java.util.*;
import java.io.*;

public class TotalInventory {

	public String nullString;

	public static HashMap<String, Weapon> weaponHash = new HashMap<>();
	public static HashMap<String, Armor> armorHash = new HashMap<>();
	
	public TotalInventory() {
		
		// weapon load-in
		Scanner scan;
		try {
			scan = new Scanner(new File("WeaponList.txt"));

			nullString = scan.nextLine();
			while (scan.hasNextLine()) {
				Weapon thisWeapon = new Weapon();
				String name = scan.nextLine();
				thisWeapon.weaponName = name;
				String typeToken = scan.nextLine();
				switch (typeToken) {
					case "sword": thisWeapon.weaponClass = WeaponClass.SWORD; break;
					case "fist": thisWeapon.weaponClass = WeaponClass.FIST; break;
					case "knife": thisWeapon.weaponClass = WeaponClass.KNIFE; break;
					case "bow": thisWeapon.weaponClass = WeaponClass.BOW; break;
					case "staff": thisWeapon.weaponClass = WeaponClass.STAFF; break;
					default: break;
				}
				String statLine = scan.nextLine();
				Scanner statScan = new Scanner(statLine);
				for (int i = 0; i < 4; i++) {
					thisWeapon.stats[i] = statScan.nextInt();

				}
				String statType = statScan.next();
				switch (statType) {
					case "strength": thisWeapon.statType = Stat.STRENGTH; break;
					case "dexterity": thisWeapon.statType = Stat.DEXTERITY; break;
					case "intelligence": thisWeapon.statType = Stat.INTELLIGENCE; break;
					case "constitution": thisWeapon.statType = Stat.CONSTITUTION; break;
					case "wisdom": thisWeapon.statType = Stat.WISDOM; break;
					case "charisma": thisWeapon.statType = Stat.CHARISMA;
					default: break;
				}
				String element = statScan.next();
				switch (element) {
					case "fire": thisWeapon.element = Element.FIRE; break;
					case "poison": thisWeapon.element = Element.POISON; break;
					case "physical": thisWeapon.element = Element.PHYSICAL; break;
					case "mystic": thisWeapon.element = Element.MYSTIC; break;
					default: break;
				}
				if (statScan.hasNextInt()) {
					thisWeapon.modChance = statScan.nextInt();
				}
				statScan.close();
				thisWeapon.breakString = scan.nextLine();
				nullString = scan.nextLine();
				weaponHash.put(name, thisWeapon);
			}
			scan.close();
			
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
		Weapon toReturn = weaponHash.get(weaponName);
		toReturn.finalize();
		return toReturn;
	}
	
}
