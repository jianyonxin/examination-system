package shixun.online.project.pojo;
/**
 * 学生实体类
 * */
public class Student {
	//学生id
	private int id;
	//学号
	private int studentid;
	//账号
	private String name;
	//密码
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

}
