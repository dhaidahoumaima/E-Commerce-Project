package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Articles;
import Model.Client;

import java.util.*;
import java.text.*;

/**
 * Servlet implementation class DemoLocale
 */
public class DemoPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession s;
	Client cos;
	ArrayList<Articles>l;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoPanier() {
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
		for (Articles product : l) {
			System.out.println(product.getPrix());
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
		request.setAttribute("Produit", l);
		request.setAttribute("nom", cos.getNom()); 
		request.setAttribute("size", l.size()); 
		request.getRequestDispatcher("Panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
