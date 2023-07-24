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
				    	 <li><h3 class="nav1">${Welcome } ${nom }</h3></li>
				    	 <li><a href="DemoProduct" class="nav4"> ${Product}</a></li>  
				    	 <li><a href="DemoPanier" class="nav4"> ${Panier }</a></li>
				    	 <li><a href="DemoCommande" class="nav4"> Commande</a></li>
				      	<li> <a href="DemoProduct?Language=en_US">US</a></li> 
					  	<li><a href="DemoProduct?Language=fr_FR">fr</a></li> 
					  	<li><a href="DemoSignUp" class="nav4"> ${Deconnexion}</a></li> 
				  </ul> 
				   <div class="right_menu_corner"></div> 
				   </div> 
				  <div class="left_content"> 
				   <div class="title_box">${Categories }</div> 
				  <ul class="left_menu"> 
				  <c:forEach items="${listt}" var="cu">
				 	 <li class="odd"><a href="DemoProduct?id_cat=${cu.cat}">
				 	 	<c:out value="${cu.cat}" />
				 	 </a></li> 
				 </c:forEach> 
				
				  </ul>   
				   
				  </div> 
				 <div class="center_content"> 
				   <div class="center_title_bar">${Our_Products }</div> 
				<c:forEach items="${Produit}" var="produit">
					   <div class="prod_box"> 
					  <div class="top_prod_box"></div> 
					   <div class="center_prod_box"> 
					  <div class="product_title"><a href="details.html"><c:out value="${produit.designation}" /> </a></div> 
					   <div class="product_img"><a href="details.html"><img style=" height: 126px;width: 158px;" src="productt/${produit.photo}"/> </a></div> 
					   <div class="prod_price"><span class="reduce"><c:out value="${produit.prix}" /> $ </span></div> 
					  </div> 
					  <div class="bottom_prod_box"></div> 
					  <form action="DemoProduct" method="post"> 
					    <input type="hidden" name="id" value="${produit.designation}" /> 
					   <div class="prod_details_tab">  <input style="background:url('images/cart.gif') 100% 0px no-repeat;margin-top: 3px;float: left;width: 20px;" type=submit value="" /> 
					  </form> 
						 <a href="DemoDetail?id_detail=${produit.designation}" class="prod_details">details</a> </div> 
					  </div> 
				</c:forEach> 
				  </div> 
				  <div class="right_content"> 
			      <div class="shopping_cart"> 
			        <div class="cart_title">${Shopping}</div> 
			        <div class="cart_details">${size}  ${itmes} <br /> 
			           <span class="border_cart"></span> Total: <span class="price">${som }</span> </div> 
			         <div class="cart_icon"><a href="#" title="header=[Checkout] body=[&nbsp;] fade=[on]"><img src="images/shoppingcart.png" alt="" width="48" height="48" border="0" /></a></div> 
			       </div> 
				  </div> 
				  <div class="footer"> 
				  <div class="left_footer"> <img src="images/footer_logo.png" alt="" width="170" height="49"/> </div> 
				  <div class="center_footer">${Fotter }<br /></div> 
				  <div class="right_footer"> <img src="images/payment.gif" alt="" /> </div> 
				  </div> 
				 </div> 
				 </body> 
				 </html>