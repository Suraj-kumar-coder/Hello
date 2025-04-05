package com.Studentdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Student_model.Student;

public class Studentdao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/batchdb","suraj","1234");
	}
  
	public int[] batchinsert(List<Student> list) throws SQLException, ClassNotFoundException
	{
		int [] result =null;
		Connection con = null;
		PreparedStatement st = null;
		
		con = Studentdao.getConnection();
		
		try {
		st = con.prepareStatement("Insert into student(NAME, E_MAIL,MOBILE,AGE,PASSWORD) VALUES(?,?,?,?,?)");
		
		for(Student std:list)
		{
			st.setString(1,std.getName());
			st.setString(2,std.getE_mail());
			st.setString(3, std.getMobile());
			st.setInt(4, std.getAge());
			st.setString(5, std.getPassword());
			st.addBatch();
		}
		
		result = st.executeBatch();
		System.out.println("success");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
			st.close();
			con.close();
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		
	
		
		
		return result;
	}
}
