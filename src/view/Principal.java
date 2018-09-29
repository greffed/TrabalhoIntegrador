package view;

import static control.MotoristaControl.ler;
import static control.MotoristaControl.salvar;
import javax.swing.JOptionPane;
import static view.MotoristaMenu.motoristaMenu;

public class Principal {

    public static int menu, subMenu;

    public static void main(String[] args) {
        menu = 1;

        String textoMenu = null;
        while (menu >= 1 && menu <= 6) {
            subMenu = 1;
            textoMenu = "Menus \n"
                    + "1 - Motorista \n"
                    + "2 - Veiculo \n"
                    + "3 - Pacote \n"
                    + "4 - Relatório\n"
                    + "5 - Carregar Dados do Arquivo\n"
                    + "6 - Salvar Dados no arquivo\n"
                    + "0 - Sair";
            menu = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));
            switch (menu) {
                case 1:
                    motoristaMenu();
                    break;
                case 2:
                    //veiculoMenu();
                    break;
                case 3:
                    //pacoteMenu();
                    break;
                case 4:
                    //relatorioMenu();
                    break;
                case 5:
                    ler();
                    break;
                case 6:
                    salvar();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
            }
        }
    }
}
