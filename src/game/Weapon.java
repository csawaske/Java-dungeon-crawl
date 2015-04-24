package game;
import game.enums.*;

import java.io.*;
import java.util.*;


public class Weapon {
	
	// new fields
	public WeaponType type;
	public String weaponType;
	public String weaponName;
	public int[] stats;
	public WeaponModType modtype;
	public int modChance;
	public Integer currentDamage;
	public Integer currentDurability;
	
	
	// weapon stats
	

	
	public int damage;
	public int baseDamage;
	public int baseDurability;
	public int durability;
	public int block;
	public int range = 1;
	public int mod = 1;
	public int modCount;
	public String breakString;
	public boolean foundWeapon;
	
	public Weapon(String name) {
		weaponType = name;
	}
	
	public Weapon() {
		this("");
	}
	
	public void setStats() {
		baseDamage = stats[0];
		currentDamage = stats[0];
		baseDurability = stats[1];
		currentDurability = stats[2];
		block = stats[2];
		range = stats[3];
	}
	
	
	

	public void use() {
		modCount--;
		durability--;
		if (modCount == 0) {
			damage = baseDamage;
			mod = 0;
		}
	}
	

	
	public String getBreakString() {
		return breakString;
	}
	
	public String toString() {
		return weaponName;
	}
	
	public String modify(Item modifier) {
		if (modifier.weaponMod == true) {
			if (modifier.modifierType.equals("fire")) {
				mod = 1;
				damage += 3;
				modChance = 50;
				return "You've applied fire to your " + weaponName + ".";
			}
			if (modifier.equals("sharpen")) {
				if ( weaponClass >= 5) {
					return "You can't sharpen your " + weaponName + ".";
				} else {
					durability = baseDurability;
					return "You've sharpened your " + weaponName + ".";
				}
			}
			return "";
		} else {
			return "You can't apply this item to a weapon.";
		}
	}
	
	
	
}