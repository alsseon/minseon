package com.myspring.minseon.consulting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.minseon.consulting.dao.consultDAO;
import com.myspring.minseon.consulting.vo.ConsultingVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

@Service("consultService")
public class ConsultServiceImpl implements ConsultService{
	@Autowired
	private consultDAO consultdao;
	@Autowired
	private PageVO pagevo;
	
	public int listCount() throws DataAccessException{
		return consultdao.listCount();
	}
	public List<ConsultingVO> listconsulting(PageVO pagevo) throws DataAccessException{
		List<ConsultingVO> consultingList = null;
		consultingList = consultdao.selectAllconsulting(pagevo);
		return consultingList;
	}
	public int updatestatus(int status, String name) throws DataAccessException{
		// TODO Auto-generated method stub
		return consultdao.consultingstatus(status,name);
	}
}
