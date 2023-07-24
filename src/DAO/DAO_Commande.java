package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Commandes;
import Model.LigneCommande;

public class DAO_Commande extends DAO<LigneCommande>{
	 public DAO_Commande() {   
	 }
	public void add(LigneCommande element,int nom) {
		Connection c=DAO.micro_projet();
		Statement s,s1;
		try {
			s = c.createStatement();
			s1 = c.createStatement();
			String query= "INSERT INTO commandes VALUES(null,'"+nom+"',CURDATE())";
			String query1= "INSERT INTO lignecommande VALUES(null,'"+element.getCodeArticle()+"','"+element.getQteCde()+"')";
	        s.executeUpdate(query);	
	        s1.executeUpdate(query1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<LigneCommande> getList() throws Exception {
		Connection c=DAO.micro_projet();
		ArrayList<LigneCommande> cat = new ArrayList<LigneCommande>();
		Statement s= c.createStatement();
		String query= "SELECT * FROM lignecommande";
        ResultSet rs=s.executeQuery(query);	
        while (rs.next())
        {
          int NumCommnde = rs.getInt("NumCommnde");
          String CodeArticle = rs.getString("CodeArticle");
          int QteCde = rs.getInt("QteCde");
          cat.add(new LigneCommande(NumCommnde,CodeArticle,QteCde));
        }
		return cat;
	}

	public ArrayList<LigneCommande> getList( int id) throws Exception {
		Connection c=DAO.micro_projet();
		ArrayList<LigneCommande> cat = new ArrayList<LigneCommande>();
		Statement s= c.createStatement();
		String query= "SELECT * FROM lignecommande,commandes WHERE `lignecommande`.`NumCommnde`=`commandes`.`NumCommande` and CodeClient="+id;
        ResultSet rs=s.executeQuery(query);	
        while (rs.next())
        {
          int NumCommnde = rs.getInt("NumCommnde");
          String CodeArticle = rs.getString("CodeArticle");
          int QteCde = rs.getInt("QteCde");
          cat.add(new LigneCommande(NumCommnde,CodeArticle,QteCde));
        }
		return cat;
	}
	@Override
	public LigneCommande getId(int id) throws Exception {
		Connection c=DAO.micro_projet();
		LigneCommande cat =null;
		Statement s= c.createStatement();
		String query= "SELECT * FROM lignecommande WHERE CodeClient="+id;
        ResultSet rs=s.executeQuery(query);	
        while (rs.next())
        {
          int NumCommnde = rs.getInt("NumCommnde");
          String CodeArticle = rs.getString("CodeArticle");
          int QteCde = rs.getInt("QteCde");
          cat=new LigneCommande(NumCommnde,CodeArticle,QteCde);
        }
		return cat;
	}
	@Override
	public void add(LigneCommande element) {
		// TODO Auto-generated method stub
		
	}

	
	 
}
