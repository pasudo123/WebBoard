package edu.doubler.board;

import java.util.List;

import edu.doubler.domain.BoardContent;

public interface BoardDao {
	
	public int getFullCountOnContent();
	
	public List<BoardContent> getBoardTableRows();
	
	public void addBoardContent(BoardContent boardContent);
}
