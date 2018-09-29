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

    public static void cadastrarMotorista() {
        motorista = new Motorista();
        motorista.setNome(JOptionPane.showInputDialog("Digite o nome do motorista:").toUpperCase());
        motorista.setNumCnh(JOptionPane.showInputDialog("Digite o número da CNH:").toUpperCase());
        motorista.setTipoCnh(JOptionPane.showInputDialog("Digite o tipo da CNH:").toUpperCase());
        listamotoristas.addMotorista(motorista);
        motorista = null;
    }

    public static String listarMotoristas() {
        return listamotoristas.toString();
    }

    public static void deletarMotorista() {
        if (listamotoristas.checkListaMotoristas()) {
            indice = Integer.parseInt(JOptionPane.showInputDialog(listarMotoristas()));
            listamotoristas.dropMotorista(indice - 1);
        } else {
            JOptionPane.showMessageDialog(null, "lista Vazia");
        }
    }

    public static void alterarMotorista() {
        if (listamotoristas.checkListaMotoristas()) {
            deletarMotorista();
            cadastrarMotorista();
        } else {
            JOptionPane.showMessageDialog(null, "lista Vazia");
        }
    }

    //não funcionando
    public static void popularListaMotoristas(ListaMotoristas motoristas) {
        listamotoristas = motoristas;
    }
    //não funcionando
    public static void salvar() {
        escreverConteudoArquivo(listamotoristas);
    }
    //não funcionando
    public static void ler() {
        lerConteudoArquivo();
    }
    
}
