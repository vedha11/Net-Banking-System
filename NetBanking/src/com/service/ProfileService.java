package com.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.management.*;
import com.model.*;
import com.util.*;
import java.util.Date;
public class ProfileService {
	  ApplicationUtil obj=new ApplicationUtil();
	  ProfileManagement obj1=new ProfileManagement();
      public int addProfileList(String str){
    	  Profile p1=generateProfileObject(str);
    	  int status=obj1.insertProfileList(p1);
    	  return status;
      }
      
      public Profile generateProfileObject(String str) {
  		String arr[]=str.split(":");
  		String name=arr[0];
  		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
  		Date dob=null;
		try {
			dob = sdf.parse(arr[1]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		String email=arr[2];
  		String address=arr[3];
  		long contact=Long.parseLong(arr[4]);
  		String id=obj.generateProfileId();
  		Profile p=new Profile(id,name,dob,email,address,contact);
  		return p;
  	}
      
    public Profile retrieveProfile(String custId) {
    	return obj1.retrieveProfile(custId);
    }
    public String utilToString(java.util.Date date) {
    	return obj.utilToString(date);
    }
    
    public int updateAddress(String address,String id) {
    	return obj1.updateAddress(address, id);
    }
    public int deleteProfile(String id) {
    	return obj1.deleteProfile(id);
    }
    
    public String retrieveCustomerId(String email) {
    	return obj1.retrieveCustomerId(email);
    }
}
