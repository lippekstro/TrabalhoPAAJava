public class HeapSortArray {

	//private int tamanho;
	public void montaHeap(Integer[] array, int tamanho) {
		tamanho -= 1;
		for(int i = tamanho/2; i >= 0; i-- ) {
		heapify(array, i, tamanho);
		}
	}

	public void troca(Integer[] array, int x, int y) {
		int aux = array[x];
		array[x] = array[y];
		array[y] = aux;
	}

	public void heapify(Integer[] array, int i, int tamanho) {
		int inicio = 2 * i + 1;
		int fim = 2 * i + 2;
		int maior = i;
		
		if(inicio <= tamanho && array[inicio] > array[i]) {
			maior = inicio;
		}
	
		if(fim <= tamanho && array[fim] > array[maior]) {
			maior = fim;
		}
	
		if(maior != i) {
			troca(array, i, maior);
			heapify(array, maior, tamanho);
		}
	}
}
