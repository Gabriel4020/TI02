package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Carro {
	private int id;
	private String modelo;
	private float preco;
	private int quantidade;
	private LocalDateTime dataFabricacao;

	public Carro() {
		id = -1;
		modelo = "";
		preco = 0.00F;
		quantidade = 0;
		dataFabricacao = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

	}

	public Carro(int id, String modelo, float preco, int quantidade, LocalDateTime fabricacao) {
		setId(id);
		setModelo(modelo);
		setPreco(preco);
		setQuantidade(quantidade);
		setDataFabricacao(fabricacao);
	}

	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDateTime getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDateTime dataFabricacao) {
		// Pega a Data Atual
		LocalDateTime agora = LocalDateTime.now();
		// Garante que a data de fabricação não pode ser futura
		if (agora.compareTo(dataFabricacao) >= 0)
			this.dataFabricacao = dataFabricacao;
	}

	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa ser
	 * exibido na forma de String.
	 */
	@Override
	public String toString() {
		return "Carro: " + modelo + "   Preço: R$" + preco + "   Quantidade.: " + quantidade + "   Fabricação: "
				+ dataFabricacao;
	}

	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Carro) obj).getID());
	}
}
