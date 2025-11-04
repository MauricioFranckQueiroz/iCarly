package br.com.iCarly.model;

import java.time.LocalDateTime;

public class Compra {
	private long idCompra;
	private Cliente cliente;
	private Vendedor vendedor;
	private Veiculo veiculo;
	private LocalDateTime data;
	
	public Compra(long idCompra, Cliente cliente, Vendedor vendedor, Veiculo veiculo, LocalDateTime data) {
		super();
		this.idCompra = idCompra;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.veiculo = veiculo;
		this.data = data;
	}
	
	public long getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
