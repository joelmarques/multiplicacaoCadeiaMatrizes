
package br.com.multiplicacaoCadeiaMatrizes;

import br.com.multiplicacaoCadeiaMatrizes.modelo.CadeiaMatriz;

public class Main {	
	
	public static void main(String[] args) {
		
		
		Integer p[]={30,35,15,5,10,20,25};
	
//		Integer p[]={5,10,3,12,5,50,6};
		
		CadeiaMatriz cm = new CadeiaMatriz();
		
		cm.MATRIX_CHAIN_ORDER(p);
		
		
		
		System.out.println("Matriz M:\n");
		
		Integer m[][] = cm.getM();
		
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m.length;j++){
				System.out.print(m[i][j]+" ");
			}
			
			System.out.println("\n");
		}
		
		
		System.out.println("Matriz S:\n");
		
		Integer s[][] = cm.getS();
		
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s.length;j++){
				System.out.print(s[i][j]+" ");
			}
			
			System.out.println("\n");
		}
			
		
		System.out.println("Colocação ótima dos parênteses:");
		
		Integer n = p.length-1;
		
		cm.PRINT_OPTIMAL_PARENS(s, 1, n);
		System.out.println(cm.getColocacaoOtimaDosParenteses());
	}

}