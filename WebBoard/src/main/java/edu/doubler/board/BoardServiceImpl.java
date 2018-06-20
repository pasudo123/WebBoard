package edu.doubler.board;

import java.text.SimpleDateFormat;
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

		return boardTableRows;
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
	public Map<String, Integer> pagingProcessing(String pagePosition) {
		logger.info("pagePosition : " + pagePosition);
		
		PagingService pagingService = new PagingService();
		
		if("prev".equals("pagePosition")){
			return null;
		}
		else if("next".equals("pagePostion")){
			return null;
		}
		// 숫자
		else{
			int pageNumber = Integer.parseInt(pagePosition);
			pagingService.setCurrentPageNPosition(pageNumber);
			
			return pagingService.getPageNumber();
		}
	}
}
