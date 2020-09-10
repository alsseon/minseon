package com.myspring.minseon.consulting.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface ConsultController {
	public ModelAndView updattestatus(@RequestParam("status") int status, @RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
