package com.myspring.minseon.startupstatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.minseon.startupstatus.dao.StartuppDAO;
import com.myspring.minseon.startupstatus.vo.ManufacVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

@Service("startupService")
public class StartupServiceImpl implements StartupService{
	@Autowired
	private StartuppDAO startuppdao;
	@Autowired
	private PageVO pagevo;
	
	public List<ManufacVO> liststartup(PageVO pagevo) throws DataAccessException{
		List<ManufacVO> startupList = null;
		startupList = startuppdao.selectAllstartup(pagevo);
		
		return startupList;
	}
	
	public int listCount() throws DataAccessException {
		return startuppdao.listCount();
	}
	public int updatestartup_esti(int sttoes_status, String startup_name) throws DataAccessException{
		return startuppdao.startupstatus(sttoes_status, startup_name);
	}
	
	
}
