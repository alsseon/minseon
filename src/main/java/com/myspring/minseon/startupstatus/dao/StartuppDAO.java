package com.myspring.minseon.startupstatus.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.minseon.startupstatus.vo.ManufacVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

public interface StartuppDAO {

	List<ManufacVO> selectAllstartup(PageVO pagevo) throws DataAccessException;

	int startupstatus(int sttoes_status, String startup_name) throws DataAccessException;

	int listCount() throws DataAccessException;




}
