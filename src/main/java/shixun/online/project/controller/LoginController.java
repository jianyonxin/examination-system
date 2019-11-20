package shixun.online.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shixun.online.project.pojo.Student;
import shixun.online.project.service.StudentService;

@Controller
public class LoginController {
	@Autowired
	StudentService studentService;
	//登录页面
	@RequestMapping("/")
	public String gologin() {
		
		
		return "login";
 			
	}
	//登录成功，进入首页
	@RequestMapping("dologin")
	public String dologin(Student student,Model model,HttpSession session) {
		   Student studentz=studentService.getStudent(student);
		   if(studentz!=null) {
			   session.setAttribute("studentz", studentz);

			   return "index";
			   
		   }else {
			   
			   model.addAttribute("tips", "账号或者密码错误!");
			   return "login";
		   }
	}

}
