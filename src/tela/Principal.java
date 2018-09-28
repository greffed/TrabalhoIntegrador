package tela;

import beans.Motorista;
import beans.Pacote;
import beans.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static tela.MotoristaMenu.*;
import static tela.VeiculoMenu.*;

public class Principal {

    public static List<Motorista> motoristas = new ArrayList<Motorista>();
    public static List<Veiculo> veiculos = new ArrayList<Veiculo>();
    public static List<Pacote> pacotes = new ArrayList<Pacote>();
    public static int menu = 1;
    public static int subMenu = 1;
    
    public static void main(String[] args) {
        menu = 1;
        String textoMenu =  null;
        while (menu >= 1 && menu <= 4) {
            textoMenu = "Menus \n"
                    + "1 - Motorista \n"
                    + "2 - Veiculo \n"
                    + "3 - Pacote \n"
                    + "4 - Relatório\n"
                    + "0 - Sair";
            menu = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));
            switch (menu) {
                case 1:
                    motoristaMenu();
                    break;
                case 2:
                    veiculoMenu();
                    break;
                case 3:
                    //pacoteMenu();
                    break;
                case 4:
                    //relatorioMenu();
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
