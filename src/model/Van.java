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
public class Van extends Veiculo {

    public Van() {
        super.setCapacidade(1);
        super.setTipo("Van");
    }

    public Van(String marca, String modelo, String placa, int ano) {
        super(marca, modelo, placa, ano, 1, "Van");
        
    }
    
}
