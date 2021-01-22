<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home Page</title>
<c:import url="bootstrapCDN.jsp"/>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster">
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
 form{
 	margin-bottom:20px;
 }
</style>
</head>
<body>
	<div class="w3-card-2">
	  <div class="w3-container w3-pink " style="text-align:center;"><h1 class="lobster">Student Details</h1></div>
	  <form action="insert" method="post" class="w3-container">
	    <div class="form-group">
		  <label for="id" class="myfont" style="margin-top:10px;">ID</label>
		  <input type="number" class="form-control" placeholder="Enter ID" name="id" required><br>
		</div>
		<div class="form-group">
		  <label for="name" class="myfont">Name</label>
		  <input type="text" class="form-control" placeholder="Enter name" name="name" required>
		  <small class="form-text text-muted">Enter only characters. </small><br>
		</div>
		<div class="form-group">  
		  <label for="email" class="myfont">Email Address</label>
		  <input type="email" class="form-control" placeholder="Enter email" name="email" required><br>
		</div>
		<div class="form-group">
		  <label for="course" class="myfont">Course</label>
		  <select name="course" class="form-control" required>
	  		<option value="" disabled selected>Choose Course</option>
			<option value="Java">Java</option>
			<option value="Python">Python</option>
			<option value="C++">C++</option>
			<option value="C#">C#</option>
			<option value="Ruby">Ruby</option>
		  </select>
		</div>
		<button type="submit" class="btn btn-primary myfont" style="margin-bottom:10px;">Save Details</button>
		<a href="view.jsp" class="btn btn-info myfont" style="margin:0px 0px 10px 20px;">View Details</a>
		</form>
	</div>
</body>
</html>