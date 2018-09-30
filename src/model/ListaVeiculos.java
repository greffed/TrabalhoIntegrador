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
public class ListaVeiculos implements Serializable {
    private List<Veiculo> listaveiculos;
    
    public ListaVeiculos() {
        listaveiculos = new ArrayList<>();
    }

    public ListaVeiculos(List<Veiculo> listaveiculos) {
        this.listaveiculos = listaveiculos;
    }
    public boolean checkVeiculo(){
        return this.listaveiculos.size()>0;
    }
    public Veiculo getVeiculo(int i){
        return this.listaveiculos.get(i);
    }
    public void addVeiculo(Veiculo v){
        this.listaveiculos.add(v);
    }
    public void dropVeiculo(int i){
        this.listaveiculos.remove(i);
    }
    public void dropVeiculo(Veiculo v){
        this.listaveiculos.remove(v);
    }
    public void alterVeiculo(int i, Veiculo v){
        this.listaveiculos.set(i, v);
    }
    public int getSize(){
        return this.listaveiculos.size();
    } 
    @Override
    public String toString(){
        String txt = "";
        int i = 1;
        for (Veiculo v:listaveiculos){
            txt += i + " - " + v.getPlaca() + "/"+v.getMarca()+" "+v.getModelo()+"\n";
        }
        return txt;
    }

    
}
