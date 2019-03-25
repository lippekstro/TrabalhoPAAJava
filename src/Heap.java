import java.util.ArrayList;

public class Heap {
	
	private int tamanho;
	
	public void montaHeap(ArrayList<Integer> array) {
		int tamanho = array.size() - 1;

		for (int i = tamanho/2; i >= 0; i--) {
			heapify(array, i);
		}
		
		for (int i = tamanho - 1; i >= 0; i--) {
			int temp = array.get(0);
			array.set(0, array.get(i));
			array.set(i, temp);
			
			heapify(array, i);
		}
		
	}

	public void heapify(ArrayList<Integer> array, int i) {
		int maior = i;
		int esquerda = 2 * i;
		int direita = 2 * i + 1;
		
		if(esquerda <= tamanho && array.get(esquerda) > array.get(i)) {
			System.out.println("mexeu esquerda");
			maior = esquerda;
		} else {
			maior = i;
		}
		
		if(direita <= tamanho && array.get(direita) > array.get(maior)) {
			System.out.println("mexeu direita");
			maior = direita;
		}
		
		if(maior != i) {
			System.out.println("troca?");
			troca(array, i, maior);
			heapify(array, maior);
			System.out.println("trocou");
		}
	}
	
	public void troca(ArrayList<Integer> array, int i, int maior) {
		int aux = array.get(i);
		array.set(i, array.get(maior));
		array.set(maior, aux);
	}
	
//	public void executaHeap(ArrayList<Integer> array) {
//		montaHeap(array);
//		for(int i = array.size()-1; i>= 0; i--) {
//			troca(array, 0, i);
//			tamanho--;
//			heapify(array, 0);
//		}
//		displayArray(array);
//	}
//	
//	public void displayArray(ArrayList<Integer> array) {
//		for (int i = 0; i<array.size(); i++) {
//			System.out.println(array.get(i));
//		}
//	}
	
}
