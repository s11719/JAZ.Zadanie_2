<%@ page import="java.util.Map"%>
<%@ page import="model.*"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="javax.servlet.ServletContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
  HttpSession userSession = request.getSession();
  ServletContext context = request.getServletContext();
  HashMap<String, addressModel> addressMap = (HashMap<String, addressModel>) context.getAttribute("addressRepository");
  addressRepository addressRepository = new addressRepository(request);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Your profile page</title>
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Roboto Condensed:light">
    <style>
	      body {
    	    font-family: 'Roboto Condensed', serif;
        	font-size: 20px;
      		}
    </style>
</head>
<body>
	<table width="900px" align="center" style="margin-top:15px">
		<tr>
		<td>

                    <div><h1><%out.println(userSession.getAttribute("username"));%>, here are your credentials</h1></div>

                    <p>                        
                        <table cellpadding="5px">
                            <tr>
                            <td><b>Your username: </b><%out.println(userSession.getAttribute("username"));%></td>
                            </tr>
                            <td><b>Your e-mail: </b><%out.println(userSession.getAttribute("email"));%></td>
                            </tr>
                            <td><b>
                                <% if ((Boolean) userSession.getAttribute("premium")) {
                                    out.println("You are Premium user");
                                }
                                else {
                                    out.println("You aren't Premium user");
                                }%></b>
                            </td>
                        </table>
                            <div><h4><a href='address_form.jsp'>Add new address</a></h4></div>    
                    </p>
                   
                    <p>                                          
                        <% if (addressRepository.containsAddress(userSession.getAttribute("username") + "_registered")) {
                            addressModel address = addressMap.get(userSession.getAttribute("username") + "_registered");
                            out.println("<table cellpadding='5px'>");
                            out.println("<tr><td><h3>Your registered address</h3></td>");
                            out.println("<td><h6><a href='address_edit.jsp?addressType=registered'>Change address</a></h6></td>");
                            out.println("<td><h6><a href='RegisterAddress?addressId=" + userSession.getAttribute("username") + "_registered&action=delete'>Delete address</a></h6></td></tr></table>");
                            out.println("<table cellpadding='5px'>");                            
                            out.println("<tr><td><b>Voivodeship: </b>" + address.getVoivodeship() + "</td></tr>");
                            out.println("<tr><td><b>City: </b>" + address.getCity() + "</td></tr>");
                            out.println("<tr><td><b>Postal code: </b>" + address.getPostalCode() + "</td></tr>");
                            out.println("<tr><td><b>Street: </b>" + address.getStreet() + "</td></tr>");
                            out.println("<tr><td><b>House number: </b>" + address.getHouseNumber() + "</td></tr>");
                            out.println("</table>"); 
                        }%>                   
                    </p>
                    
                    <p>                                          
                        <% if (addressRepository.containsAddress(userSession.getAttribute("username") + "_mailing")) {
                            addressModel address = addressMap.get(userSession.getAttribute("username") + "_mailing");
                            out.println("<table cellpadding='5px'>");
                            out.println("<tr><td><h3>Your mailing address</h3></td>");
                            out.println("<td><h6><a href='address_edit.jsp?addressType=mailing'>Change address</a></h6></td>");
                            out.println("<td><h6><a href='RegisterAddress?addressId=" + userSession.getAttribute("username") + "_mailing&action=delete'>Delete address</a></h6></td></tr></table>");
                            out.println("<table cellpadding='5px'>");     
                            out.println("<tr><td><b>Voivodeship: </b>" + address.getVoivodeship() + "</td></tr>");
                            out.println("<tr><td><b>City: </b>" + address.getCity() + "</td></tr>");
                            out.println("<tr><td><b>Postal code: </b>" + address.getPostalCode() + "</td></tr>");
                            out.println("<tr><td><b>Street: </b>" + address.getStreet() + "</td></tr>");
                            out.println("<tr><td><b>House number: </b>" + address.getHouseNumber() + "</td></tr>");
                            out.println("</table>"); 
                        }%>                   
                    </p>
                    
                    <p>                                          
                        <% if (addressRepository.containsAddress(userSession.getAttribute("username") + "_work")) {
                            addressModel address = addressMap.get(userSession.getAttribute("username") + "_work");
                            out.println("<table cellpadding='5px'>");
                            out.println("<tr><td><h3>Your work address</h3></td>");
                            out.println("<td><h6><a href='address_edit.jsp?addressType=work'>Change address</a></h6></td>");
                            out.println("<td><h6><a href='RegisterAddress?addressId=" + userSession.getAttribute("username") + "_work&action=delete'>Delete address</a></h6></td></tr></table>");
                            out.println("<table cellpadding='5px'>");     
                            out.println("<tr><td><h3>Your work address</h3><h5><a href='RegisterAddress?addressId=" + userSession.getAttribute("username") + "_work&action=delete'>Delete address</a></h5></td></tr>");
                            out.println("<tr><td><b>Voivodeship: </b>" + address.getVoivodeship() + "</td></tr>");
                            out.println("<tr><td><b>City: </b>" + address.getCity() + "</td></tr>");
                            out.println("<tr><td><b>Postal code: </b>" + address.getPostalCode() + "</td></tr>");
                            out.println("<tr><td><b>Street: </b>" + address.getStreet() + "</td></tr>");
                            out.println("<tr><td><b>House number: </b>" + address.getHouseNumber() + "</td></tr>");
                            out.println("</table>"); 
                        }%>                   
                    </p>
                            
                    <p>
                        <a href='main_menu.jsp'>Back</a>
                    </p>

		</td>
		</tr>
	</table>
</body>
</html>