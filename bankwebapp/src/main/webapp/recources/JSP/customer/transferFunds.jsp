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
 

    <form method="POST" action='transferFunds.php' name="formUTransferMoney" >
        From account : <input type="text"  name="senderAccountNumber"
            value="<c:out value="${param.accountNumber}" />" /> <br /> 
        To account : <input
            type="text" name="receiverAccountNumber" /> <br /> 
            Amount : <input
            type="text" name="amount" /> <br /> 
            
             Comments : <input
            type="text" name="comments" /> <br /> 
       
          <input
            type="submit" value="Submit" />
    </form>
</body>
</html>