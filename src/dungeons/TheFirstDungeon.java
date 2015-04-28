package dungeons;

public class TheFirstDungeon extends Dungeon {

	public TheFirstDungeon() {
		this.dungeonName = "The First Dungeon";
		this.firstRoom = new D1R1();
		firstRoom.generateUp();
	}
	
	public void generate() {
		DungeonNode current = this.firstRoom;
		DungeonNode previous = this.firstRoom;
		for (int i = 0; i < 5; i++) {
			
		}
	}
	
}
