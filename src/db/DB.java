package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class DB {

	private static Connection conn = null;;
	
	//Conectar o banco de dados
	public static Connection getConnection(){
		if(conn == null) {
			try {
				
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				
				conn = DriverManager.getConnection(url, props);
			
				return conn;
				
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
			
		}
		return conn;
	}
	
	//fechar o Connection
	public static void closeConnection() {
		
		if(conn != null) {
			
			try {
				conn.close();
			} catch (SQLException e) {
			
				throw new DbException(e.getMessage());
			}
			
		}
		
	}
	
	//abrindo e lendo o arquivo db.properties com as info de conecção do banco de dados
	public static Properties loadProperties() {
		
		try(FileInputStream fs = new FileInputStream("db.properties")){
			
			Properties prop = new Properties();
			
			prop.load(fs);
			
			return prop;
			
		}
		catch(IOException e){
			
			throw new DbException(e.getMessage());
			
		}
	}
	
	//fechar o Statement
	public static void closeStatement(Statement st) {
		
		try {
			
			st.close();
			
		} catch (SQLException e) {
			
			throw new DbException(e.getMessage());
			
		}
	}
	
	//Fechar o ResultSet
	public static void closeResultSet(ResultSet rs) {
		
		try {
			
			rs.close();
			
		} catch (SQLException e) {
			
			throw new DbException(e.getMessage());
		}
	}
	

}
