package com.myspring.minseon.startupstatus.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.minseon.startupstatus.vo.ManufacVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

public interface StartupService {

	public List<ManufacVO> liststartup(PageVO pagevo) throws DataAccessException;

	public int updatestartup_esti(int sttoes_status, String startup_name);

	public int listCount() throws DataAccessException;
}
