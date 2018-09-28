package tela;

import beans.Veiculo;
import beans.Pacote;
import beans.Motorista;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Cadastro {
	
	public static List<Motorista> motoristas = new ArrayList<Motorista>();
	public static List<Veiculo> veiculos = new ArrayList<Veiculo>();
	public static List<Pacote> pacotes = new ArrayList<Pacote>();
	
	public static void main(String[] args) {
	String textoMenu = "1-Cadastrar Motorista \n"
					+"2-Alterar Motorista \n"
					+"3-Deletar Motorista \n"
					+"4-Cadastrar Veiculo \n"
					+"5-Alterar Veiculo \n"
					+"6-Deletar Veiculo \n"
					+"7-Cadastrar Pacote \n"
					+"8-Alterar Pacote \n"
					+"9-Deletar Pacote \n"
					+"10-Sair";

		while(true){
			String opcao = JOptionPane.showInputDialog(textoMenu);
			switch(opcao){
				case "1":
					cadastrarMotorista();
					break;
				case "2":
					alterarMotorista();
                                        break;
				case "3":
					deletarMotorista();
                                        break;
				case "4":
					cadastrarVeiculo();
					break;
				case "5":
					alterarVeiculo();
                                        break;
				case "6":
					deletarVeiculo();
                                        break;
				case "7":
					cadastrarPacote();
					break;
				case "8":
					alterarPacote();
                                        break;
				case "9":
					deletarPacote();
					break;
				case "10":
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
					break;
			}
		}
	}
	
	private static void cadastrarMotorista(){
		Motorista motorista = new Motorista();
		motorista.setNome(JOptionPane.showInputDialog("Digite o nome do motorista:").toUpperCase());
		//motorista.setDataNasc(Integer.parseInt(JOptionPane.showInputDialog("")));
		motorista.setNumCnh(JOptionPane.showInputDialog("Digite o número da CNH:").toUpperCase());
		motorista.setTipoCnh(JOptionPane.showInputDialog("Digite o tipo da CNH:").toUpperCase());
		Motorista.motoristas.add(motorista);
		//escreverConteudoArquivo();
	}
        
	public static Motorista buscarPorNome(String nomeMotorista) {
		for(Motorista m : Motorista.motoristas){
			if(nomeMotorista.equals(m.getNome())){
				return m;
			}
		}
		return null;
	}
	
	private static void deletarMotorista(){
		String nomeMotorista = JOptionPane.showInputDialog("Digite o nome do motorista que deseja alterar:").toUpperCase();
		buscarPorNome(nomeMotorista);
		
		if(Motorista.motoristas == null){
			JOptionPane.showMessageDialog(null, "Motorista (" + nomeMotorista + ") não localizado!");
		}else{
			boolean achou = false;
			int posicao = 0;
			for(Motorista m : Motorista.motoristas){
				if(nomeMotorista == m.getNome()){
					achou = true;
					break;
				}
				posicao++;
			}
			if(achou) Motorista.motoristas.remove(posicao);
		}	
	}
	
	private static void alterarMotorista(){
		String nomeMotorista = JOptionPane.showInputDialog("Digite o nome do motorista que deseja alterar:").toUpperCase();
		buscarPorNome(nomeMotorista);
		
		if(Motorista.motoristas == null){
			JOptionPane.showMessageDialog(null, "Motorista (" + nomeMotorista + ") n�o localizado!");
		}else{
			deletarMotorista();//????
			Motorista motorista = new Motorista();
			motorista.setNome(JOptionPane.showInputDialog("Digite o nome do motorista:").toUpperCase());
			//motorista.setDataNasc(Integer.parseInt(JOptionPane.showInputDialog("")));
			motorista.setNumCnh(JOptionPane.showInputDialog("Digite o n�mero da CNH:").toUpperCase());
			motorista.setTipoCnh(JOptionPane.showInputDialog("Digite o tipo da CNH:").toUpperCase());
			motorista.alterarM(motorista);//????
		}
	}
	
	public void alterarM(Object obj) {
		boolean achou = false;
		int posicao = 0;
		for(Motorista m : Motorista.motoristas){
			if(((Motorista) obj).getNome() == m.getNome()){
				achou = true;
				break;
			}
			posicao++;
		}
		if(achou) Motorista.motoristas.set(posicao, (Motorista) obj);
	}
		
	private static void cadastrarVeiculo(){
		Veiculo veiculo = new Veiculo();
		veiculo.setMarca(JOptionPane.showInputDialog("Digite a marca do ve�culo:").toUpperCase());
		veiculo.setModelo(JOptionPane.showInputDialog("Digite o modelo do ve�culo:").toUpperCase());
		veiculo.setPlaca(JOptionPane.showInputDialog("Digite a placa do ve�culo:").toUpperCase());
		veiculo.setAno(JOptionPane.showInputDialog("Digite o ano do ve�culo:"));
		Veiculo.veiculos.add(veiculo);
		//escreverConteudoArquivo();
	}
	public static Veiculo buscarPorPlaca(String placaVeiculo) {
		for(Veiculo v : Veiculo.veiculos){
			if(placaVeiculo.equals(v.getPlaca())){
				return v;
			}
		}
		return null;
	}
	
	private static void deletarVeiculo(){
		String placaVeiculo = JOptionPane.showInputDialog("Digite a placa do veiculo que deseja excluir:").toUpperCase();
		buscarPorPlaca(placaVeiculo);
		
		if(Veiculo.veiculos == null){
			JOptionPane.showMessageDialog(null, "Veiculo (" + placaVeiculo + ") n�o localizado!");
		}else{
			boolean achou = false;
			int posicao = 0;
			for(Veiculo v : Veiculo.veiculos){
				if(placaVeiculo == v.getPlaca()){
					achou = true;
					break;
				}
				posicao++;
			}
			if(achou) Veiculo.veiculos.remove(posicao);
		}	
	}
	
	private static void alterarVeiculo(){
		String placaVeiculo = JOptionPane.showInputDialog("Digite a placa do veiculo que deseja alterar:").toUpperCase();
		buscarPorPlaca(placaVeiculo);
		
		if(Veiculo.veiculos == null){
			JOptionPane.showMessageDialog(null, "Veiculo (" + placaVeiculo + ") n�o localizado!");
		}else{
			deletarVeiculo();//????
			Veiculo veiculo = new Veiculo();
			veiculo.setMarca(JOptionPane.showInputDialog("Digite a marca do ve�culo:").toUpperCase());
			veiculo.setModelo(JOptionPane.showInputDialog("Digite o modelo do ve�culo:").toUpperCase());
			veiculo.setPlaca(JOptionPane.showInputDialog("Digite a placa do ve�culo:").toUpperCase());
			veiculo.setAno(JOptionPane.showInputDialog("Digite o ano do ve�culo:"));
			veiculo.alterarV(veiculo);//???
		}
	}
	
	public void alterarV(Object obj) {
		boolean achou = false;
		int posicao = 0;
		for(Veiculo v : Veiculo.veiculos){
			if(((Veiculo) obj).getPlaca() == v.getPlaca()){
				achou = true;
				break;
			}
			posicao++;
		}
		if(achou) Veiculo.veiculos.set(posicao, (Veiculo) obj);
	}
		
	private static void cadastrarPacote(){
		Pacote pacote = new Pacote();
		pacote.setNomeRemetente(JOptionPane.showInputDialog("Digite o nome do remetente:").toUpperCase());
		pacote.setEndRemetente(JOptionPane.showInputDialog("Digite o endere�o do remetente:").toUpperCase());
		pacote.setNomeDestinatario(JOptionPane.showInputDialog("Digite o nome do destinat�rio:").toUpperCase());
		//pacote.setDataDeposito((JOptionPane.showInputDialog("").toUpperCase());
		pacote.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso do pacote:")));
		pacote.setCodLocalizador(Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo localizador:")));
		Pacote.pacotes.add(pacote);
		//escreverConteudoArquivo();
	}
	public static Pacote buscarPorCodigo(int codigoL) {
		for(Pacote p : Pacote.pacotes){
			if(codigoL == p.getCodLocalizador()){
				return p;
			}
		}
		return null;
	}
	
	private static void deletarPacote(){
		int codigoL = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do pacote que deseja excluir:").toUpperCase());
		buscarPorCodigo(codigoL);
		
		if(Pacote.pacotes == null){
			JOptionPane.showMessageDialog(null, "Pacote (" + codigoL + ") n�o localizado!");
		}else{
			boolean achou = false;
			int posicao = 0;
			for(Pacote p : Pacote.pacotes){
				if(codigoL == p.getCodLocalizador()){
					achou = true;
					break;
				}
				posicao++;
			}
			if(achou) Pacote.pacotes.remove(posicao);
		}	
	}
	
	private static void alterarPacote(){
		int codigoL = Integer.parseInt(JOptionPane.showInputDialog("Digite o nome do pacote que deseja excluir:").toUpperCase());
		buscarPorCodigo(codigoL);
		
		if(Pacote.pacotes == null){
			JOptionPane.showMessageDialog(null, "Pacote (" + codigoL + ") n�o localizado!");
		}else{
			deletarPacote();//????
			Pacote pacote = new Pacote();
			pacote.setNomeRemetente(JOptionPane.showInputDialog("Digite o nome do remetente:").toUpperCase());
			pacote.setEndRemetente(JOptionPane.showInputDialog("Digite o endere�o do remetente:").toUpperCase());
			pacote.setNomeDestinatario(JOptionPane.showInputDialog("Digite o nome do destinat�rio:").toUpperCase());
			//pacote.setDataDeposito((JOptionPane.showInputDialog("").toUpperCase());
			pacote.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso do pacote:")));
			pacote.setCodLocalizador(Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo localizador:")));
			pacote.alterarP(pacote);
		}
	}
	
	public void alterarP(Object obj) {
		boolean achou = false;
		int posicao = 0;
		for(Pacote p : Pacote.pacotes){
			if(((Pacote) obj).getCodLocalizador() == p.getCodLocalizador()){
				achou = true;
				break;
			}
			posicao++;
		}
		if(achou) Pacote.pacotes.set(posicao, (Pacote) obj);
	}
}









