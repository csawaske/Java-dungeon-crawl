package game;

import java.util.Random;
import enums.*;
import dungeons.*;
import java.awt.*;

public class BattleCalculator {

	static Random r = new Random();

	public static void attack(Character character, Character target, Move move) {
		if (character.position.distance(target.position) >= 1.5 * character.rightHand.range) {
			System.out.println(target.characterName + " is too far away!");
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
			System.out.println(character + " did " + damage + " damage to " + target + "!");
		}
		if (target.HP <= 0) {
			System.out.println(target.characterName + " was killed by " + character.characterName + "'s " + character.rightHand + "!");
			System.out.println();
			target.die();
		}
	}
	
	public static void move(Character character, Move thisMove, DungeonNode thisNode) {
		Point previousPosition = new Point(character.position.x, character.position.y);
		switch (thisMove.dir) {
		case UP: character.position.translate(0, -1);
			break;
		case DOWN: character.position.translate(0, 1);
			break;
		case LEFT: character.position.translate(-1, 0);
			break;
		case RIGHT: character.position.translate(1, 0);
			break;
		default: break;
		}
		for (Character other : thisNode.characterList) {
			if (!other.equals(character) && (character.position.equals(other.position))) {
				character.position = previousPosition;
			}
		}
		if (character.position.y <= 0) {
			if (character.position.x >= thisNode.x / 2 - 1 && character.position.x <= thisNode.x / 2 + 1) {
				thisNode = thisNode.up;
				character.position.y = thisNode.y;
				thisNode.characterList.add(character);
			} else {
				character.position.translate(0, character.SIZE);
			}
		}
	}
	
	
	
}
