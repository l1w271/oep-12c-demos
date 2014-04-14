<!DOCTYPE HTML>
<html>
<head>
<title>Healthy Snacks Company</title>
<style type="text/css">

#div_main {width:1050px;height:356px; padding:1px;border:2px solid #666666;}
#div1 {width:800px;height:350px; float:left; padding:1px;border:2px solid #ff0000;}
#div0 {width:235px;height:350px; float:right; padding:1px;border:2px solid #666666;}

#div_shop {width:1050px;height:356px; padding:1px;border:2px solid #666666;}
#div2 {width:800px;height:350px; float:left; padding:1px;border:2px solid #000000;}
#div4 {width:235px;height:350px; float:right; padding:1px;border:2px solid #2868C7;}
</style>

<script src="http://ajax.googleapis.com/ajax/libs/dojo/1.5/dojo/dojo.xd.js" type="text/javascript"></script>
<script type="text/javascript">
    
	dojo.require("dojo.io.script");
	dojo.require("dojox.cometd");
	dojo.require("dojox.cometd.callbackPollTransport");
	
	dojo.addOnLoad(function() {
	    dojox.cometd.init("/ShoppingWeb/cometd", {});
        dojox.cometd.subscribe("/shopping/offer", onEvent); 
        dojox.cometd.subscribe("/shopping/customer", onEvent); 
        // publish the login to OEP to prep the cache
        var customer = document.getElementById("uname").innerHTML ; 
        dojox.cometd.publish("/shopping/login", {"customerID": customer});   	        
	});
  
function onEvent(event)
  {
     var ch = event.channel;
     if (ch == "/shopping/offer") handleOffer(event); 
     if (ch == "/shopping/customer") showCustomer(event);      
  }

function handleOffer(obj){ 
    var session = document.getElementById("usession").innerHTML ;
	
	if (session == obj.data.sessionID){    
	    var prod = obj.data.productID ;
	    var name = obj.data.productName ;
	    var price = obj.data.price ;
	    var imgSource = obj.data.imgSource ; 
	    createProduct(prod,name,price,imgSource);
	}
}

function showCustomer(obj){ 
            //var msg = document.getElementById("msg").innerHTML ;
            alert(obj.data.loyaltyStatus);
	    var customerID = obj.data.customerID ;
            var firstName = obj.data.firstName ;
            var lastName = obj.data.lastName ;
            var loyaltyStatus = obj.data.loyaltyStatus ;
            
	    //var name = obj.data.productName ;
	    //var price = obj.data.price ;
	    //createProduct(prod,name,price,imgSource);
            msg = "Welcome " + firstName + " " + lastName + "! Thanks for being a " + loyaltyStatus + " customer."  
            document.getElementById("msg").innerHTML = msg ;
}

function createProduct(prod,name,price,imgSource){
	
	//var img = document.createElement('img');
	var img = new Image();
	img.id=prod;
	img.src="images/" + imgSource ; 
	img.title=name + " - $" + price ; 
	//img.draggable="true";
	//img.ondragstart="drag(event)";
	//alert(img.id);
	document.getElementById('div4').appendChild(img);
        document.getElementById(prod).addEventListener('dragstart', function(event) {
        event.dataTransfer.setData('text/plain', prod);});
	
	
	products[prod]={"name":name,"price":price};
	
	var px=products[prod];
	//alert(prod + ': ' + px.name + ' - ' + px.price );
}

function publishAddToCart(product,price){ 
 var customer = document.getElementById("uname").innerHTML ;
 var sessionID = document.getElementById("usession").innerHTML ;	
 dojox.cometd.publish("/shopping/cart", {"sessionID": sessionID, "customerID": customer , "product": product, "category": "grocery", "quantity": 1, "price": price});
	  
}  

var total = 0.00; 

//var products = [ 
 //             {num : 1, app:'helloworld',message:'message'},
 //             {num : 2, app:'helloagain',message:'another message'} 
//          ]

