package edu.doubler.board;

import java.util.HashMap;
import java.util.Map;

// 싱글톤 구성 및 동기화 처리
public class PagingService {
	private static final int PRINT_CONTENT_COUNT = 10;	// 한 페이지에 보여줄 글의 수
	private static final int PRINT_PAGE_COUNT = 5;		// 한 화면당 페이지의 수
	
	private Integer currentPagePosotion = null;			// 현재 페이지 번호
	private Integer currentPageBlock = null;			// 현재 페이지 블록
	
	// setter()
	public void setCurrentPageNPosition(Integer currentPagePosotion) {
		this.currentPagePosotion = currentPagePosotion;
	}

	public void setCurrentPageBlock(Integer currentPageBlock) {
		this.currentPageBlock = currentPageBlock;
	}
	
	public Map<String, Integer> getPageNumber(){
		int endNumber = currentPagePosotion * PRINT_CONTENT_COUNT;
		int startNumber = endNumber - (PRINT_CONTENT_COUNT-1);
		
		Map<String, Integer> rangeMap = new HashMap<String, Integer>();
		rangeMap.put("startNumber", startNumber);
		rangeMap.put("endNumber", endNumber);
		
		return rangeMap;
	}
}
