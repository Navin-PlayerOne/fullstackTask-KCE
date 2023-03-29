package com.kce.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import com.kce.dao.RegisterDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class DeleteHandler
 */
@WebServlet("/DeleteHandler")
public class DeleteHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println(email);
		boolean result = new RegisterDao().deleteUser(email);
		PrintWriter printWriter = response.getWriter();
		if(result) {
			printWriter.write("true");
		}
		else {
			printWriter.write("false");
		}
	}

}
