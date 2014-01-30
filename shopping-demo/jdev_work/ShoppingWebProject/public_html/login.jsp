<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Healthy Snacks Company (Login)</title>
  </head>
  <body bgcolor="#ffffff"> 
  
  <img alt="Healthy Snacks Co." src="images/HealthySnacksCompany2.png">
  <p>
  <form method="POST" action="j_security_check">
  <table border=0 cellpadding="5" width="30%">
    <tr>
      <td>Username:</td>
      <td><input type="text" name="j_username"></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="j_password"></td>
    </tr>
    <tr>
    <td></td>
    <td colspan=2 align=left><input type=submit value="Submit"></td>
    </tr>
  </table>
  </form>
 
  </body>
</html>