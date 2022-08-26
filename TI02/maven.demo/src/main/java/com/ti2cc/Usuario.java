package com.ti2cc;

public class Usuario {
	private int codigo;
	private String carro;
	private String placa;
	private char pago;
	
	public Usuario() {
		this.codigo = -1;
		this.carro = "";
		this.placa = "";
		this.pago = '*';
	}
	
	public Usuario(int codigo, String carro, String placa, char pago) {
		this.codigo = codigo;
		this.carro = carro;
		this.placa = placa;
		this.pago = pago;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCarro() {
		return carro;
	}

	public void setCarro(String carro) {
		this.carro = carro;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public char getPago() {
		return pago;
	}

	public void setPago(char pago) {
		this.pago = pago;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", carro=" + carro + ", placa=" + placa + ", pago=" + pago + "]";
	}	
}