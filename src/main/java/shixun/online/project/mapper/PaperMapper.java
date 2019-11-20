package shixun.online.project.mapper;

import java.util.List;

import shixun.online.project.pojo.Paper;
/**
 * 试卷mapper
 * */
public interface PaperMapper {
	//得到所有试卷
	public List<Paper> getPaper();
	//根据id查询试卷
	public Paper getPaperById( int pid);

}
