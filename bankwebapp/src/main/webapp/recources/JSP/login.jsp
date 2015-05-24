<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Login</title>
</head>
<body>
  

    <form action='login.php' method="post" >
		<table>
			<tr>
				<td colspan="2" >Login</td>
			</tr>
			
			<tr>
			
			<tr>
				<td>Login</td>
				<td>
					<input type="text" name="login" id="login" value="" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input type="password" name="password" id="password" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align:center;border-top:1px solid gray;">
					<input type="submit" value="Submit">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>