package shixun.online.project.pojo;

import java.util.List;
/**
 * 试卷实体类
 * */
public class Paper {
	//试卷id
	private int pid;
	//试卷名字
	private String pname;
	//试卷分数
	private String score;
	//详细信息
	private String information;
	//题目集合
	private List<Questions> questions;
	public List<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	
}
