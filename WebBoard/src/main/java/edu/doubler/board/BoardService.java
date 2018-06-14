package edu.doubler.board;

import edu.doubler.domain.BoardContent;

public interface BoardService {
	
	public int getFullCountOnContent();
	
	public void addBoardContent(BoardContent boardContent);
}
