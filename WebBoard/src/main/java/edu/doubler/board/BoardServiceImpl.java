package edu.doubler.board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.doubler.domain.BoardContent;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	private static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	private static final String DATE_FORMAT = "yy/MM/dd";

	@Autowired
	BoardDao boardDao;

	@Override
	public int getFullCountOnContent() {
		return boardDao.getFullCountOnContent();
	}

	@Override
	public List<BoardContent> getBoardTableRows(Map<String, Integer> rangeMap) {
		List<BoardContent> boardTableRows = boardDao.getBoardTableRows(rangeMap);
		List<BoardContent> reverseTableRows = new ArrayList<BoardContent>();
		
		/** rownum 기준이기 때문에 역순으로 (reverse) 데이터 조정 : 서비스에서 설정 **/
		
		int size = boardTableRows.size();
		for(int i = size - 1; i >= 0; i--){
			reverseTableRows.add(boardTableRows.get(i));
		}
		
		return reverseTableRows;
	}

	@Override
	public BoardContent getBoardContent(int pkn) {
		return boardDao.getBoardContent(pkn);
	}

	@Override
	public void addBoardContent(BoardContent boardContent) {
//		String title = boardContent.getTitle();
//		String writer = boardContent.getWriter();
//		String content = boardContent.getContent();
		String today = null;
		int hitCount = 0;

//		 제목, 작성자, 내용
//		 logger.info(title);
//		 logger.info(writer);
//		 logger.info(content);

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT, Locale.KOREA);
		today = formatter.format(date);
		boardContent.setHit(hitCount);
		boardContent.setWriteDate(today);

		logger.info("게시글 내용 : " + boardContent.toString());
		boardDao.addBoardContent(boardContent);
	}

	@Override
	public void deleteBoardContent(int pkn) {
		boardDao.deleteBoardContent(pkn);
	}

	@Override
	public void updateBoardContent(BoardContent boardContent) {
		boardDao.updateBoardContent(boardContent);
	}

	@Override
	public Map<String, Integer> pagingProcessing(int currentPageBlock, int pagePosition) {
		logger.info(":: pagingProcessing ::");
		
		int count = getFullCountOnContent();
		PagingService pagingService = new PagingService();
		return pagingService.pagingProcess(currentPageBlock, pagePosition, count);
	}
	
	@Override
	public int movePrevProcessing(int currentPageBlock){
		logger.info(":: movePrevProcessing ::");
		PagingService pagingService = new PagingService();
		return pagingService.getPrevPage(currentPageBlock);
	}
	
	@Override
	public int moveNextProcessing(int currentPageBlock){
		logger.info(":: moveNextProcessing ::");
		PagingService pagingService = new PagingService();
		return pagingService.getNextPage(currentPageBlock);
	}
}
