package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Client;

public class DAO_Client extends DAO<Client>{

	@Override
	public void add(Client element) {
		Connection c=DAO.micro_projet();
		Statement s;
		try {
			s = c.createStatement();
			String query= "INSERT INTO client VALUES(null,'"+element.getEmail()+"','"+element.getNom()+"','"+element.getAdress()+"',"+element.getCodePostal()+",'"+element.getVille()+"','"+element.getTel()+"','"+element.getMotPass()+"')";
	        s.executeUpdate(query);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Client> getList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getId(int id) throws Exception {
		Client cat = null;
		Connection c=DAO.micro_projet();
		Statement s= c.createStatement();
		String query= "SELECT * FROM client WHERE Id="+id;
        ResultSet rs=s.executeQuery(query);	
        while (rs.next())
        {
          int Id_Custome = rs.getInt("Id");
          String Email = rs.getString("Email");
          String Name = rs.getString("Nom");
          String Adress = rs.getString("Adress");
          int CodePosstal = rs.getInt("CodePosstal");
          String Ville = rs.getString("Ville");
          String Tel = rs.getString("Tel");
          String Password = rs.getString("MotPasse");
          
          cat = new Client(Id_Custome,Email,Name,Adress,CodePosstal,Ville,Tel, Password);
        }
       
		return cat;
	}
	
	public Client getC(String email,String pass) throws Exception {
		Client cat = null;
		Connection c=DAO.micro_projet();
		Statement s= c.createStatement();
		String query= "SELECT * FROM client WHERE Email='"+email+"' AND MotPasse='"+pass+"'";
        ResultSet rs=s.executeQuery(query);	
        while (rs.next())
        {
          int Id_Custome = rs.getInt("Id");
          String Email = rs.getString("Email");
          String Name = rs.getString("Nom");
          String Adress = rs.getString("Adress");
          int CodePosstal = rs.getInt("CodePosstal");
          String Ville = rs.getString("Ville");
          String Tel = rs.getString("Tel");
          String Password = rs.getString("MotPasse");
          
          cat = new Client(Id_Custome,Email,Name,Adress,CodePosstal,Ville,Tel, Password);
        }
       
		return cat;
	}
	
	

}
