package co.edu.ufps.previodos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConexionPostgreSQL {

	public Connection con;

	private PreparedStatement preparedStatement;

	public ConexionPostgreSQL() {
		
		String host = "queenie.db.elephantsql.com";
		String db = "mnjgxshj";
		String url = "jdbc:postgresql://"+host+":5432/"+db;
		String usuario = "mnjgxshj";
		String pass = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url,usuario,pass);
			
			boolean valid = con.isValid(50000);
			System.out.println(valid ? "TEST OK" : "TEST FAIL");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void cerrarConexcion() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public PreparedStatement setPreparedStatement (String sql) throws SQLException{
		
		this.preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		return this.preparedStatement;
	}
	
}
