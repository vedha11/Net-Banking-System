package com.model;
public class Account{
	private String customer_id; 
	private String customer_name;
	private long contact_number;
	private String email_id;
	private long account_number;
	private String bank_name;
	private String account_type;
	private double balance;
	private String branch;
	private String IFSC_code;
	private String IDProof_type;
	private String IDProof_number;
	public String getIDProof_type() {
		return IDProof_type;
	}
	public void setIDProof_type(String iDProof_type) {
		IDProof_type = iDProof_type;
	}
	public String getIDProof_number() {
		return IDProof_number;
	}
	public void setIDProof_number(String iDProof_number) {
		IDProof_number = iDProof_number;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public long getContact_number() {
		return contact_number;
	}
	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(String customer_id, String customer_name, long contact_number, String email_id, long account_number,
			String bank_name, String account_type, double balance, String branch, String iFSC_code, String iDProof_type,
			String iDProof_number) {
		this(customer_id,customer_name,contact_number,email_id,account_number,bank_name);
		this.account_type = account_type;
		this.balance = balance;
		this.branch = branch;
		IFSC_code = iFSC_code;
		IDProof_type = iDProof_type;
		IDProof_number = iDProof_number;
	}
	
	public Account(String customer_id, String customer_name, long contact_number, String email_id, long account_number,
			String bank_name) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.contact_number = contact_number;
		this.email_id = email_id;
		this.account_number = account_number;
		this.bank_name = bank_name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIFSC_code() {
		return IFSC_code;
	}
	public void setIFSC_code(String iFSC_code) {
		IFSC_code = iFSC_code;
	}
	
	

}