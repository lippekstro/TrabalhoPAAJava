import java.util.Scanner;

public class TesteAlocacaoNaoDinamica {

public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	Integer[] array = new Integer[200000];
	int tamanhoUsado = 0;
	HeapSortArray hp = new HeapSortArray();
	int caso = 1;

	while(true) {
		String itemDeEntada = scan.nextLine().toUpperCase(); //le entrada
		if(itemDeEntada.contains("I") || itemDeEntada.contains("P")) { //verifica se tem I ou P
			if(itemDeEntada.contains("I")) { //se tem I
				array[tamanhoUsado] = Integer.parseInt(itemDeEntada.substring(2)); //insere
				tamanhoUsado++;
				//procura se o valor inserido em menor que o no pai pra ja posicionar no local certo
				int index = tamanhoUsado - 1;
				while(index > 0 && array[index] > array[(index-1)/2]) {
					hp.troca(array, index, (index-1)/2);
					index = (index-1)/2;
				}
			} else if (itemDeEntada.contains("P")) { //se tem P
				if(tamanhoUsado == 0) {
					System.out.println("empty"); // se nao tiver elementos printa empty
				} else { //se tiver elementos
					System.out.println(array[0]); // printa o maior
					//troca o primeiro com o ultimo
					hp.troca(array, 0, tamanhoUsado - 1);
					//remove diminuindo o tamanho do array
					tamanhoUsado--;
					hp.heapify(array, 0, tamanhoUsado-1);
				}
			}
		} else {
			if(itemDeEntada.matches("0 0")) { //verifica se eh uma entrada 0 0 (nao deve fazer nada)
				System.out.println(" "); //pulei uma linha pr ficar mais visivel
			} else {
				if(itemDeEntada.matches("[0-9]* ")) { //se for uma entrada no formato (numero|espaço)  (pra que nao se confunda com o caso (numero|espaco|numero) pois era o que estava acontecendo em alguns casos)
					array[tamanhoUsado] = Integer.parseInt(itemDeEntada.trim()); //pega so o numero e adiciona ao vetor
					tamanhoUsado++;
					int index = tamanhoUsado - 1;
					while(index > 0 && array[index] > array[(index-1)/2]) {
						hp.troca(array, index, (index-1)/2);
						index = (index-1)/2;
					}
					
				}
				else if (itemDeEntada.matches("([0-9]* [0-9]*)")) { //se forem 2 numeros no formato (numero|espaco|numero) marca o inicio de um novo caso
					tamanhoUsado = 0; // reinicia o array
					System.out.println("Caso #" + caso);
					caso++;
				} 
				else { //se for apenas um numero inteiro solto entao adiciona no vetor (valores iniciais do vetor)
					array[tamanhoUsado] = Integer.parseInt(itemDeEntada.trim());
					tamanhoUsado++;
					int index = tamanhoUsado - 1;
					while(index > 0 && array[index] > array[(index-1)/2]) {
						hp.troca(array, index, (index-1)/2);
						index = (index-1)/2;
					}
					// tamanhoUsado++;
				}
			}
		}
	}
	}
}