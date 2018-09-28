/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import beans.Motorista;
import javax.swing.JOptionPane;
import static tela.Principal.subMenu;

/**
 *
 * @author Marcos Oliveira
 */
public class MotoristaControle {

    public static void cadastrarMotorista() {
        Motorista motorista = new Motorista();
        motorista.setNome(JOptionPane.showInputDialog("Digite o nome do motorista:").toUpperCase());
        motorista.setNumCnh(JOptionPane.showInputDialog("Digite o número da CNH:").toUpperCase());
        motorista.setTipoCnh(JOptionPane.showInputDialog("Digite o tipo da CNH:").toUpperCase());
        Motorista.motoristas.add(motorista);
        //escreverConteudoArquivo();
    }

    public static void alterarExcluirMotorista() {
        if (Motorista.motoristas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem motoristas cadastrados!");
        } else {
            String mot = "Digite o nome do motorista: \n";
            mot = listarMotoristas(mot);
            String nomeMotorista = JOptionPane.showInputDialog(mot).toUpperCase();
            Motorista motorista = new Motorista();
            motorista = buscarPorNome(nomeMotorista);
            if (motorista == null) {
                JOptionPane.showMessageDialog(null, "Motorista (" + nomeMotorista + ") não localizado!");
            } else {
                if (subMenu == 2) {
                    alterarMotorista(motorista);
                } else {
                    deletarMotorista(motorista);
                }
            }
        }
    }

    public static String listarMotoristas(String mot) {
        int i = 1;
        for (Motorista m : Motorista.motoristas) {
            mot = mot + i + " - " + m.getNome() + "\n";
            i++;
        }
        return mot;
    }

    public static Motorista buscarPorNome(String nomeMotorista) {
        for (Motorista m : Motorista.motoristas) {
            if (nomeMotorista.equalsIgnoreCase(m.getNome())) {
                return m;
            }
        }
        return null;
    }

    public static void alterarMotorista(Motorista motorista) {
        for (Motorista m : Motorista.motoristas) {
            if (motorista.getNome().equals(m.getNome())) {
                m.setNome(JOptionPane.showInputDialog("Digite o nome do motorista:").toUpperCase());
                m.setNumCnh(JOptionPane.showInputDialog("Digite o número da CNH:").toUpperCase());
                m.setTipoCnh(JOptionPane.showInputDialog("Digite o tipo da CNH:").toUpperCase());
            }

        }
    }

    public static void deletarMotorista(Motorista motorista) {
        boolean achou = false;
        int posicao = 0;
        for (Motorista m : Motorista.motoristas) {
            if (motorista.getNome().equals(m.getNome())) {
                achou = true;
                break;
            }
            posicao++;
        }
        //showMessageDialog(null, achou);
        if (achou) {
            Motorista.motoristas.remove(posicao);
        }
    }
}
