<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>

<script src="http://ajax.googleapis.com/ajax/libs/dojo/1.5/dojo/dojo.xd.js" type="text/javascript"></script>
<script language=javascript>
    
	dojo.require("dojo.io.script");
	dojo.require("dojox.cometd");
	dojo.require("dojox.cometd.callbackPollTransport");
	
	dojo.addOnLoad(function() {
	    dojox.cometd.init("/TestingInterfaceWeb/cometd", {});
        dojox.cometd.subscribe("/shopping/**", onEvent);  
        //dojox.cometd.publish("/shopping/cart", {"product": "P456X"});   	        
	});
  
function onEvent(event)
  {
     var ch = event.channel;
    // if (ch == "/shopping/targetprospect") targetProspect(event); 
    // if (ch == "/shopping/payment") paymentAlert(event);      
  }

function addToCart(side){
    
	
 dojox.cometd.publish("/shopping/cart", {"sessionID": "X123WERWER443", "customerID": "C1006", "product": "P123X", "category": "electronics", "quantity": 1, "price": 49.99});
	  
}  
  
function moveToRightOrLeft(side){
    
	if(side==1){
		alert('Product has been added to the cart!');
	}
	  
}  

function log(msg)
  {
      var now = new Date();
      now = now.getHours() + ":" + now.getMinutes()
                           + ":" + now.getSeconds();
      var la = document.getElementById('logarea');
      if (!la) return;
      la.value = la.value + "[" + now + "] " + msg + '\n';
  }

</script>

</head>
<body>
<!-- ***********************************************************  -->
<!-- Define the page header                                       -->
<!-- ***********************************************************  -->
<table cellspacing="2" cellpadding="2" border="0" width="80%" height="20">
  <tr>
  <td>
  <img src="Oracle_3d_v2_small.jpg"></img>
  </td>
  </tr>
  
  <tr>
  <td width="70%">
  <font size=5 color="#ab2a25">Shopping</font>
  </td>
  <td align="right">  
  </td>
  </tr>
  
</table>
<table cellspacing="2" cellpadding="5" border="0" width="40%"><tr><td>
<form method="get" action="http://localhost:9002/paymentAggregationAdmin">
<input name="btnRight" type="button" id="btnRight" value="Add to Cart" onClick="javaScript:addToCart(1);">
</form>
</table>
</body>
</html>