package com.myspring.minseon.startup.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.minseon.startup.vo.StartuppageVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

@Repository("startuppagedao")
public class StartupPageDAOImpl implements StartupPageDAO{
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int listCount() throws DataAccessException{
		int listCount = (sqlSession).selectOne("mapper.startuppage.listCount");
		return listCount;
	}
	@Override
	public List<StartuppageVO> selectAllEstiList(PageVO pagevo) throws DataAccessException{
		List<StartuppageVO> estiList = null;
		estiList = sqlSession.selectList("mapper.startuppage.selectAllEstilist",pagevo);
		return estiList;
	}
	@Override
	public int esti_status(int e_status, String m_name) throws DataAccessException{
		int result = 0;
		if (e_status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_ing",m_name); //������ ���� ������ ������Ʈ
		}else if(e_status ==1) {
			result = sqlSession.update("mapper.startuppage.upstatus_complete",m_name); // ������ ���� �Ϸ�
		}
		return result;
	}
	//=========================================������ü ���� ��Ȳ ===========================================
	@Override
	public List<StartuppageVO> selectAllProdList(PageVO pagevo) throws DataAccessException{
		List<StartuppageVO> prodList = null;
		prodList = sqlSession.selectList("mapper.startuppage.selectAllProdlist",pagevo);
		return prodList;
	}
	@Override
	public int prod_status(int prodstatus, String manuname) throws DataAccessException{
		int result = 0;
		if (prodstatus == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_pord_ing",manuname); //������ ���������� ������Ʈ
		}else if(prodstatus ==1) {
			result = sqlSession.update("mapper.startuppage.upstatus_prod_complete",manuname); // ������ ���ۿϷ�� 
		}else if(prodstatus ==2) {
			result = sqlSession.update("mapper.startuppage.upstatus_sh",manuname); //������ �����������
		}else if(prodstatus ==3) {
			result = sqlSession.update("mapper.startuppage.upstatus_complete_sh",manuname); //������ �Ϸ��
		}
		return result;
	}
	//=========================================������ü ���� ��Ȳ ===========================================
	@Override
	public List<StartuppageVO> selectAllConsultingList(PageVO pagevo) throws DataAccessException{
		List<StartuppageVO> conList = null;
		conList = sqlSession.selectList("mapper.startuppage.selectAllConsultinglist",pagevo);
		return conList;
	}
	public int con_status(int status, String expname) throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_ing",expname); //������ ���������� ������Ʈ
		}else if(status ==1) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_complete",expname); // ������ ���ۿϷ�� 
		}
		return result;
	}
}
