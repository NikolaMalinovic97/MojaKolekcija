package mojaKolekcija;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		NikolaLista<Integer> nl = new NikolaLista<>();
		List<Integer> sl = new NikolaLista<>();

		ArrayList<Integer> al = new ArrayList<>();

		al.add(1);
		al.add(2);
		al.add(3);

		nl.add(10);
		nl.add(54);
		nl.add(41);
		nl.add(99);
		nl.add(21);
		
		Object[] array = new Object[nl.size()];
		for (int i = 0; i < nl.size(); i++) {
			System.out.println(array[i]);
		}
		System.out.println("----");
		nl.toArray(array);
		
		for (int i = 0; i < nl.size(); i++) {
			System.out.println(array[i]);
		}
		
		
	}

}
