package model;
import java.io.Serializable;
import java.util.Date;
public class Motorista implements Serializable{
    private String nome;
    private Date dataNasc;
    private String numCnh;
    private String tipoCnh;

    public Motorista() {
    }

    public Motorista(String nome, Date dataNasc, String numCnh, String tipoCnh) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.numCnh = numCnh;
        this.tipoCnh = tipoCnh;
    }
    
    public Motorista(String nome, String numCnh, String tipoCnh) {
        this.nome = nome;
        this.numCnh = numCnh;
        this.tipoCnh = tipoCnh;
    }

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
