package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_Client;
import Model.Client;

import java.util.*;
import java.text.*;

/**
 * Servlet implementation class DemoLocale
 */
public class DemoCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String u="";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoCreate() {
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
		request.setAttribute("Adress", b.getString("Adress"));
		request.setAttribute("Name", b.getString("Name"));
		request.setAttribute("u",u);
		request.getRequestDispatcher("CreateAccouant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO_Client cn= new DAO_Client();
		Client c= new Client(0, request.getParameter("email") ,request.getParameter("name") , request.getParameter("add1") ,Integer.parseInt(request.getParameter("add2") ),request.getParameter("add3") , request.getParameter("tel") ,request.getParameter("password1") );
		try {
			cn.add(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u="You have a new account now, Welcome";
		doGet(request, response);
	}

}
