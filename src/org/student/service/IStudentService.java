package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
//	增
	public int addStudent(Student student) ;
	
//	删
	public int deleteStudentBySno(int sno) ;
	
//	改
	public int updateStudentBySno(int sno,Student student) ;
	
//	查
	//根据学号查询一个人
	public Student queryStudentBySno(int sno) ;
	
	//查询全部学生
	public List<Student> queryAllStudents();
	
	public List<Student> queryStudentsByPage(int currentPage, int pageSize);
	
	public int getTotalCount();
	
}
