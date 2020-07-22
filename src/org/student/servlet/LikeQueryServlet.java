package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.impl.ServiceImpl;

/**
 * Servlet implementation class LikeSearchServlet
 */
@WebServlet("/LikeQueryServlet")
public class LikeQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServiceImpl service=new ServiceImpl();
		String name=request.getParameter("sname");
		List<Student> students=service.LikeQueryStudents(name);
		System.out.println(students);
		if(students!=null) {
			//设置并传输数据集students
			request.setAttribute("students", students);
		}else {
			request.setAttribute("error", "操作失败");
		}
		
		//因为request域中有数据，因此需要通过请求转发的方式跳转
		//pageContxet<request<session<application
		request.getRequestDispatcher("queryforms.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
