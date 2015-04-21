package game;

public class Move {
	
	Action action;
	Direction dir;
	Item item;
	Weapon weapon;
	String target = "";

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
