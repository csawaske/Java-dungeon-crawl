package game;

import enums.*;
import inventory.*;
import inventory.Weapon;
import java.awt.*;

public class Move {
	
	Action action;
	Direction dir;
	Item item;
	Weapon weapon;
	Character target;
	Point point = new Point(0, 0);

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
