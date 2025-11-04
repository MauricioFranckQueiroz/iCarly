package br.com.iCarly.model;

public class Carro extends Veiculo{
	private boolean ar;
	private int numPortas;
	
	public Carro(long id, String placa, String modelo, String cor, double preco, int ano, double kmRodados, boolean ar,int numPortas) {
		super(id, placa, modelo, preco, cor, ano, kmRodados);
		this.ar = ar;
		this.numPortas = numPortas;
	}

	public boolean getAr() {
		return ar;
	}

	public void setAr(boolean ar) {
		this.ar = ar;
	}

	public int getNumPortas() {
		return numPortas;
	}

	public void setNumPortas(int numPortas) {
		this.numPortas = numPortas;
	}
}
