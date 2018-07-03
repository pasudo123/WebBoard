package edu.doubler.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public static final Integer NONE = -1;
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/list")
	public String showInitBoardList(Model model){
		return "redirect:/board/list/1";
	}
	
	@RequestMapping(value = "/list/{pagePosition}")
	public String showBoardList(
	Model model, 
	HttpServletRequest request,
	HttpServletResponse response,
	@PathVariable String pagePosition){
		
		/**
		 * IP 가져오는 ~
		 * **/
		
		String pageBlock = request.getParameter("pageBlock");
		
		// 페이지 클릭
		if(pageBlock == null){
			int currentPage = Integer.parseInt(pagePosition);
			Map<String, Integer> pageInfo = boardService.pagingProcessing(NONE, currentPage);
			
			Map<String, Integer> rangeInfo = new HashMap<String, Integer>();
			rangeInfo.put("startNumber", pageInfo.get("startNumber"));
			rangeInfo.put("endNumber", pageInfo.get("endNumber"));
			List<BoardContent> boardTableRows = boardService.getBoardTableRows(rangeInfo);
			
			model.addAttribute("boardTableRows", boardTableRows);
			model.addAttribute("pageInfo", pageInfo);
			
			return "boardViews/list";
		}
		
		// [이전] & [다음] 클릭
		else{
			int block = Integer.parseInt(pageBlock);
			int movePage = 0;
			
			// move 는 현재 페이지블록
			if("prev".equals(pagePosition))
				movePage = boardService.movePrevProcessing(block);
			else 
				movePage = boardService.moveNextProcessing(block);
			
			return "redirect:/board/list/" + movePage;
		}
	}
	
	@RequestMapping(value = "/content/{pkn}")
	public String showBoardContent(
	@PathVariable int pkn,
	HttpServletRequest request,
	Model model){

		// 이전 URL 확인
		String refererURL = request.getHeader("referer");
		
		logger.info(":: refererURL :: " + refererURL);
		logger.info("게시글 조회 시도");
		BoardContent boardContent = boardService.getBoardContent(pkn);
		logger.info("게시글 조회 성공");
		
		model.addAttribute("pkn", pkn);
		model.addAttribute("boardContent", boardContent);
		model.addAttribute("refererURL", refererURL);
		
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
	
	@RequestMapping(value = "/delete")
	public String boardDeleteProcess(HttpServletRequest request){
		
		logger.info(request.getParameter("pkn"));
		int pkn = Integer.parseInt(request.getParameter("pkn"));
		
		// 글 삭제
		logger.info("게시글 삭제 시도");
		boardService.deleteBoardContent(pkn);
		logger.info("게시글 삭제 완료");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/test-ajax")
	public String testAjax(HttpServletRequest request){
		
		return null;
	}
	
	/**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	 * 
	 * 페이징처리 위한 데이터 삽입 [ 테스트 로직  ]
	 * 
	 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/
	@RequestMapping(value = "/insert_batch")
	public String batch(){
		String title = "title";
		String writer = "writer";
		String content = "content";
		String date = "18/06/";
		
		int count = boardService.getFullCountOnContent();
		
		for(int i = count + 1; i <= count + 500; i++){
			BoardContent boardContent = new BoardContent();
			
			boardContent.setTitle(title + i +"");
			boardContent.setWriter(writer + i + "");
			boardContent.setContent(content + i + "");
			
			boardService.addBoardContent(boardContent);
		}
		
		return "redirect:/board/list";
	}
}
