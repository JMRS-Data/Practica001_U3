<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comprobant List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			<form action="ComprobantController">
				<input type="submit" name="btn_new" value="New"/>
			</form>
			<a href="ComprobantReport">Imprimir Reporte</a>
			</th>
			<th>Id</th>
			<th>Date</th>
			<th>Request</th>
			<th>Total</th>
		</tr>
		<c:forEach var="comprobant" items="${comprobants}">
			<tr>
				<td>
					<form action="ComprobantController">
						<input type="hidden" name="id" value="${comprobant.id}"/>
						<input type="submit" name="btn_edit" value="Edit"/>
						<input type="submit" name="btn_delete" value="Delete"/>
					</form>
				</td>
			<td>${comprobant.id}</td>
			<td>${comprobant.date}</td>
			<td>${comprobant.idRequest}</td>
			<td>${comprobant.total}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>