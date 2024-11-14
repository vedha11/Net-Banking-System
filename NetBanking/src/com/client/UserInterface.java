package com.client;
import java.util.*;
import com.model.Account;
import com.model.CheckBookRequest;
//import com.model.Login;
import com.model.Profile;
import com.model.Transactions;
import com.service.*;
//import java.sql.Date;
public class UserInterface {
 public static void main(String[] args) {
	 ProfileService ps=new ProfileService();
	 LoginService logser=new LoginService();
	 AccountService accser=new AccountService();
	 CheckBookRequestService cheser=new CheckBookRequestService();
	 TransactionService transer=new TransactionService();
	 try (Scanner sc = new Scanner(System.in)) {
		int choice=0;
		
		 do {
			 System.out.println("1.Login");
			 System.out.println("2.Register");
			 System.out.println("3.Exit");
			 System.out.println("Enter the choice");
			 choice=sc.nextInt();
			 sc.nextLine();
			 switch(choice){
				 case 1:{
					 
					 System.out.println("Enter the user name");
					 String username=sc.next();
					 System.out.println("Enter the password");
					 String pwd=sc.next();
					 int option=0;
					 if(logser.checkUserId(username,pwd)) {
						 do {
							 System.out.println("1. Profile");
							 System.out.println("2. Account");
							 System.out.println("3. Transaction");
							 System.out.println("4. CheckBook Request");
							 System.out.println("5. Logout");
							 System.out.println("Enter the choice");
							 option=sc.nextInt();
							 switch(option) {
							 case 1:{
								 int option_profile=0;
								 do {
									 System.out.println("1. View Profile");
									 System.out.println("2. Update Profile");
									 System.out.println("3. Delete Profile");
									 System.out.println("4. Exit");
									 System.out.println("Enter the choice");
									 option_profile=sc.nextInt();
									 switch(option_profile) {
										 case 1:{
											 System.out.println("Enter the Customer Id");
											 String custId=sc.next();
											 Profile pobj=ps.retrieveProfile(custId);
											 if(pobj==null) {
												 System.out.println("Profile not found");
											 }
											 else {
												 System.out.println("Customer Id : "+pobj.getCustomerId());
												 System.out.println("Customer Name : "+pobj.getCustomerName());
												 String date=ps.utilToString(pobj.getDob());
												 System.out.println("Date of Birth : "+date);
												 System.out.println("Email Id : "+pobj.getEmailId());
												 System.out.println("Address : "+pobj.getAddress());
												 System.out.println("Contact Number : "+pobj.getContactNumber());
											 }
											 break;
										 }
										 case 2:{
											 System.out.println("Enter the Customer Id");
											 String custId=sc.next();
											 sc.nextLine();
											 Profile pobj=ps.retrieveProfile(custId);
											 if(pobj==null) {
												 System.out.println("Profile not found");
											 }
											 else {
												 System.out.println("Enter the new address");
												 String newAdd=sc.nextLine();
												 int status=ps.updateAddress(newAdd, custId);
												 if(status>0)
												 {
													 System.out.println("Address updated successfully");
												 }
												 else {
													 System.out.println("Please provide valid Customer Id");
												 }
											 }
											 break;
										 }
										 case 3:{
											 System.out.println("Enter the Customer Id");
											 String custId=sc.next();
											 sc.nextLine();
											 Profile pobj=ps.retrieveProfile(custId);
											 if(pobj==null) {
												 System.out.println("Profile not found");
											 }
											 else {
												 int result=ps.deleteProfile(custId);
												 if(result>0) {
													 System.out.println("Profile deleted successfully");
												 }
												 else {
													 System.out.println("Please provide valid Customer Id");
												 }
											 }
											 break;
										 }
									 }
								 }while(option_profile!=4);
								 break;
							 }
							 case 2:{
								 int option_account=0;
								 do {
										 System.out.println("1. Account Creation");
										 System.out.println("2. View Account Details");
										 System.out.println("3. View Transaction Details");
										 System.out.println("4. Delete Account");
										 System.out.println("5. Exit");
										 System.out.println("Enter the choice");
										 option_account=sc.nextInt();
										 sc.nextLine();
										 switch(option_account) {
											 case 1:{
												 System.out.println("Enter the Customer_Id");
												 String custid=sc.nextLine();
											
												 Profile pobj=ps.retrieveProfile(custid);
												 if(pobj==null) {
													 System.out.println("Profile not in the database");
												 }
												 else {
													 String id=pobj.getCustomerId();
													 String name=pobj.getCustomerName();
													 long contact=pobj.getContactNumber();
													 String email=pobj.getEmailId();
													 long accno=accser.createAccountNo();
													 System.out.println("Enter the Bank Name");
													 String bankName=sc.nextLine();
													 System.out.println("Enter the Account Type");
													 String acctype=sc.nextLine();
													 System.out.println("Enter deposit amount");
													 double balance=sc.nextDouble();
													 sc.nextLine();
													 System.out.println("Enter the Branch");
													 String branch=sc.nextLine();
													 System.out.println("Enter the IFSC_Code");
													 String ifsc=sc.nextLine();
													 System.out.println("Enter the ID Proof Type");
													 String idtype=sc.nextLine();
													 System.out.println("Enter the ID Proof Number");
													 String idno=sc.next();
													 Account aobj=new Account(id,name,contact,email,accno,bankName,acctype,balance,branch,ifsc,idtype,idno);
													 int status=accser.addAccountDetails(aobj);
													 if(status>0) {
														 System.out.println("Account created successfully");
														 System.out.println("Your Account No : "+accser.retrieveAccountNo(email));
														 
													 }
													 else {
														 System.out.println("Please enter the correct password");
													 }
												 } 
												 break;
	                                         }
											 case 2:{
												 System.out.println("Enter the Account Number");
												 long accno=sc.nextLong();
												 Account aobj=accser.retriveAccountDetails(accno);
												 if(aobj==null) {
													 System.out.println("Account not found");
												 }
												 else {
													 System.out.println("Customer Id : "+aobj.getCustomer_id());
													 System.out.println("Customer Name : "+aobj.getCustomer_name());
													 System.out.println("Contact Number : "+aobj.getContact_number());
													 System.out.println("Email Id : "+aobj.getEmail_id());
													 System.out.println("Account Number : "+aobj.getAccount_number());
													 System.out.println("Bank Name : "+aobj.getBank_name());
													 System.out.println("Account Type : "+aobj.getAccount_type());
													 System.out.println("Balance : "+aobj.getBalance());
													 System.out.println("Branch : "+aobj.getBranch());
													 System.out.println("IFSC Code : "+aobj.getIFSC_code());
													 System.out.println("IDProof Type : "+aobj.getIDProof_type());
													 System.out.println("IDProof Number : "+aobj.getIDProof_number());
												 }
												 break;
											 }
											 case 3:{
												 System.out.println("Enter the Account Number");
												 long accno=sc.nextLong();
												 Account aobj=accser.retriveAccountDetails(accno);
												 if(aobj==null) {
													 System.out.println("Account not found");
												 }
												 else {
													List<Transactions> list=new ArrayList<Transactions>();
													list=accser.retrieveTransaction(accno);
													if(list.isEmpty()) {
														System.out.println("No transaction made");
													}
													else {
														for(Transactions obj:list) {
															System.out.println("Transaction Id : "+obj.getTransactionId());
															System.out.println("Customer Id : "+obj.getCustomerId());
															System.out.println("Customer Name : "+obj.getCustomerName());
															System.out.println("Account Number : "+obj.getAccountNumber());
															System.out.println("Sender Name : "+obj.getSenderName());
															System.out.println("Sender Account : "+obj.getSenderAccountNumber());
															System.out.println("Amount : "+obj.getAmount());
															System.out.println("Transaction Date : "+obj.getTransactionDate());
															System.out.println("Status : "+obj.getStatus());
														}
														
													}
												 }
												 break;
											 }
											 case 4:{
												 System.out.println("Enter the Account Number");
												 long accno=sc.nextLong();
												 Account aobj=accser.retriveAccountDetails(accno);
												 if(aobj==null) {
													 System.out.println("Account not found");
												 }
												 else {
													 int result=accser.deleteAccount(accno);
													 if(result>0) {
														 System.out.println("Account deleted successfully");
													 }
													 else {
														 System.out.println("Please provide valid Account No");
													 }
												 }
												 break;
											 }
											 case 5:{
												 System.out.println("Thank you...!!!");
												 break;
											 }
										 }
											 
									}while(option_account!=5);
								 break;
							 }
							 case 3:{
								 int tran_option=0;
								 do{
									 System.out.println("1. Money Transfer");
									 System.out.println("2. Balance Enquiry");
									 System.out.println("3. Exit");
									 System.out.println("Enter the choice");
									 tran_option=sc.nextInt();
									 switch(tran_option) {
									     case 1:{
									    	 System.out.println("Enter the sender account no");
									    	 long sender=sc.nextLong();
									    	 Account a1=accser.retriveAccountDetails(sender);
									    	 if(a1==null) {
									    		 System.out.println("Account number not exists");
									    	 }
									    	 else {
										    	 System.out.println("Enter the receiver account no");
										    	 long receiver=sc.nextLong();
										    	 sc.nextLine();
									    	     Account a2=accser.retriveAccountDetails(receiver);
									    	     if(a2==null) {
									    	    	 System.out.println("Account number not exists");
									    	     }
									    	     else {
									    	    	 System.out.println("Enter the Transaction Type");
									    	    	 String ttype=sc.nextLine();
									    	    	 System.out.println("Enter the amount");
									    	    	 double amount=sc.nextDouble();
									    	    	 int result=transer.depositAmount(a1, a2,ttype,amount);
									    	    	 if(result==1) {
									    	    		 System.out.println("Transaction successfull");
									    	    	 }
									    	    	 else if(result==0) {
									    	    		 System.out.println("Insufficient Balance");
									    	    		 System.out.println("Transaction failed");
									    	    	 }
									    	    	
									    	    	 
									    	     }
									    	 }
									    	 break;
									     }
									     case 2:{
									    	 System.out.println("Enter the Account No");
									    	 long accno=sc.nextLong();
									    	 Account obj=accser.retriveAccountDetails(accno);
									    	 if(obj!=null) {
									    		 System.out.println("Available Balance : "+obj.getBalance());
									    	 }
									    	 else {
									    		 System.out.println("Account number not exists");
									    	 }
									    	 break;
									     }
									     case 3:{
									    	 System.out.println("Thank you...!!!");
									    	 break;
									     }
									   
									 }
								 }while(tran_option!=3);
								 break;
							 }
							 case 4:{
								 int check_option=0;
								 do {
									 System.out.println("1. Request Generation");
									 System.out.println("2. Delete Request");
									 System.out.println("3. Exit");
									 System.out.println("Enter yor choice");
									 check_option=sc.nextInt();
									 switch(check_option) {
										 case 1:
											 System.out.println("Enter the Account Number");
											 long accNo=sc.nextLong();
											 Account aobj=accser.retriveAccountDetails(accNo);
											 if(aobj==null) {
												 System.out.println("Account not in the database");
											 }
											 else {
												 String requestId=cheser.generateCheckBookId();
												 String custId=aobj.getCustomer_id();
												 String name=aobj.getCustomer_name();
												 long accountNo=aobj.getAccount_number();
												 String accounttype=aobj.getAccount_type();
												 String bankName=aobj.getBank_name();
												 java.util.Date requestDate=cheser.getRequestDate();
												 CheckBookRequest obj=new CheckBookRequest(requestId,custId,name,accountNo,accounttype,bankName,requestDate);
												 int status=cheser.insertCheckBookData(obj);
												 if(status>0) {
													 System.out.println("Request created successfully");
													 System.out.println("Your Request Id : "+cheser.retrieveRequestId(accountNo));
												 }
												 else {
													 System.out.println("Please provide valid customer id");
												 }
											 }
											 
											 break;
										 case 2:
											 System.out.println("Enter the Request Id");
											 String rId=sc.next();
											 int status=cheser.deleteCheckBookRequest(rId);
											 if(status>0) {
												 System.out.println("Request deleted successfully");
											 }
											 else {
												 System.out.println("Please provide valid request id");
											 }
											 break;
										 case 3:
											 System.out.println("Thank you...!!!");
											 break;
									 }
								 }while(check_option!=3);
								 
								 break;
							 }
							 case 5:{
								 System.out.println("Thank you for reaching us");
								 break;
							 }
							 }
						 }while(option!=5);
					 }
					 else {
						 System.out.println("Please enter valid username and password");
					 }
					 break;
				 }
				 case 2:{
					 System.out.println("Enter the details(name:dob(yyyy-MM-dd):emailid:address:contactno):");
					 String s=sc.nextLine();
					 String arr[]=s.split(":");
					 String email=arr[2];
					 String name=arr[0];
					 String dob=arr[1];
					 int status=ps.addProfileList(s);
					 if(status>0) {
						 System.out.println("Profile created successfully");
						 System.out.println("Your Customer Id is : "+ps.retrieveCustomerId(email));
						 boolean flag=true;
						 //System.out.println("Enter the user Id");
						 String userName=logser.createUserId(name, dob);
						 System.out.println("Your User Id is : "+userName);
						 while(flag) {
							 System.out.println("Enter the new password");
							 String newPwd=sc.next();
							 System.out.println("Enter the confirmation password");
							 String conPwd=sc.next();
							 if(logser.checkPassword(newPwd, conPwd)==1) {
								 int x=logser.addLoginDetails(userName,newPwd);
								 System.out.println("User Id and Password generated successfully ");
								 flag=false;
							 }
							 else if(logser.checkPassword(newPwd, conPwd)==-1) {
								 System.out.println("New password and confirm password must be same");
							 }
							 else if(logser.checkPassword(newPwd, conPwd)==0) {
								System.out.println("Password must contain atleast One uppercase,lower case and special character"); 
							 }
						 }
					 }
					 else {
						 System.out.println("Please provide valid record");
					 }
					 
					 break;
				 }
				 case 3:{
					 System.out.println("Thank you for using our application");
					 break;
				 }
			 }
		 }while(choice<3);
	}
}
}
