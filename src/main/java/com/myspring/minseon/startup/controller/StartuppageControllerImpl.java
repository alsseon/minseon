package com.myspring.minseon.startup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.minseon.startup.service.StartuppageService;
import com.myspring.minseon.startup.vo.StartuppageVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

@Controller("startuppageController")
public class StartuppageControllerImpl implements StartuppageController{
	@Autowired
	private StartuppageService startuppageservice;
	@Autowired
	private StartuppageVO startuppagevo;
	
	@RequestMapping(value = {"/startuppage/manu_estilist.do","/startuppage/manu_estilist_sh.do" },method = RequestMethod.GET)
	private ModelAndView estilist(PageVO pagevo, @RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required = false)String cntPerPage,HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.listCount();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartuppageVO> estilist = startuppageservice.listesti(pagevo);
		List<StartuppageVO> manulist = startuppageservice.listprod(pagevo);
		List<StartuppageVO> conlist = startuppageservice.listcon(pagevo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("estilist",estilist);
		mav.addObject("manulist",manulist);
		mav.addObject("conlist",conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = {"/startuppage/manu_esti_updatestatus.do"}, method = RequestMethod.GET)
	public ModelAndView updatestatus(@RequestParam("e_status") int e_status, @RequestParam("m_name") String m_name, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.updatestatus(e_status,m_name);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist.do");
		return mav;
	}
	@RequestMapping(value = {"/startuppage/manu_esti_updatestatus_sh.do"}, method = RequestMethod.GET)
	public ModelAndView updatestatus_sh(@RequestParam("e_status") int e_status, @RequestParam("m_name") String m_name, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.updatestatus(e_status,m_name);// 제조업체 견적 현황
		
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist_sh.do");
		return mav;
	}
	// ==============================================제조업체 견적 요청 ===================================================================
	
	@RequestMapping(value = "/startuppage/manu_list.do",method = RequestMethod.GET)
	private ModelAndView manulist(PageVO pagevo, @RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required = false)String cntPerPage,HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.listCount();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		System.out.println("여기는 와?");
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartuppageVO> manulist = startuppageservice.listprod(pagevo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("manulist",manulist);
		
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = {"/startuppage/manu_updatestatus.do"}, method = RequestMethod.GET)
	public ModelAndView manu_updatestatus(@RequestParam("prodstatus") int prodstatus, @RequestParam("manuname") String manuname, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.updatestatus_pord(prodstatus,manuname);
		System.out.println("들어와?");
		System.out.println(prodstatus);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_list.do");
		return mav;
	}
	@RequestMapping(value = {"/startuppage/manu_updatestatus_sh.do"}, method = RequestMethod.GET)
	public ModelAndView manu_updatestatus_sh(@RequestParam("prodstatus") int prodstatus, @RequestParam("manuname") String manuname, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		// 제조업체 견적 현황
		startuppageservice.updatestatus_pord(prodstatus, manuname); //제조업체 제조 현황
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist_sh.do");
		return mav;
	}
	//=========================================제조업체 제조 현황==============================================================
	@RequestMapping(value = "/startuppage/consulting_list.do",method = RequestMethod.GET)
	private ModelAndView m(PageVO pagevo, @RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required = false)String cntPerPage,HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.listCount();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartuppageVO> conlist = startuppageservice.listcon(pagevo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("conlist",conlist);
		
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = {"/startuppage/con_updatestatus.do"}, method = RequestMethod.GET)
	public ModelAndView con_updatestatus(@RequestParam("status") int status, @RequestParam("expname") String expname, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.updatestatus_con(status,expname);
		System.out.println("들어와?");
		System.out.println(status);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/consulting_list.do");
		return mav;
	}
	@RequestMapping(value = {"/startuppage/con_updatestatus_sh.do"}, method = RequestMethod.GET)
	public ModelAndView con_updatestatus_sh(@RequestParam("status") int status, @RequestParam("expname") String expname, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		startuppageservice.updatestatus_con(status, expname); //제조업체 제조 현황
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist_sh.do");
		return mav;
	}
	//=========================================컨설팅 현황==============================================================
}
