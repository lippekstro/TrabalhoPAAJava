import java.util.Scanner;

public class TesteAlocacaoNaoDinamica {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer[] array = new Integer[200000];
		int tamanhoUsado = 0;
		HeapSortArray hp = new HeapSortArray();
		int caso = 1;
		
		while(caso <= 30) {
			String itemDeEntada = scan.nextLine().toUpperCase(); //le entrada
			
			if(itemDeEntada.contains("I") || itemDeEntada.contains("P")) { //verifica se tem I ou P
				if(itemDeEntada.contains("I")) { //se tem I
					array[tamanhoUsado] = Integer.parseInt(itemDeEntada.substring(2)); //insere
					tamanhoUsado++;
				} else if (itemDeEntada.contains("P")) { //se tem P
					if(tamanhoUsado == 0) {
						System.out.println("empty"); // se nao tiver elementos printa empty
					} else { //se tiver elementos
						hp.montaHeap(array, tamanhoUsado);
						System.out.println(array[0]); // printa o maior
						int aux = array[tamanhoUsado - 1];
						array[tamanhoUsado - 1] = array[0];
						array[0] = aux;
						tamanhoUsado--;
						
					}
				}
			} else {
				if(itemDeEntada.matches("0 0")) { //verifica se eh uma entrada 0 0 (nao deve fazer nada)
					System.out.println();
				} else {
					if(itemDeEntada.matches("[0-9]* ")) { //se for uma entrada no formato numero|espaço  (pra que nao se confunda com o caso numero|espaco|numero pois era o que estava acontecendo em alguns casos)
						array[tamanhoUsado] = Integer.parseInt(itemDeEntada.trim()); //pega so o numero e adiciona ao vetor
						tamanhoUsado++;
					}
					else if (itemDeEntada.matches("([0-9]* [0-9]*)")) { //se forem 2 numeros no formato numero|espaco|numero marca o inicio de um novo caso
						tamanhoUsado = 0;
						System.out.println("Caso #" + caso);
						caso++;
					} 
					else { //se for apenas um numero inteiro solto entao adiciona no vetor (valores iniciais do vetor)
						array[tamanhoUsado] = Integer.parseInt(itemDeEntada.trim());
						tamanhoUsado++;
					}
				}
			}
		}
	}
}
