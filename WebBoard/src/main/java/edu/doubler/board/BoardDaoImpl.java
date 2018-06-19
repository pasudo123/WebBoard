package edu.doubler.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.doubler.domain.BoardContent;
import edu.doubler.util.EnumBoardMapper;

@Repository("BoardDao")
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
	public BoardContent getBoardContent(int pkn){
		// 조회수 +1 & 게시글 획득
		sqlSession.update(EnumBoardMapper.NAME_SPACE + "." + EnumBoardMapper.UPDATE_READ_COUNT, pkn);
		return sqlSession.selectOne(EnumBoardMapper.NAME_SPACE + "." + EnumBoardMapper.GET_BOARD_CONTENT, pkn);
	}

	@Override
	public void addBoardContent(BoardContent boardContent){
		sqlSession.insert(EnumBoardMapper.NAME_SPACE + "." + EnumBoardMapper.ADD_BOARD_CONTENT, boardContent);
	}
	
	@Override
	public void deleteBoardContent(int pkn){
		sqlSession.delete(EnumBoardMapper.NAME_SPACE + "." + EnumBoardMapper.DELETE_BOARD_CONTENT, pkn);
	}
	
	@Override
	public void updateBoardContent(BoardContent boardContent){
		sqlSession.update(EnumBoardMapper.NAME_SPACE + "." + EnumBoardMapper.UPDATE_BOARD_CONTENT, boardContent);
	}
}
