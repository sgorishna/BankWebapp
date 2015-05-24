package com.webapp.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.webapp.db.DBUtill;

public class TransactionDao {

	public void doTransaction(long senderAccountNumber, long receiverAccountNumer, BigDecimal amount) {

		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement preparedStatement1 = conn.prepareStatement("update account set balance=balance-" + amount + " where account_number=" + senderAccountNumber);
			PreparedStatement preparedStatement2 = conn.prepareStatement("update account set balance=balance+" + amount + " where account_number=" + receiverAccountNumer);

			preparedStatement1.executeUpdate();
			preparedStatement2.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
			}

			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

}
