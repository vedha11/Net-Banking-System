package com.model;
import java.util.Date;
public class CheckBookRequest {
	private String requestId;
	private String customerId;
	private String customerName;
	private long accountNumber;
	private String accountType;
	private String bankName;
	private Date requestDate;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
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
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public CheckBookRequest(String requestId, String customerId, String customerName, long accountNumber,
			String accountType, String bankName, Date requestDate) {
		super();
		this.requestId = requestId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.bankName = bankName;
		this.requestDate = requestDate;
	}
	

}
