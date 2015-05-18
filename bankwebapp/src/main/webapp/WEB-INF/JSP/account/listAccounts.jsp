<%@page import="com.webapp.dao.AccountDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.webapp.model.Account"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Accounts</title>
</head>
<body>

<%request.setCharacterEncoding("UTF-8");

    long IdCustomer = 0L;

    try {
    	IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }

%>

<jsp:useBean id="accountList" class="com.webapp.dao.AccountDao" scope="page"/>
    <table border=1>
        <thead>
            <tr>
                <th> Id Account</th>
                <th>Customer</th>
                <th>Account number</th>
                <th>Account type</th>
                <th>Currency</th>
                <th>Balance</th>
                <th>Created</th>
                <th>Updated</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>

            <%

            for (Account account : accountList.getAccountByIdCustomer(IdCustomer)) {

        %>
            
                <tr>
                    <td><%=account.getIdAccount()%></td>
                    
                    <td><%=account.getCustomerName()%></td>
                    
                    <td><%=account.getAccountNumber()%></td>
                    <td><%=account.getAccountType()%></td>
                     
                    <td><%=account.getCurrency()%></td>
                    
                    <td><%=account.getBalance()%></td>
                    
                    <td><%=account.getCreated()%></td>
                    <td><%=account.getUpdated()%></td>
                    <td><a href="transaction.php?IdCustomer=<%=account.getIdAccount()%>&account_number=<%=account.getAccountNumber()%>">Transfer money</a></td>
                    
                </tr>
           
           
         
        </tbody>
         <%}%>
    </table>
    <p><a href="add_account.php?IdCustomer=<c:out value="${account.idCustomer}"/>">Add Account</a></p>
</body>
</html>