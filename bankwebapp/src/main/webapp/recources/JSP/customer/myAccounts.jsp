
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>My accounts</title>
</head>
<body>

	<table border=1>
		<thead>
			<tr>
				<th>Id Account</th>
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

			<c:forEach items="${sessionScope.accounts}" var="account">
				<tr>

					<td><c:out value="${account.idAccount}" /></td>

					<td><c:out value="${account.сustomerName}" /></td>

					<td><c:out value="${account.accountNumber}" /></td>
					<td><c:out value="${account.accountType}" /></td>

					<td><c:out value="${account.сurrency}" /></td>

					<td><c:out value="${account.balance}" /></td>

					<td><c:out value="${account.created}" /></td>
					<td><c:out value="${account.updated}" /></td>
					<td><a
						href="transferFunds.php?accountNumber=${account.accountNumber}">Transfer
							funds</a></td>



				</tr>



			</c:forEach>
		</tbody>

	</table>


	<p>
		<a href="home.php">Home</a>
	</p>
	<p>
		<a href="myTransactions.php">My transactions</a>
	</p>

</body>
</html>