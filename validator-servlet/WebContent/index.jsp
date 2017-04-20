<!DOCTYPE html>
<meta charset="UTF-8">	
<html>
<head><title>index</title>
<link rel="stylesheet" href="main.css">
</head>
<script type="text/javascript">

 function SendDate() {
	 var date = new Date();
	 var time = date.getTime();
    document.getElementById('time').value = time; 
} 
 function LoadTest() {
    document.getElementById('time0').value = 0; 
} 
 
 function showfield(name){
	  if(name=='Other')
 {document.getElementById('div1').innerHTML='<input type="text" name="other" required/>';
	  document.getElementById("city").style.display = 'none';}
	 // else document.getElementById("city").innerHTML='';
	}

</script>
<body>
<div id="divout">
<h2 style="text-decoration: underline;">Fraudulent Transaction Check page</h2>

<form action="RunServlet" method="post" onsubmit="SendDate()">
<table>
<tr>
	<td><input type="hidden" name="time" id="time"/></td>
	</tr>

	<tr>
		<td><b>Card Number</b></td>
		<td><input type="text"  name="cardnum"	maxlength="16"
		onkeypress="return event.charCode > 47 && event.charCode < 58;" required> </td>		
	</tr>
	<tr>
		<td><b>Amount</b></td>
		<td><input type="text"  name="amount"
		onkeypress="return event.charCode > 47 && event.charCode < 58;" required> </td>
	</tr>
	<tr>
		<td><b>City</b></td>
		<td >
		<select  name="city" id="city" onchange="showfield(this.options[this.selectedIndex].value)">
		<option value="">Select</option>
<option value="Mumbai">Mumbai</option>
<option value="Pune">Pune</option>
<option value="Kolkata">Kolkata</option>
<option value="Chennai">Chennai</option>
<option value="Bangalore">Bangalore</option>
<option value="Other">Other</option>
</select>
		<div id="div1"></div>
		
		</td>
	</tr>
	<tr>
		<td><b>Year</b></td>
		<td><input type="text"  name="year"
		onkeypress="return event.charCode > 47 && event.charCode < 58;" required></td>
	</tr>
		<tr></tr>
	</table>
		<br>
		<input type="submit" value="  Submit now  " style="width:110px;height:30px;font-weight:bold;"/>
		
	
</form>

<h2> __________________________________________ </h2>
<br>
<form action="RunServlet" method="post" onsubmit="LoadTest()"> 
<input type="hidden" name="time" id="time0"/>
<input type="submit" value=" LoadTest " style="width:100px;height:30px;font-weight:bold;" />
</form>
</div>
</body>
</html>