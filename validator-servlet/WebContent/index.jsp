<!DOCTYPE html>
<meta charset="UTF-8">	
<html>
<head><title>First JSP</title></head>
<script type="text/javascript">

 function SendDate() {
	 var date = new Date();
	 var time = date.getTime();
    document.getElementById('time').value = time; 
} 

</script>
<h2>Fraudulent Transaction Check page</h2>
<form action="RunServlet" method="post" onsubmit="SendDate()">
<table>
	<tr>
		<td>Card Number</td>
		<td><input type="text"  name="cardnum"	maxlength="16"
		onkeypress="return event.charCode > 47 && event.charCode < 58;"> </td>		
	</tr>
	<tr>
		<td>Amount</td>
		<td><input type="text"  name="amount"
		onkeypress="return event.charCode > 47 && event.charCode < 58;"> </td>
	</tr>
	<tr>
		<td>City</td>
		<td><input type="text"  name="city"/></td>
	</tr>
	<tr>
		<td>Year</td>
		<td><input type="text"  name="year"/></td>
	</tr>
	<tr>
	<td><input type="hidden" name="time" id="time"/></td>
	</tr>
	<tr><br></tr>
	<tr>
		<td><input type="submit" value="Submit now" /></td>
		<td><input type="reset" value="Reset" /></td>
	</tr>
</table>
<!-- 	<div id="FRate">
	 <h1> Fraud Rate is </h1>
	
	</div> -->
</form>
</body>
</html>