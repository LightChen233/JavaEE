package org.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.IStudentService;
import org.student.service.impl.ServiceImpl;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ɾ��
		request.setCharacterEncoding("UTF-8");
		//����ǰ�˴���ѧ��
		int no =Integer.parseInt(request.getParameter("sno"));
		IStudentService service=new ServiceImpl();
		int result=service.deleteStudentBySno(no);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(result==1) {
//			response.getWriter().println("ɾ���ɹ�");
			response.sendRedirect("QueryAllServlet");//���²�ѯ
		}else {
			response.getWriter().println("ɾ��ʧ��");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
