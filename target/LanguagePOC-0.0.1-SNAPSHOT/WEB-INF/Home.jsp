<html>
<head>
	<title>Amadeus Langauage Localise</title>
	<link rel="shortcut icon" href="images/favicon1.png" type="image/png">
	<link rel="stylesheet" type="text/css" href="css/awastyle.css">
</head>	
<body onload="startTime(); errormsg();">
	<div class="container">

		<div class="header">
			<h2 id="heading">Amadeus Language Localise</h2>
			<h6 id="clock"></h6>
		</div>

		<div class="main">

			<div id="login_form">
				<form onsubmit="validate(event) && this.submit()" action="" method="POST">
				<br>
				<h2>Login Form</h2>
				<br><br>
				<b>Username : <input type="text" name="username" id="username" required/><br><br>
				Password :    <input type="password" name="pass"id="pass" required/><br><br>
							  <input type="submit" name="login" id="login" value="Login" />
							  <input type="checkbox" name="remember" value="remember">Remember Me!<br>
				</b>
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