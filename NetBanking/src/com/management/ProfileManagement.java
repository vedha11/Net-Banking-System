package com.management;
import com.model.*;
import com.util.ApplicationUtil;
import java.sql.*;
//import java.util.*;
//import com.model.*;
//import com.management.*;
public class ProfileManagement {
	
      public int insertProfileList(Profile obj){
//    	  DBConnectionManager db=new DBConnectionManager();
    	  int status=0;
    	  try {
    		  Connection con=DBConnectionManager.getConnection();
    		  String query="insert into profile(CUSTOMER_ID,CUSTOMER_NAME,DOB,EMAIL_ID,ADDRESS,CONTACT_NUMBER)values(?,?,?,?,?,?)";
    		  PreparedStatement pmst=con.prepareStatement(query);
    		  pmst.setString(1,obj.getCustomerId());
    		  pmst.setString(2,obj.getCustomerName());
    		  ApplicationUtil aobj=new ApplicationUtil();
    		  pmst.setDate(3, aobj.convertSqlDate(obj.getDob()));
    		  pmst.setString(4, obj.getEmailId());
    		  pmst.setString(5,obj.getAddress());
    		  pmst.setLong(6, obj.getContactNumber());
    		  status=pmst.executeUpdate();
    		  }
    	  catch(SQLException | ClassNotFoundException e) {
    		  System.out.println(e.getMessage());
    	  }
    	  
		return status;
      }
      
      public Profile retrieveProfile(String custId) {
    	  Profile obj=null;
    	  ApplicationUtil  util=new ApplicationUtil();
    	  try {
    		  Connection con=DBConnectionManager.getConnection();
    		  String query="select * from profile where CUSTOMER_ID = ?";
    		  PreparedStatement p=con.prepareStatement(query);
    		  p.setString(1, custId);
    		  ResultSet rs=p.executeQuery();
    		  while(rs.next()) {
    			  String id=rs.getString(1);
    			  String name=rs.getString(2);
    			  String d=util.convertStringDate(rs.getDate(3));
    			  java.util.Date date=util.convertUtilDate(d);
    			  String email=rs.getString(4);
    			  String address=rs.getString(5);
    			  long contact=rs.getLong(6);
    			  obj=new Profile(id,name,date,email,address,contact);
    		  }
    	  }
    	  catch(SQLException | ClassNotFoundException e) {
    		  System.out.println(e.getMessage());
    	  }
    	  return obj;
      }
      
      public String retrieveCustomerId(String email) {
    	  String id="";
    	  try {
			Connection con=DBConnectionManager.getConnection();
			String query="select CUSTOMER_ID from profile where EMAIL_ID=?";
			 PreparedStatement p=con.prepareStatement(query);
   		     p.setString(1, email);
   		     ResultSet rs=p.executeQuery();
   		     while(rs.next()) {
   		    	 id=rs.getString(1);
   		     }
		   } 
    	  catch(SQLException | ClassNotFoundException e) {
  		  System.out.println(e.getMessage());
  	      }
    	  return id;
      }
      
      public int updateAddress(String address,String id) {
    	  int status=0;
    	  try {
			Connection con=DBConnectionManager.getConnection();
			String query="update profile set ADDRESS =? where CUSTOMER_ID=?";
			 PreparedStatement p=con.prepareStatement(query);
			 p.setString(1, address);
			 p.setString(2, id);
			 status=p.executeUpdate();
		} 
    	  catch(SQLException | ClassNotFoundException e) {
    		  System.out.println(e.getMessage());
    	  }
    	  return status;
      }
      
      public int deleteProfile(String id) {
    	  int status=0;
    	  try {
    		  Connection con=DBConnectionManager.getConnection();
    		  String query="delete from profile where CUSTOMER_ID=?";
    		  PreparedStatement p=con.prepareStatement(query);
    		  p.setString(1, id);
    		  status=p.executeUpdate();  		  
    		  }
    	  catch(SQLException | ClassNotFoundException e) {
    		  System.out.println(e.getMessage());
    	  }
    	  return status;
      }
}
