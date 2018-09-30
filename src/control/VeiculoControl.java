/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Veiculo;
import javax.swing.JOptionPane;
import model.ListaVeiculos;
import static view.Principal.*;

/**
 *
 * @author Marcos Oliveira
 */
public class VeiculoControl {

    private static Veiculo veiculo = null;
    private static ListaVeiculos listaveiculos = new ListaVeiculos();
    private static int indice;

    public VeiculoControl() {
        this.veiculo = new Veiculo();
    }
    public static ListaVeiculos getListaVeiculo() {
        return listaveiculos;
    }
    public static void coletaDados() {
        veiculo = new Veiculo();
        veiculo.setPlaca(JOptionPane.showInputDialog("Digite a placa do veículo:").toUpperCase());
        veiculo.setMarca(JOptionPane.showInputDialog("Digite a marca do veículo:").toUpperCase());
        veiculo.setModelo(JOptionPane.showInputDialog("Digite o modelo do veículo:").toUpperCase());
        veiculo.setAno(JOptionPane.showInputDialog("Digite o ano do veículo:"));
    }

    public static String listarVeiculos() {
        return listaveiculos.toString();
    }

    public static void cadastrarVeiculo() {
        coletaDados();
        listaveiculos.addVeiculo(veiculo);
        veiculo = null;
    }

    public static void alterarVeiculo() {
        if (listaveiculos.getSize() > 0) {
            indice = Integer.parseInt(JOptionPane.showInputDialog(listarVeiculos()));
            if (indice > 0 && indice <= listaveiculos.getSize()) {
                coletaDados();
                listaveiculos.alterVeiculo(indice - 1, veiculo);
                veiculo = null;

            } else {
                JOptionPane.showMessageDialog(null, "Opção Inválida");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
        }
    }

    public static void deletarVeiculo() {
        if (listaveiculos.getSize() > 0) {
            indice = Integer.parseInt(JOptionPane.showInputDialog(listarVeiculos()));
            if (indice > 0 && indice <= listaveiculos.getSize()) {
                listaveiculos.dropVeiculo(indice-1);
            } else {
                JOptionPane.showMessageDialog(null, "Opção Inválida");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
        }
    }

    public static Veiculo buscarPorPlaca(String placaVeiculo) {
//        for (Veiculo v : Veiculo.veiculo) {
      //      if (placaVeiculo.equalsIgnoreCase(v.getPlaca())) {
    //            return v;
        //    }
  //      }
        return null;
    }

    public static void popularListaVeiculos(ListaVeiculos listanova){
        listaveiculos =  listanova;
    }

    
}
