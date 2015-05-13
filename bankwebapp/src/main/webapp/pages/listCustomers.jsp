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
                <th>Name</th>
                <th>Gender</th>
                <th>Created</th>
                <th>Updated</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td><c:out value="${customer.idCustomer}" /></td>
                    <td><c:out value="${customer.name}" /></td>
                    <td><c:out value="${customer.gender}" /></td>
                    <td><c:out value="${customer.created}" /></td>
                    <td><c:out value="${customer.updated}" /></td>
                    <td><a href="">Update</a></td>
                    <td><a href="">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="CustomerController?action=insert">Add Customer</a></p>
</body>
</html>