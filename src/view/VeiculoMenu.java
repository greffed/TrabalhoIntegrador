/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static control.VeiculoControl.*;
import javax.swing.JOptionPane;
import static view.Principal.subMenu;

/**
 *
 * @author Marcos Oliveira
 */
public class VeiculoMenu {

    public static void veiculoMenu() {
        String textoSubMenu = "";
        do {
            textoSubMenu = "1 - Cadastrar Veículo \n"
                    + "2 - Alterar Veículo \n"
                    + "3 - Deletar Veículo \n"
                    + "0 - Voltar";
            subMenu = (JOptionPane.showInputDialog(textoSubMenu));
            switch (subMenu) {
                case "1":
                    cadastrarVeiculo();
                    break;
                case "2":
                    alterarVeiculo();
                    break;
                case "3":
                    deletarVeiculo();
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
