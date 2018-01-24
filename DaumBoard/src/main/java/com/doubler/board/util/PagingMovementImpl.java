package com.doubler.board.util;

import java.util.HashMap;

public class PagingMovementImpl implements PagingMovement {
	
	private BoardPaging boardPaging = null;
	
	public PagingMovementImpl(){
		boardPaging = new BoardPaging();
	}
	
	@Override
	public void chooseMovement(String paging) {
		if(paging.equals("begin")){
			moveBeginBlock();
			return;
		}
		
		if(paging.equals("prev")){
			movePrevBlock();
			return;
		}
		
		if(paging.equals("next")){
			moveNextBlock();
			return;
		}
		
		if(paging.equals("end")){
			moveEndBlock();
			return;
		}
		
		int pageNum = Integer.parseInt(paging);
		movePage(pageNum);
	}
	
	@Override
	public HashMap<String, Integer> moveBeginBlock() {
		// 처음 페이지 블록
		boardPaging.setCurrentBlock(boardPaging.getFirstBlock());
		boardPaging.setCurrentPage(boardPaging.getFirstPageNum());
		
		return boardPaging.getPagingInformation();
	}

	@Override
	public HashMap<String, Integer> movePrevBlock() {
		// 이전 페이지 블록으로
		boardPaging.setCurrentBlock(boardPaging.getCurrentBlock() - 1);
		boardPaging.setCurrentPage(boardPaging.getCurrentBlock() * BoardPaging.PRINT_PAGE_COUNT);
		
		return boardPaging.getPagingInformation();
	}

	@Override
	public HashMap<String, Integer> moveNextBlock() {
		// 다음 페이지 블록으로
		boardPaging.setCurrentBlock(boardPaging.getCurrentBlock() + 1);
		boardPaging.setCurrentPage(boardPaging.getCurrentBlock()*BoardPaging.PRINT_PAGE_COUNT - (BoardPaging.PRINT_PAGE_COUNT - 1));
	
		return boardPaging.getPagingInformation();
	}

	@Override
	public HashMap<String, Integer> moveEndBlock() {
		// 마지막 페이지 블록으로
		boardPaging.setCurrentBlock(boardPaging.getLastBlock());
		boardPaging.setCurrentPage(boardPaging.getLastPageNum());;
		
		return boardPaging.getPagingInformation();
	}

	@Override
	public HashMap<String, Integer> movePage(int pageNum) {
		boardPaging.setCurrentPage(pageNum);
		
		return boardPaging.getPagingInformation();
	}
}
