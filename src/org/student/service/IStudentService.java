package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
//	��
	public int addStudent(Student student) ;
	
//	ɾ
	public int deleteStudentBySno(int sno) ;
	
//	��
	public int updateStudentBySno(int sno,Student student) ;
	
//	��
	//����ѧ�Ų�ѯһ����
	public Student queryStudentBySno(int sno) ;
	
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudents();
	
	public List<Student> queryStudentsByPage(int currentPage, int pageSize);
	
	public int getTotalCount();
	
}
