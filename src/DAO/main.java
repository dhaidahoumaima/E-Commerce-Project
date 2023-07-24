package DAO;

import java.util.ArrayList;

import Model.Articles;
import Model.Categories;
import Model.Client;
import Model.LigneCommande;

public class main {
	public static void main (String []args) throws Exception {
		/*DAO_Commande d = new DAO_Commande();
		ArrayList<LigneCommande> cn= d.getList();
		
		for (LigneCommande categories : cn) {
			 System.out.print(categories.getNumCommnde());
			 System.out.print("         "+categories.getCodeArticle());
			 System.out.print("         "+categories.getQteCde());
		}
		//LigneCommande c= new LigneCommande(3, 8, 7);
		//d.add(c,9);
		
		
		/*
		DAO_Article d = new DAO_Article();
		
		Articles cn= d.getNm("azzza");
		System.out.println(cn.getPrix());
		/*for (Articles categories : cn) {
			 System.out.print(categories.getDesignation());
			 System.out.print("         "+categories.getCategories());
			 System.out.print("         "+categories.getCodeArticle());
			 System.out.print("       "+categories.getStock());	
		
		}
		Articles categories=d.getId(4);
		 System.out.print(categories.getDesination());
		 System.out.print("         "+categories.getCategories());
		 System.out.print("         "+categories.getCodeArticle());
		 System.out.print("       "+categories.getStock());	*/
		/*DAO_Categories d = new DAO_Categories();
		ArrayList<Categories> cn= d.getList();
		for (Categories categories : cn) {
			 System.out.print(categories.getCat());
			 System.out.print("         "+categories.getRefCat());
		}
		DAO_Client d = new DAO_Client();
		Client categories= d.getC("sanaamkar@gmail.com", "1234");
			 System.out.print(categories.getId());
			 System.out.print("         "+categories.getNom());
			 /*Client element= new Client(12, "", "", "ddd", 4, "", "", "");
			 d.add(element);*/
		DAO_Article d = new DAO_Article();
		d.modifierStock("azzza");
	}
}
