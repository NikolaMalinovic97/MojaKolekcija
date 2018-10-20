package mojaKolekcija;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;

public class Test {

	public static void main(String[] args) {
		
		NikolaMapa<Integer, String> nm = new NikolaMapa<>();
		HashMap<Integer, String> hm = new HashMap<>();
		
		System.out.println(nm.size());
		System.out.println(nm.size);
		
		nm.put(1, "Nikola");
		nm.put(2, "Stefan");
		nm.put(3, "Marko");
		nm.put(4, "uros");
		
		System.out.println(nm.put(1, "Nemanja"));
		
		System.out.println(nm);
	}

}
