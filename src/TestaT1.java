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
		Heap h = new Heap();
		int caso = 1;
		
		while(caso <= 30) {
			if(itemDeEntada.contains("I") || itemDeEntada.contains("P")) {
				if(itemDeEntada.contains("I")) {
					entradas.add(Integer.parseInt(itemDeEntada.substring(2)));
					h.montaHeap((ArrayList<Integer>) entradas); //ainda nao sei a melhor posicao pra "ordenar" entao coloquei em todos os lugares onde se adiciona um valor
				} else if (itemDeEntada.contains("P")) {
					if(entradas.isEmpty()) {
						System.out.println("empty");
					} else {
						System.out.println(entradas.get(0)); // como ta no inicio printa o primeiro
						entradas.remove(entradas.get(0)); // e remove o primeiro
					}
				}
			} else {
				if(itemDeEntada.matches("0 0")) {
					System.out.println();
				} else {
					if(itemDeEntada.matches("[0-9]* ")) { //verificador da pegadinha 1 numero e um espaco
						entradas.add(Integer.parseInt(itemDeEntada.trim()));
						h.montaHeap((ArrayList<Integer>) entradas); //ainda nao sei a melhor posicao pra "ordenar" entao coloquei em todos os lugares onde se adiciona um valor
					}
					else if (itemDeEntada.matches("([0-9]* [0-9]*)")) {
						entradas.clear();
						System.out.println("Caso #" + caso);
						caso++;
					} 
					else {
						entradas.add(Integer.parseInt(itemDeEntada.trim()));
						h.montaHeap((ArrayList<Integer>) entradas); //ainda nao sei a melhor posicao pra "ordenar" entao coloquei em todos os lugares onde se adiciona um valor
					}
				}
			}
			
			itemDeEntada = scan.nextLine().toUpperCase();
		}

	}

}