var products = {
		  p155 : { 
		    name : "Kind Nuts and Sea Salt",
		    price : 11.99
		  },
		  p156 : { 
			name : "Kashi Almond Flax",
			price : 9.99
		  },
		  p157 : { 
			name : "Kelloggs Fiber Plus",
			price : 8.49
		  },
		  p158 : { 
			name : "Balance Mocha Chip",
			price : 17.19
		  },
		  p159 : { 
			name : "ThinkThin Crunch",
			price : 6.32
		  },
		  p160 : { 
			name : "Kashi TLC",
			price : 7.59
		  },
		  p161 : {
		    name : "Enjoy Life Very Berry Crunch",
		    price : 10.15
		  }
		};



function allowDrop(ev)
{
ev.preventDefault();
}

function drag(ev)
{
ev.dataTransfer.setData("Text", ev.target.id);
//ev.dataTransfer.setData("Text",ev.target.id);
}

function drop(ev)
{
ev.preventDefault();
var data=ev.dataTransfer.getData("Text");
//alert("Data: " + data );
var prid = event.dataTransfer.getData('Text') ;
var product=products[event.dataTransfer.getData('Text')];

//alert("Added: " + product.name + " = " + product.price );

var dt = document.createElement('dt');
var dd = document.createElement('dd');

dt.id = product.name+"-name";
dd.id = product.name+"-price";
dt.textContent = product.name;
dd.textContent = product.price;
	
// add elements to the DOM
document.getElementById('cartlist').appendChild(dt);
document.getElementById('cartlist').appendChild(dd);

total += product.price ;
total = Math.round(total*100)/100 ;

document.getElementById("p1").innerHTML= total.toFixed(2);

//this.innerHTML += '<p>' + product.price + '&nbsp;' + product.name + '</p>';
ev.target.appendChild(document.getElementById(data));

publishAddToCart(product.name,product.price);
}
</script>
</head>
<body>
<img alt="Healthy Snacks Co." src="images/HealthySnacksCompany2.png">
<table>
<tr>
<td>Welcome <%= request.getRemoteUser() %>!</td>
<td width="20%">Shopping Cart Total $</td>
<td width="40%"><h3 id="p1">0.00</h3></td>
<td width="10%"></td>
<td> <a href="logout.jsp">Logout</a></td>
</tr>
<tr>
<td><h2 id="msg"></h2></td> 
</tr>
</table>
<form method="get" action="next.jsp">
<!-- 
<input id="CheckpromoBtn" type="button" value="Check for Promotions" onClick="javaScript:createProduct('p200','Skinny Cow Dreamy Clusters',12.99);">
 -->
<!-- <input id="CheckoutBtn" type="button" value="Checkout" onClick="javaScript:alert('OK!');"> -->
</form>
<div id="div_main"> 
<div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<div id="div0"><dl id="cartlist"></dl></div>
</div>
<br>
<table width="1050" border="" cellpadding="5"> 
<tr>
<td width="800">Drag the products you would like to purchase into the red box above:</td>
<td>Special Offers</td>
</tr>
</table>
<div id="div_shop">
<div id="div2" ondrop="drop(event)" ondragover="allowDrop(event)">
<img id="p156" src="images/156.jpg" draggable="true" ondragstart="drag(event)" title="Kashi Almond Flax: $9.99" >
<img id="p155" src="images/155.jpg" draggable="true" ondragstart="drag(event)" title="Kind Nuts and Sea Salt: $5.99">
<img id="p157" src="images/157.jpg" draggable="true" ondragstart="drag(event)" title="Kelloggs Fiber Plus: $8.49">
<img id="p158" src="images/158.jpg" draggable="true" ondragstart="drag(event)" title="Balance Mocha Chip: $17.19">
<img id="p159" src="images/159.jpg" draggable="true" ondragstart="drag(event)" title="Think Thin Crunch: $6.32">
<img id="p160" src="images/160.jpg" draggable="true" ondragstart="drag(event)" title="Kashi TLC Pumpkin Spice Flax: $7.59">
<img id="p161" src="images/161.jpg" draggable="true" ondragstart="drag(event)" title="Enjoy Life Very Berry Crunch: $10.15">
</div>
<div id="div4"></div>
</div>

<h5 id="uname"><%= request.getRemoteUser() %></h5>
<h5 id="usession"><%= session.getId() %></h5> 
</body>

</html>
