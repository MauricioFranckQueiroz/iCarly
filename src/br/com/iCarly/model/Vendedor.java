package br.com.iCarly.model;

public class Vendedor extends Usuario
{
	private double comissao;
	public Vendedor(long id, String cpf, String nome, String email, String senha, double comissao) {
		super(id, cpf, nome, email, senha);
		this.comissao = comissao;
	}
	public double getComissao() {
		return comissao;
	}
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
}