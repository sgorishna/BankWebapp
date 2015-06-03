package com.webapp.model;

import java.math.BigDecimal;

import com.sun.jmx.snmp.Timestamp;

public class Transaction {

	private long idTransaction;

	private long idAccountSender;

	private long idAccountReceiver;

	private long senderAccountNumber;

	private long receiverAccountNumber;

	private BigDecimal amount;

	private String comments;

	private Timestamp created;

	public long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public long getIdAccountSender() {
		return idAccountSender;
	}

	public void setIdAccountSender(long idAccountSender) {
		this.idAccountSender = idAccountSender;
	}

	public long getIdAccountReceiver() {
		return idAccountReceiver;
	}

	public void setIdAccountReceiver(long idAccountReceiver) {
		this.idAccountReceiver = idAccountReceiver;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public long getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public void setSenderAccountNumber(long senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}

	public long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

}
