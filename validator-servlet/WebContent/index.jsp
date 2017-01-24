<!DOCTYPE html>
<meta charset="UTF-8">	
<html>
<head><title>First JSP</title></head>
<body>
<h2>Fraudulent Transaction Check page</h2>
<form action="RunServlet" method="post">
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
	<tr><td></td><td></td></tr>
	<tr>
		<td><input type="submit" value="Submit now" /></td>
		<td><input type="reset" value="Reset" /></td>
	</tr>
</table>
	
</form>
</body>
</html>