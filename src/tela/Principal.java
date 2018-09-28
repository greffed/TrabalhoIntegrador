package tela;

import beans.Motorista;
import beans.Pacote;
import beans.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static tela.MotoristaMenu.*;

public class Principal {

    public static List<Motorista> motoristas = new ArrayList<Motorista>();
    public static List<Veiculo> veiculos = new ArrayList<Veiculo>();
    public static List<Pacote> pacotes = new ArrayList<Pacote>();

    public static void main(String[] args) {
        int menuPrincipal = 1;
        String textoMenu =  null;
        while (menuPrincipal >= 1 && menuPrincipal <= 4) {
            textoMenu = "Menus\n"
                    + "1 - Motorista \n"
                    + "2 - Veiculo \n"
                    + "3 - Pacote \n"
                    + "4 - Relatório\n"
                    + "0 - Sair";
            menuPrincipal = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));
            switch (menuPrincipal) {
                case 1:
                    motoristaMenu();
                    break;
                case 2:
                    //motoristaMenu();
                    break;
                case 3:
                    //motoristaMenu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
