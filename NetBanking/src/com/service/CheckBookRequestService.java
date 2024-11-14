package com.service;

import java.text.SimpleDateFormat;
//import java.sql.Date;
//import java.util.*;

import com.management.CheckBookRequestManagement;
import com.model.CheckBookRequest;
import com.util.ApplicationUtil;

public class CheckBookRequestService {
	CheckBookRequestManagement cm=new CheckBookRequestManagement();
	    ApplicationUtil au=new ApplicationUtil();
         public int insertCheckBookData(CheckBookRequest obj) {
        	       
        	    return cm.insertCheckBookRequestList(obj);
         }
         public String generateCheckBookId() {
        	 return au.generateCheckBookId();
         }
         public java.util.Date getRequestDate() {
        	 java.util.Date date=new java.util.Date();
        	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        	 String str=sdf.format(date);
        	 java.util.Date d=au.convertUtilDate(str);
        	 return d;
        	 
         }
         
         public int deleteCheckBookRequest(String id) {
        	 return cm.deleteRequest(id);
         }
         
         public String retrieveRequestId(long accNo) {
        	 return cm.retrieveRequestId(accNo);
         }
}
