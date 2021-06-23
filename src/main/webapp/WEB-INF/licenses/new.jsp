<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 

			
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>New License</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
	<div class="container border border-dark bg-light mt-5 p-3">
		<div class="main form-group row mt-5">
			<h2>New License</h2>
			<form:form action="/licenses/new" method="post" modelAttribute="license">
	    		<!-- select a person from a drop-down of all persons -->
	    		<p class="m-3">
	        		<form:label  class="col-sm-2 col-form-label" path="person">Name:</form:label>
	        		<form:errors class="text-danger" path="person"/>
	        		<form:select class="form-control" path="person">
	        			<c:forEach items="${pList}" var="p">
	        				<form:option value="${p}">
	        					<c:out value="${p.first_name}"/>
	        					<c:out value="${p.last_name}"/>
	        				</form:option>	
	        			</c:forEach>
	        		</form:select>
	    		</p>
			    <p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="state">State:</form:label>
			        <form:errors class="text-danger" path="state"/>
			        <form:select class="form-control" path="state">
			        	<option value="AL">AL</option>
						<option value="AK">AK</option>
						<option value="AR">AR</option>	
						<option value="AZ">AZ</option>
						<option value="CA">CA</option>
						<option value="CO">CO</option>
						<option value="CT">CT</option>
						<option value="DC">DC</option>
						<option value="DE">DE</option>
						<option value="FL">FL</option>
						<option value="GA">GA</option>
						<option value="HI">HI</option>
						<option value="IA">IA</option>	
						<option value="ID">ID</option>
						<option value="IL">IL</option>
						<option value="IN">IN</option>
						<option value="KS">KS</option>
						<option value="KY">KY</option>
						<option value="LA">LA</option>
						<option value="MA">MA</option>
						<option value="MD">MD</option>
						<option value="ME">ME</option>
						<option value="MI">MI</option>
						<option value="MN">MN</option>
						<option value="MO">MO</option>	
						<option value="MS">MS</option>
						<option value="MT">MT</option>
						<option value="NC">NC</option>	
						<option value="NE">NE</option>
						<option value="NH">NH</option>
						<option value="NJ">NJ</option>
						<option value="NM">NM</option>			
						<option value="NV">NV</option>
						<option value="NY">NY</option>
						<option value="ND">ND</option>
						<option value="OH">OH</option>
						<option value="OK">OK</option>
						<option value="OR">OR</option>
						<option value="PA">PA</option>
						<option value="RI">RI</option>
						<option value="SC">SC</option>
						<option value="SD">SD</option>
						<option value="TN">TN</option>
						<option value="TX">TX</option>
						<option value="UT">UT</option>
						<option value="VT">VT</option>
						<option value="VA">VA</option>
						<option value="WA">WA</option>
						<option value="WI">WI</option>	
						<option value="WV">WV</option>
						<option value="WY">WY</option>
					</form:select>		
			    </p>
			    <p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="expirationDate">Expiration date:</form:label>
			        <form:errors class="text-danger" path="expirationDate"/>
			        <form:input type="date" class="form-control" path="expirationDate"/>
			    </p>  
				<input type="submit" value="Create" class="m-3"/>
			</form:form>
		</div>
		<nav class="navbar mt-3">
			<div class="container-fluid">
				<a href="/persons/add" class="nav-link text-end">Back</a>
			</div>
		</nav>
	</div>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>		
</body>
</html>