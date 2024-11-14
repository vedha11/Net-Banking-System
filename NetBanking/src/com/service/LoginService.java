package com.service;


import com.management.LoginManagement;
import com.model.Login;
import com.util.ApplicationUtil;

public class LoginService {
	public int checkPassword(String pwd1,String pwd2) {
		if(pwd1.equals(pwd2)) {
			if(validPassword(pwd1)) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			return -1;
		}
	}
	public boolean validPassword(String s) {
		int lc=0,uc=0,num=0,spe=0;
		char[]arr=s.toCharArray();
		for(char x:arr) {
			if(Character.isDigit(x)) {
				num++;
			}
			else if(Character.isUpperCase(x)) {
				uc++;
			}
			else if(Character.isLowerCase(x)) {
				lc++;
			}
			else {
				spe++;
			}
		}
		if(lc==0 || uc==0 || num==0 || spe==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public int addLoginDetails(String userName,String newPwd) {
		Login lobj=new Login(userName,newPwd);
		LoginManagement lm=new LoginManagement();
		int status=lm.insertLoginList(lobj);
		return status;
	}
	public boolean checkUserId(String userId,String pwd) {
		LoginManagement lm=new LoginManagement();
		return lm.checkUserExists(userId, pwd);
	}
	public String createUserId(String name,String dob) {
		ApplicationUtil au=new ApplicationUtil();
		return au.createUserId(name, dob);
	}
}
