package shixun.online.project.pojo;

import java.util.List;
/**
 * 题目实体类
 * */
public class Questions {
	//题目id
	private int qid;
	//题干
	private String title;
	//试卷id
	private int p_id;
	//答案集合
	private List<Anwser> anwser;
	public List<Anwser> getAnwser() {
		return anwser;
	}
	public void setAnwser(List<Anwser> anwser) {
		this.anwser = anwser;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
		
}
