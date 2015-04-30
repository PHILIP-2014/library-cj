<%-- 
    Document   : login
    Created on : 29/04/2015, 17:51:18
    Author     : Philip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean class="com.church.model.UserModel" id="user" scope="session"/>
<jsp:setProperty name="user" property="*" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="Bootstrap后台管理系统登录模板页面">
	    <meta name="author" content="未见之乡、异乡客旅、Philip">
	    <title>Login</title>
	    <link href="/css/bootstrap.css" rel="stylesheet">
	    <link href="/css/login.css" rel="stylesheet">
	    <link rel="icon" href="/img/icon.jpg">
    </head>
    <body>
	<div class="container">
		<form class="form-signin" role="form" method="post" action="/login">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="phone" name="phone" class="form-control" placeholder="Phone Number" required autofocus> 
			<input type="password" name="password" class="form-control" placeholder="Password" required> 
			<!-- <label
				class="checkbox checkbox-login"> 
				<input type="checkbox" value="remember-me"> Remember me
			</label> -->
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>
</body>
</html>