package org.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.student.entity.Student;

//操作MyBatis的接口
public interface StudentMapper {
	public void addStudent(Student student);
	public void deleteStudentBySno(int id);
	public void updateStudentBySno(Student student);
	public Student queryStudentBySno(int id);
	public List<Student> queryAllStudents();
	public List<Student> listStudentByName(String name);
	public List<Student> listByPage(@Param("start") int start, @Param("count")int count);
	public int queryCount();
}
