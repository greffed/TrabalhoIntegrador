package view;

import control.MotoristaControl;
import control.VeiculoControl;
import static dao.Arquivos.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import static view.MotoristaMenu.motoristaMenu;
import static view.VeiculoMenu.veiculoMenu;

public class Principal {

    public static String menu, subMenu;
    private static MotoristaControl motorista = null;
    private static VeiculoControl veiculo = null;

    public static void main(String[] args) {
        /* pegar dia da semana
            RF004
            o roteiro só pode ser gerado de seg a sab
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        */
        motorista = new MotoristaControl();
        veiculo = new VeiculoControl();
        carregarDadosTXT();
        String textoMenu = "";
        do {
            textoMenu = "Menus \n"
                    + "1 - Motorista \n"
                    + "2 - Veiculo \n"
                    + "3 - Pacote \n"
                    + "4 - Relatório\n"
                    + "0 - Sair";
            menu = (JOptionPane.showInputDialog(textoMenu));
            switch (menu) {
                case "1":
                    motoristaMenu();
                    break;
                case "2":
                    veiculoMenu();
                    break;
                case "3":
                    //pacoteMenu();
                    break;
                case "4":
                    //relatorioMenu();
                    break;
                case "0":
                    salvarDadosTXT();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    break;
            }
        } while (!menu.equals("0"));
    }
}
