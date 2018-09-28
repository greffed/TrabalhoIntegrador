/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import static controle.MotoristaControle.*;
import javax.swing.JOptionPane;
import static tela.Principal.*;

/**
 *
 * @author Marcos Oliveira
 */
public class MotoristaMenu {

    public static void motoristaMenu() {
        String textoSubMenu = "";
        while (subMenu >= 1 && subMenu <= 4) {
            textoSubMenu = "1 - Cadastrar Motorista \n"
                + "2 - Alterar Motorista \n"
                + "3 - Deletar Motorista \n"
                + "0 - Voltar";
            subMenu = Integer.parseInt(JOptionPane.showInputDialog(textoSubMenu));
            switch (subMenu) {
                case 1:
                    cadastrarMotorista();
                    break;
                case 2:
                    alterarExcluirMotorista();
                    break;
                case 3:
                    alterarExcluirMotorista();
                    break;
            }
        }
    }
}
