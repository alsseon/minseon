package com.myspring.minseon.startupstatus.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.minseon.startupstatus.vo.ManufacVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

@Repository("startuppdao")
public class StartuppDAOImpl implements StartuppDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ManufacVO> selectAllstartup(PageVO pagevo) throws DataAccessException{
		List<ManufacVO> startupList = null;
		startupList = sqlSession.selectList("mapper.startup.selectAllstartup",pagevo);

		return startupList;
	}
	
	@Override
	public int listCount() throws DataAccessException{
		int listCount = sqlSession.selectOne("mapper.startup.listCount");
		return listCount;
	}
	public int startupstatus(int sttoes_status, String startup_name) throws DataAccessException{
		int result = 0;
		if(sttoes_status == 0) {
			result = sqlSession.update("mapper.startup.upstatus_estreceipt", startup_name);//���� ����
		}else if(sttoes_status == 1) {
			result = sqlSession.update("mapper.startup.upstatus_order_request", startup_name);//���� ��û
		}else if(sttoes_status == 2) {
			result = sqlSession.update("mapper.startup.upstatus_produc_receipt", startup_name);//��ǰ����
		}else if(sttoes_status == 3) {
			result = sqlSession.update("mapper.startup.upstatus_invoice_complete", startup_name);//��꼭���� �Ϸ�
		}else if(sttoes_status == 4) {
			result = sqlSession.update("mapper.startup.upstatus_complete", startup_name);//�Ϸ�
		}
		System.out.println(result);
		return result;	
	}
}
