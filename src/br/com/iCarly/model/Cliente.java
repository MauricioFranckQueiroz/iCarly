package br.com.iCarly.model;

public class Cliente extends Usuario
{
	private double credito;

	public Cliente(long id, String cpf, String nome, String email, String senha, double credito) {
		super(id, cpf, nome, email, senha);
		this.credito = credito;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}
	
}