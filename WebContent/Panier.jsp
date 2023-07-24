<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
		 <body> 
				 <div id="main_container"> 
				 <div id="header">  
		      		 <div id="logo"> <a href="DemoProduct"><img src="images/footer_logo.png" alt="" width="200" height="55" style="margin-left: 334px;margin-top: 45px;"/></a> </div>  
		     	</div> 
		   <div id="main_content"> 
		     <div id="menu_tab"> 
		       <div class="left_menu_corner"></div> 
		   	<ul class="menu"> 
				 <li><h3  class="nav1"> ${Welcome } ${nom }</h3></li> 
				 <li><a href="DemoProduct" class="nav4"> ${Product}</a></li>  
				  <li><a href="DemoPanier" class="nav4"> ${Panier }</a></li>
				 <li><a href="DemoCommande" class="nav4"> Commande</a></li>
			 	<li> <a href="DemoPanier?Language=en_US">US</a></li> 
				<li><a href="DemoPanier?Language=fr_FR">fr</a></li> 
				<li><a href="DemoSignUp" class="nav4"> ${Deconnexion}</a></li> 
			</ul> 
		       <div class="right_menu_corner"></div> 
		      </div> 
		      <div class="center_content" style="float: none;display: block;margin: auto;"> 
		       <div class="center_title_bar">${Panier }</div> 
		       <div class="prod_box"> 
		         <div class="prod_box_big"> 
		         <div class="top_prod_box_big"></div> 
		         <div class="center_prod_box_big"> 
		           <div class="contact_form"> 
		          <c:forEach items="${Produit}" var="produit">
		        	   <div class="form_row"> 
			             <h4 style="margin-bottom: -37px;"><strong>${produit.designation} Prix:  ${produit.prix} </strong></H4> 
			           </div> 
		   			</c:forEach> 
		            <div class="form_row"> 
		             <h3 class="contact"><strong> ${Have } ${size}  ${itmes} </strong></h3> 
		          </div> 
		          
		           <div class="form_row"> 
		             <a href= "DemoProduct"><strong>${Order }</strong></a> 
		           </div> 
		           <div class="form_row"> 
		             <a href= "DemoCommande?save=yes"><strong>${Save } </strong></a> 
		           </div> 
		       </div> 
		       <div class="bottom_prod_box_big"></div> 
		     </div> 
		     </div> 
		  </div> 
		  <div>  </div> </div> </div> 
		  <div class="footer" > 
		   <div class="left_footer"> <img src="images/footer_logo.png" alt="" width="170" height="49"/> </div> 
		   <div class="center_footer">${Fotter }<br /></div> 
		   <div class="right_footer"> <img src="images/payment.gif" alt="" /> </div> 
		 </div> 
		
		</body> 
	</html> 	