package com.controller;

import java.util.Scanner;

import com.models.Employee;
import com.service.EmployeeService;

public class EmployeeController {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		EmployeeService employeService=new EmployeeService();
		while(true) {
			System.out.println("******Employee DB Ops********");
			System.out.println("1. Insert Employee");
			System.out.println("2. Fetch All Employee");
			System.out.println("3. Fetch Employee by Id");
			System.out.println("4. Delete Employee by Id");
			System.out.println("5. Filter the Salary");
			System.out.println("6. Filter the City");
			System.out.println("0. to Exit");
			System.out.println("*******************\n");
			
			int input=sc.nextInt();//1 2 3 4 5 6 0
			if(input==0) {
				System.out.println("Exiting Bye...");
				break;//Exiting while loop
			}
			switch (input) {
			case 1:
				Employee employee=new Employee();
				System.out.println("Enter the Name");
				employee.setName(sc.next());
				System.out.println("Enter the Email");
				employee.setEmail(sc.next());
				System.out.println("Enter the Salary");
				employee.setSalary(sc.nextDouble());
				System.out.println("Enter the City");
				employee.setCity(sc.next());
				employeService.insertEmployee(employee);
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			default:
				System.out.println("Invalid Input, Try Again!");
				break;
			}
		}
	}
}
