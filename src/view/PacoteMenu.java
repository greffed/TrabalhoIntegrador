/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import static view.Principal.*;

/**
 *
 * @author Marcos Oliveira
 */
public class PacoteMenu {

    public static void pacoteMenu() {
        String textoSubMenu = "";
        do {
            textoSubMenu = "1 - Cadastrar Pacote \n"
                    + "2 - Alterar Pacote \n"
                    + "3 - Deletar Pacote \n"
                    + "0 - Voltar";
            subMenu = (JOptionPane.showInputDialog(textoSubMenu));
            switch (subMenu) {
                case "1":
                    //cadastrarPacote();
                    break;
                case "2":
                    //alterarExcluirMotorista();
                    break;
                case "3":
                    //alterarExcluirMotorista();
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
