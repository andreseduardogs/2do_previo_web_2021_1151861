package co.edu.ufps.previodos.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.previodos.beans.Country;
import co.edu.ufps.previodos.beans.Team;
import co.edu.ufps.previodos.util.ConexionPostgreSQL;

public class TeamDao {

private ConexionPostgreSQL conexionPostgreSQL;
	
	private static final String INSERT_TEAM_SQL = "INSERT INTO mnjgxshj (name,country) VALUES (?,?);";
	private static final String DELETE_TEAM_SQL = "DELETE FROM mnjgxshj WHERE id = ?;";
	private static final String UPDATE_TEAM_SQL = "UPDATE mnjgxshj SET name = ?,country = ? WHERE id = ?;";
	private static final String SELECT_TEAM_BY_ID = "SELECT * FROM mnjgxshj WHERE id = ?;";
	private static final String SELECT_ALL_TEAM = "SELECT * FROM mnjgxshj;";
	
	public TeamDao() {
		this.conexionPostgreSQL = new ConexionPostgreSQL();
	}
	
	public void insert(Team team, Country country) throws SQLException{
		
		try {
			PreparedStatement preparedStatement = conexionPostgreSQL.setPreparedStatement(INSERT_TEAM_SQL);
			preparedStatement.setString(1, team.getName());
			preparedStatement.setString(2, country.getName());
			conexionPostgreSQL.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void delete (int id) throws SQLException{
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conexionPostgreSQL.setPreparedStatement(DELETE_TEAM_SQL);
			preparedStatement.setInt(1,id);
			
			conexionPostgreSQL.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void update(Team team, Country country) throws SQLException{
			
			try {
				PreparedStatement preparedStatement = conexionPostgreSQL.setPreparedStatement(UPDATE_TEAM_SQL);
				preparedStatement.setString(1, team.getName());
				preparedStatement.setString(2, country.getName());
				preparedStatement.setInt(3,team.getId());
				conexionPostgreSQL.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	public List<Team> selectAll(){
		
		List<Team> teams = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conexionPostgreSQL.setPreparedStatement(SELECT_ALL_TEAM);
			
			ResultSet rs = conexionPostgreSQL.query();
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String country = rs.getString("country");
				teams.add(new Team(id,name,country));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teams;
	}
	
	
	public Team select(int id){
		
		Team team = null;
		
		try {
			PreparedStatement preparedStatement = conexionPostgreSQL.setPreparedStatement(SELECT_TEAM_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexionPostgreSQL.query();
			while(rs.next()) {
				
				String name = rs.getString("name");
				String country = rs.getString("country");
				team = new Team(id,name,country);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return team;
		}
	
	
	
}
