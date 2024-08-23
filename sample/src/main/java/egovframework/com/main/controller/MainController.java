package egovframework.com.main.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.main.service.MainService;

@Controller
public class MainController {
	
	@Resource(name="MainService")
	private MainService mainService;
	
	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}

	@RequestMapping("/main/student.do")
	public ModelAndView student() {
		ModelAndView mv = new ModelAndView("main/student");
		List<HashMap<String, Object>> list = mainService.selectStudentInfo();
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/main/score.do")
	public ModelAndView score() {
		ModelAndView mv = new ModelAndView("main/score");
		List<HashMap<String, Object>> scorelist = mainService.selectStudentScore();
		mv.addObject("list", scorelist);
		return mv;
	}
	
	@RequestMapping("/sessionTest.do")
	public ModelAndView sessionTest(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("main");
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			System.out.println("최초방문");
		}else {
			String sessionId = session.getId();
			System.out.println("세션 ID: "+ sessionId);
		}
		
		return mv;
	}
	
	@RequestMapping("/sessionNumberTest.do")
	public ModelAndView sessionTest(HttpSession session) {
		ModelAndView mv = new ModelAndView("main");
		
		Integer randomNumber = (Integer)session.getAttribute("random-number");
		if (randomNumber == null) {
			Integer generated = new Random().nextInt();
			System.out.println("generate-random-number : " + generated.toString());
			session.setAttribute("random-number", generated);
		} else {
			System.out.println("my random-number : " + randomNumber.toString());
		}
		
		return mv;
	}
	
	@RequestMapping("/cookieTest.do")
	public ModelAndView sessionTest(HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("main");
		
		Cookie cookie = new Cookie("message", URLEncoder.encode("from main", "UTF-8"));
		response.addCookie(cookie);
		
					return mv;
	}
	
}
