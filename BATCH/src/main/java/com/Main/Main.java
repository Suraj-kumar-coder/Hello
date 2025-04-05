package com.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Studentdao.Studentdao;

import Student_model.Student;



public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println(" how many student are you added: ");
		int n = Integer.parseInt(sc.nextLine());
		
		List<Student> list = new ArrayList<>();
		
		
		//n loop will be stop when n==0
		while(n-->0)
		{
			Student student = new Student();
			System.out.println("enter the name");
			student.setName(sc.nextLine());
			System.out.println("enter email");
			student.setE_mail(sc.nextLine());
			System.out.println("enter Mobile");
			student.setMobile(sc.nextLine());
			System.out.println("enter age");
			student.setAge (Integer.parseInt(sc.nextLine()));
			System.out.println("enter password");
			student.setPassword(sc.nextLine());
			list.add(student);
			
			
		}
		Studentdao dao = new Studentdao();
		 dao.batchinsert(list);
		
		 
		 
		

	}

}
