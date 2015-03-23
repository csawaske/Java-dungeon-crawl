package game;

import java.io.*;
import java.util.*;

public class test {
	
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Weapon> list = new ArrayList<Weapon>();
		Weapon IronSword = new Weapon("Iron Sword", "HellBreaker");
		list.add(IronSword);
		System.out.println(list.toString());
		System.out.println(Arrays.toString(IronSword.use()));
		System.out.println(IronSword.getBreakString());
	}

}
