package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Page;
import org.student.entity.Student;
import org.student.service.impl.ServiceImpl;

/**
 * Servlet implementation class QueryStudentByPageServlet
 */
@WebServlet("/QueryStudentByPageServlet")
public class QueryStudentByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStudentByPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServiceImpl service=new ServiceImpl();
		Page page=new Page();
		String cNum=request.getParameter("currentNum");
		if(cNum==null) {
			cNum="0";
		}
		int currentPage= Integer.parseInt(cNum);
		String cSize=request.getParameter("pageSize");
		if(cSize==null){
			cSize="5";
		}
		int pageSize =Integer.parseInt(cSize);
		int totalCount=service.getTotalCount();
		page.setTotalCount(totalCount);
		page.setPageSize(pageSize);
		page.setCurrentPage(currentPage);
		
		List<Student> students=service.queryStudentsByPage(page.getCurrentNum(), page.getPageSize());
		System.out.println(students);
		if(students!=null) {
			//设置并传输数据集students
			request.setAttribute("students", students);
			request.setAttribute("page", page);
		}else {
			request.setAttribute("error", "操作失败");
		}
		
		//因为request域中有数据，因此需要通过请求转发的方式跳转
		//pageContxet<request<session<application
		request.setAttribute("page", page);
		request.getRequestDispatcher("forms.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
