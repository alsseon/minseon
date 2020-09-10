package com.myspring.minseon.consulting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.minseon.consulting.service.ConsultService;
import com.myspring.minseon.consulting.vo.ConsultingVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

@Controller("consultingController")
public class ConsultControllerImpl implements ConsultController{
	@Autowired
	private ConsultService consultservice;
	@Autowired 
	private ConsultingVO consultingvo;
	
	@RequestMapping(value = "/expert/consultinglist.do", method = RequestMethod.GET)
	private ModelAndView consultingList(PageVO pagevo, @RequestParam(value="nowPage", required= false)String nowPage, @RequestParam(value="cntPerPage",required = false)String cntPerPage,HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(viewName);
		int total = consultservice.listCount();
		System.out.println(total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "5";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<ConsultingVO> consultingList = consultservice.listconsulting(pagevo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("consultingList",consultingList);
		mav.addObject("pagevo",pagevo);
		System.out.println(mav);
		return mav;
	}
	@RequestMapping(value = "/expert/consulting_updatestatus.do", method = RequestMethod.GET)
	public ModelAndView updattestatus(@RequestParam("status") int status, @RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("¾È´¿");
		consultservice.updatestatus(status,name);
		ModelAndView mav = new ModelAndView("redirect:/expert/consultinglist.do");
		return mav;
	}
}
