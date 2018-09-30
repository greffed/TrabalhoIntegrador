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
import model.ListaMotoristas;
import model.Motorista;


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
}
