package um;

import java.util.Date;


public class Pacote extends Cadastro{
	
	private String nomeRemetente;
	private String endRemetente;
	private String nomeDestinatario;
	private Date dataDeposito;
	private Double peso;
	private int codLocalizador;
	
	public String getNomeRemetente() {
		return nomeRemetente;
	}
	public void setNomeRemetente(String nomeRemetente) {
		this.nomeRemetente = nomeRemetente;
	}
	public String getEndRemetente() {
		return endRemetente;
	}
	public void setEndRemetente(String endRemetente) {
		this.endRemetente = endRemetente;
	}
	public String getNomeDestinatario() {
		return nomeDestinatario;
	}
	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}
	public Date getDataDeposito() {
		return dataDeposito;
	}
	public void setDataDeposito(Date dataDeposito) {
		this.dataDeposito = dataDeposito;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public int getCodLocalizador() {
		return codLocalizador;
	}
	public void setCodLocalizador(int codLocalizador) {
		this.codLocalizador = codLocalizador;
	}
}