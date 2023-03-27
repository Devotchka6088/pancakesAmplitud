package pancakesAmplitud;

import java.util.LinkedList;

public class Main {
	
	static String ordenPrin = "";

	public static void main(String[] args) {
		
		char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		String ordenRan = "";
		int nDiscos = 5;
		
		for(int i=0;i<=nDiscos-1;i++) {
			ordenPrin+=letras[i];
		}
		System.out.println("Inicio     > "+ordenPrin);
		
		ordenRan = shuffle();
		
		busquedaAmplitud(ordenRan);

	}
	
	private static String shuffle() {

		char[] pos = ordenPrin.toCharArray();
		String orden = "";
		for(int i=0;i<ordenPrin.length();i++) {
			int ran = (int)(Math.random()*ordenPrin.length());
			if(pos[ran]!=0) {
				orden+=pos[ran];
				pos[ran]=0;
			}else {
				i--;
			}
		}
		System.out.println("Aleatorio  > "+orden);
		return orden;
	}
	
	private static void busquedaAmplitud(String ordenRan) {
		
		char[] pos = ordenRan.toCharArray();
		String orden = "";
		LinkedList<String> colaDiscos= new LinkedList<String>();
		LinkedList<Integer> noRegreso = new LinkedList<Integer>();
		LinkedList<Integer> padre = new LinkedList<Integer>();
		int contador = 0;
		
		colaDiscos.add(ordenRan);
		noRegreso.add(0);
		padre.add(null);
		
		for(int a=0;!veriSol(orden);a++) {
			
			pos = colaDiscos.get(a).toCharArray();
			
			for(int i=1;i<pos.length;i++) {
				
				if((int)noRegreso.get(a)!=i) {
					
					contador++;
					padre.add(a);
					noRegreso.add(i);
					
					for(int j=i;j>=0;j--) {
						orden+=pos[j];
					}
					
					for(int j=i+1;j<pos.length;j++) {
						orden+=pos[j];
					}
					
					if(veriSol(orden)) {
						break;
					}
					
					colaDiscos.add(orden);
					orden = "";
					
				}
			}
		}
		System.out.println("\nSolucion encontrada");
		System.out.println("Nodos visitados > " + contador);
	}
	
	private static boolean veriSol(String ordenRan) {
		
		return ordenPrin.equals(ordenRan);
		
	}
}