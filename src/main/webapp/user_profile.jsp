<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
  HttpSession userSession = request.getSession();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Select your next step</title>
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
                    </p>

                    <p>
                        <a href='main_menu.jsp'>Back</a>
                    </p>

		</td>
		</tr>
	</table>
</body>
</html>