package br.com.iCarly.model;

public abstract class Veiculo 
{
	private long id;
	private String placa;
	private String cor;
	private double preco;
	private String modelo;
	private int ano;
	private double kmRodados;
	
	public Veiculo(long id, String placa, String cor, double preco, String modelo, int ano, double kmRodados) 
	{
		super();
		this.id = id;
		this.placa = placa;
		this.cor = cor;
		this.preco = preco;
		this.modelo = modelo;
		this.ano = ano;
		this.kmRodados = kmRodados;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getKmRodados() {
		return kmRodados;
	}

	public void setKmRodados(double kmRodados) {
		this.kmRodados = kmRodados;
	}
}
