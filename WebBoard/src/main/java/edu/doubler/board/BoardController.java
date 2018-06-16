package edu.doubler.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.doubler.domain.BoardContent;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showBoardList(Model model){
		
		int count = boardService.getFullCountOnContent();
		List<BoardContent> boardTableRows = boardService.getBoardTableRows();
		
		model.addAttribute("boardTableRows", boardTableRows);
		
		return "boardViews/list";
	}
	
	@RequestMapping(value="/write")
	public String boardProcess(
	@ModelAttribute("boardContent") BoardContent boardContent){
		return "boardViews/write";
	}
	
	@RequestMapping(value="/write/data", method=RequestMethod.POST)
	public String boardWriteProcess(
	@ModelAttribute("boardContent") BoardContent boardContent){
		
		// 글 작성
		logger.info("게시글 작성 시도");
		boardService.addBoardContent(boardContent);
		logger.info("게시글 작성 완료");
		
		return "redirect:/board/list";
	}
}
