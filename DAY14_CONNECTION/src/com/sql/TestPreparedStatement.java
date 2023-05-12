package com.sql;

import static com.sql.DButils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class TestPreparedStatement {

	public static void main(String[] args) throws SQLException {
try(Scanner sc=new Scanner(System.in);
	Connection cn=openConnection();	
		PreparedStatement pst=cn.prepareStatement("select first_name,last_name,reg_amt,reg_date from users where reg_date between ? and ?");
		
		
		
		
		
		){
	System.out.println("Enter the begin and last date");
	pst.setDate(1,Date.valueOf(sc.next()));
	pst.setDate(2,Date.valueOf(sc.next()));
	try(ResultSet rst=pst.executeQuery()){
		while(rst.next())
			System.out.println("Name "+rst.getString(1)+" "+rst.getString(2)+"Amount ="+rst.getDouble(3)+"date="+rst.getDate(4));
		
	}
	
}catch(Exception e) {
	e.printStackTrace();
}

	}

}
