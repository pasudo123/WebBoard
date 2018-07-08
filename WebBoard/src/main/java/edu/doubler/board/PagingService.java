package edu.doubler.board;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PagingService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final int VIEW_CONTENT_COUNT = 10;	// 한 페이지에 보여줄 글의 수
	private static final int VIEW_PAGE_COUNT = 5;		// 한 화면당 페이지의 수
	private static final int NONE = -1;
	
	public Map<String, Integer> pagingProcess(int pageBlock, int page, int contentCount){

		/**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 
		 * 	  - 현재 페이지블록, 현재 페이지, 전체 데이터 개수
		 * 
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/
		
		Map<String, Integer> pageInfo = new HashMap<String, Integer>();
		
		int currentPageBlock = 0;
		
		if(pageBlock == NONE) // 페이지 클릭
			currentPageBlock = getCurrentPageBlock(page);
		else
			currentPageBlock = pageBlock;
		
		int lastTableRowNum = contentCount - (VIEW_CONTENT_COUNT * (page - 1));
		int startTableRowNum = lastTableRowNum - (VIEW_CONTENT_COUNT - 1);
		if(startTableRowNum < 0)
			startTableRowNum = 0;
		
		logger.info("pageBlock : " + pageBlock);
		logger.info("page : " + page);
		logger.info("contentCount : " + contentCount);
		logger.info("startTableRowNum : " + startTableRowNum);
		logger.info("lastTableRowNum : " + lastTableRowNum);
		logger.info("------------------------------");
		
		pageInfo.put("startNumber", startTableRowNum);
		pageInfo.put("endNumber", lastTableRowNum);
		
		int startPage = getStartPageOnBlock(currentPageBlock);
		int lastPage = getLastPageOnBlock(currentPageBlock);
		int beginPageBlock = getBeginBlockOnBoard();
		int endPageBlock = getEndpageBlockOnBoard(contentCount);
		int endPage = getEndPageOnBoard(contentCount);
		
		pageInfo.put("currentPageBlock", currentPageBlock);
		pageInfo.put("startPage", startPage);
		pageInfo.put("lastPage", lastPage);
		pageInfo.put("beginPageBlock", beginPageBlock);
		pageInfo.put("endPageBlock", endPageBlock);
		pageInfo.put("endPage", endPage);
		
		return pageInfo;
	}
	
	// 현재 페이지블록을 통해 이전 페이지블록의 첫번째 페이지 획득
	public int getPrevPage(int currentPageBlock){
		int prevPage = getStartPageOnBlock(currentPageBlock-1);
		
		return prevPage;
	}
	
	// 현재 페이지블록을 통해 다음 페이지블록의 첫번째 페이지 획득 ( 이전 혹은 다음 버튼 클릭 시 작동 )
	public int getNextPage(int currentPageBlock){
		int nextPage = currentPageBlock * VIEW_PAGE_COUNT + 1;
		
		/**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 
		 * e.g. pageBlock = 1, nextPage = pageBlock * 5 + 1 = 6
		 * e.g. pageBlock = 2, nextPage = pageBlock * 5 + 1 = 11
		 * 
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/
		
		return nextPage;
	}
	
	// 현재 페이지를 통해 현재 페이지 블록 확인
	private int getCurrentPageBlock(int page){
		int pageBlock = (page % VIEW_PAGE_COUNT != 0)? page / VIEW_PAGE_COUNT + 1 : page / VIEW_PAGE_COUNT;
		
		/**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 *	
		 * e.g. page = 1, (page % 5 != 0)?  ... 
		 * e.g. page = 3, (page % 5 != 0)? **(3 / 5 + 1 = 1) : (3 / 5); , pageBlock = 1;
		 * e.g. page = 5, (page % 5 != 0)? (5 / 5 + 1 = 2) : **(5 / 5); , pageBlock = 1;
		 * e.g. page = 7, (page % 5 != 0)? **(7 / 5 + 1 = 2) : (7 / 5); , pageBlock = 2;
		 * 
		 * - 위에서 순서대로 좌우좌 형태로 선택
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/
		
		return pageBlock;
	}
	
	// 현재 페이지블록의 첫번째 페이지 값 획득
	private int getStartPageOnBlock(int currentPageBlock){
		int startPage = (currentPageBlock * VIEW_PAGE_COUNT) - (VIEW_PAGE_COUNT - 1);
		
		/**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 *	
		 * e.g. currentPageBlock = 1, (1 * 5) - (5 - 1) = 1;
		 * e.g. currentPageBlock = 2, (2 * 5) - (5 - 1) = 6;
		 * e.g. currentPageBlock = 3, (3 * 5) - (5 - 1) = 11;
		 * e.g. currentPageBlock = 4, (4 * 5) - (5 - 1) = 16;
		 * 
		 * - 위에서 순서대로 좌우좌 형태로 선택
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/
		
		return startPage;
	}
	
	// 현재 페이지 블록의 마지막 페이지 값 획득 
	private int getLastPageOnBlock(int currentPageBlock){
		int lastPage = (currentPageBlock * VIEW_PAGE_COUNT);
		return lastPage;
	}
	
	// 게시판의 첫번째 페이지블록 획득 ( view 상에서 [이전] 버튼을 보여주지 않기 위함 )
	private int getBeginBlockOnBoard(){
		return 1;
	}
	
	// 게시판의 마지막 페이지블록 획득 ( view 상에서 [다음] 버튼을 보여주지 않기 위함 )
	private int getEndpageBlockOnBoard(int contentCount){
		int endPageBlock = (contentCount % (VIEW_CONTENT_COUNT * VIEW_PAGE_COUNT) != 0)? (contentCount / (VIEW_CONTENT_COUNT * VIEW_PAGE_COUNT) + 1):(contentCount / (VIEW_CONTENT_COUNT * VIEW_PAGE_COUNT));
		return endPageBlock;
	}
	
	// 게시판의 마지막 페이지 값 획득 ( view 상에서 마지막 페이지 블록에 마지막 페이지 만큼만 보여주기 위해서 )
	private int getEndPageOnBoard(int contentCount){
		int endPage = (contentCount % VIEW_CONTENT_COUNT != 0)? (contentCount / VIEW_CONTENT_COUNT + 1) : (contentCount / VIEW_CONTENT_COUNT);
		
		return endPage;
	}
}
