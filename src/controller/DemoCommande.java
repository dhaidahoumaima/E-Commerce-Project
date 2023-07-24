package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Article;
import DAO.DAO_Commande;
import Model.Articles;
import Model.Client;
import Model.LigneCommande;

import java.util.*;
import java.text.*;

/**
 * Servlet implementation class DemoLocale
 */
public class DemoCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession s;
	Client cos;
	ArrayList<Articles>l;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResourceBundle b;
		s= request.getSession(false);
		cos=(Client) s.getAttribute("Customer");
		l=(ArrayList<Articles>) s.getAttribute("Shopping");
		if(request.getParameter("save")!=null){
			l=(ArrayList<Articles>) s.getAttribute("Shopping");
			DAO_Commande d = new DAO_Commande();
			for (Articles articles : l) {
				LigneCommande c= new LigneCommande(articles.getCodeArticle(), articles.getDesignation(),7);
				d.add(c,cos.getId());
			}
			 
			l.removeAll(l);
		}
		
		for (Articles product : l) {
			System.out.println(product.getPrix());
		}
		try {
			DAO_Commande d = new DAO_Commande();
			DAO_Article d1 = new DAO_Article();
			ArrayList<LigneCommande> cn= d.getList(cos.getId());
			ArrayList<Articles> p=new ArrayList<Articles>();
			for (LigneCommande articles : cn) {
				p.add(d1.getNm(articles.getCodeArticle()));
			}
			
			request.setAttribute("Commande", p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(request.getParameter("Language")!=null){
			String[] planguage= request.getParameter("Language").split("_");
			String lang= planguage[0];
			String con= planguage[1];
			Locale lo= new Locale(lang,con);
			request.setAttribute("contry", lo.getDisplayCountry());
			b= ResourceBundle.getBundle("resources.content",lo);
		}else{
			Locale lo= request.getLocale();
			request.setAttribute("contry", lo.getCountry());
			b= ResourceBundle.getBundle("resources.content",lo);
		}
		request.setAttribute("Title", b.getString("Title"));
		request.setAttribute("Welcome", b.getString("Welcome"));
		request.setAttribute("Panier", b.getString("Panier"));
		request.setAttribute("itmes", b.getString("itmes"));
		request.setAttribute("Save", b.getString("Save"));
		request.setAttribute("Panier", b.getString("Panier"));
		request.setAttribute("Fotter", b.getString("Fotter")); 
		request.setAttribute("Product", b.getString("Product")); 
		request.setAttribute("Deconnexion", b.getString("Deconnexion"));
		request.setAttribute("Have", b.getString("Have")); 
		request.setAttribute("Order", b.getString("Order"));
		request.setAttribute("CommandeY", b.getString("CommandeY"));
		request.setAttribute("Produit", l);
		request.setAttribute("nom", cos.getNom()); 
		request.getRequestDispatcher("Commande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		s= request.getSession(false);
		cos=(Client) s.getAttribute("Customer");

		doGet(request, response);
	}

}
