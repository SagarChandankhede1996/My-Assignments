package com.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.models.Employee;


public class EmployeeRepository {
	
	private String url="jdbc:mysql://localhost:3306/jdbcapp";
	private String userdb="root";
	private String passdb="";
	private String driver="com.mysql.jdbc.Driver";
	Connection con;
	public void dbConnect() {
		try {
			Class.forName(driver);
//			System.out.println("driver loaded...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			con = DriverManager.getConnection(url, userdb, passdb);
//			System.out.println("conn established");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void dbClose() {
		try {
			con.close();
//			System.out.println("DB closed...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insertEmployee(Employee employee) {
		
		dbConnect();
		String sql="insert into employee(name, email, salary, city) values(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.setString(4, employee.getCity());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		dbClose();
	}
	 


}
