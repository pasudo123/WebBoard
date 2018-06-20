package edu.doubler.board;

import java.util.List;
import java.util.Map;

import edu.doubler.domain.BoardContent;

public interface BoardDao {
	
	public int getFullCountOnContent();
	
	public List<BoardContent> getBoardTableRows(Map<String, Integer> rangeMap);
	
	public BoardContent getBoardContent(int pkn);
	
	public void addBoardContent(BoardContent boardContent);
	
	public void deleteBoardContent(int pkn);
	
	public void updateBoardContent(BoardContent boardContent);
}
