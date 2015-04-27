package dungeons;

public class TheFirstDungeon extends Dungeon {

	public TheFirstDungeon() {
		this.dungeonName = "The First Dungeon";
		this.firstRoom = new D1R1();
		firstRoom.generateUp();
	}
	
}
