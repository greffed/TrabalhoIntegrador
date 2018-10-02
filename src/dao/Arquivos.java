/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.ArquivoMotorista.*;
import static dao.ArquivoVeiculo.*;
import static control.MotoristaControl.*;
import static control.VeiculoControl.*;
import java.io.File;


/**
 *
 * @author Marcos Oliveira
 */
public class Arquivos {
    public static void salvarDadosTXT() {
        salvarMotorista(getListaMotorista());
        salvarVeiculo(getListaVeiculo());
    }

    public static void carregarDadosTXT() {
        carregarMotorista();
        carregarVeiculo();
    }
    public static void verificaArquivo(String arquivo){
        File file = new File(arquivo);
        if (file.exists()){
            System.out.println("ARQUIVO: "+arquivo+" EXISTE");
        } else {
            try{
                file.createNewFile();
            }catch(Exception e){
                System.out.println("Impossivel Criar Arquivo");
            }
        }
    }
}
