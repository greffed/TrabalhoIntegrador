/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static control.MotoristaControl.*;
import javax.swing.JOptionPane;
import static view.Principal.subMenu;

/**
 *
 * @author Marcos Oliveira
 */
public class MotoristaMenu {

    public static void motoristaMenu() {
        String textoSubMenu = "";
        do {
            textoSubMenu = "1 - Cadastrar Motorista \n"
                    + "2 - Alterar Motorista \n"
                    + "3 - Deletar Motorista \n"
                    + "0 - Voltar";
            subMenu = (JOptionPane.showInputDialog(textoSubMenu));
            switch (subMenu) {
                case "1":
                    cadastrarMotorista();
                    break;
                case "2":
                    alterarMotorista();
                    break;
                case "3":
                    deletarMotorista();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, listarMotoristas());
                    break;
                case "0":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    break;

            }
        } while (!subMenu.equals("0"));
    }
}
