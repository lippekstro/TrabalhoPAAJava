import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestaT1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		List<Integer> entradas = new ArrayList<>();
		String itemDeEntada = scan.nextLine().toUpperCase();
		HeapSortArray hp = new HeapSortArray();
		int caso = 1;
		
		while(true) {
			if(itemDeEntada.contains("I") || itemDeEntada.contains("P")) {
				if(itemDeEntada.contains("I")) {
					entradas.add(Integer.parseInt(itemDeEntada.substring(2)));
				} else if (itemDeEntada.contains("P")) {
					if(entradas.isEmpty()) {
						System.out.println("empty");
					} else {
						Integer[] array = entradas.toArray(new Integer[entradas.size()]);
						hp.montaHeap(array); //troquei do executahs
						entradas = new ArrayList<Integer>(Arrays.asList(array));
						System.out.println(entradas.get(0)); // entradas.size()-1 
						entradas.remove(entradas.get(0)); //entradas.size()-1
					}
				}
			} else {
				if(itemDeEntada.matches("0 0")) {
					System.out.println();
				} else {
					if(itemDeEntada.matches("[0-9]* ")) { //verificador da pegadinha 1 numero e um espaco
						entradas.add(Integer.parseInt(itemDeEntada.trim()));
					}
					else if (itemDeEntada.matches("([0-9]* [0-9]*)")) {
						entradas.clear();
						System.out.println("Caso #" + caso);
						caso++;
					} 
					else {
						entradas.add(Integer.parseInt(itemDeEntada.trim()));
					}
				}
			}
			
			itemDeEntada = scan.nextLine().toUpperCase();
		}

	}

}
