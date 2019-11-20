package shixun.online.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shixun.online.project.mapper.PaperMapper;
import shixun.online.project.pojo.Paper;
/**
 * 试卷service
 * */
@Service
public class PaperService {
	@Autowired
	PaperMapper paperMapper;
	/**
	 * 得到试卷集合
	 * */
	public List<Paper> getPapers(){
		return paperMapper.getPaper();	
	}
	/**
	 * 根据id查询试卷
	 * */
	public Paper allPaperById(int pid) {
		return paperMapper.getPaperById(pid);
	}
}
