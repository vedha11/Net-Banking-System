package com.service;

import java.util.List;
import java.util.Random;

import com.management.AccountManagement;
import com.management.TransactionManagement;
import com.model.Account;
import com.model.Transactions;

public class AccountService{
	AccountManagement am=new AccountManagement();
	public long createAccountNo() {
		long min=10000000;
		long max=100000000;
		Random rand=new Random();
		long accno=rand.nextLong(max-min+1)+min;
		return accno;
	}
	
	public int addAccountDetails(Account obj) {
		int status=am.insertAccountList(obj);
		return status;
	}
	
	public Account retriveAccountDetails(long accNo) {
		return  am.retriveAccountDetails(accNo);
	}
	
	public int updateBalance(long accNo,double balance) {
		return am.updateBalance(accNo,balance);
	}
	 public long retrieveAccountNo(String email) {
		 return am.retrieveAccountNo(email);
	 }
	 public int deleteAccount(long accNo) {
		 return am.deleteAccount(accNo);
	 }
	 
	 public List<Transactions> retrieveTransaction(long accNo){
		 TransactionManagement tm=new TransactionManagement();
		 return tm.retrieveTransaction(accNo);
	 }
}