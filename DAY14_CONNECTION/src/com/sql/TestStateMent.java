package com.sql;

import static com.sql.DButils.openConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class TestStateMent {
public static void main(String[] args) throws SQLException {
	try(Scanner sc=new Scanner(System.in);
		Connection cn=openConnection();
		Statement st=cn.createStatement();
		ResultSet rst=st.executeQuery("Select * from users order by first_name");
		
		
		
	){
		while(rst.next())
			 System.out.println("Id="+rst.getInt(1)+"Name="+rst.getString(2)+" "+rst.getString(3)+" email="+rst.getString(4)+"RegAmount="+rst.getDouble(6)+"Regdate="+rst.getDate(7));
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
