package game;
import java.util.*;
import java.awt.*;


public class Character {

	Scanner console;
	public int[] position = new int[2];

	public static enum Action {
		MOVE, ATTACK, INTERACT, USE, STAY
	};

	public static enum Direction {
		UP, DOWN, LEFT, RIGHT
	};
		
	public String characterName;
	public ArrayList<Item> inventory = new ArrayList<Item>();
	public ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	public ArrayList<Armor> armor = new ArrayList<Armor>();
	public int[] stats = new int[4];
	public int money = 100;
	
	public Character(String nameIn, Scanner consoleIn) {
		console = consoleIn;	
		name = nameIn;
	}

	public String toString() {
		return characterName;
	}
	
	public void showInventory() {
		for (int i = 0; i <inventory.size(); i++) {
			System.out.println(inventory.get(i).toString());
		}
	}

	public Move getMove() {
		Move move = new Move();
		System.out.println("Next move?");
		System.out.println("(M)ove\t (A)ttack\t (U)se item\t (I)nteract\t 				(T)alk: ");
		String input = console.next();
		switch (input) {
			case "M": move.action = Action.MOVE;
					this.promptDirection();
			case "A": move.action = Action.ATTACK;
					this.promptDirection();
					move.item = 
			case "U": move.action = Action.USE;
					this.promptItem();
					promptDirection();
			case "I": move.action = Action.INTERACT;
					this.promptDirection();
			case "T": move.action = Action.TALK;
					this.promptDirection();
			default: System.out.println("Invalid input. Too slow!");
					move.action = Action.STAY;
					move.dir = Direction.UP;
		}
		return move;
	}

	public void promptDirection() {
		System.out.println("Direction?");
		System.out.println("(U)p, (D)own, (L)eft, (R)ight: ");
		String input = console.next();
		switch (input) {
			case "U": move.dir = Direction.UP;
			case "D": move.dir = Direction.DOWN;
			case "L": move.dir = Direction.LEFT;
			case "R": move.dir = Direction.RIGHT;
			default: System.out.println("Invalid input. Too slow!");
					move.action = Action.STAY;
					move.dir = Direction.UP;
		}
	}
		

}
