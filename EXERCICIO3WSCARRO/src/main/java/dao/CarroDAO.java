package dao;

import model.Carro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO extends DAO {
	public CarroDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public boolean insert(Carro carro) {
		boolean status = false;
		try {
			String sql = "INSERT INTO carro (modelo, preco, quantidade, datafabricacao) " + "VALUES ('"
					+ carro.getModelo() + "', " + carro.getPreco() + ", " + carro.getQuantidade() + ", ?, ?);";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setTimestamp(1, Timestamp.valueOf(carro.getDataFabricacao()));
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public Carro get(int id) {
		Carro carro = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro WHERE id=" + id;
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				carro = new Carro(rs.getInt("id"), rs.getString("modelo"), (float) rs.getDouble("preco"),
						rs.getInt("quantidade"), rs.getTimestamp("datafabricacao").toLocalDateTime());
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carro;
	}

	public List<Carro> get() {
		return get("");
	}

	public List<Carro> getOrderByID() {
		return get("id");
	}

	public List<Carro> getOrderByModelo() {
		return get("modelo");
	}

	public List<Carro> getOrderByPreco() {
		return get("preco");
	}

	private List<Carro> get(String orderBy) {
		List<Carro> carros = new ArrayList<Carro>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Carro p = new Carro(rs.getInt("id"), rs.getString("modelo"), (float) rs.getDouble("preco"),
						rs.getInt("quantidade"), rs.getTimestamp("datafabricacao").toLocalDateTime());
				carros.add(p);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}

	public boolean update(Carro carro) {
		boolean status = false;
		try {
			String sql = "UPDATE carro SET modelo = '" + carro.getModelo() + "', " + "preco = " + carro.getPreco()
					+ ", " + "quantidade = " + carro.getQuantidade() + "," + "datafabricacao = ? WHERE id = "
					+ carro.getID();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setTimestamp(1, Timestamp.valueOf(carro.getDataFabricacao()));
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean delete(int id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM carro WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
}