/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Motorista;
import javax.swing.JOptionPane;
import model.ListaMotoristas;

/**
 *
 * @author Marcos Oliveira
 */
public class MotoristaControl {

    private static Motorista motorista = null;
    private static ListaMotoristas listamotoristas = null;
    private static int indice;

    public MotoristaControl() {
        listamotoristas = new ListaMotoristas();
    }

    public static ListaMotoristas getListaMotorista() {
        return listamotoristas;
    }
    
    public static void setListaMotoristas(ListaMotoristas motoristas) {
        listamotoristas = motoristas;
    }

    public static void coletaDados() {
        motorista = new Motorista();
        motorista.setNome(JOptionPane.showInputDialog("Digite o nome do motorista:").toUpperCase());
        motorista.setNumCnh(JOptionPane.showInputDialog("Digite o número da CNH:").toUpperCase());
        motorista.setTipoCnh(JOptionPane.showInputDialog("Digite o tipo da CNH:").toUpperCase());
    }

    public static void cadastrarMotorista() {
        coletaDados();
        listamotoristas.addMotorista(motorista);
        motorista = null;
    }

    public static String listarMotoristas() {
        return listamotoristas.toString();
    }

    public static void deletarMotorista() {
        if (listamotoristas.getSize() > 0) {
            try {
                indice = Integer.parseInt(JOptionPane.showInputDialog(listarMotoristas()));

                System.out.println(listamotoristas.getSize());
                if (indice > 0 && indice <= listamotoristas.getSize()) {
                    listamotoristas.dropMotorista(indice - 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Dado Inválido");
                }
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Dado Inválido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
        }
    }

    public static void alterarMotorista() {
        if (listamotoristas.getSize() > 0) {
            try {
                indice = Integer.parseInt(JOptionPane.showInputDialog(listarMotoristas()));

                if (indice > 0 && indice <= listamotoristas.getSize()) {
                    coletaDados();
                    listamotoristas.alterMotorista(indice - 1, motorista);
                    motorista = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Dado Inválido");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Dado Inválido");
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
        }
    }


}
