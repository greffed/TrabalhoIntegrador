package dao;

import static control.MotoristaControl.popularListaMotoristas;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
import model.ListaMotoristas;
import model.Motorista;

public class ArquivoMotorista {

    static String arquivo = "conteudo/ListaMotoristas.bin";

    public static void lerConteudoArquivo() {
        InputStream leitorByte = null;
        ObjectInputStream leitorObjeto = null;
        
        try {
            leitorByte = new FileInputStream(arquivo);
            leitorObjeto = new ObjectInputStream(leitorByte);
            
           ListaMotoristas motoristas = (ListaMotoristas) leitorObjeto.readObject();
            System.out.println(motoristas.checkListaMotoristas());
            /*ListaMotoristas motoristas = null;
            motoristas = (ListaMotoristas) leitorObjeto.readObject();           
            popularListaMotoristas(motoristas);*/

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } catch(ClassNotFoundException e){
            System.err.println(e);
        }
                finally {
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

    public static void escreverConteudoArquivo(ListaMotoristas listamotoristas) {
        OutputStream escritorByte = null;
        ObjectOutputStream escritorObjeto = null;
        try {
            escritorByte = new FileOutputStream(arquivo);
            escritorObjeto = new ObjectOutputStream(escritorByte);
            // salva o objeto
            escritorObjeto.writeObject(listamotoristas);
            escritorObjeto.flush();
            System.out.println("Arquivo Atualizado!");
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
