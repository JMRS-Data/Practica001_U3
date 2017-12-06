<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comprobant Form</title>
</head>
<body>
	<form action="ComprobantController">
	
		<label>Date:</label><br/>
		<input type="text" name="date" value="${comprobant.date}"/><br/>
		<label>Request:</label><br/>
		<input type="text" name="idrequest" value="${comprobant.idRequest}"/><br/>
		<label>Total:</label><br/>
		<input type="text" name="total" value="${comprobant.total}"/><br/>
		<input type="submit" name="btn_save" value="Save"/>
	</form>
</body>
</html>