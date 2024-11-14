package com.util;
import java.text.ParseException;
//import com.model.*;
import java.text.SimpleDateFormat;
import java.util.*;
//import java.sql.*;
import java.sql.Date;

//import com.model.*;
public class ApplicationUtil{
	public java.sql.Date convertDate(String date) {
		Date d=null;
		d = Date.valueOf(date);
		return d;
	}
	public String generateProfileId() {
		Random rand=new Random();
		int max=999,min=100;
		int pid=rand.nextInt(max-min+1)+min;
		String s="PRONET"+pid;
		return s;
		
	}
	
	public String generateCheckBookId() {
		Random rand=new Random();
		int max=999,min=100;
		int checkid=rand.nextInt(max-min+1)+min;
		String s="CHECK"+checkid;
		return s;
	}
	
	public String generateTransactionId() {
		Random rand=new Random();
		int max=99999,min=10000;
		int tid=rand.nextInt(max-min+1)+min;
		String s="TRANS"+tid;
		return s;
	}
	public java.sql.Date convertSqlDate(java.util.Date obj){
		java.sql.Date d1=new java.sql.Date(obj.getTime());
		return d1;
	}
	public String convertStringDate(java.sql.Date obj){
		return obj.toString();
	}
	public String utilToString(java.util.Date d) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d);
		return date;
	}
	public java.util.Date convertUtilDate(String date){
		java.util.Date obj=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			obj=sdf.parse(date);
					
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public java.util.Date getCurrentDate(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date obj=new java.util.Date();
		String date=sdf.format(obj);
		return convertUtilDate(date);
	}
	
	public String createUserId(String name,String dob) {
		String s="";
		String arr[]=dob.split("-");
		s=name+arr[0];
		return s;
	}
}
	
