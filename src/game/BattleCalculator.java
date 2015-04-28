package game;

import java.util.Random;
import enums.*;
import dungeons.*;
import java.awt.*;

public class BattleCalculator {

	static Random r = new Random();

	
	
	
	// process attacks
	public static String attack(Character character, Character target, Move move) {
		String result = "";
		if (character.position.distance(target.position) >= 1.5 * character.rightHand.range) {
			result = target.characterName + " is too far away!";
		} else {
			int atk = 0;
			int def = 0;
			switch (character.rightHand.statType) {
				case STRENGTH: atk = character.strength; def = target.strength; break;
				case DEXTERITY: atk = character.dexterity; def = target.strength; break;
				case CONSTITUTION: atk = character.constitution; def = target.constitution; break;
				case INTELLIGENCE: atk = character.intelligence; def = target.intelligence; break;
				case WISDOM: atk = character.wisdom; def = target.wisdom; break;
				case CHARISMA: atk = character.charisma; def = target.charisma; break;
				case SPECIAL: break;
				default: break;
			}
			int damage = 0;
			if (atk + character.rightHand.statBonus - def > 0) {
				damage = r.nextInt(character.rightHand.die);
			}
			target.HP -= damage;
			result = character + " attacks " + target + " with " + character.rightHand + "." + "\n" +
					character + " did " + damage + " damage to " + target + "!";
		}
		if (target.HP <= 0) {
			result += "\n" + target.characterName + " was killed by "
					+ character.characterName + "'s " + character.rightHand + "!";
			target.die();
		}
		return result;
	}
	
	
	
	
	
	// process movement
	public static Direction move(Character character, Move thisMove, DungeonNode thisNode) {
		if (thisNode.spaces[thisMove.point.x][thisMove.point.y].character == null) {
			character.position = thisMove.point;
		}
		if (character.position.y <= 0) {
			if (character.position.x >= 5 && character.position.x <= 7) {
				character.position.y = 11;
				return Direction.UP;
			} else {
				character.position.translate(0, character.SIZE);
			}
		}
		return Direction.STAY;
	}
	
	
	
}
