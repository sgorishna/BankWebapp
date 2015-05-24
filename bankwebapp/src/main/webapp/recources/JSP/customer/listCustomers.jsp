<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Customers</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Customer Id</th>
                <th>Login</th>
                <th>Password</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Created</th>
                <th>Updated</th>
                <th colspan=3>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.customers}" var="customer">
                <tr>
                    <td><c:out value="${customer.idCustomer}" /></td>
                    <td><c:out value="${customer.login}" /></td>
                     <td><c:out value="${customer.password}" /></td>
                    <td><a href="listAccounts.php?IdCustomer=<c:out value="${customer.idCustomer}"/>"><c:out value="${customer.name}" /></a></td>
                    <td><c:out value="${customer.gender}" /></td>
                    <td><c:out value="${customer.created}" /></td>
                    <td><c:out value="${customer.updated}" /></td>
                    <td><a href="update_customer.php?IdCustomer=<c:out value="${customer.idCustomer}"/>">Update</a></td>
                    <td><a href="delete_customer.php?IdCustomer=<c:out value="${customer.idCustomer}"/>">Delete</a></td>
                     <td><a href="add_account.php?IdCustomer=<c:out value="${customer.idCustomer}"/>">Add Account</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="new_customer.php">Add Customer</a></p>
</body>
</html>