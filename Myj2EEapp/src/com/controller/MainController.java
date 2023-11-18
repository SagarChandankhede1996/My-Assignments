package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.models.Products;
import com.models.Users;
import com.service.UserService;


/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private UserService userService=new UserService();  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		if(page == null)//we have to do it as page will go first for null parameter that time we have to load default page
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		if(page.equals("contact")) {
			request.getRequestDispatcher("contact.jsp").forward(request, response);
			return;
		}
		if(page.equals("all_products")) {
			//pass a variable message to jsp.file
			request.setAttribute("msg", "hi i'm a controller!");
			request.getRequestDispatcher("products.jsp").forward(request, response);
			return;
		}
		if(page.equals("sign_up")) {
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page"); 
		if(page.equalsIgnoreCase("sign_up_form")) {
			String name= request.getParameter("name");
			String userName=request.getParameter("email");
			String password=request.getParameter("password");
			
			Users user=new Users();
			user.setName(name);
			user.setUserName(userName);
			user.setPassword(password);
			
			userService.insertUser(user);
			
			request.setAttribute("msg", "Sign Up Seccess!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return; 
			
		}
		if(page.equalsIgnoreCase("login_form")) {
			String userName=request.getParameter("email");
			String password=request.getParameter("password");
			boolean status= userService.doLogin(userName, password);
			if(status== true) {
				List<Products> list= userService.fetchAllProducts();
				
				request.setAttribute("list_products", list);
				request.getRequestDispatcher("coustomer_dashboard.jsp").forward(request, response);
				return;
			} else {
				request.setAttribute("msg", "Invalid Credientials!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
		}
	}

}
