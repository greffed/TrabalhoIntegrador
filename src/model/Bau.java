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
public class Bau extends Veiculo {

    public Bau() {
        super.setCapacidade(3);
        super.setTipo("Baú");
    }

    public Bau(String marca, String modelo, String placa, int ano) {
        super(marca, modelo, placa, ano, 3, "Baú");
        
    }
    
}
