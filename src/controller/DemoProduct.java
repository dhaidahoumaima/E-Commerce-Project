package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Article;
import DAO.DAO_Categories;
import Model.Articles;
import Model.Categories;
import Model.Client;

import java.util.*;
import java.text.*;

/**
 * Servlet implementation class DemoLocale
 */
public class DemoProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession s;
	Client cos;
	ArrayList<Articles>l;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		s= request.getSession(false);
		cos=(Client) s.getAttribute("Customer");
		l=(ArrayList<Articles>) s.getAttribute("Shopping");
		
		int som=0;
		for (Articles product : l) {
			som+=product.getPrix();
		}
		ResourceBundle b;
	    /************ si l'utilisateur n'a pas choisi une lague
	     *********** je recupere la langue du systeme puis je remplis
	     * le bundle avec le dictionnaire correspond au langue choisi 
	     */
		if(request.getParameter("Language")!=null){
			String[] planguage= request.getParameter("Language").split("_");
			String lang= planguage[0];
			String con= planguage[1];
			Locale l= new Locale(lang,con);
			request.setAttribute("contry", l.getDisplayCountry());
			b= ResourceBundle.getBundle("resources.content",l);
		}
		/************ si l'utilisateur a  choisi une lague
	     *********** je remplis mon bundle avec le dictionnaire correspond au langue  choisi
	     */
		else{
			Locale l= request.getLocale();
			request.setAttribute("contry", l.getCountry());
			b= ResourceBundle.getBundle("resources.content",l);
		}
		request.setAttribute("Title", b.getString("Title"));
		request.setAttribute("Welcome", b.getString("Welcome"));
		request.setAttribute("Categories", b.getString("Categories"));
		request.setAttribute("itmes", b.getString("itmes"));
		request.setAttribute("Our_Products", b.getString("Our_Products"));
		request.setAttribute("Shopping", b.getString("Shopping"));
		request.setAttribute("Panier", b.getString("Panier"));
		request.setAttribute("Fotter", b.getString("Fotter")); 
		request.setAttribute("Product", b.getString("Product")); 
		request.setAttribute("Deconnexion", b.getString("Deconnexion")); 
		
		
		request.setAttribute("som", som); 
		request.setAttribute("nom", cos.getNom()); 
		request.setAttribute("size", l.size()); 
		
		ArrayList<Categories> listt ;
		try {
			DAO_Categories d = new DAO_Categories();
			listt = d.getList();
			request.setAttribute("listt", listt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Articles> pro=new ArrayList<Articles>() ;
		DAO_Article dn = new DAO_Article();
		//choix
		try {
			if(request.getParameter("id_cat")!=null){
				for (Articles articles : dn.getList()) {
					if(articles.getCategories().equals(request.getParameter("id_cat"))){
						pro.add(articles);
					}
				}
				
			}else{
				pro = dn.getList();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("Produit", pro);
		request.getRequestDispatcher("Product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")!=null){
			String id=request.getParameter("id");
			DAO_Article cn= new DAO_Article();
			Articles e;
			try {
				e = cn.getNm(id);
				l.add(e);
				cn.modifierStock(id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			doGet(request, response);
	}

}
