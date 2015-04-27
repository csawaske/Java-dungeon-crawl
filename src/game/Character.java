package game;
import inventory.*;
import dungeons.*;
import enums.*;

import java.util.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;

import enums.Direction;

public class Character {
	Scanner console = new Scanner(System.in);
	
	// IMPORTANT! USED FOR BATTLE! SET EQUAL TO OFFSET IN BATTLETEST
	public final int SIZE = 50;
	
	
	// names and representations
	public String characterName;
	public String stringRep;
	public Color color = Color.WHITE;
	

	
	//stats
	public int level = 1;
	public int exp = 0;
	public int maxHP = 5;
	public int HP = 5;
	public int strength = 5;
	public int dexterity = 5;
	public int constitution = 5;
	public int intelligence = 5;
	public int wisdom = 5;
	public int charisma = 5;
	public Alignment alignment = Alignment.NEUTRAL;
	public EnumSet<Language> languages = EnumSet.of(Language.MUTE);
	
	public boolean isDead = false;
	
	
	// loadout
	
	public ArrayList<Weapon> weapons = new ArrayList<Weapon>();	
	public Weapon rightHand = TotalInventory.getWeapon("Fist");
	public Weapon leftHand = TotalInventory.getWeapon("Fist");
	
	
	public ArrayList<Armor> armor = new ArrayList<Armor>();	
	public Item equippedArmor;
	
	public ArrayList<Item> inventory = new ArrayList<Item>();	
	public ArrayList<Item> hotInventory = new ArrayList<Item>() {{
		add(new Item("ONE"));
		add(new Item("TWO"));
		add(new Item("THREE"));
	}};
	public int money = 100;	
	
	
	
	
	// location trackers
	public Point position;
	public DungeonNode currentNode;

	
		
	public Character(String name) {	
		characterName = name;
		stringRep = name.substring(0, 2).toUpperCase();
		position = new Point(2, 2);
	}

	
	public Character() {
		this("  ");
	}
	
	
	public String getStringRep() {
		return stringRep;
	}
	
	
	public Color getColor() {
		return color;
	}
	
	
	public void showInventory() {
		for (int i = 0; i <inventory.size(); i++) {
			System.out.println(inventory.get(i).toString());
		}
	}

	
	public Move getMove() {
		final Move move = new Move();
		if (isDead == true) {
			return move;
		}
		
		// prompts for move
		System.out.println("Move: \t\tWASD");
		System.out.println("Attack:\t\t(r)ight hand, " + rightHand);
		System.out.println("\t\t(l)eft hand, " + leftHand);
		System.out.println("Quick items: \t(1) " + hotInventory.get(0) + "\t(2) " + hotInventory.get(1) + "\t(3) " + hotInventory.get(2));
		System.out.println("Other options:\t(i)nteract\t(t)alk\t\t(m)anage character and inventory");
		System.out.print("Next action?");
		String actionInput = console.next();
		
	
		
		//process input
		switch (actionInput) {
			case "w": move.action = Action.MOVE;
					move.dir = Direction.UP;
					break;
			case "s": move.action = Action.MOVE;
					move.dir = Direction.DOWN;
					break;
			case "a": move.action = Action.MOVE;
					move.dir = Direction.LEFT;
					break;
			case "d": move.action = Action.MOVE;
					move.dir = Direction.RIGHT;
					break;
			case "r": move.action = Action.ATTACK;
					move.dir = Direction.STAY;
					move.weapon = rightHand;
					move.target = getTarget(move);
					break;
			case "l": move.action = Action.ATTACK;
					move.dir = Direction.STAY;
					move.weapon = leftHand;
					move.target = getTarget(move);
					break;
			case "1": move.action = Action.USE;
					move.item = hotInventory.get((Integer.parseInt(actionInput) - 1));
					move.target = getTarget(move); break;
			case "2": move.action = Action.USE;
					move.item = hotInventory.get((Integer.parseInt(actionInput) - 1));
					move.target = getTarget(move); break;
			case "3": move.action = Action.USE;
					move.item = hotInventory.get((Integer.parseInt(actionInput) - 1));
					move.target = getTarget(move); break;
			case "x": return new Move();
			default: System.out.println("Invalid input. Try again!");
					this.getMove();
					break;	
		}
		return move;
	}

	public Character getTarget(Move move) {
		Character target = null;
		String actionType = "";
		switch (move.action) {
			case ATTACK: actionType = "Attack "; break;
			case USE: actionType = "Use " + move.item + " on"; break;
			default: break;
		}
		System.out.print(actionType + " which character?");
		String targetString = console.next();
		for (Character character: currentNode.characterList) {
			if (character.stringRep.equalsIgnoreCase(targetString)) {
				target = character;
			}
		}
		if (target == null) {
			System.out.println("There is no character of that name. Try again.");
			this.getTarget(move);
		}
		return target;
	}
	
	
	
	
	public Direction promptDirection() {
		System.out.println("Direction?");
		System.out.println("(u)p, (d)own, (l)eft, (r)ight: ");
		String directionInput = console.next();
		switch (directionInput) {
			case "u": return Direction.UP;
			case "d": return Direction.DOWN;
			case "l": return Direction.LEFT;
			case "r": return Direction.RIGHT;
			default: System.out.println("Invalid input. Try again.");
					return this.promptDirection();
		}
	}
	
	public void die() {
		isDead = true;
		stringRep = "*";
	}
	
	
	public String toString() {
		return characterName;
	}
	
	public Item promptItem() {
		System.out.println("Current inventory:");
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println((i + 1) + ". " + inventory.get(i));
		}
		System.out.println("Type item number to use: ");
		int itemNumber = console.nextInt();
		return inventory.get(itemNumber - 1);
	}
		

}
