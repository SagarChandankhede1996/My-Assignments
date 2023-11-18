package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Policy;
import com.model.PolicyHolder;



public class PolicyHolderRepository {
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
	public void insertUser(PolicyHolder policyHolder) {
		dbConnect();
		String sql="insert into PolicyHolder(name,age, username, password) values(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement= con.prepareStatement(sql);
			preparedStatement.setString(1, policyHolder.getName());
			preparedStatement.setInt(2, policyHolder.getAge());
			preparedStatement.setString(3, policyHolder.getUsername());
			preparedStatement.setString(4, policyHolder.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbClose();
	}
	public boolean doLogin(String userName, String password) {
		boolean status=false;
		dbConnect();
		String sql="select * from PolicyHolder where username=? and password=?";
		
		try {
			PreparedStatement preparedStatement= con.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			
			ResultSet rst = preparedStatement.executeQuery();
			if(rst.next()) {
				status=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		dbClose();
		return status;
	}
	public List<Policy> fetchAllProducts() {
		dbConnect();
		List<Policy> list = new ArrayList<Policy>();
		String sql = "select * from Policy";
		
		try {
			PreparedStatement preparedStatement= con.prepareStatement(sql);
			ResultSet rst = preparedStatement.executeQuery();
			while(rst.next()) {
				Policy policy=new Policy();
				policy.setId(rst.getInt("id"));
				policy.setTitle(rst.getString("title"));
				policy.setDescription(rst.getString("description"));
				policy.setTermDuration(rst.getInt("termDuration"));
				policy.setPremiumAmount(rst.getDouble("premiumAmount"));
				list.add(policy);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
}
