package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Policy;
import com.model.PolicyHolder;

import com.service.PhService;



/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PhService phService=new PhService();  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		if(page == null)//we have to do it as page will go first for null parameter that time we have to load default page
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		if(page.equals("login")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
			Integer age=Integer.parseInt(request.getParameter("age"));
			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			
			PolicyHolder policyHolder=new PolicyHolder();
			
			policyHolder.setName(name);
			policyHolder.setAge(age);
			policyHolder.setUsername(userName);
			policyHolder.setPassword(password);
			
		    phService.insertUser(policyHolder);
			
			request.setAttribute("msg", "Sign Up Seccess!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return; 
			
		}
		if(page.equalsIgnoreCase("login_form")) {
			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			boolean status= phService.doLogin(userName, password);
			if(status== true) {
				List<Policy> list= phService.fetchAllProducts();
				
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
