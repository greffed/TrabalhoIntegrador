/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Marcos Oliveira
 */
public class MotoristaB extends Motorista{

    
    //vale a pena criar???
    public MotoristaB() {
    }

    public MotoristaB(String nome, Date dataNasc, String numCnh, String tipoCnh) {
        super(nome, dataNasc, numCnh, tipoCnh);
    }

    public MotoristaB(String nome, String numCnh, String tipoCnh) {
        super(nome, numCnh, tipoCnh);
    }
    
}
