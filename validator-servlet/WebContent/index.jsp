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
		<td><b>Name</b></td>
		<td><input type="text"  name="name" ></td>		
	</tr>
	<tr>
		<td><b>CVV / PIN</b></td>
		<td><input type="text"  name="pin"	maxlength="4"
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
		<td><b>Card Validity</b></td>
		<td>
		<select  name="expmon" id="expmon" >
		<option value="">MM</option>
<option value="1">01</option>
<option value="2">02</option>
<option value="3">03</option>
<option value="4">04</option>
<option value="5">05</option>
<option value="6">06</option>
<option value="7">07</option>
<option value="8">08</option>
<option value="9">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select></td>

<td>
		<select  name="expyear" id="expyear" >
		<option value="">yyyy</option>
<option value="2017">2017</option>
<option value="2018">2018</option>
<option value="2019">2019</option>
<option value="2020">2020</option>
<option value="2021">2021</option>
<option value="2022">2022</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
<option value="2025">2025</option>
<option value="2026">2026</option>
<option value="2027">2027</option>
<option value="2028">2028</option>
<option value="2029">2029</option>
<option value="2030">2030</option>

</select></td>
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