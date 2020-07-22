package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.impl.ServiceImpl;

@WebServlet("/QueryInfoBySnoServlet")
public class QueryInfoBySnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryInfoBySnoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		ServiceImpl dao = new ServiceImpl();
		Student student = dao.queryStudentBySno(sno);
		if (student != null) {
			request.setAttribute("student", student);
		} else {
			request.setAttribute("error", "��ѯʧ��");
		}
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);// �漰�����ݣ�����ת����������Ϣ��ʾҳ��
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}