<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Add new account</title>
</head>
<body>
  

    <form method="POST" action='add_account.php' name="formAddAccount" >
    <%--  Account ID : <input type="text" readonly="readonly" name="idAccount"
            value="<c:out value="${account.idAccount}" />" /> <br />  --%>
        Customer ID : <input type="text" readonly="readonly" name="idCustomer"
            value="<c:out value="${customer.idCustomer}" />" /> <br /> 
         Name : <input
            type="text" readonly="readonly" name="name"
            value="<c:out value="${customer.name}" />" /> <br /> 
            Account number : <input
            type="text" name="accountNumber"
            value="<c:out value="${account.accountNumber}" />" /> <br /> 
            
        Account type :  <input TYPE="radio" NAME="accountType" VALUE="1" CHECKED>
             DEBIT
            <br>
            <INPUT TYPE="radio" NAME="accountType" VALUE="2">
             CREDIT
            <br>
        
         <br /> 
         
          Currency :  <input TYPE="radio" NAME="currency" VALUE="1" CHECKED>
             EUR
            <br>
            <INPUT TYPE="radio" NAME="currency" VALUE="2">
             USD
            <br>
        
         <br /> 
         
         Balance : <input
            type="text" name="balance"
            value="<c:out value="${account.balance}" />" /> <br /> 
         <input
            type="submit" value="Submit" />
    </form>
</body>
</html>