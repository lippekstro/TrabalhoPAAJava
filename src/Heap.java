import java.util.ArrayList;

public class Heap {
	
	private int tamanho;
	
	public void montaHeap(ArrayList<Integer> array) {
		
		tamanho = array.size() - 1;

		for (int i = tamanho/2; i >= 0; i--) {
			heapify(array, i);
		}
	}
	
	public void troca(ArrayList<Integer> array, int i, int maior) {
		int aux = array.get(i);
		array.set(i, array.get(maior));
		array.set(maior, aux);
	}

	public void heapify(ArrayList<Integer> array, int i) {
		
		int inicio = 2 * i;
		int fim = 2 * i + 1;
		int maior = i;
		
		if(inicio <= tamanho && array.get(inicio) > array.get(i)) {
			maior = inicio;
		} 
		
		if(fim <= tamanho && array.get(fim) > array.get(maior)) {
			maior = fim;
		}
		
		if(maior != i) {
			troca(array, i, maior);
			heapify(array, maior);
		}
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
