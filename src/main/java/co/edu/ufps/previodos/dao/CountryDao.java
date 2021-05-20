package co.edu.ufps.previodos.dao;

import co.edu.ufps.previodos.util.ConexionPostgreSQL;

public class CountryDao {

	private ConexionPostgreSQL conexionPostgreSQL;
	
	private static final String INSERT_USUARIO_SQL = "INSERT INTO mnjgxshj (name, email birthdate,country,team) VALUES (?,?,?,?,?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM mnjgxshj WHERE id = ?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE mnjgxshj SET name = ?, email = ?, birthdate = ?,country = ?, team = ? WHERE id = ?;";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM mnjgxshj WHERE id = ?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM mnjgxshj;";
	
	
	
}
