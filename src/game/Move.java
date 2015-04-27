package game;

import enums.Action;
import enums.Direction;
import inventory.Item;
import inventory.Weapon;

public class Move {
	
	Action action;
	Direction dir;
	Item item;
	Weapon weapon;
	Character target;

	public Move(Action actionIn, Direction dirIn, Item itemIn) {
		action = actionIn;
		dir = dirIn;
		item = itemIn;
	}
	
	public Move(Action actionIn, Direction dirIn) {
		this(actionIn, dirIn, new Item());
	}
	
	public Move() {
		this(Action.STAY, Direction.STAY);
	}
}
