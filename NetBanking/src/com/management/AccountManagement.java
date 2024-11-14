package com.management;
import com.model.*;
//import com.util.ApplicationUtil;
import java.sql.*;
//import java.util.*;
//import com.model.*;
//import com.management.*;
public class AccountManagement {
    public int insertAccountList(Account obj){
  	  int status=0;
  	  try {
  		  Connection con=DBConnectionManager.getConnection();
  		  String query="insert into account(CUSTOMER_ID,CUSTOMER_NAME,CONTACT_NUMBER,EMAIL_ID,ACCOUNT_NUMBER,BANK_NAME,ACCOUNT_TYPE,BALANCE,BRANCH,IFSC_CODE,IDPROOF_TYPE,IDPROOF_NUMBER)values(?,?,?,?,?,?,?,?,?,?,?,?)";
  		  PreparedStatement pmst=con.prepareStatement(query);
  		  pmst.setString(1,obj.getCustomer_id());
  		  pmst.setString(2,obj.getCustomer_name());
  		  pmst.setLong(3, obj.getContact_number());
  		  pmst.setString(4, obj.getEmail_id());
  		  pmst.setLong(5,obj.getAccount_number());
  		  pmst.setString(6, obj.getBank_name());
  		  pmst.setString(7, obj.getAccount_type());
  		  pmst.setDouble(8, obj.getBalance());
  		  pmst.setString(9, obj.getBranch());
  		  pmst.setString(10, obj.getIFSC_code());
  		  pmst.setString(11, obj.getIDProof_type());
  		  pmst.setString(12, obj.getIDProof_number());
  		  status=pmst.executeUpdate();
  		  }
  	  catch(SQLException | ClassNotFoundException e) {
  		  System.out.println(e.getMessage());
  	  }
  	  
		return status;
    }
    
    public Account retriveAccountDetails(long accNo) {
    	Account a=null;
    	try {
    		Connection con=DBConnectionManager.getConnection();
    		String query="select * from account where ACCOUNT_NUMBER=?";
    		PreparedStatement p=con.prepareStatement(query);
    		p.setLong(1, accNo);
    		ResultSet rs=p.executeQuery();
	  		  while(rs.next()) {
	  			  String id=rs.getString(1);
	  			  String name=rs.getString(2);
	  			  long contact=rs.getLong(3);
	  			  String email=rs.getString(4);
	  			  long accountNo=rs.getLong(5);
	  			  String bankName=rs.getString(6);
	  			  String accountType=rs.getString(7);
	  			  double balance=rs.getDouble(8);
	  			  String branch=rs.getString(9);
	  			  String ifsc=rs.getString(10);
	  			  String idproof=rs.getString(11);
	  			  String idproofNo=rs.getString(12);
	  			  a=new Account(id,name,contact,email,accountNo,bankName,accountType,balance,branch,ifsc,idproof,idproofNo);
	  		  }
  		  }
    	
    	 catch(SQLException | ClassNotFoundException e) {
     		  System.out.println(e.getMessage());
     	  }
    	return a;
    }
    
    public int updateBalance(long accNo,double balance) {
    	int status=0;
    	try {
    		Connection con=DBConnectionManager.getConnection();
    		String query="update account set BALANCE = ? where ACCOUNT_NUMBER = ?";
    		PreparedStatement p=con.prepareStatement(query);
    		p.setDouble(1, balance);
    		p.setLong(2, accNo);
    		status=p.executeUpdate();
    	}
    	catch(SQLException | ClassNotFoundException e) {
   		  System.out.println(e.getMessage());
   	  }
    	return status;
    }
    
    public long retrieveAccountNo(String email) {
  	  long accNo=0;
  	  try {
			Connection con=DBConnectionManager.getConnection();
			String query="select ACCOUNT_NUMBER from account where EMAIL_ID=?";
			 PreparedStatement p=con.prepareStatement(query);
 		     p.setString(1, email);
 		     ResultSet rs=p.executeQuery();
 		     while(rs.next()) {
 		    	 accNo=rs.getLong(1);
 		     }
		   } 
  	  catch(SQLException | ClassNotFoundException e) {
		  System.out.println(e.getMessage());
	      }
  	  return accNo;
    }
    
    public int deleteAccount(long accNo) {
    	int status=0;
    	try {
			Connection con=DBConnectionManager.getConnection();
			String query="delete from account where ACCOUNT_NUMBER=?";
			 PreparedStatement p=con.prepareStatement(query);
			 p.setLong(1, accNo);
			 status = p.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return status;
    }
}