package shixun.online.project.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shixun.online.project.pojo.Anwser;
import shixun.online.project.pojo.Paper;
import shixun.online.project.pojo.Questions;
import shixun.online.project.service.AnwserService;
import shixun.online.project.service.PaperService;
import shixun.online.project.service.QuestionsService;

@Controller
public class PaperController {

	@Autowired
	PaperService paperService;
	@Autowired
	QuestionsService questionsService;
	@Autowired
	AnwserService anwserService;
	//获得所有试卷	
	@RequestMapping("gopaper")
	public String gopaper(HttpSession session, Model model) {
		int totalPages = questionsService.getsQuestions();
		List<Paper> paper = paperService.getPapers();
		model.addAttribute("paper", paper);
		int[] a = new int[totalPages];
		session.setAttribute("answers", a);
		return "gopaper";
	}
	//得到第一页题目与答案
	@RequestMapping("goquestions")
	public String goquestions(HttpSession session, Model model, int pid,
			  @RequestParam(defaultValue = "1") int pageNum) {
		List<Questions> questions = questionsService.getAllQuestions(pid, pageNum);
		int totalPages = questionsService.getsQuestions();
		model.addAttribute("questions", questions);
		model.addAttribute("pageNums", pageNum);
		model.addAttribute("totalPage", totalPages);
		model.addAttribute("pids", pid);
		return "goquestions";
	}
	//记录答案
	@RequestMapping("istrue")
	public String istrue(HttpSession session, Model model, int pageNums, int istrue, HttpServletRequest request) {
		int[] a = (int[]) session.getAttribute("answers");
		a[pageNums - 1] = istrue;
		request.getSession().setAttribute("answers", a);
		return "goquestions";
	}
	//计算总分
	@RequestMapping("fraction")
	public String fraction(Model model, HttpSession session, int pid) {
		
		int i = 0;
		
		int[] as = (int[]) session.getAttribute("answers");
		
		for (int ass : as) {
			Anwser anwser = anwserService.allGetById(ass);
			if(anwser!=null) {
				if (anwser.getIstrue() == 1) {
					i = i + 2;
				}
			}else {
				
				System.out.println("此题没有答案");
			}

		}
		session.setAttribute("score", i);
		session.setAttribute("pid", pid);
		return "index";
	}

	//用json 将答案传到前端保存
	@RequestMapping("getSessionAnswers")
	@ResponseBody
	public int[] getSessions(HttpSession session) {
		return (int[]) session.getAttribute("answers");
	}
	
	//显示分数
	@RequestMapping("schoolreport")
	public String schoolreport(HttpSession session,Model model) {
		Paper paper= paperService.allPaperById((int) session.getAttribute("pid"));
		model.addAttribute("paper", paper);
		model.addAttribute("totalPages", questionsService.getsQuestions());
		return "schoolreport";
	}
}
