package game;
import java.io.*;
import java.awt.*;

public class Barbarian extends Character {
	

	
	public Barbarian(String name) throws FileNotFoundException {
		super(name);
		weapons.add(new Weapon("Iron Sword", "HellBreaker"));
		weapons.add(new Weapon("Flame Sword", "Ice Breaker"));
		armor.add(new Armor("Loincloth"));
		primaryWeapon = weapons.get(0);
		color = Color.green;
	}
	
	public Move getMove() {
		Move move = new Move();
		move.dir = Direction.STAY;
		move.action = Action.MOVE;
		return move;
	}
	

}
