package dao;

import static control.MotoristaControl.popularListaMotoristas;
import static dao.Arquivos.verificaArquivo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import model.ListaMotoristas;

public class ArquivoMotorista {

    private static String arquivo = "conteudo/motoristas4.bin";
    
    public static void carregarMotorista() {
        verificaArquivo(arquivo);
        InputStream leitorByte = null;
        ObjectInputStream leitorObjeto = null;

        try {
            leitorByte = new FileInputStream(arquivo);
            leitorObjeto = new ObjectInputStream(leitorByte);

            ListaMotoristas motoristas = (ListaMotoristas) leitorObjeto.readObject();
            if (motoristas.getSize() <= 0) {
                System.out.println("Arquivo de motoristas Vazio!");
            } else {
                popularListaMotoristas(motoristas);
                System.out.println("Arquivo de motoristas Carregado!");
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

    public static void salvarMotorista(ListaMotoristas listamotoristas) {
        verificaArquivo(arquivo);
        OutputStream escritorByte = null;
        ObjectOutputStream escritorObjeto = null;
        try {
            escritorByte = new FileOutputStream(arquivo);
            escritorObjeto = new ObjectOutputStream(escritorByte);
            // salva o objeto
            escritorObjeto.writeObject(listamotoristas);
            escritorObjeto.flush();
            //System.out.println(listamotoristas);
            System.out.println("Arquivo de motoristas Atualizado!");
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
