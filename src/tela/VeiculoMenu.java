/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import static controle.VeiculoControle.*;
import javax.swing.JOptionPane;
import static tela.Principal.subMenu;

/**
 *
 * @author Marcos Oliveira
 */
public class VeiculoMenu {

    public static void veiculoMenu() {
        String textoSubMenu = "";
        while (subMenu >= 1 && subMenu <= 3) {
            textoSubMenu = "1 - Cadastrar Veículo \n"
                    + "2 - Alterar Veículo \n"
                    + "3 - Deletar Veículo \n"
                    + "0 - Voltar";
            subMenu = Integer.parseInt(JOptionPane.showInputDialog(textoSubMenu));
            switch (subMenu) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    alterarExcluirVeiculo();
                    break;
                case 3:
                    alterarExcluirVeiculo();
                    break;
            }
        }
    }
}
