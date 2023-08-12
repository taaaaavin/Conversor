package br.com.conversor.classes;

import javax.swing.JOptionPane;

public class ConversorDeMoedas {
	
	private int continuar = JOptionPane.NO_OPTION;
	private String escolha;
	private double valor;
	private String[] opcoes = 
		{"Escolha",
		"Real para Dólar", 
		"Dólar para Real", 
		"Real para Euro", 
		"Euro para Real", 
		"Real para Libra Esterlina", 
		"Libra Esterlina para Real", 
		"Real para Peso Argentino", 
		"Peso Argentino para Real", 
		"Real para Peso Chileno", 
		"Peso Chileno para Real"};
	
	public ConversorDeMoedas() {
		while(continuar != JOptionPane.YES_OPTION) {
			showInput();
			converter();
		}
		JOptionPane.showMessageDialog(null, "Saindo do Programa", "Saindo", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
	private void converter() {
		switch (escolha) {
			case "Real para Dólar": {
				converterParaEstrangeiro(this.valor, 4.90);
				break;
			}
			case "Dólar para Real": {
				converterParaReal(this.valor, 4.90);
				break;
			}
			case "Real para Euro": {
				converterParaEstrangeiro(this.valor, 5.36);
				break;
			}
			case "Euro para Real": {
				converterParaReal(this.valor, 5.36);
				break;
			}
			case "Real para Libra Esterlina": {
				converterParaEstrangeiro(this.valor, 6.22);
				break;
			}
			case "Libra Esterlina para Real": {
				converterParaReal(this.valor, 6.22);
				break;
			}
			case "Real para Peso Argentino": {
				converterParaEstrangeiro(this.valor, 0.017);
				break;
			}
			case "Peso Argentino para Real": {
				converterParaReal(this.valor, 0.017);
				break;
			}
			case "Real para Peso Chileno": {
				converterParaEstrangeiro(this.valor, 0.0057);
				break;
			}
			case "Peso Chileno para Real": {
				converterParaReal(this.valor, 0.0057);
				break;
			}
		
			default:
				JOptionPane.showMessageDialog(null, "Escolha uma forma válida");
			}	
	}
	
	private void converterParaEstrangeiro(double valor, double cotacao) {
		double moeda = (double) Math.round(valor * cotacao);
		mensagem(moeda);
	}
	
	private void converterParaReal(double valor, double cotacao) {
		double moeda = (double) Math.round(valor / cotacao);
		mensagem(moeda);
	}
	
	private void mensagem(double moeda) {
		JOptionPane.showMessageDialog(null, "A conversão deu " + moeda, "Resultado", JOptionPane.INFORMATION_MESSAGE);
		
		continuar = JOptionPane.showConfirmDialog(null, "Deseja sair?");
	}

	
	private void showInput() {
		try {
			escolha = JOptionPane.showInputDialog(null, "Escolha a forma de conversão", "Conversor de Moeda", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]).toString();
		} catch(NullPointerException ex) {
			System.exit(0);
		}
		
		if(escolha == "Escolha") {
			JOptionPane.showMessageDialog(null, "Escolha uma forma válida", "Forma Inválida", JOptionPane.OK_OPTION);
			System.exit(0);
		}
		
		String str = JOptionPane.showInputDialog(null, "Digite um valor");
		
		try {
			valor = Double.parseDouble(str);
		} catch(NumberFormatException | NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Digite um número válido");
		}
	}
}
