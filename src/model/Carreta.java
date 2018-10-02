/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marcos Oliveira
 */
public class Carreta extends Veiculo {

    public Carreta() {
        super.setCapacidade(10);
        super.setTipo("Carreta");
    }

    public Carreta(String marca, String modelo, String placa, int ano) {
        super(marca, modelo, placa, ano, 10, "Carreta");
        
    }
    
}
