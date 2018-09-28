/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import beans.Motorista;
import javax.swing.JOptionPane;

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

    public static void alterarMotorista() {
        if (Motorista.motoristas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem motoristas cadastrados!");
        } else {
            String mot = "Digite o nome do motorista a ser alterado: \n";
            mot = listaMotoristas(mot);
            String nomeMotorista = JOptionPane.showInputDialog(mot).toUpperCase();
            Motorista motorista = new Motorista();
            motorista = buscarPorNome(nomeMotorista);
            if (motorista == null) {
                JOptionPane.showMessageDialog(null, "Motorista (" + nomeMotorista + ") não localizado!");
            } else {
                for (Motorista m : Motorista.motoristas) {
                    if (motorista.getNome().equals(m.getNome())) {
                        m.setNome(JOptionPane.showInputDialog("Digite o nome do motorista:").toUpperCase());
                        m.setNumCnh(JOptionPane.showInputDialog("Digite o número da CNH:").toUpperCase());
                        m.setTipoCnh(JOptionPane.showInputDialog("Digite o tipo da CNH:").toUpperCase());
                    }

                }
            }
        }
    }

    public static String listaMotoristas(String mot) {
        int i = 1;
        for (Motorista m : Motorista.motoristas) {
            mot = mot + i + " - " + m.getNome() + "\n";
            i++;
        }
        return mot;
    }

    public static Motorista buscarPorNome(String nomeMotorista) {
        for (Motorista m : Motorista.motoristas) {
            if (nomeMotorista.equals(m.getNome())) {
                return m;
            }
        }
        return null;
    }

    public static void deletarMotorista() {
        if (Motorista.motoristas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem motoristas cadastrados!");
        } else {
            String mot = "Digite o nome do motorista a ser alterado: \n";
            mot = listaMotoristas(mot);
            String nomeMotorista = JOptionPane.showInputDialog(mot).toUpperCase();
            Motorista motorista = new Motorista();
            motorista = buscarPorNome(nomeMotorista);
            if (motorista == null) {
                JOptionPane.showMessageDialog(null, "Motorista (" + nomeMotorista + ") não localizado!");
            } else {
                boolean achou = false;
                int posicao = 0;
                for (Motorista m : Motorista.motoristas) {
                    if (motorista.getNome().equals(m.getNome())) {
                        achou = true;
                        break;
                    }
                    posicao++;
                }
                JOptionPane.showMessageDialog(null, achou);

                if (achou) {
                    Motorista.motoristas.remove(posicao);
                }
            }
        }
    }

}
