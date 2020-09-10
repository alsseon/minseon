package com.myspring.minseon.consulting.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.minseon.consulting.vo.ConsultingVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

public interface consultDAO {

	int listCount() throws DataAccessException;


	int consultingstatus(int status, String name) throws DataAccessException;

	List<ConsultingVO> selectAllconsulting(PageVO pagevo) throws DataAccessException;


}
