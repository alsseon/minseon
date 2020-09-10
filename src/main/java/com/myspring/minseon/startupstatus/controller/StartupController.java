package com.myspring.minseon.startupstatus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface StartupController {
	public ModelAndView updatestartupesti(@RequestParam("sttoes_status") int sttoes_status, @RequestParam("startup_name") String startup_name, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
