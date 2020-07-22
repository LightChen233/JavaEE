package org.student.service.impl;

import java.io.IOException;
import java.util.List;

import org.student.mybatis.MybatisDao;
import org.student.entity.Student;
import org.student.service.IStudentService;

//ҵ���߼��㣺�߼��Ե���ɾ�Ĳ飨������+����,��dao����е���װ
public class ServiceImpl implements IStudentService{
	MybatisDao md=new MybatisDao();
	public ServiceImpl() throws IOException{
		
	}

//	��
	public int addStudent(Student student) {
		try {
			if(!md.isExist(student.getSno())) {
				md.addStudent(student);
				return 1;
			}else {
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
		
	}
//	ɾ
	public int deleteStudentBySno(int sno) {
		try {
			if(md.isExist(sno)) {
				return md.deleteStudentBySno(sno);
			}else {
				return 0;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
//	��
	public int updateStudentBySno(int sno,Student student) {
		try {
			if(md.isExist(student.getSno())) {
				return md.updateStudentBySno(student);
			}else {
				return 0;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
//	��
	//����ѧ�Ų�ѯһ����
	public Student queryStudentBySno(int sno) {
		try {
			return md.queryStudentBySno(sno);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudents(){
		try {
			return md.queryAllStudents();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Student> LikeQueryStudents(String name) {
		try {
			return md.listStudentByName(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		ServiceImpl ss;
		try {
			ss = new ServiceImpl();
//			System.out.println(ss.addStudent(new Student(6,"asdf",11,"asdfa")));
			System.out.println(ss.queryAllStudents());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//��ѯ��ǰҳ���ݼ���
	@Override
	public List<Student> queryStudentsByPage(int start, int count) {
		return md.listStudent(start, count);
//		return studentDao.queryStudentsByPage(currentPage, pageSize);
	}
	//��ѯ����������
	@Override
	public int getTotalCount() {
		return md.queryCount();
	}
}
