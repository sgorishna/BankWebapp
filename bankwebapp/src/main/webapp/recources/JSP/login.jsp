<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<style>
        <%@include file="/recources/css/style.css" %>
        <%@include file="/recources/css/bootstrap.min.css" %>
</style>

<title>Login</title>
</head>
<body>
  
 <div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Login</h1>
            <div class="account-wall">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                    alt="">
                <form class="form-signin" action='login.php' method="post" >
                <input type="text" class="form-control" id="login" name="login" placeholder="Login" required autofocus>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                
                
				Select role
				
					<select name="role" id="role">
						<option value="1">Administrator</option>
						<option value="2">User</option>
					</select>
				
			
                
                <button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">
                    Sign in</button>
                <label class="checkbox pull-left">
                    <input type="checkbox" value="remember-me">
                    Remember me
                </label>
                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="#" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>
  
</body>
</html>