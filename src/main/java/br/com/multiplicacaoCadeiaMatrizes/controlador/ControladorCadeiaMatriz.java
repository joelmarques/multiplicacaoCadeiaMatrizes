package br.com.multiplicacaoCadeiaMatrizes.controlador;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.multiplicacaoCadeiaMatrizes.modelo.CadeiaMatriz;


@ManagedBean(name = "controladorCadeiaMatriz")
@RequestScoped
public class ControladorCadeiaMatriz {
	
	CadeiaMatriz cadeiaMatriz = new CadeiaMatriz();
	
	private String ordensDasMatrizes;
	
	private StreamedContent fileArtigo;
	
	private StreamedContent fileCodigoFonte;
	
	private List<Integer> listaMatrizM = new ArrayList<Integer>();
	
	private List<Integer> listaMatrizS = new ArrayList<Integer>();
	
	public ControladorCadeiaMatriz(){
		InputStream streamArtigo = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/arquivos/ProblemaDeMultiplicacaoDeCadeiasDeMatrizes.pdf");		
		fileArtigo = new DefaultStreamedContent(streamArtigo,"file/pdf","ProblemaDeMultiplicacaoDeCadeiasDeMatrizes.pdf");
		
		InputStream streamCodigoFonte = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/arquivos/ProblemaDeMultiplicacaoDeCadeiasDeMatrizes.zip");		
		fileCodigoFonte = new DefaultStreamedContent(streamCodigoFonte,"file/zip","ProblemaDeMultiplicacaoDeCadeiasDeMatrizes.zip");
		
	}
	
	
	public void buscarColocacaoOtima(ActionEvent ae){
		Integer p[] = colocarOrdensDasMatrizesNoVetor();
		cadeiaMatriz.MATRIX_CHAIN_ORDER(p);
		
		Integer n = p.length-1;
		cadeiaMatriz.PRINT_OPTIMAL_PARENS(cadeiaMatriz.getS(), 1, n);
		
		preencherListaMatrizM();
		preencherListaMatrizS();
	}
	
	private Integer[] colocarOrdensDasMatrizesNoVetor(){		
		String m[];		
		m=ordensDasMatrizes.split(",");		
		Integer p[] = new Integer[m.length];
		
		for(int i=0; i<m.length; i++){
			p[i] = Integer.parseInt(m[i]);
		}
		
		return p;
	}
		
	public void preencherListaMatrizM(){
		Integer m[][] = cadeiaMatriz.getM();
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m.length; j++){
				listaMatrizM.add(m[i][j]);
			}
		}
	}
	
	public void preencherListaMatrizS(){
		Integer s[][] = cadeiaMatriz.getS();
		for(int i=0; i<s.length; i++){
			for(int j=0; j<s.length; j++){
				listaMatrizS.add(s[i][j]);
			}
		}
	}
	
	
	/**get e set*/

	public CadeiaMatriz getCadeiaMatriz() {
		return cadeiaMatriz;
	}

	public void setCadeiaMatriz(CadeiaMatriz cadeiaMatriz) {
		this.cadeiaMatriz = cadeiaMatriz;
	}

	public String getOrdensDasMatrizes() {
		return ordensDasMatrizes;
	}

	public void setOrdensDasMatrizes(String ordensDasMatrizes) {
		this.ordensDasMatrizes = ordensDasMatrizes;
	}

	public StreamedContent getFileArtigo() {
		return fileArtigo;
	}

	public StreamedContent getFileCodigoFonte() {
		return fileCodigoFonte;
	}

	public List<Integer> getListaMatrizM() {
		return listaMatrizM;
	}

	public void setListaMatrizM(List<Integer> listaMatrizM) {
		this.listaMatrizM = listaMatrizM;
	}

	public List<Integer> getListaMatrizS() {
		return listaMatrizS;
	}

	public void setListaMatrizS(List<Integer> listaMatrizS) {
		this.listaMatrizS = listaMatrizS;
	}
	
}