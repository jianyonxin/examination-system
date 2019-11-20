package shixun.online.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shixun.online.project.mapper.StudentMapper;
import shixun.online.project.pojo.Student;
/**
 * 学生service
 * */
@Service
public class StudentService {
	@Autowired
	StudentMapper studentMapper;
	/**
	 * 根据名字查询是否有该学生
	 * */
	public Student getStudent(Student student) {
		Student student1 = studentMapper.getByName(student);
		//判断密码是否相等
		if (student1 != null&&student1.getPassword().equals(student.getPassword())) {

			return student1;
		} else {

			return null;
		}

	}

}
