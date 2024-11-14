package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Account;
import com.model.Transactions;

import com.util.ApplicationUtil;
public class TransactionManagement 
{
	 public int insertTransactionList(Transactions obj)
     {
		 int status=0;
		   try
		   {
			      // DBConnectionManager db=new DBConnectionManager();
				   Connection conn=DBConnectionManager.getConnection();
				   String query="insert into transaction(TRANSACTION_ID,CUSTOMER_ID,CUSTOMER_NAME,CONTACT_NUMBER,ACCOUNT_NUMBER,ACCOUNT_TYPE,BANK_NAME,SENDER_NAME,SENDER_ACCOUNT_NUMBER,SENDER_BANK_NAME,SENDER_CONTACT_NUMBER,TRANSACTION_TYPE,AMOUNT,CURRENT_BALANCE,TRANSACTION_DATE,STATUS)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				    
					PreparedStatement pmst=conn.prepareStatement(query);
				      pmst.setString(1,obj.getTransactionId());
			  		  pmst.setString(2,obj.getCustomerId());
			  		  pmst.setString(3, obj.getCustomerName());
			  		  pmst.setLong(4, obj.getContactNumber());
			  		  pmst.setLong(5,obj.getAccountNumber());
			  		  pmst.setString(7, obj.getAccountType());
			  		  pmst.setString(6, obj.getBankName());
			  		  pmst.setString(8, obj.getSenderName());
			  		  pmst.setLong(9, obj.getSenderAccountNumber());
			  		  pmst.setString(10, obj.getSenderBankName());
			  		  pmst.setLong(11, obj.getSenderContactNumber());
			  		  pmst.setString(12, obj.getTransactionType());
			  		  pmst.setDouble(13, obj.getAmount());
			  		  pmst.setDouble(14, obj.getCurrentBalance());
			  		  ApplicationUtil aobj=new ApplicationUtil();
			  		  pmst.setDate(15, aobj.convertSqlDate(obj.getTransactionDate()));
			  		  pmst.setString(16, obj.getStatus());
			  		  status=pmst.executeUpdate();
	        }
		   catch(SQLException | ClassNotFoundException e) {
	    		  System.out.println(e.getMessage());
	    	  }
	  	  
			return status;
	    }
	 public List<Transactions> retrieveTransaction(long accNo) {
		 List<Transactions> obj=new ArrayList<Transactions>();
		 try {
			Connection conn=DBConnectionManager.getConnection();
			String query="select * from transaction where ACCOUNT_NUMBER =? or SENDER_ACCOUNT_NUMBER=?";
			PreparedStatement pmst=conn.prepareStatement(query);
			pmst.setLong(1,accNo);
			pmst.setLong(2, accNo);
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
				String id=rs.getString(1);
				String cust_id=rs.getString(2);
				String receiverName=rs.getString(3);
				long contact=rs.getLong(4);
				long receiver_accNo=rs.getLong(5);
				String acc_type=rs.getString(6);
				String bankName=rs.getString(7);
				String senderName=rs.getString(8);
				long sender_accNo=rs.getLong(9);
				String sender_bankName=rs.getString(10);
				long sender_contact=rs.getLong(11);
				String trans_type=rs.getString(12);
				double amount=rs.getDouble(13);
				double current_balance=rs.getDouble(14); 
				ApplicationUtil au=new ApplicationUtil();
				String d1=au.convertStringDate(rs.getDate(15));
				java.util.Date date=au.convertUtilDate(d1);
				String status=rs.getString(16);
				Transactions t=new Transactions(id,cust_id,receiverName,contact,receiver_accNo,acc_type,bankName,senderName,sender_accNo,sender_bankName,sender_contact,trans_type,amount,current_balance,date,status); 
				obj.add(t);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return obj;
	 }
	   
	 public void debitAmount(Account sender,double amount) {
		  //DBConnectionManager db=new DBConnectionManager();
		  
		  long accNo=sender.getAccount_number();
		   try {
			Connection conn=DBConnectionManager.getConnection();
			String query="update account set BALANCE = BALANCE - ? where ACCOUNT_NUMBER=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setDouble(1,amount);
			ps.setLong(2, accNo);
			int status=ps.executeUpdate();
			status=status+0;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	public void creditAmount(Account receiver,double amount) {
		//DBConnectionManager db=new DBConnectionManager();
		
		  long accNo=receiver.getAccount_number();
		  try {
			Connection conn=DBConnectionManager.getConnection();
			String query="update account set BALANCE = BALANCE + ? where ACCOUNT_NUMBER=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setDouble(1,amount);
			ps.setLong(2, accNo);
			int status=ps.executeUpdate();
			status=status+0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	

}
