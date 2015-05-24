package com.webapp.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.webapp.db.DBUtill;
import com.webapp.model.Account;

public class AccountDao {

	public void addAccount(Account account) {

		Connection connection = null;

		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into account(idCustomer,idAccount_type,idCurrency,account_number,balance,created) values (?, ?, ?, ?, ?, ?)");

			preparedStatement.setLong(1, account.getIdCustomer());
			preparedStatement.setLong(2, account.getIdAccountType());
			preparedStatement.setLong(3, account.getIdCurrency());
			preparedStatement.setLong(4, account.getAccountNumber());
			preparedStatement.setBigDecimal(5, account.getBalance());
			preparedStatement.setTimestamp(6, new Timestamp(new java.util.Date().getTime()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

	}

	public List<Account> getAccountByIdCustomer(long idCustomer) {

		Connection connection = null;

		ArrayList<Account> accountList = new ArrayList<Account>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			connection = DBUtill.getConnection();
			stmt = connection.createStatement();
			rs = stmt
					.executeQuery("select a.idAccount, a.idCustomer, a.account_number,a.balance,a.created,a.updated, c.name as customer,actp.account_type as account_type, accr.currency as account_currency from account a "
							+ "inner join customer c on a.idCustomer=c.idCustomer inner join account_type actp on a.idAccount_type=actp.idAccount_type inner join account_currency accr on a.idCurrency=accr.idAccount_currency where c.idCustomer="
							+ idCustomer);
			while (rs.next()) {
				Account account = new Account();

				account.setIdAccount(rs.getLong("idAccount"));
				account.setIdCustomer(rs.getLong("idCustomer"));
				account.setCustomerName(rs.getString("customer"));
				account.setAccountNumber(rs.getLong("account_number"));
				account.setAccountType(rs.getString("account_type"));
				account.setCurrency(rs.getString("account_currency"));
				account.setBalance(rs.getBigDecimal("balance"));
				account.setCreated(rs.getTimestamp("created"));
				account.setUpdated(rs.getTimestamp("updated"));
				accountList.add(account);
			}

		} catch (SQLException ex) {
			Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return accountList;

	}

	public void topUpBalance(Account account, BigDecimal amount) {
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("update account set balance=balance+" + amount + " where account_number=?");

			preparedStatement.setBigDecimal(1, account.getBalance());

			preparedStatement.setLong(2, account.getAccountNumber());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(conn);
		}
	}

	public Account getAccountByAccountNumber(long accountNumber) {

		Connection connection = null;
		Account account = new Account();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from account where account_number=?");
			preparedStatement.setLong(1, accountNumber);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				account.setIdAccount(rs.getLong("idAccount"));
				account.setIdCustomer(rs.getLong("idCustomer"));
				account.setCustomerName(rs.getString("customer"));
				account.setAccountNumber(rs.getLong("account_number"));
				account.setAccountType(rs.getString("account_type"));
				account.setCurrency(rs.getString("account_currency"));
				account.setBalance(rs.getBigDecimal("balance"));
				account.setCreated(rs.getTimestamp("created"));
				account.setUpdated(rs.getTimestamp("updated"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

		return account;
	}

}
