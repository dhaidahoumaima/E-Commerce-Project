<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
		       <div id="logo"> <a href="DemoSignUp"><img src="images/footer_logo.png" alt="" width="200" height="55" style="margin-left: 334px;margin-top: 45px;"/></a> </div>  
		     </div>  
		     <div id="main_content">  
		       <div id="menu_tab">  
		         <div class="left_menu_corner"></div>  
		         <ul class="menu">  
		           <li><a href="DemoCreate" class="nav4"> ${Create }</a></li>  
		           <li class="divider"></li>  
		           <li><a href="DemoSignUp" class="nav4">${Sign } </a></li>  
		         	 <li> <a href="DemoSignUp?Language=en_US">US</a></li> 
					<li><a href="DemoSignUp?Language=fr_FR">fr</a></li> 
		         </ul>  
		         <div class="right_menu_corner"></div>  
		       </div>  
		       <div class="center_content" style="float: none;display: block;margin: auto;">  
		         <form action="DemoSignUp" method="post">  
		         <div class="center_title_bar">${Sign } </div>  
		         <div class="prod_box">  
		           <div class="prod_box_big">  
		           <div class="top_prod_box_big"></div>  
		           <div class="center_prod_box_big">  
		             <div class="contact_form">  
		            <label ><strong>${u }</strong></label>  
		               <div class="form_row">  
		               <label class="contact"><strong>${Email } :</strong></label>  
		               <input type="email" name="email" class="contact_input" />  
		             </div>  
		             <div class="form_row">  
		               <label class="contact"><strong>${Password }:</strong></label>  
		               <input type="password" name="password" class="contact_input" />  
		             </div>  
		             <div class="form_row">   
		               <input type="submit" name="Sign_Up" class="contact_input" style="width: 100px;color: rgb(80, 137, 148);background-color: rgb(212, 223, 225);" value="${Sign }" />  
		            </div>  
		           </div>  
		           </form>  
		         </div>  
		         <div class="bottom_prod_box_big"></div>  
		       </div>  
		         <div > <img src="images/signup.jpg" alt="" style="width: 560px;height: 250px;border-radius: 20px;"/> </div>  
		       </div>  
		    </div>  
		    <div>   
		   <div class="footer" >  
		     <div class="left_footer"> <img src="images/footer_logo.png" alt="" width="170" height="49"/> </div>  
		     <div class="center_footer">${Fotter }<br /></div>  
		     <div class="right_footer"> <img src="images/payment.gif" alt="" /> </div>  
		   </div>  
		 </div>  
		 </body>  
		 </html>  	