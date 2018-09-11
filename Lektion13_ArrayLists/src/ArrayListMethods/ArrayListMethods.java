package ArrayListMethods;

import java.util.ArrayList;

public class ArrayListMethods {

	/**
	 * Sums the numbers in the list using a for loop each
	 */
	public int sumListeForEach(ArrayList<Integer> list) {
		int resultat = 0;
		for (int tal : list) {
			resultat = resultat + tal;
		}
		return resultat;
	}

	/**
	 * Sums the numbers in the list using a for loop
	 */
	public int sumListeFor(ArrayList<Integer> list) {
		int resultat = 0;
		for (int i = 0; i < list.size(); i++) {
			resultat = resultat + list.get(i);
		}
		return resultat;
	}

	/**
	 * Returns the index of the first even number
	 */
	public int hasEvenAtIndex(ArrayList<Integer> list) {
		int index = -1;
		int i = 0;
		while (index == -1 && i < list.size()) {
			if (list.get(i) % 2 == 0) {
				index = i;
			}
			i++;
		}
		return index;
	}
	
}
