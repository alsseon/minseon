package com.myspring.minseon.consulting.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.minseon.consulting.vo.ConsultingVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

public interface ConsultService {
	public List<ConsultingVO> listconsulting(PageVO pagevo) throws DataAccessException;
	public int updatestatus(int status, String name);
	public int listCount() throws DataAccessException;
}
