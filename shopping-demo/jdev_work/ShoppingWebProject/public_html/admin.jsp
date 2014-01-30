<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Special Offer Administration</title>
</head>
<body>
<!-- ***********************************************************  -->
<!-- Define the page header                                       -->
<!-- ***********************************************************  -->
<table cellspacing="2" cellpadding="2" border="0" width="80%">
  <tr>
  <td>
  <img src="images/HealthySnacksCompany2.png"></img>
  </td>
  </tr>
  
  <tr>
  <td>
  <font size=5 color="#ab2a25">Special Offer Administration</font>
  </td>
  <td align="right">  
  </td>
  </tr>
  
</table>

<form method="get" action="http://localhost:9002/shoppingAdmin">

<table cellspacing="2" cellpadding="3" border="0" width="60%">

<tr>
<td>Query ID:</td><td><input name="queryId" size="25" type="text" value="Q203" /></td>
</tr>
<tr>
<td>Product ID:</td><td><input name="productID" size="25" type="text" value="p203"/></td>
</tr>
<tr>
<td>Product Name:</td><td><input name="productName" size="45" type="text" value="Think Thin Brownie Crunch" /></td>
</tr>
<tr>
<td>Price:</td><td><input name="price" size="25" type="text" value="4.39" /></td>
</tr>
<tr>
<td>Image Source:</td><td><input name="imgSource" size="25" type="text" value="203.jpg"/></td>
</tr>

<tr><td>
Comparison:
</td><td> 
<select name="compare" width="70" size="1">
<option value="=">=</option>
<option value="<"><</option>
<option value=">">></option>
</select></td></tr>

<tr><td>
Loyalty Status: </td><td> 
<select name="loyaltyStatus" width="120" size="1">
<option value="0">Green</option>
<option value="1">Silver</option>
<option value="2">Gold</option>
<option value="3">Platinum</option>
</select>
</td></tr>
<tr>
<td></td>
<td>
<input name="OfferQuery" type="submit" value="Submit" />
</td></tr>

</table>
</form>
</body>
</html>