package com.service;

import com.management.TransactionManagement;
import com.model.Account;
import com.model.Transactions;
import com.util.ApplicationUtil;

public class TransactionService 
{
	ApplicationUtil au=new ApplicationUtil();
	TransactionManagement tm=new TransactionManagement();
	 AccountService accser=new AccountService();
	public int depositAmount(Account sender,Account receiver,String tType,double amou){
		String transactionId=au.generateTransactionId();
		String custId=receiver.getCustomer_id();
		String custName=receiver.getCustomer_name();
		long contNo=receiver.getContact_number();
		long accNo=receiver.getAccount_number();
		String accType=receiver.getAccount_type();
		String bankName=receiver.getBank_name();
		String senderName=sender.getCustomer_name();
		long senderAccno=sender.getAccount_number();
		String senderBankName=sender.getBank_name();
		long senderContact=sender.getContact_number();
		String transactionType=tType;
		double amount=amou;
		java.util.Date tdate=au.getCurrentDate();
		if(sender.getBalance()<amount) {
			String status="Failed";
			double balance=sender.getBalance();
			Transactions obj=new Transactions(transactionId,custId,custName,contNo,accNo,accType,bankName,senderName,senderAccno,senderBankName,senderContact,transactionType,amount,balance,tdate,status);
			int temp=tm.insertTransactionList(obj);
			if(temp>0) {
				return 0;
			}
			
		}
		else {
			String status="Success";
			tm.debitAmount(sender,amount);
			tm.creditAmount(receiver, amount);
			Account aobj=accser.retriveAccountDetails(sender.getAccount_number());
			double balance=aobj.getBalance();
			Transactions obj=new Transactions(transactionId,custId,custName,contNo,accNo,accType,bankName,senderName,senderAccno,senderBankName,senderContact,transactionType,amount,balance,tdate,status);
			int temp=tm.insertTransactionList(obj);
			if(temp>0) {
				return 1;
			}
		}
		return 0;
	}
	
	
	
	

}
