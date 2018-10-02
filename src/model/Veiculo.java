package model;

import java.io.Serializable;
import view.Cadastro;

public abstract class Veiculo implements Serializable {

    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private int capacidade;
    private String tipo;

    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, String placa, int ano, int capacidade, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    
    
    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setAno(String ano) {
        try {
            this.ano = Integer.parseInt(ano);
        } catch (Exception e) {
            this.ano = 0;
        }
    }
}
