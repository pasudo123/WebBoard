package edu.doubler.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.doubler.util.EnumOnBoardDao;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int getFullCountOnContent(){
		return sqlSession.selectOne(EnumOnBoardDao.NAME_SPACE + "." + EnumOnBoardDao.QUERY_THAT_GET_FULL_COUNT_ON__CONTENT);
	}
}
