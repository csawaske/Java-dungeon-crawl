package game;
import inventory.*;
import enums.*;
import java.io.*;
import java.awt.*;
import java.util.*;

public class Barbarian extends Character {
	
	Random r = new Random();
	
	public Barbarian(String name) {
		super(name);
		weapons.add(TotalInventory.getWeapon("Fist"));
		armor.add(TotalInventory.getArmor("Loincloth"));
		this.rightHand = weapons.get(0);
		color = Color.green;
		alignment = Alignment.WILD;
	}
	
	

	
	public Move getMove() {
		Move move = new Move();
		Character target = null;
		double minDistance = 100000;
		for (Character character: currentNode.characterList) {
			if (!character.alignment.equals(this.alignment) &&
					character.position.distance(this.position) < minDistance &&
					character.isDead == false) {
				target = character;
			}
		}
		if (target == null) {
			return new Move();
		}
		if (this.position.distance(target.position) >= 1.5 * this.rightHand.range) {
			move.action = Action.MOVE;
			if (Math.abs(this.position.x - target.position.x) > Math.abs(this.position.y - target.position.y) ||
					(Math.abs(this.position.x - target.position.x) == Math.abs(this.position.y - target.position.y) && r.nextBoolean())) {
				move.point.y = this.position.y;
				if (this.position.x - target.position.x <= 0) {
					move.point.x = this.position.x + 1;
				} else {
					move.point.x = this.position.x - 1;
				}
			} else {
				move.point.x = this.position.x;
				if (this.position.y - target.position.y <= 0) {
					move.point.y = this.position.y + 1;
				} else {
					move.point.y = this.position.y - 1;
				}
			}
			
		} else {
			move.action = Action.ATTACK;
			move.weapon = this.rightHand;
		}
		move.target = target;
		return move;
	}

}
