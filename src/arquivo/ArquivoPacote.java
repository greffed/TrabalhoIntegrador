package arquivo;

import beans.Pacote;
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



public class ArquivoPacote {

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

	public List<Pacote> lerConteudoArquivo() {
		InputStream leitorByte = null;
		InputStreamReader leitorCaracter = null;
		BufferedReader leitorPalavras = null;

		List<Pacote> listaPacotes = new ArrayList<Pacote>();

		try {
			leitorByte = new FileInputStream("conteudo/novaPasta/ListaDePacotes.txt");
			leitorCaracter = new InputStreamReader(leitorByte);
			leitorPalavras = new BufferedReader(leitorCaracter);
			String linha = leitorPalavras.readLine();

			while(linha != null) {
				String[] valores = linha.split("\\|");

				if(valores.length == 2) { 
					System.out.println(linha);
					Pacote pacote = new Pacote();
					pacote.setNomeRemetente(valores[0]);
					pacote.setEndRemetente(valores[1]);
					pacote.setNomeDestinatario(valores[2]);
					//pacote.setDataDeposito(valores[3]);
					//pacote.setPeso(valores[4];
					//pacote.setCodLocalizador[5];
					linha = leitorPalavras.readLine();
					listaPacotes.add(pacote);
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
		return listaPacotes;
	}

	public void escreverConteudoArquivo(List<Pacote> lista) {
		OutputStream escritorByte = null;
		OutputStreamWriter escritorCaracter = null;
		BufferedWriter escritorPalavras = null;

		try {
			escritorByte = new FileOutputStream("conteudo/novaPasta/ListaDePacotes.txt", false);
			escritorCaracter = new OutputStreamWriter(escritorByte);
			escritorPalavras = new BufferedWriter(escritorCaracter);

			for (Object object : lista) {
				Pacote pacote = (Pacote) object;
				escritorPalavras.write(pacote.getNomeRemetente() + "|" + pacote.getEndRemetente() + "|" + pacote.getNomeDestinatario()
									//+ "|" + pacote.getDataDeposito() + "|" + pacote.getPeso() + "|" + pacote.getCodLocalizador()
			);
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

