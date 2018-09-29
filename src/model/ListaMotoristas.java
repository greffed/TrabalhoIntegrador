/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos Oliveira
 */
public class ListaMotoristas implements Serializable {

    List<Motorista> listamotoristas;

    public ListaMotoristas() {
        listamotoristas = new ArrayList<>();
    }

    public ListaMotoristas(List<Motorista> listamotoristas) {
        this.listamotoristas = listamotoristas;
    }

    public boolean checkListaMotoristas() {
        return listamotoristas.size() > 0;
    }

    public void addMotorista(Motorista m) {
        this.listamotoristas.add(m);
    }

    public void dropMotorista(int i) {
        this.listamotoristas.remove(i);
    }

    public void alterMotorista(int i, Motorista m) {
        this.listamotoristas.set(i, m);
    }

    public Motorista getMotorista(int i) {
        return this.listamotoristas.get(i);
    }

    @Override
    public String toString() {
        String txt = "";
        int i = 1;
        for (Motorista m : listamotoristas) {
            txt += i + " - " + m.getNome() + "\n";
            i++;
        }
        return txt;
    }
}
