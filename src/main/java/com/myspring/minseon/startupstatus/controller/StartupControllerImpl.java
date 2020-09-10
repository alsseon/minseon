package com.myspring.minseon.startupstatus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.minseon.startupstatus.service.StartupService;
import com.myspring.minseon.startupstatus.vo.ManufacVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

@Controller("manufacController")
public class StartupControllerImpl implements StartupController{
	@Autowired
	private StartupService startupService;
	@Autowired
	private ManufacVO manufacvo;
	
	@RequestMapping(value = "/startup/statuslist.do", method = RequestMethod.GET)
	private ModelAndView startupList(PageVO pagevo, @RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required=false)String cntPerPage,HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(viewName);
		int total = startupService.listCount();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		System.out.println(cntPerPage);
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<ManufacVO> startupList = startupService.liststartup(pagevo);
		System.out.println(startupList);
		ModelAndView mav = new ModelAndView();
		mav.addObject("startupList",startupList);
		mav.addObject("pagevo",pagevo);
//		mav.addObject("setTotalCount", setTotalCount);
		System.out.println(mav);
		return mav;
		
	}


	@RequestMapping(value = "/startup/startup_updatestatus.do", method = RequestMethod.GET)
	public ModelAndView updatestartupesti(@RequestParam("sttoes_status") int sttoes_status, @RequestParam("startup_name") String startup_name, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("¾È³ç");
		System.out.println(sttoes_status);
		startupService.updatestartup_esti(sttoes_status, startup_name);
		ModelAndView mav = new ModelAndView("redirect:/startup/statuslist.do");
		System.out.println(mav);
		return mav;
	}
}
