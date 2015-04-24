package game;
import game.enums.*;

import java.util.*;
import java.io.*;

public class TotalInventory implements Cloneable {

	public ArrayList<Consumable> consumables;
	public ArrayList<Armor> armors;
	public ArrayList<Weapon> weapons;
	@SuppressWarnings("unused")
	private String nullString;
	
	public TotalInventory() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("WeaponList.txt"));
		while (scan.hasNextLine()) {
			String nameLine = scan.nextLine();
			Weapon thisWeapon = new Weapon(nameLine);
			String typeToken = scan.nextLine();
			switch (typeToken) {
				case "sword": thisWeapon.type = WeaponType.SWORD; break;
				case "fist": thisWeapon.type = WeaponType.FIST; break;
				case "knife": thisWeapon.type = WeaponType.KNIFE; break;
				case "bow": thisWeapon.type = WeaponType.BOW; break;
				case "staff": thisWeapon.type = WeaponType.STAFF; break;
				default: break;
			}
			Scanner statScan = new Scanner(scan.nextLine());
			for (int i = 0; i < 4; i++) {
				thisWeapon.stats[i] = statScan.nextInt();
			}
			if (statScan.hasNext()) {
				String modToken = statScan.next();
				switch (modToken) {
					case "fire": thisWeapon.modtype = WeaponModType.FIRE; break;
					case "poison": thisWeapon.modtype = WeaponModType.POISON; break;
					default: break;
				}
			}
			if (statScan.hasNextInt()) {
				thisWeapon.modChance = statScan.nextInt();
			}
			statScan.close();
			thisWeapon.breakString = scan.nextLine();
			nullString = scan.nextLine();
			thisWeapon.setStats();
			weapons.add(thisWeapon);
		}
		scan.close();
	}
	
	
}
