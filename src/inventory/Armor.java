package inventory;
import enums.*;

public class Armor {
	
	public String armorName;
	public int[] stats = new int[2];
	public Integer damageReduction = stats[0];
	public Integer evadeReduction = stats[1];
	public Element element;

	public Armor(String name) {
		armorName = name;
	}
	
	public Armor() {
		this("");
	}

	
	
	
}
