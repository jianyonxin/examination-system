package shixun.online.project.mapper;

import java.util.List;


import shixun.online.project.pojo.Questions;
/**
 * 题目mapper
 * */
public interface QuestionsMapper {
	 
	//根据试卷id获得题目
	public List<Questions> getQuestions(int pid,int start,int count);
	//得到题目总数
	public int getssArrQuestions();
}
