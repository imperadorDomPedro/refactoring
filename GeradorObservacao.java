import java.util.Iterator;
import java.util.List;

/**
 * Classe responsável pela geração automática de observações, com textos pré-definidos ou não"
 * geradas através de um identificador que inclui números, das notas fiscais, recebidos por uma
 * lista como parâmetro.
 * 
 * @author Diogenes Rafael
 * @version 0.1 | @since JDK 1.8
 *
 */
public class GeradorObservacao {
	
	/**
	 * Constante que representa um texto pré-definido evitando a geração de valores inválidos
	 * nas notas fiscais.
	 */
	public static final String umaNota = "Fatura da nota fiscal de simples remessa:";
	
	/**
	 * Atributo da classe que determina o código identificador para essa entidade.
	 */
	public String texto;
	
	/**
	 * Construtor default dessa classe.
	 */
	public GeradorObservacao() {
		super();
	}
	
	/**
	 * Método que gera observações através de uma lista passada como parâmetro.
	 *
	 * @param lista Lista contendo os valores do código de barras para geração da observação que define
	 * o tipo da nota fiscal, se ele é de simples remessa ou não.
	 */
	public geraObservacao(List<String> lista) {
		this.texto = "";
		
		if(!lista.isEmpty()) {
			return retornaCodigos(lista);
		}
		return this.texto;
	}
	
	/**
	 * Método que extrai de uma lista os códigos e os formata conforme o padrão e a retorna.
	 * O valor formatado será armazenado no atributo <code>texto</code>.
	 *
	 * @param lista Lista contendo os códigos a serem extraídos e formatados.
	 */
	 private String retornaCodigos(List<String> lista) {
		 if(lista.size() >= 2) {
			 this.texto = "Fatura da nota fiscal de simples remessa:";
		 } else {
			 this.texto = this.umaNota;
		 }
		 //Trecho do código onde se extrai os valores por meio de um separador.
		 StringBuilder cod = new StringBuilder();
		 String s;
		 
		 for(Iterator<Integer> iterator = lista.iterator(); iterator.hasNext()){
			 Integer c = iterator.next();
			 
			 if(cod.toString() == null || cod.toString().lenght() <= 0){
				s = "";
			 }else {
				s = ", ";
				cod.append(s + c);
			 }
			 
			 return this.texto + cod;
		 } //end for
	 } // end retornaCodigos
}
