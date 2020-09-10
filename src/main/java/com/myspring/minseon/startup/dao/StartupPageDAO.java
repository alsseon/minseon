package com.myspring.minseon.startup.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.minseon.startup.vo.StartuppageVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

public interface StartupPageDAO {

	int listCount() throws DataAccessException;

	List<StartuppageVO> selectAllEstiList(PageVO pagevo)throws DataAccessException;
	
	int esti_status(int e_status, String m_name) throws DataAccessException;

	//=====================================������ü ���� ��Ȳ ======================================================
	
	List<StartuppageVO> selectAllProdList(PageVO pagevo) throws DataAccessException;

	int prod_status(int prodstatus, String manuname) throws DataAccessException;

	//=====================================������ü ���� ��Ȳ ======================================================
	
	List<StartuppageVO> selectAllConsultingList(PageVO pagevo) throws DataAccessException;

	int con_status(int status, String expname)throws DataAccessException;

}
