package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Login;

public class LoginManagement {
	int status=0;
    public int insertLoginList(Login obj) {
    	try {
    		Connection con=DBConnectionManager.getConnection();
    		String query="insert into Login(USER_ID,PASSWORD)values(?,?)";
    		PreparedStatement p=con.prepareStatement(query);
    		p.setString(1,obj.getUserId());
    		p.setString(2, obj.getPassword());
    	    status=p.executeUpdate();
    	}
    	catch(SQLException | ClassNotFoundException e) {
  		  System.out.println(e.getMessage());
  	  }
    	return status;
    }
    
    public boolean checkUserExists(String user,String pwd) {
    	int t=0;
    	try {
    		Connection con=DBConnectionManager.getConnection();
    		String query="select * from Login where USER_ID=? and PASSWORD=?";
    		PreparedStatement p=con.prepareStatement(query);
    		p.setString(1,user);
    		p.setString(2, pwd);
    		ResultSet rs=p.executeQuery();
    		
    		while(rs.next()) {
    		
    			String pw=rs.getString(2);
    			if(pwd.equals(pw)) {
    				t++;
    			}
    		}
    	    
    	}
    	catch(SQLException | ClassNotFoundException e) {
  		  System.out.println(e.getMessage());
  	  }
    	if(t>0) {
    		return true;
    	}
    	else {
    	return false;
    	}
    }
}
