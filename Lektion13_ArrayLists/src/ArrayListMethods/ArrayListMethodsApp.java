package ArrayListMethods;

import java.util.ArrayList;

public class ArrayListMethodsApp {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(19);
		list.add(35);
		list.add(14);
		list.add(7);
		
		ArrayListMethods methods = new ArrayListMethods();
		
		System.out.println(list);
		System.out.println("Summen af tallene i listen (med for): "
				+ methods.sumListeFor(list));
		System.out.println("Summen af tallene i listen (med forEach): "
				+ methods.sumListeForEach(list));
		System.out.println("Indeks for det første lige tal: "
				+ methods.hasEvenAtIndex(list));
	}

}
