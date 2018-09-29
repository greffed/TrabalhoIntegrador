/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static dao.ArquivoMotorista.*;
import model.Motorista;
import javax.swing.JOptionPane;
import model.ListaMotoristas;

/**
 *
 * @author Marcos Oliveira
 */
public class MotoristaControl {

    private static Motorista motorista = null;
    private static ListaMotoristas listamotoristas = new ListaMotoristas();
    private static int indice;

    public MotoristaControl() {
        motorista = new Motorista();
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
        if (listamotoristas.checkListaMotoristas()) {
            indice = Integer.parseInt(JOptionPane.showInputDialog(listarMotoristas()));
            if (indice > 0 && indice < listamotoristas.getSize()) {
                listamotoristas.dropMotorista(indice - 1);
            } else {
                JOptionPane.showMessageDialog(null, "Dado Inválido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
        }
    }

    public static void alterarMotorista() {
        if (listamotoristas.checkListaMotoristas()) {
            indice = Integer.parseInt(JOptionPane.showInputDialog(listarMotoristas()));
            if (indice > 0 && indice < listamotoristas.getSize()) {
                coletaDados();
                listamotoristas.alterMotorista(indice - 1, motorista);
                motorista = null;
            } else {
                JOptionPane.showMessageDialog(null, "Dado Inválido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
        }
    }

    public static void popularListaMotoristas(ListaMotoristas motoristas) {
        listamotoristas = motoristas;
    }
    
    public static void salvar() {
        escreverConteudoArquivo(listamotoristas);
    }

    public static void ler() {
        lerConteudoArquivo();
    }

}
