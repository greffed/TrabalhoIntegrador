/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Veiculo;
import javax.swing.JOptionPane;
import static view.Principal.*;

/**
 *
 * @author Marcos Oliveira
 */
public class VeiculoControl {

    public static void cadastrarVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(JOptionPane.showInputDialog("Digite a marca do veículo:").toUpperCase());
        veiculo.setModelo(JOptionPane.showInputDialog("Digite o modelo do veículo:").toUpperCase());
        veiculo.setPlaca(JOptionPane.showInputDialog("Digite a placa do veículo:").toUpperCase());
        veiculo.setAno(JOptionPane.showInputDialog("Digite o ano do veículo:"));
        Veiculo.veiculos.add(veiculo);
        //escreverConteudoArquivo();
    }

    public static Veiculo buscarPorPlaca(String placaVeiculo) {
        for (Veiculo v : Veiculo.veiculos) {
            if (placaVeiculo.equalsIgnoreCase(v.getPlaca())) {
                return v;
            }
        }
        return null;
    }

    public static String listarPorPlaca(String veiculo) {
        int i = 1;
        for (Veiculo v : Veiculo.veiculos) {
            veiculo = veiculo + i + " - " + v.getPlaca() + " " + v.getModelo() + " " + v.getMarca() + "\n";
            i++;
        }
        return veiculo;
    }

    public static void alterarExcluirVeiculo() {
        if (Veiculo.veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem Veículos cadastrados!");
        } else {
            String strveiculo = "Digite a placa do veiculo:\n";
            strveiculo = listarPorPlaca(strveiculo);
            listarPorPlaca(strveiculo);
            String placa = JOptionPane.showInputDialog(strveiculo);
            Veiculo veiculo = new Veiculo();
            veiculo = buscarPorPlaca(placa);
            if (veiculo == null) {
                JOptionPane.showMessageDialog(null, "Veiculo (" + placa + ") não localizado!");
            } else {
                if (subMenu == 2) {
                    alterarVeiculo(veiculo);
                } else {
                    deletarVeiculo(veiculo);
                }

            }
        }
    }

    public static void alterarVeiculo(Veiculo veiculo) {
        for(Veiculo v : Veiculo.veiculos){
            if (v.getPlaca().equals(veiculo.getPlaca())){
                veiculo.setMarca(JOptionPane.showInputDialog("Digite a marca do veículo:").toUpperCase());
                veiculo.setModelo(JOptionPane.showInputDialog("Digite o modelo do veículo:").toUpperCase());
                veiculo.setPlaca(JOptionPane.showInputDialog("Digite a placa do veículo:").toUpperCase());
                veiculo.setAno(JOptionPane.showInputDialog("Digite o ano do veículo:"));
                //veiculo.alterarV(veiculo);//???
            }
        }
    }

    public static void deletarVeiculo(Veiculo veiculo) {
        boolean achou = false;
            int posicao = 0;
            for (Veiculo v : Veiculo.veiculos) {
                if (veiculo.getPlaca().equals(v.getPlaca())) {
                    achou = true;
                    break;
                }
                posicao++;
            }
            if (achou) {
                Veiculo.veiculos.remove(posicao);
            }
    }

    public void alterarV(Object obj) {
        boolean achou = false;
        int posicao = 0;
        for (Veiculo v : Veiculo.veiculos) {
            if (((Veiculo) obj).getPlaca() == v.getPlaca()) {
                achou = true;
                break;
            }
            posicao++;
        }
        if (achou) {
            Veiculo.veiculos.set(posicao, (Veiculo) obj);
        }
    }
}
