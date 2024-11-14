package com.management;

import java.sql.*;
import com.model.*;
import com.util.ApplicationUtil;

public class CheckBookRequestManagement {
	  
	  public int insertCheckBookRequestList(CheckBookRequest obj)
	  {
		  int status=0;
		  try
		  {
			  Connection con=DBConnectionManager.getConnection();
			  String query="insert into CheckBookRequest(REQUEST_ID,CUSTOMER_ID,CUSTOMER_NAME,ACCOUNT_NUMBER,ACCOUNT_TYPE,BANK_NAME,REQUEST_DATE)values(?,?,?,?,?,?,?)";
			  PreparedStatement pre=con.prepareStatement(query);
			  pre.setString(1,obj.getRequestId());
			  pre.setString(2,obj.getCustomerId());
			  pre.setString(3,obj.getCustomerName());
			  pre.setLong(4,obj.getAccountNumber());
			  pre.setString(5,obj.getAccountType());
			  pre.setString(6, obj.getBankName());
			  ApplicationUtil aobj=new ApplicationUtil();
			  pre.setDate(7,aobj.convertSqlDate(obj.getRequestDate()));
			  status=pre.executeUpdate();
			  
		  }
		  catch(SQLException |ClassNotFoundException e)
		  {
			  System.out.println(e.getMessage());
		  }
		  return status;
	  }
	  public int deleteRequest(String id) {
		  int status=0;
		  try {
			Connection con=DBConnectionManager.getConnection();
			String query="delete from CheckBookRequest where REQUEST_ID=?";
			PreparedStatement pre=con.prepareStatement(query);
			pre.setString(1, id);
			status=pre.executeUpdate();
		   } 
		  catch(SQLException |ClassNotFoundException e)
		  {
			  System.out.println(e.getMessage());
		  }

     	 return status;
      }
	 public String retrieveRequestId(long accNo) {
		 String id="";
		 try {
			Connection con=DBConnectionManager.getConnection();
			String query="select REQUEST_ID from CheckBookRequest where ACCOUNT_NUMBER=?";
			PreparedStatement pre=con.prepareStatement(query);
			pre.setLong(1, accNo);
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
				id=rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return id;
	 }
  	  
}
