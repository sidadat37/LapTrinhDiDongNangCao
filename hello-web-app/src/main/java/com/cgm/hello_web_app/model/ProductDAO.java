package com.cgm.hello_web_app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	public String url, user, pwd;
	public Connection conn = null;
	List<Product> product;
	public List<Product> getAllProducts(){
		//1. connect to db
		url = "jdbc:mysql://localhost:3306/product";
		user = "root";
		pwd = "26072003";	
		PreparedStatement pst;
		String query = "Select * from products";
		ResultSet res;
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create a connection to db
			conn = DriverManager.getConnection(url, user, pwd);
			pst = conn.prepareStatement(query);
			res = pst.executeQuery();
			product = new ArrayList<Product>();
			while (res.next()) {
				String name = res.getString("name");
				double price = res.getDouble("price");
				String img = res.getString("image");
				Product pro = new Product(name,price,img);
				product.add(pro);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Success");
		//System.out.println(product);
		return product;
	}
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
//		productDAO.getAllProducts();
		System.out.println(productDAO.getAllProducts()); 
//		Connection conn = DAO.getConnect();
		Product pro = new Product("New item",12543, "Productadd.js");
//		productDAO.CreateProduct(pro, conn);
//		productDAO.delete(5, conn);
//		productDAO.Update(5, pro, conn);
//		System.out.println(productDAO.getProductByID(5,conn).getName());
	}
}
