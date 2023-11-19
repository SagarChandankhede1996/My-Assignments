package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.Product;

public class ProductRepository {

	private String url = "jdbc:mysql://localhost:3306/jdbcapp";
	private String userdb = "root";
	private String passdb = "";
	private String driver = "com.mysql.jdbc.Driver";
	Connection con;

	public void dbConnect() {

		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, userdb, passdb);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dbClose() {
		try {
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertModel(Product model) {
		dbConnect();
		// sql query
		String sql = "insert into model (name, price, catogory) values(?,?,?)";
		try {
			// took from java.sql package
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			// input data took form model(pojo) class
			preparedStatement.setString(1, model.getName());
			preparedStatement.setDouble(2, model.getPrice());
			preparedStatement.setString(3, model.getCategory());
			// execute script
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbClose();
	}

	public List<Product> fetchAllProducts() {
		dbConnect();

		String sql = "select * from model";
		List<Product> list = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rst = preparedStatement.executeQuery();
			while (rst.next()) {
				Product model = new Product();
				// fetch each column from DB and save it in a object
				model.setId(rst.getInt("id"));
				model.setName(rst.getString("name"));
				model.setPrice(rst.getDouble("price"));
				model.setCategory(rst.getString("catogory"));
				// save obj in list
				list.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbClose();

		return list;
	}

	public Product getOneModelById(int id) {

		dbConnect();
		Product model = new Product();
		String sql = "select * from model where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rst = preparedStatement.executeQuery();
			if (rst.next()) {
				model.setId(rst.getInt("id"));
				model.setName(rst.getString("name"));
				model.setPrice(rst.getDouble("price"));
				model.setCategory(rst.getString("catogory"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbClose();
		return model;

	}

	public void deleteModel(int id) {
		dbConnect();
		String sql = "delete from model where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dbClose();
	}

}
