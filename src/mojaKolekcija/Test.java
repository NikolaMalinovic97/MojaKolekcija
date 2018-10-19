package mojaKolekcija;

import java.util.ArrayList;
import java.util.ListIterator;

public class Test {

	public static void main(String[] args) {
		
		NikolaLista<Integer> nl = new NikolaLista<>();

		ArrayList<Integer> al = new ArrayList<>();

		al.add(1);
		al.add(2);
		al.add(3);

		nl.add(10);
		nl.add(54);
		nl.add(41);
		nl.add(99);
		nl.add(21);
		
		ListIterator<Integer> it = nl.listIterator(0);
		
		int i = 0;
		while(it.hasNext()) {
			it.next();
			if(i == 1)
				it.remove();
			i++;
			System.out.println(it.previous());
			it.next();
		}
		
		
		while(it.hasNext()) {
			System.out.println(it.previous());
		}
				
	}

}
