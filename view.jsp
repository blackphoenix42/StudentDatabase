<%@page import="studentProfile.Student"%>
<%@page import="studentProfile.StudentDAOimplement"%>
<%@page import="studentProfile.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Student Table</title>
<c:import url="bootstrapCDN.jsp"/>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Allerta+Stencil">
<style>
  body{
  	margin:10px 30px 0px 20px;
  }
  .myfont {
  font-family: "Comic Sans MS", cursive, sans-serif;
}
  .lobster {
  font-family: "Lobster", serif;
}
  .allerta {
  font-family: "Allerta Stencil", Sans-serif;
}
table{
border-color:blue;
}
</style>
</head>
<body>
<div class="w3-container w3-blue" style="text-align:center;letter-spacing:2px;"><h1 class="allerta">Student Table</h1></div>
<table class="w3-table-all" >
  <thead>
	<tr class="w3-indigo">
	  <th>ID</th>
	  <th>Name</th>
	  <th>Email</th>
	  <th>Course</th>
	  <th class="w3-center">Operations</th>
	</tr>
  </thead>
  <tbody>
  	<%
  		StudentDAO studentDAO = new StudentDAOimplement();
  		for(Student s:studentDAO.fetchAllStudents()){
  	%>
  	
  	<tr>
  	  <td><%=s.getId() %></td>
  	  <td><%=s.getName() %></td>
  	  <td><%=s.getEmail() %></td>
  	  <td><%=s.getCourse() %></td>
	  <td class="w3-center"> 
		<a href="edit.jsp?id=<%=s.getId()%>" class="btn btn-success btn-sm " style="margin-left:50px;"><i class = "fas fa-cog"></i> Edit</a>
		<form method="post" action="remove" style="display: inline;">
			<input type="hidden" name="id" value="<%=s.getId()%>">
			<button type="submit" class="btn btn-danger btn-sm "><i class = "fas fa-minus"></i> Delete</button>
		</form>
	  </td>
  	</tr>
  	<%} %>
  </tbody>
</table>
<a href="index.jsp" style="text-decoration:none;">
	<button class="w3-button w3-block w3-black" style="width:22.5%;float:right;">
		<i class = "fas fa-plus"></i> WANT TO ADD ?
	</button>
</a><br>

</body>
</html>