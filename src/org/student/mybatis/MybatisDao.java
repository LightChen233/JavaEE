package org.student.mybatis;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.student.entity.Student;
import org.student.mapper.StudentMapper;


public class MybatisDao {
	Reader reader =Resources.getResourceAsReader("config.xml");
	SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
	SqlSession session=sessionFactory.openSession();
	StudentMapper studentMapper=session.getMapper(StudentMapper.class);
	public MybatisDao() throws IOException {
		
	}
	
	//查询单个学生
	public Student queryStudentBySno(int sno) throws IOException {
		Student student=studentMapper.queryStudentBySno(sno);
		return student;
//		System.out.println(student);
//		session.close();
	}
	//查询全部学生
	public List<Student> queryAllStudents() throws IOException {
		return studentMapper.queryAllStudents();
//		System.out.println(students);
		
	}
	//增加学生
	public void addStudent(Student student) throws IOException {
//			Student student=new Student(444,"ww",25);
		studentMapper.addStudent(student);
		session.commit();
//			System.out.println("增加成功！");
//			session.close();
	}
	//删除
	public int deleteStudentBySno(int sno) throws IOException {
		studentMapper.deleteStudentBySno(sno);
		session.commit();
		return 1;
//			System.out.println("删除"+count+"个人");
//			session.close();
	}
	//修改
	public int updateStudentBySno(Student student) throws IOException {
		studentMapper.updateStudentBySno(student);
		session.commit();
		return 1;
//		System.out.println("修改"+count+"个人");
//		session.close();
	}
	public List<Student> listStudentByName(String name) throws IOException {
		System.out.println(studentMapper.listStudentByName(name));
		return studentMapper.listStudentByName(name);
	}
	public List<Student> listStudent(int start,int count){
		return studentMapper.listByPage(start, count);
	}
	
	public int queryCount() {
		return studentMapper.queryCount();
	}
	
	//关闭sqlsession连接
		public void closeSession() {
			session.close();
		}
	//检查是否存在
		public boolean isExist(int sno) throws IOException {
			return queryStudentBySno(sno)!=null;
		}
		public static void main(String[] args) throws IOException {
		MybatisDao t=new MybatisDao();
//		t.deleteStudentBySno(15);
//		updateStudentBySno();
//		addStudent();
//		t.queryAllStudents();
//		t.listStudentByName("s");
		System.out.println(t.listStudent(0, 5));
		t.closeSession();
//		t.queryStudentBySno();
	}
}
