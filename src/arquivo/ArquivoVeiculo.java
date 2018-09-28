package arquivo;

import beans.Veiculo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;



public class ArquivoVeiculo {

	public void criarArquivo(String nome) throws IOException {

		File pastaRaiz = new File("conteudo/");
		boolean pastaExiste = pastaRaiz.exists();
		System.out.println("Arquivo existe: " + pastaRaiz.exists());
		if(pastaExiste){
			File novaPasta = new File("conteudo/novaPasta/");
			if(novaPasta.exists()== false) {
				novaPasta.mkdir();
			}else {
				File novoArquivo = new File("conteudo/novaPasta/"+ nome +".txt");
				novoArquivo.createNewFile();
			}
			System.out.println(novaPasta.getAbsolutePath());
		}
	}

	public List<Veiculo> lerConteudoArquivo() {
		InputStream leitorByte = null;
		InputStreamReader leitorCaracter = null;
		BufferedReader leitorPalavras = null;

		List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

		try {
			leitorByte = new FileInputStream("conteudo/novaPasta/ListaDeVeiculos.txt");
			leitorCaracter = new InputStreamReader(leitorByte);
			leitorPalavras = new BufferedReader(leitorCaracter);
			String linha = leitorPalavras.readLine();

			while(linha != null) {
				String[] valores = linha.split("\\|");

				if(valores.length == 2) { 
					System.out.println(linha);
					Veiculo veiculo = new Veiculo();
					veiculo.setMarca(valores[0]);
					veiculo.setModelo(valores[1]);
					veiculo.setPlaca(valores[2]);
					veiculo.setAno(valores[3]);
					linha = leitorPalavras.readLine();
					listaVeiculos.add(veiculo);
					System.out.println(linha);
				}
				linha = leitorPalavras.readLine();
			}

		}catch (FileNotFoundException e) {
			System.err.println(e);
		}catch (IOException e) {
			System.err.println(e);
		}finally {
			try {
				if(leitorByte != null) {
					leitorByte.close();
				}
				if(leitorCaracter != null) {
					leitorCaracter.close();
				}
				if(leitorPalavras != null) {
					leitorPalavras.close();
				}
			} catch(Exception e) {}
		}
		return listaVeiculos;
	}

	public void escreverConteudoArquivo(List<Veiculo> lista) {
		OutputStream escritorByte = null;
		OutputStreamWriter escritorCaracter = null;
		BufferedWriter escritorPalavras = null;

		try {
			escritorByte = new FileOutputStream("conteudo/novaPasta/ListaDeVeiculos.txt", false);
			escritorCaracter = new OutputStreamWriter(escritorByte);
			escritorPalavras = new BufferedWriter(escritorCaracter);

			for (Object object : lista) {
				Veiculo veiculo = (Veiculo) object;
				escritorPalavras.write(veiculo.getMarca() + "|" + veiculo.getModelo() + "|" + veiculo.getPlaca() + "|" + veiculo.getAno());
				escritorPalavras.newLine();
				escritorPalavras.flush();
			}
			
		}catch (FileNotFoundException e) {
			System.err.println(e);
		}catch (IOException e) {
			System.err.println(e);
		}finally {
			try {
				if(escritorPalavras != null) {
					escritorPalavras.close();
				}
				if(escritorCaracter != null) {
					escritorCaracter.close();
				}
				if(escritorByte != null) {
					escritorByte.close();
				}
			}
			catch(Exception e) {}
		}
	}
}

