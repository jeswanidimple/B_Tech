<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fill Payment Details</title>
</head>
<body>
<form action="RunServlet" method="POST">

	Card Number : 
	<input type="text" name="cardnum" size="20" maxlength="16"
	onkeypress="return event.charCode > 47 && event.charCode < 58;">
	<br><br>
	City : 
	<input type="text" name="city" size="20">
	<br><br>
	Amount : 
	<input type="text" name="amount" size="20"
	onkeypress="return event.charCode > 47 && event.charCode < 58;">
	<br><br>
	<button type="submit" value="Submit">Submit</button>

</form>


</body>
</html>