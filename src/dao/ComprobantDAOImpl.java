package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Comprobant;

public class ComprobantDAOImpl implements ComprobantDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public ComprobantDAOImpl() {
		getConnection();
	}

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/comprobantdb", "postgres",
					"12345");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createComprobant(Comprobant comprobant) {
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("INSERT INTO public.comprobants(date, id_request, total) VALUES (?, ?, ?);");
				preparedStatement.setString(1, comprobant.getDate());
				preparedStatement.setString(2, comprobant.getIdRequest());
				preparedStatement.setString(3, comprobant.getTotal());
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Comprobant readComprobant(Long id) {
		Comprobant comprobant = null;
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("SELECT * FROM comprobants WHERE id=?;");
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					comprobant = new Comprobant(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comprobant;
	}

	@Override
	public List<Comprobant> readAllComprobants() {
		List<Comprobant> comprobants = new ArrayList<Comprobant>();
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("SELECT  * FROM comprobants;");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Comprobant comprobant = new Comprobant(resultSet.getLong("id"), resultSet.getString("date"),
							resultSet.getString("id_request"), resultSet.getString("total"));
					comprobants.add(comprobant);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comprobants;
	}

	@Override
	public void updateComprobant(Comprobant comprobant) {
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("UPDATE comprobants SET date=?, id_request=?, total=? WHERE id=?;");
				preparedStatement.setString(1, comprobant.getDate());
				preparedStatement.setString(2, comprobant.getIdRequest());
				preparedStatement.setString(3, comprobant.getTotal());
				preparedStatement.setLong(4, comprobant.getId());
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void deleteComprobant(Long id) {
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM comprobants WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
