package co.edu.ufps.previodos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionPostgreSQL {

	public Connection con;

	public Statement st = null;

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
	
	public ResultSet consultar(String sql) {
		try {
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public void cerrarConexcion() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
