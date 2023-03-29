package com.kce.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import com.kce.dao.RegisterDao;
import com.kce.model.Register;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

@jakarta.servlet.annotation.WebServlet("/register")
public class register extends jakarta.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private Register getUserRegisterationDataFromRequest(HttpServletRequest request) {
		Register user = new Register();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setBirthDay(request.getParameter("birthDay"));
		user.setGender(request.getParameter("inlineRadioOptions"));
		user.setEmail(request.getParameter("email"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setMemberShip(request.getParameter("memberShip"));
		
		return user;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Register user = getUserRegisterationDataFromRequest(request);
		RegisterDao registerUser = new RegisterDao();
		boolean result = registerUser.insertRegistration(user);
		PrintWriter printWriter = response.getWriter();
		if(result) {
			printWriter.write("true");
//			System.out.println("Registration success");
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("registeredlist.jsp");
//			requestDispatcher.forward(request, response);
		}
		else {
			printWriter.write("false");
//			PrintWriter pw = response.getWriter();
//			pw.write("Registration failed");
		}
	}

}
