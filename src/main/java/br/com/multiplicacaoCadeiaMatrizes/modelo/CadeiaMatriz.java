
package br.com.multiplicacaoCadeiaMatrizes.modelo;

public class CadeiaMatriz {
	/**matriz para armazenar o número mínimo de multiplicações escalares(custos ótimos)**/
	private Integer m[][];		
	
	/**matriz auxiliar que registra qual índice de k alcançou o custo ótimo no cálculo de m[i,j]**/
	private Integer s[][];
	
	/**variável para guardar como as matrizes deverão ser multiplicadas com o número mínimo de 
	 * multiplicações escalares. Essa é a resposta para o Problema de Multiplicação de Cadeias de Matrizes
	 */
	StringBuilder colocacaoOtimaDosParenteses = new StringBuilder();
	
	private Integer numeroMinimoDeMultiplicacoesEscalares;
	
	public void	MATRIX_CHAIN_ORDER(Integer p[]){		
		
		/**sendo n=número de matrizes à multiplicar, como tamanho do vetor p=n+1, então n=p-1**/
		final Integer n = p.length - 1;//constante local		
		
		m = new Integer[n][n];
				
		s = new Integer[n][n];
		
		
		for(int i=0; i<n; i++){
				m[i][i]=0;
		}
		
		for(int L=2; L<=n; L++){
			for(int i=1; i<=n-L+1; i++){
				int j=i+L-1;
				m[i-1][j-1]=Integer.MAX_VALUE;
				for(int k=i; k<=j-1; k++){
					Integer q = m[i-1][k-1] + m[k][j-1] + p[i-1]*p[k]*p[j];
					if(q<m[i-1][j-1]){
						m[i-1][j-1] = q;
						numeroMinimoDeMultiplicacoesEscalares = q;
						s[i-1][j-1] = k;
					}	
				}				
			}
		}
//		return m,s;
	}	
	
//	public void PRINT_OPTIMAL_PARENS(Integer s[][], Integer i, Integer j){
//		
//		if(i==j){
//			System.out.print("A"+i);			
//		}
//		else{
//			System.out.print("(");
//			PRINT_OPTIMAL_PARENS(s, i, s[i-1][j-1]);
//			PRINT_OPTIMAL_PARENS(s, s[i-1][j-1]+1, j);			
//			System.out.print(")");
//		}
//	}
	
	public void PRINT_OPTIMAL_PARENS(Integer s[][], Integer i, Integer j){		
		if(i==j){
			colocacaoOtimaDosParenteses.append("A"+i);
		}
		else{
			colocacaoOtimaDosParenteses.append("(");
			PRINT_OPTIMAL_PARENS(s, i, s[i-1][j-1]);
			PRINT_OPTIMAL_PARENS(s, s[i-1][j-1]+1, j);			
			colocacaoOtimaDosParenteses.append(")");
		}
	}

	
	/**somente get para ler as duas matrizes*/

	public Integer[][] getM() {
		return m;
	}

	public Integer[][] getS() {
		return s;
	}

	public StringBuilder getColocacaoOtimaDosParenteses() {
		return colocacaoOtimaDosParenteses;
	}
	
	public void setColocacaoOtimaDosParenteses(
			StringBuilder colocacaoOtimaDosParenteses) {
		this.colocacaoOtimaDosParenteses = colocacaoOtimaDosParenteses;
	}

	public Integer getNumeroMinimoDeMultiplicacoesEscalares() {
		return numeroMinimoDeMultiplicacoesEscalares;
	}

	public void setNumeroMinimoDeMultiplicacoesEscalares(
			Integer numeroMinimoDeMultiplicacoesEscalares) {
		this.numeroMinimoDeMultiplicacoesEscalares = numeroMinimoDeMultiplicacoesEscalares;
	}

}