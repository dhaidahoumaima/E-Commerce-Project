package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.*;
import Model.*;
import java.util.*;

/**
 * Servlet implementation class DemoLocale
 */
public class DemoDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession s;
	Client cos;
	ArrayList<Articles>l;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoDetail() {
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

		ResourceBundle b;
		if(request.getParameter("Language")!=null){
			String[] planguage= request.getParameter("Language").split("_");
			String lang= planguage[0];
			String con= planguage[1];
			Locale l= new Locale(lang,con);
			request.setAttribute("contry", l.getDisplayCountry());
			b= ResourceBundle.getBundle("resources.content",l);
		}else{
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
		request.setAttribute("nom", cos.getNom()); 
		Articles pro=null;
		DAO_Article dn = new DAO_Article();
		//choix
		try {
			if(request.getParameter("id_detail")!=null){
				String id= request.getParameter("id_detail");
				pro = dn.getNm(id);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pro.getCategories());
		request.setAttribute("cat", pro.getCategories());
		request.setAttribute("produit", pro);
		request.getRequestDispatcher("Detail.jsp").forward(request, response);
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
