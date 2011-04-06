import java.sql.*; 

public class Connect1 { 

	public static void main(String[] args) {
		Connection connection; 
	
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL","root","WIT2012"); 
			System.out.println("Connection succeed!"); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}