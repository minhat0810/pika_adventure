package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSql {
		public static Connection getConnection() {
			Connection conn = null;
			try {
				conn = (Connection) DriverManager.getConnection("jdbc:sqlserver://LAPTOP-VQ8FO7NU\\SQLEXPRESS:1433;" + "user=sa;password=123;databaseName=Do_an_N1_HKII_PikaGame;encrypt=false");
				if(conn != null) System.out.println("Ket noi thanh cong");
			} catch (Exception e) {
				// TODO: handle exception
				 System.err.println(e.toString());
			}
			
			return conn;
		}
	
	public static void main(String[] args) {
		ConnectSql c = new ConnectSql();
	}
}
