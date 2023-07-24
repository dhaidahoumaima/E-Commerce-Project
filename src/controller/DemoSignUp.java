package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Client;
import Model.Articles;
import Model.Client;

import java.util.*;
import java.text.*;

/**
 * Servlet implementation class DemoLocale
 */
public class DemoSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String u="";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		request.setAttribute("Create", b.getString("Create"));
		request.setAttribute("Sign", b.getString("Sign"));
		request.setAttribute("Email", b.getString("Email"));
		request.setAttribute("Fotter", b.getString("Fotter"));
		request.setAttribute("Password", b.getString("Password"));
		request.setAttribute("u", u);
		request.getRequestDispatcher("SignUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client Cnn = null;
		DAO_Client c = new DAO_Client();;
			try {
				Cnn=c.getC(request.getParameter("email"), request.getParameter("password"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(Cnn==null){
			u="Email or Password incorrect";
			doGet(request, response);
		}else{
			ArrayList<Articles> l=new ArrayList<Articles>();
			HttpSession se= request.getSession(true);
		    se.setAttribute("Customer", Cnn);
		    se.setAttribute("Shopping", l);
			request.getRequestDispatcher("/DemoProduct").forward(request, response);
		}
	
	}
}
