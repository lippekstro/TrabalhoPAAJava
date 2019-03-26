
public class HeapSortArray {

	private int tamanho;
	
	public void montaHeap(Integer[] array, int tamanho) {
		//tamanho = array.length - 1;
		
		for(int i = tamanho/2; i >= 0; i-- ) {
			heapify(array, i);
		}
	}
	
	public void troca(Integer[] array, int x, int y) {
		int aux = array[x];
		array[x] = array[y];
		array[y] = aux;
	}
	
	public void heapify(Integer[] array, int i) {
		
		int inicio = 2 * i;
		int fim = 2 * i + 1;
		int maior = i;
		
		if(inicio <= tamanho && array[inicio] > array[i]) {
			maior = inicio;
		}
		
		if(fim <= tamanho && array[fim] > array[maior]) {
			maior = fim;
		}
		
		if(maior != i) {
			troca(array, i, maior);
			heapify(array, maior);
		}
	}
	
//	public void executaHS(Integer[] array) {
//		montaHeap(array, );
//		
//		for(int i = array.length-1; i > 0; i--) {
//			troca(array, 0, i);
//			tamanho--;
//			//mostraArray(array);
//			heapify(array, 0);
//		}
//		//mostraArray(array);
//	}
//	
//	public void mostraArray(Integer[] array) {
//		for(int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + " ");
//		}
//	}
//	
//	//remove elemento
//	public int removeMaior(Integer[] array) {
//		int removido = array[0];
//		array[0] = array[tamanho--];
//		heapify(array, 0);
//		return removido;
//	}
	
}
