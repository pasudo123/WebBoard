package edu.doubler.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.doubler.domain.BoardContent;


@Controller("BoardController")
@RequestMapping("board")
public class BoardController {
	
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/list")
	public String showBoardList(Model model, HttpServletRequest request){
		
		StringBuffer URL = request.getRequestURL();
		
		int count = boardService.getFullCountOnContent();
		List<BoardContent> boardTableRows = boardService.getBoardTableRows();
		
		model.addAttribute("boardTableRows", boardTableRows);
		
		return "boardViews/list";
	}
	
	@RequestMapping(value = "/list/{pkn}")
	public String showBoardContent(
	@PathVariable int pkn,
	Model model){

		logger.info("게시글 조회 시도");
		BoardContent boardContent = boardService.getBoardContent(pkn);
		logger.info("게시글 조회 성공");
		
		model.addAttribute("pkn", pkn);
		model.addAttribute("boardContent", boardContent);
		
		return "boardViews/content";
	}
	
	@RequestMapping(value = "/write")
	public String boardProcess(
	@ModelAttribute("boardContent") BoardContent boardContent){
		
		// 이전 URL 을 알게되는 경우,
		// 비정상적 접근시, 다시 되돌아가기
		
		return "boardViews/write";
	}
	
	@RequestMapping(value = "/write/data", method=RequestMethod.POST)
	public String boardWriteProcess(
	@ModelAttribute("boardContent") BoardContent boardContent){
		
		// 글 작성
		logger.info("게시글 작성 시도");
		boardService.addBoardContent(boardContent);
		logger.info("게시글 작성 완료");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String boardModifyProcess(
	@ModelAttribute("boardContent") BoardContent boardContent,
	HttpServletRequest request){
		
		logger.info("게시글 수정 시도");
		boardService.updateBoardContent(boardContent);
		logger.info("게시글 수정 완료");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String boardDeleteProcess(HttpServletRequest request){
		
		logger.info(request.getParameter("pkn"));
		int pkn = Integer.parseInt(request.getParameter("pkn"));
		
		// 글 삭제
		logger.info("게시글 삭제 시도");
		boardService.deleteBoardContent(pkn);
		logger.info("게시글 삭제 완료");
		
		return "redirect:/board/list";
	}
	
	private synchronized void reWriteURL(String URL){
		
	}
}
