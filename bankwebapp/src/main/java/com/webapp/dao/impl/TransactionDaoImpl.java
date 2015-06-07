package com.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.webapp.dao.TransactionDao;
import com.webapp.db.DBUtill;
import com.webapp.model.Transaction;

public class TransactionDaoImpl implements TransactionDao {

	public void create(Transaction transaction) {

		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement preparedStatement1 = conn.prepareStatement("update account set balance=balance-" + transaction.getAmount() + " where account_number=" + transaction.getSenderAccountNumber());
			PreparedStatement preparedStatement2 = conn.prepareStatement("update account set balance=balance+" + transaction.getAmount() + " where account_number=" + transaction.getReceiverAccountNumber());
			PreparedStatement preparedStatement3 = conn.prepareStatement("insert into transaction(idAccount_sender,idAccount_receiver,amount,comments,created) values (?, ?, ?, ?, ?)");
			preparedStatement3.setLong(1, transaction.getIdAccountSender());
			preparedStatement3.setLong(2, transaction.getIdAccountReceiver());
			preparedStatement3.setBigDecimal(3, transaction.getAmount());
			preparedStatement3.setString(4, transaction.getComments());
			preparedStatement3.setTimestamp(5, new Timestamp(new java.util.Date().getTime()));

			preparedStatement1.executeUpdate();
			preparedStatement2.executeUpdate();
			preparedStatement3.executeUpdate();

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

	public Transaction findByIdCustomer(long id) throws UnsupportedOperationException {
		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {
			return null;
		}
	}

	public void update(Transaction object) throws UnsupportedOperationException {

		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {

		}

	}

	public void delete(Transaction object) throws UnsupportedOperationException {
		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {

		}

	}

	public Transaction findById(long id) throws UnsupportedOperationException {
		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {
			return null;
		}
	}

	public List<Transaction> findAll() throws UnsupportedOperationException {
		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {
			return null;
		}
	}

}
