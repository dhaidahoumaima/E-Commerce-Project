<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
			 <title>${Title }</title> 
				 <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" /> 
				 <link rel="stylesheet" type="text/css" href="style/style.css" /> 
				 <script type="text/javascript" src="js/boxOver.js"></script> 
				 </head> 
				 <body> 
				 <div id="main_container"> 
				 <div id="header">  
		      		 <div id="logo"> <a href="DemoProduct"><img src="images/footer_logo.png" alt="" width="200" height="55" style="margin-left: 334px;margin-top: 45px;"/></a> </div>  
		     	</div> 
				  <div id="main_content"> 
				   <div id="menu_tab"> 
				     <div class="left_menu_corner"></div> 
				    <ul class="menu"> 
				     <li><h3  class="nav1">${Welcome } ${nom }</h3></li>
				     <li><a href="DemoProduct" class="nav4"> ${Product}</a></li>  
				    	 <li><a href="DemoPanier" class="nav4"> ${Panier }</a></li>
				    	 <li><a href="DemoCommande" class="nav4"> Commande</a></li>
				      <li> <a href="DemoProduct?Language=en_US">US</a></li> 
					  <li><a href="DemoProduct?Language=fr_FR">fr</a></li>  
					  <li><a href="DemoSignUp" class="nav4"> ${Deconnexion}</a></li> 
				  </ul> 
				   <div class="right_menu_corner"></div> 
				   </div> 
				 <div class="center_content" style="float: none;margin: 0 auto;"> 
				   <div class="center_title_bar">${Our_Products }</div> 
				
					   <div class="prod_box"> 
					  <div class="top_prod_box"></div> 
					   <div class="center_prod_box"> 
					  <div class="product_title"><c:out value="${produit.designation}" /> </div> 
					   <div class="product_img"><a href="details.html"><img style=" height: 126px;width: 158px;" src="productt/${produit.photo}"/> </a></div> 
					  </div> 
					  <div class="bottom_prod_box"></div> 
					  <form action="DemoProduct" method="post"> 
					    <input type="hidden" name="id" value="${produit.designation}" /> 
					   	<div class="prod_details_tab"> <input style="background:url('images/cart.gif') 100% 0px no-repeat;margin-top: 3px; margin-left: 74px;width: 20px;" type="submit"  /> </div>
					  </form> 
					  </div> 
					  <div class="prod_box" style="width: 360px;"> 
					   <div class="center_prod_box" style="width: 360px;background: none;    background-color: #f7f3f3;border: 1px #f7f3f3 solid;border-radius: 7px;"> 
					  <div class="product_title" style="width: 360px;">
					  		<label style="color: blue;font-size: 20px;font-family: monospace;">Designation: </label> <label>${produit.designation}</label></br>
					  		<label style="color: blue;font-size: 20px;font-family: monospace;">Categorie:</label>	 <label>${cat}</label></br>
					  		<label style="color: blue;font-size: 20px;font-family: monospace;">Prix:</label>		 <label>${produit.prix} $</label></br>
					  		<label style="color: blue;font-size: 20px;font-family: monospace;">Stock:</label>		 <label>${produit.stock}</label></br>
					  </div>
					  </div> 
			</div> 
				  </div> 
				  <div class="footer"> 
				  <div class="left_footer"> <img src="images/footer_logo.png" alt="" width="170" height="49"/> </div> 
				  <div class="center_footer">${Fotter }<br /></div> 
				  <div class="right_footer"> <img src="images/payment.gif" alt="" /> </div> 
				  </div> 
				 
				 </body> 
				 </html>