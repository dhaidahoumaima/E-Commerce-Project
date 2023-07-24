package DAO;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import Model.Articles;

public class DAO_Article extends DAO<Articles>{
	 public DAO_Article() {   
	 }
	@Override
	public void add(Articles element) {	
	}
	@Override
	public  ArrayList<Articles> getList() throws Exception{
		Connection c=DAO.micro_projet();
		ArrayList<Articles> cat = new ArrayList<Articles>();
		java.sql.Statement s= c.createStatement();
		String query= "SELECT * FROM articles where Stock>0";
        java.sql.ResultSet rs=s.executeQuery(query);	
        while (rs.next())
        {
        	int Id_Product=rs.getInt("CodeArticle");
        	int Stock=rs.getInt("Stock");
        	String Name= rs.getString("Designation");
        	int Price=rs.getInt("Prix");
        	String Picture= rs.getString("Photo");
        	
        	java.sql.Statement s1= c.createStatement();
        	String query1= "SELECT * FROM categories WHERE RefCat="+rs.getInt("Categories");
            java.sql.ResultSet rs1=s1.executeQuery(query1);	
            String Name_Categories = null;
            while (rs1.next())
            {
            	Name_Categories = rs1.getString("Cat");
            }
            cat.add(new Articles(Id_Product, Stock, Name_Categories, Name, Price, Picture));
        	
        }
		return cat;
	}

	
	public Articles getId(int id) throws Exception{
		Connection c=DAO.micro_projet();
		Articles cat = null;
		java.sql.Statement s= c.createStatement();
		String query= "SELECT * FROM articles where CodeArticle="+id;
        java.sql.ResultSet rs=s.executeQuery(query);	
        while (rs.next())
        {
        	int Id_Product=rs.getInt("CodeArticle");
        	int Stock=rs.getInt("Stock");
        	String Name= rs.getString("Designation");
        	int Price=rs.getInt("Prix");
        	String Picture= rs.getString("Photo");
        	
        	java.sql.Statement s1= c.createStatement();
        	String query1= "SELECT * FROM categories WHERE RefCat="+rs.getInt("Categories");
            java.sql.ResultSet rs1=s1.executeQuery(query1);	
            String Name_Categories = null;
            while (rs1.next())
            {
            	Name_Categories = rs1.getString("Cat");
            }
            cat=new Articles(Id_Product, Stock, Name_Categories, Name, Price, Picture);
        	
        }
		return cat;
	}
	public Articles getNm(String id) throws Exception{
		Connection c=DAO.micro_projet();
		Articles cat = null;
		java.sql.Statement s= c.createStatement();
		String query= "SELECT * FROM articles where Designation='"+id+"'";
        java.sql.ResultSet rs=s.executeQuery(query);	
        while (rs.next())
        {
        	int Id_Product=rs.getInt("CodeArticle");
        	int Stock=rs.getInt("Stock");
        	String Name= rs.getString("Designation");
        	int Price=rs.getInt("Prix");
        	String Picture= rs.getString("Photo");
        	
        	java.sql.Statement s1= c.createStatement();
        	String query1= "SELECT * FROM categories WHERE RefCat="+rs.getInt("Categories");
            java.sql.ResultSet rs1=s1.executeQuery(query1);	
            String Name_Categories = null;
            while (rs1.next())
            {
            	Name_Categories = rs1.getString("Cat");
            }
            cat=new Articles(Id_Product, Stock, Name_Categories, Name, Price, Picture);
        	
        }
		return cat;
	}
	
	public void modifierStock(String id){
		String query="update articles set stock=stock-1 where  Designation='"+id+"'";
		Connection c=DAO.micro_projet();
		
		try {
			java.sql.Statement s= c.createStatement();
			s.executeUpdate(query);
			System.out.println("Bien modifier");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}
}
