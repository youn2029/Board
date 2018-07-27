<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">
    
  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="post" action="<%=request.getContextPath() %>/login">
        <h2 class="form-signin-heading">LOGIN</h2>
        <label for="inputEmail" class="sr-only">ID</label>
        <input type="text" id="std_id" name="std_id" class="form-control" placeholder="ID" value="${param.std_id }" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="pass" name="pass" class="form-control" placeholder="Password" required>        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
