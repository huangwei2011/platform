package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HellowPlat extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		response.setContentType("text/html");
        PrintWriter out;
        
		try {
			out = response.getWriter();
			 out.println("hellow platform");
		        out.flush();
		        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
