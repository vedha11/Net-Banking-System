package com.model;

import java.util.Date;

public class Transactions {
	private String transactionId;
	public Transactions(String transactionId, String customerId, String customerName, long contactNumber,
			long accountNumber, String accountType, String bankName, String senderName, long senderAccountNumber,
			String senderBankName, long senderContactNumber, String transactionType, double amount,
			double currentBalance, Date transactionDate, String status) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.bankName = bankName;
		this.senderName = senderName;
		this.senderAccountNumber = senderAccountNumber;
		this.senderBankName = senderBankName;
		this.senderContactNumber = senderContactNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.currentBalance = currentBalance;
		this.transactionDate = transactionDate;
		this.status = status;
	}
	private String customerId;
	private String customerName;
	private long contactNumber;
	private long accountNumber;
	private String accountType;
	private String bankName;
	private String senderName;
	private long senderAccountNumber;
	private String senderBankName;
	private long senderContactNumber;
	private String transactionType;
	private double amount;
	private double currentBalance;
	private Date transactionDate;
	private String status;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public long getSenderAccountNumber() {
		return senderAccountNumber;
	}
	public void setSenderAccountNumber(long senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}
	public String getSenderBankName() {
		return senderBankName;
	}
	public void setSenderBankName(String senderBankName) {
		this.senderBankName = senderBankName;
	}
	public long getSenderContactNumber() {
		return senderContactNumber;
	}
	public void setSenderContactNumber(long senderContactNumber) {
		this.senderContactNumber = senderContactNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
