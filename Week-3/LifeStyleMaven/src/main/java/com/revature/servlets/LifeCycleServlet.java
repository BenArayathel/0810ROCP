package main.java.com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet{
	
	/*
	 * Servlet(I) -> GenericServlet(AC) -> HttpServlet(AC)
	 *	Which methods are implemented (none of them) -> (init() and destroy()) -> (Service() )
	 * doGet
	 * 
	 * doPost
	 * 
	 * doDelete
	 * 
	 * doPut
	 * 
	 */
	
	/*
	 * init()
	 * 
	 * service()
	 * 
	 * destroy()
	 * 
	 * 
	 */
	
	@Override
	public void init() throws ServletException {
		System.out.println("Inside init");
		super.init();
		
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Inside service");
		super.service(req, res);
	}
	
	@Override
	public void destroy() {
		System.out.println("Inside destroy");
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		System.out.println("Inside get");
		doPost(req,res);
		doDelete(req,res);
		//asdf
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		System.out.println("Inside post");
		
	}
	
	
}
