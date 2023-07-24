package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Articles;
import Model.Categories;

public class DAO_Categories extends DAO<Categories>{
	
	public DAO_Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Categories element) {
	}

	@Override
	public ArrayList<Categories> getList() throws Exception {
		Connection c=DAO.micro_projet();
		ArrayList<Categories> cat = new ArrayList<Categories>();
		Statement s= c.createStatement();
		String query= "SELECT * FROM Categories";
        ResultSet rs=s.executeQuery(query);	
        while (rs.next())
        {
          int id = rs.getInt("RefCat");
          String name = rs.getString("Cat");
          cat.add(new Categories(id, name));
        }
       
		return cat;
	}

	@Override
	public Categories getId(int id) throws Exception {
		return null;
	}
	
	
}
