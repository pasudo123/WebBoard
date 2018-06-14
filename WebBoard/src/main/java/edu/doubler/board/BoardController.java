package edu.doubler.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.doubler.domain.BoardContent;


@Controller
public class BoardController {
	
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showBoardList(){
		
		int count = boardService.getFullCountOnContent();
		
		return "boardViews/demo";
	}
	
	@RequestMapping(value="/list/{boardProcess}")
	public String boardProcess(
	@PathVariable String boardProcess,
	@ModelAttribute("boardContent") BoardContent boardContent){
		
		if("write".equals(boardProcess))
			return "boardViews/write";
		
		return null;
	}
	
	@RequestMapping(value="/list/write/data", method=RequestMethod.POST)
	public String boardProcess(
	@ModelAttribute("boardContent") BoardContent boardContent){
		
		// 글 작성
		logger.info("게시글 작성 시도");
		boardService.addBoardContent(boardContent);
		logger.info("게시글 작성 완료");
		
		return "redirect:/list";
	}
}
