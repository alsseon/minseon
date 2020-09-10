package com.myspring.minseon.startup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.minseon.startup.dao.StartupPageDAO;
import com.myspring.minseon.startup.vo.StartuppageVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

@Service("startuppageService")
public class StartuppageServiceImpl implements StartuppageService{
	@Autowired
	private StartupPageDAO startuppagedao;
	@Autowired
	private PageVO pagevo;
	public int listCount() throws DataAccessException{
		return startuppagedao.listCount();
	}
	public List<StartuppageVO> listesti(PageVO pagevo) throws DataAccessException{
		List<StartuppageVO> estilist = null;
		estilist = startuppagedao.selectAllEstiList(pagevo);
		return estilist;
	}
	public int updatestatus(int e_status, String m_name)throws DataAccessException{
		return startuppagedao.esti_status(e_status,m_name);
	}
	//==================================================제조업체 견적 현황 =====================================
	public List<StartuppageVO> listprod(PageVO pagevo) throws DataAccessException{
		List<StartuppageVO> prodlist = null;
		prodlist = startuppagedao.selectAllProdList(pagevo);
		return prodlist;
	}
	public int updatestatus_pord(int prodstatus, String manuname)throws DataAccessException{
		return startuppagedao.prod_status(prodstatus,manuname);
	}
	//==================================================제조업체 제조 현황 =====================================
	public List<StartuppageVO> listcon(PageVO pagevo) throws DataAccessException{
		List<StartuppageVO> conlist = null;
		conlist = startuppagedao.selectAllConsultingList(pagevo);
		return conlist;
	}
	public int updatestatus_con(int status, String expname)throws DataAccessException{
		return startuppagedao.con_status(status,expname);
	}
}
