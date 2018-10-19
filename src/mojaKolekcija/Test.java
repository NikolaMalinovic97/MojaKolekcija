package mojaKolekcija;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;

public class Test {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<>();
		NikolaSet<Integer> ns = new NikolaSet<>();
		
		set.add(22);
		set.add(24);
		set.add(99);
		set.add(11);
		
		ns.add(24);
		ns.add(55);
		ns.add(99);
		ns.add(38);
		ns.add(11);		
		
		
		System.out.println(set.retainAll(ns));
		
		System.out.println(set);
		
	}

}
