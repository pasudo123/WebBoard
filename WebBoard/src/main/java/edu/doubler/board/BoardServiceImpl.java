package edu.doubler.board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.doubler.domain.BoardContent;

@Service
public class BoardServiceImpl implements BoardService{
	
	private static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	private static final String DATE_FORMAT = "yy/MM/dd";
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public int getFullCountOnContent(){
		return boardDao.getFullCountOnContent();
	}
	
	@Override
	public void addBoardContent(BoardContent boardContent){
		String title = boardContent.getTitle();
		String writer = boardContent.getWriter();
		String content = boardContent.getContent();
		String today = null;
		int hitCount = 0;
		
		// 제목, 작성자, 내용
//		logger.info(title);
//		logger.info(writer);
//		logger.info(content);
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT, Locale.KOREA);
		today = formatter.format(date);
		boardContent.setHit(hitCount);
		boardContent.setDate(today);
		
		logger.info("게시글 내용 : " + boardContent.toString());
		boardDao.addBoardContent(boardContent);
	}
	
	@Test
	public void test(){
		Date today = new Date();
		String outToday = new String();
		
		System.out.println(today);
		
		SimpleDateFormat formatter1;
		SimpleDateFormat formatter2;
		SimpleDateFormat formatter3;
		SimpleDateFormat formatter4;
		SimpleDateFormat formatter5;
		
		String format1 = "yy/MM/dd";
		formatter1 = new SimpleDateFormat(format1, Locale.KOREA);
		outToday = formatter1.format(today);
		System.out.println(outToday);
	}
}
