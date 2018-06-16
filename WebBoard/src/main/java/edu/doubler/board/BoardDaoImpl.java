package edu.doubler.board;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.doubler.domain.BoardContent;
import edu.doubler.util.EnumBoardMapper;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int getFullCountOnContent(){
		return sqlSession.selectOne(EnumBoardMapper.NAME_SPACE + "." + EnumBoardMapper.GET_FULL_COUNT_CONTENT);
	}
	
	@Override
	public List<BoardContent> getBoardTableRows(){
		return sqlSession.selectList(EnumBoardMapper.NAME_SPACE + "." + EnumBoardMapper.GET_BOARD_TABLE_ROWS);
	}

	@Override
	public void addBoardContent(BoardContent boardContent){
		sqlSession.insert(EnumBoardMapper.NAME_SPACE + "." + EnumBoardMapper.ADD_BOARD_CONTENT, boardContent);
	}
}
