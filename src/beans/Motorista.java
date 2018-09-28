package beans;

import java.util.Date;
import tela.Cadastro;


public class Motorista extends Cadastro{
	private String nome;
	private Date dataNasc;
	private String numCnh;
	private String tipoCnh;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getNumCnh() {
		return numCnh;
	}
	public void setNumCnh(String numCnh) {
		this.numCnh = numCnh;
	}
	public String getTipoCnh() {
		return tipoCnh;
	}
	public void setTipoCnh(String tipoCnh) {
		this.tipoCnh = tipoCnh;
	}
}
