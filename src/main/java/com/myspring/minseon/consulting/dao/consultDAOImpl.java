package com.myspring.minseon.consulting.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.minseon.consulting.vo.ConsultingVO;
import com.myspring.minseon.startupstatus.vo.PageVO;

@Repository("consultdao")
public class consultDAOImpl implements consultDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int listCount() throws DataAccessException{
		int listCount = sqlSession.selectOne("mapper.consulting.listCount");
		return listCount;
	}
	@Override
	public List<ConsultingVO> selectAllconsulting(PageVO pagevo) throws DataAccessException{
		List<ConsultingVO> consultingList = null;
		consultingList = sqlSession.selectList("mapper.consulting.selectAllconsulting",pagevo);
		return consultingList;
	}
	public int consultingstatus(int status, String name) throws DataAccessException{
		int result = 0;
		if(status == 0) {
			result = sqlSession.update("mapper.consulting.upstatus_ing",name); //견적 수령
		}else if(status ==1) {
			result = sqlSession.update("mapper.consulting.upstatus_complete",name); //견적 중
		}
		return result;
	}
}
