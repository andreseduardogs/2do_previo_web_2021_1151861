package co.edu.ufps.previodos.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.ufps.previodos.beans.Country;
import co.edu.ufps.previodos.beans.Team;
import co.edu.ufps.previodos.util.ConexionPostgreSQL;

public class TeamDao {

private ConexionPostgreSQL conexionPostgreSQL;
	
	private static final String INSERT_USUARIO_SQL = "INSERT INTO mnjgxshj (name,country) VALUES (?,?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM mnjgxshj WHERE id = ?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE mnjgxshj SET name = ?,country = ? WHERE id = ?;";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM mnjgxshj WHERE id = ?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM mnjgxshj;";
	
	public TeamDao() {
		this.conexionPostgreSQL = new ConexionPostgreSQL();
	}
	
	public void insert(Team team, Country country) {
		
		try {
			PreparedStatement preparedStatement = conexionPostgreSQL.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, team.getName());
			preparedStatement.setString(2, country.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
