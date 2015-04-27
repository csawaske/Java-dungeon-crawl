package inventory;
import enums.*;

import java.io.*;
import java.util.*;


public class Weapon {
	
	
	
	public String weaponName;
	public WeaponClass weaponClass;
	public String breakString;
	
	
	public int[] stats = new int[4];
	public int baseDurability;
	public Integer durability;
	public int baseRange;
	public int range;	
	public int die;
	public int statBonus;
	public Stat statType;	
	public Element element;
	public Integer modChance;

	
	
	


	
	
	
	public void finalize() {
		baseDurability = stats[0];
		durability = stats[0];
		range = stats[1];
		die = stats[2];
		statBonus = stats[3];

	}

	public String toString() {
		return weaponName;
	}
	
}