package shixun.online.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shixun.online.project.mapper.AnwserMapper;
import shixun.online.project.pojo.Anwser;
/**
 * 答案service
 * */
@Service
public class AnwserService {
	@Autowired
	AnwserMapper anwserMapper;
	/**
	 * 根据id来查询答案
	 * */
	public Anwser allGetById(int aid) {
		return anwserMapper.getAnwserById(aid);
	}

}
