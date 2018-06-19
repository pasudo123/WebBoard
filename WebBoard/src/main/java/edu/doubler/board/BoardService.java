package edu.doubler.board;

import java.util.List;

import edu.doubler.domain.BoardContent;

public interface BoardService {
	
	public int getFullCountOnContent();
	
	public List<BoardContent> getBoardTableRows();
	
	public BoardContent getBoardContent(int pkn);
	
	public void addBoardContent(BoardContent boardContent);
	
	public void deleteBoardContent(int pkn);
	
	public void updateBoardContent(BoardContent boardContent);
}
