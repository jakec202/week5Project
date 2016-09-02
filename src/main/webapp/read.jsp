<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.beerzoo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>

		</div>
		<table class="table table-striped table-bordered" style="width: 75%"
			align="center">
			<tr>
				<th>Beer ID</th>
				<th>Beer Name</th>
				<th>Country of Origin</th>
				<th>Style</th>
				<th>ABV</th>
			</tr>
			
			<%DAOBeer.readFromDB(); %>
			
			<%
			Beer readToJSP = new Beer();
			
			for(int i = 0; i < DAOBeer.ourBeers.size(); i ++){
				readToJSP = DAOBeer.ourBeers.get(i);%>			
			<tr>
				<td><%= readToJSP.getBeerID() %></td>
				<td><%= readToJSP.getBeerName() %></td>
				<td><%= readToJSP.getCountryOfOrigin() %></td>
				<td><%= readToJSP.getStyle() %></td>
				<td><%= readToJSP.getAbv() %></td>
			</tr>
			<% }DAOBeer.ourBeers.clear(); %>
		</table>
	</div>
	
	<a href="bindex.html"><button type="button" class="btn btn-default">Home</button></a>

</body>
</html>