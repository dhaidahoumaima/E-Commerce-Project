package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public abstract  class DAO<T> {
	private static Connection con;
	
	public static Connection micro_projet(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_projet","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public abstract void add(T element) ;
	public abstract ArrayList<T> getList() throws Exception;
	public abstract T getId(int id) throws Exception;
}
