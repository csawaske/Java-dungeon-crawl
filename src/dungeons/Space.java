package dungeons;
import enums.*;
import game.*;
import game.Character;

import java.awt.*;
import java.util.EnumMap;

public class Space {
	
	public SpaceType type;
	public Color color;
	public EnumMap<SpaceType, Color> typeToColor = new EnumMap<>(SpaceType.class);
	public boolean canMove;
	public Character character;
	
	
	public Space(SpaceType typeIn) {
		type = typeIn;
		character = null;
		switch (typeIn) {
			case WALL: canMove = false; color = Color.GRAY; break;
			case BLANK: canMove = true; color = Color.BLACK; break;
			case DOOR: canMove = true; color = Color.BLUE; break;
			default: break;
		}
	}
	
	public Space() {
		this(SpaceType.BLANK);
	}
}
