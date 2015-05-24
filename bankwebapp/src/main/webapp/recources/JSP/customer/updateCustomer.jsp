<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Add new customer</title>
</head>
<body>
  

    <form method="POST" action='update_customer.php' name="formUpdateCustomer" >
        Customer ID : <input type="text" readonly="readonly" name="idCustomer"
            value="<c:out value="${customer.idCustomer}" />" /> <br /> 
             Login : <input
            type="text" name="login"
            value="<c:out value="${customer.login}" />" /> <br />
             Password : <input
            type="password" name="password"
            value="<c:out value="${customer.password}" />" /> <br /> 
         Name : <input
            type="text" name="name"
            value="<c:out value="${customer.name}" />" /> <br /> 
        Gender :  <input TYPE="radio" NAME="gender" VALUE="male" CHECKED>
             Male
            <br>
            <INPUT TYPE="radio" NAME="gender" VALUE="female">
             Female
            <br>
        
         <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>