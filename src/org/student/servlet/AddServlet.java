package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.ServiceImpl;
import org.student.servlet.QueryAllServlet;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddServlet() {
//        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//«Î«Û±‡¬Î
		request.setCharacterEncoding("UTF-8");
		int no=Integer.parseInt(request.getParameter("sno"));
		String name=request.getParameter("sname");
		int age=Integer.parseInt(request.getParameter("sage"));
		String address=request.getParameter("saddress");
		Student student=new Student(no,name,age,address);
		
		IStudentService studentService=new ServiceImpl();
		int result=studentService.addStudent(student);
		
		//œÏ”¶±‡¬Î
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		/*
		 * out request response session application
		 * out:			PrintWriter out=response.getWriter();
		 * session:		request.getSession()
		 * application:	request.getServletContext()
		 */
		if(result!=1){
			request.setAttribute("error", "addError");
		}else {
			request.setAttribute("error", "noaddError");
		}
		request.getRequestDispatcher("QueryAllServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
