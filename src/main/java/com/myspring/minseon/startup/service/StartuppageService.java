package com.myspring.minseon.startup.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.minseon.startup.vo.StartuppageVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

public interface StartuppageService {
	public int listCount() throws DataAccessException;

	public List<StartuppageVO> listesti(PageVO pagevo) throws DataAccessException;

	public int updatestatus(int e_status, String m_name);

	//==============================제조업체 견적 현황====================================
	
	public List<StartuppageVO> listprod(PageVO pagevo) throws DataAccessException;

	public int updatestatus_pord(int prodstatus, String manuname);
	//==============================제조업체 제조 현황====================================
	
	public List<StartuppageVO> listcon(PageVO pagevo) throws DataAccessException;

	public int updatestatus_con(int status, String expname);
	
}
