package com.repository;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.Products;
import com.models.Users;

import java.sql.Connection;

public class UserRepository {

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
	
	
	public void insertUser(Users user) {
		dbConnect();
		String sql="insert into users(name, username, password) values(?,?,?)";
		
		try {
			PreparedStatement preparedStatement= con.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
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
		String sql="select * from users where username=? and password=?";
		
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
	public List<Products> fetchAllProducts() {
		dbConnect();
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products";
		
		try {
			PreparedStatement preparedStatement= con.prepareStatement(sql);
			ResultSet rst = preparedStatement.executeQuery();
			while(rst.next()) {
				Products products=new Products();
				products.setId(rst.getInt("id"));
				products.setTitle(rst.getString("title"));
				products.setShort_des(rst.getString("short_des"));
				products.setCategory(rst.getString("category"));
				products.setPrice(rst.getDouble("price"));
				list.add(products);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		dbClose();
		return list;
	}

}
