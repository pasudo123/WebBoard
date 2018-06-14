package edu.doubler.board;

import edu.doubler.domain.BoardContent;

public interface BoardDao {
	
	public int getFullCountOnContent();
	
	public void addBoardContent(BoardContent boardContent);
}
