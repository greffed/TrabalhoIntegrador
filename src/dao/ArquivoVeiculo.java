package dao;

import static control.VeiculoControl.*;
import java.io.*;
import model.ListaVeiculos;
import model.Veiculo;

public class ArquivoVeiculo {

    static String arquivo = "conteudo/veiculos.bin";

    public static void carregarVeiculo() {
        InputStream leitorByte = null;
        ObjectInputStream leitorObjeto = null;

        try {
            leitorByte = new FileInputStream(arquivo);
            leitorObjeto = new ObjectInputStream(leitorByte);

            ListaVeiculos veiculos = (ListaVeiculos) leitorObjeto.readObject();
            if (veiculos.getSize() <= 0) {
                System.out.println("Arquivo de veiculos Vazio!");
            } else {
                popularListaVeiculos(veiculos);
                System.out.println("Arquivo de veiculos Carregado!");
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } finally {
            try {
                if (leitorObjeto != null) {
                    leitorObjeto.close();
                }
                if (leitorByte != null) {
                    leitorByte.close();
                }

            } catch (Exception e) {
            }
        }
    }

    public static void salvarVeiculo(ListaVeiculos listaveiculos) {
        OutputStream escritorByte = null;
        ObjectOutputStream escritorObjeto = null;
        try {
            escritorByte = new FileOutputStream(arquivo);
            escritorObjeto = new ObjectOutputStream(escritorByte);
            // salva o objeto
            escritorObjeto.writeObject(listaveiculos);
            escritorObjeto.flush();
            //System.out.println(listaveiculos);
            System.out.println("Arquivo de veiculos Atualizado!");
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (escritorObjeto != null) {
                    escritorObjeto.close();
                }
                if (escritorByte != null) {
                    escritorByte.close();
                }
            } catch (Exception e) {
            }
        }

    }
}
