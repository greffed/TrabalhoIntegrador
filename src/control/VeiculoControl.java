/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author Marcos Oliveira
 */
public class VeiculoControl {

    private static Veiculo veiculo = null;
    private static ListaVeiculos listaveiculos = null;
    private static int indice;

    public VeiculoControl() {
        listaveiculos = new ListaVeiculos();;
    }

    public static ListaVeiculos getListaVeiculo() {
        return listaveiculos;
    }

    public static void coletaDados() {
        int tipoveic = 0;
        while (tipoveic < 1 || tipoveic > 3) {
            tipoveic = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de veículo \n 1 - Carreta \n 2 - Caminhão Baú \n 3 - Van"));
            switch (tipoveic) {
                case 1:
                    veiculo = new Carreta();
                    break;
                case 2:
                    veiculo = new Bau();
                    break;
                case 3:
                    veiculo = new Van();
                    break;
            }
        }
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
            try {
                indice = Integer.parseInt(JOptionPane.showInputDialog(listarVeiculos()));
                if (indice > 0 && indice <= listaveiculos.getSize()) {
                    coletaDados();
                    listaveiculos.alterVeiculo(indice - 1, veiculo);
                    veiculo = null;

                } else {
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opção Inválida");
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
        }
    }

    public static void deletarVeiculo() {
        if (listaveiculos.getSize() > 0) {
            try {
                indice = Integer.parseInt(JOptionPane.showInputDialog(listarVeiculos()));
                if (indice > 0 && indice <= listaveiculos.getSize()) {
                    listaveiculos.dropVeiculo(indice - 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opção Inválida");
                System.out.println(e);
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

    public static void popularListaVeiculos(ListaVeiculos listanova) {
        listaveiculos = listanova;
    }

}
