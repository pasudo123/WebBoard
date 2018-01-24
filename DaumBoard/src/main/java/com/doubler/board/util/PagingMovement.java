package com.doubler.board.util;

import java.util.HashMap;

public interface PagingMovement {
	
	//-- 페이지 이동 관련
	public void chooseMovement(String paging);					// 이동 결정
	public HashMap<String, Integer> moveBeginBlock();			// 처음 페이지 블록
	public HashMap<String, Integer> movePrevBlock();			// 이전 페이지 블록
	public HashMap<String, Integer> moveNextBlock();			// 이후 페이지 블록
	public HashMap<String, Integer> moveEndBlock();				// 끝 페이지 블록
	public HashMap<String, Integer> movePage(int pagingNum);	// 단순 페이지 이동
}
