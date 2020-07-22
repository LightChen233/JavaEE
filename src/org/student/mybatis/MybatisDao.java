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
	
	//��ѯ����ѧ��
	public Student queryStudentBySno(int sno) throws IOException {
		Student student=studentMapper.queryStudentBySno(sno);
		return student;
//		System.out.println(student);
//		session.close();
	}
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudents() throws IOException {
		return studentMapper.queryAllStudents();
//		System.out.println(students);
		
	}
	//����ѧ��
	public void addStudent(Student student) throws IOException {
//			Student student=new Student(444,"ww",25);
		studentMapper.addStudent(student);
		session.commit();
//			System.out.println("���ӳɹ���");
//			session.close();
	}
	//ɾ��
	public int deleteStudentBySno(int sno) throws IOException {
		studentMapper.deleteStudentBySno(sno);
		session.commit();
		return 1;
//			System.out.println("ɾ��"+count+"����");
//			session.close();
	}
	//�޸�
	public int updateStudentBySno(Student student) throws IOException {
		studentMapper.updateStudentBySno(student);
		session.commit();
		return 1;
//		System.out.println("�޸�"+count+"����");
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
	
	//�ر�sqlsession����
		public void closeSession() {
			session.close();
		}
	//����Ƿ����
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
