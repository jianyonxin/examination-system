package shixun.online.project.pojo;
/**
 * 答案实体类
 * */
public class Anwser {
	//答案id
	private int aid;
	//答案内容
	private String content;
	//是否为正确答案
	private int istrue;
	//题目id
	private int questions_id;
	//题目集合
	private Questions questions;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIstrue() {
		return istrue;
	}
	public void setIstrue(int istrue) {
		this.istrue = istrue;
	}
	public int getQuestions_id() {
		return questions_id;
	}
	public void setQuestions_id(int questions_id) {
		this.questions_id = questions_id;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

}
