package shixun.online.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shixun.online.project.mapper.QuestionsMapper;
import shixun.online.project.pojo.Questions;
/**
 * 题目service
 * */
@Service
public class QuestionsService {
	@Autowired
	QuestionsMapper questionsMapper;
	//实现分页 ，一页一题
	public List<Questions> getAllQuestions(int pid, int pageNum) {

		int start = (pageNum - 1)*4;

		int count = 4;
		return questionsMapper.getQuestions(pid, start, count);
	}
	//获得题目总数
	public int getsQuestions() {
		return questionsMapper.getssArrQuestions();

	}

}
