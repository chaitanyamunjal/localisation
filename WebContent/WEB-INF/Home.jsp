<html>
<head>
	<title>Amadeus Langauage Localisation</title>
	<link rel="shortcut icon" href="images/favicon1.png" type="image/png">
	<link rel="stylesheet" type="text/css" href="css/awastyle.css">
</head>	
<body onload="startTime(); errormsg();">
	<div class="container">

		<div class="header">
			
			<h2 id="L1">Amadeus Language Localisation</h2>
			
			<h6 id="clock"></h6>
		
		</div>

		<div class="main">

			<div id="login_form">
				<form onsubmit="validate(event) && this.submit()" action="" method="POST">
				<br>
				
				<br><br>
				
				<label for="name" id="L2">Name</label>
				
				<input type="text" name="name" id="name" required/><br><br>
				
				<label for="username" id="L3">XXXX</label>
				
				<input type="text" name="username" id="username" required/><br><br>
				
				<label for="email" id="L4">Email</label>
				
				<input type="text" name="email" id="email" required/><br><br>
				
				<label for="mobile" id="L5">Mobile</label>
				
				<input type="number" name="mobile" id="mobile" required/><br><br>
				
				<label for="password" id="L6">Password</label>  
				
				<input type="password" name="pass"id="pass" required/><br><br>
				
				
				<label for="airlines" id="L7" style="margin-left:-44px">XXXX</label>
				<select name="airlines">
				  <option value="volvo">British Airways</option>
				  <option value="saab">Air France</option>
				  <option value="opel">Lufthansa</option>
				  <option value="audi">Emirates</option>
				</select>
				<br><br>
				
				<label for="gender" id="L8" style="margin-left:-44px">XXXX</label>  
				
				<input type="radio" id="L9" name="gender" value="Male">Male</input>
				
				<input type="radio" id="L10" name="gender" value="Female">Female</input><br><br>
				
				<input type="submit" id="L11" name="login" value="XXXX" /><br><br>
				
				<input type="checkbox" id="L12" name="remember" value="XXXX">XXXX</input><br>
				
				
				</form>
			</div>	
			
		</div>
	</div>
		



<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script>

	flag = "${flag}";
	console.log("flag is "+ flag);
</script>

<script type="text/javascript">
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('clock').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}


function validate(e){

	e.preventDefault();
	var username = document.getElementById('username').value;
	var password = document.getElementById('pass').value;

	action.value = "login";
	
	return true;
}
		
	

	function errormsg(){
		
		if(flag == "5"){
			alert('The Username Already Exists. Please try again.');
		}
		else if(flag == "4")
			{
			alert('Account created successfully');
			
			}
	
	}

	
</script>
</body>
</html>