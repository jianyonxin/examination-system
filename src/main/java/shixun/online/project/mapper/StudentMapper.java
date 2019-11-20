package shixun.online.project.mapper;

import shixun.online.project.pojo.Student;
/**
 * 学生mapper
 * */
public interface StudentMapper {
	//根据名字查询学生
	public Student getByName(Student student);
}
