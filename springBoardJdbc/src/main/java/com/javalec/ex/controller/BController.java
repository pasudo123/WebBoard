package com.javalec.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javale.ex.util.Constant;
import com.javalec.ex.command.BCommand;
import com.javalec.ex.command.BContentCommand;
import com.javalec.ex.command.BDeleteCommand;
import com.javalec.ex.command.BListCommand;
import com.javalec.ex.command.BModifyCommand;
import com.javalec.ex.command.BReplyCommand;
import com.javalec.ex.command.BReplyViewCommand;
import com.javalec.ex.command.BWriteCommand;

// 컨트롤러 역할을 하기 때문에 오토스캔에 걸려야 한다.
// 그렇기 때문에 어노테이션을 추가해준다.
@Controller
public class BController {
	/**
	 * 클라이언트의 요청에 따른 전체적인 작업을 지휘하는 컨트롤러
	 * 
	 * 클라이언트에서 요청이 들어오면 디스패처가 받고, 오토스캔을 이용해서
	 * 컨트롤러를 찾고 컨트롤러 내부에 RequestMapping 어노테이션이 적용된
	 * 메소드를 하나씩 찾아나간다.
 	 * **/
	
	// 각자 작업을 시키려고 하지만, 인터페이스 구현체를 통해서
	// BCommand 객체를 통해서 유연하게 접근할 수 있다.
	BCommand command;
	
	// 원래는 로그를 넣어주지만, 현재는 Sys.out()으로
	// 각각의 RequestMapping에 대한 호출을 확인한다.
	
	public JdbcTemplate template;
	
	// setter 이용, 왜냐? 
	// 자바빈을 통해서 스프링 설정파일로 설정이 가능하기 떄문
	// 위의 필드에 빈 객체가 담겨야 한다. 오토스캔하는 경우 자동으로 객체 생성할 수 있도록 설정 
	// 이전에는 따로  src/test/resources 에 담겨 xml파일을 만들고 파싱했지만 그거와는 다르다. 
	// 펜슬 프로젝트 혹은 초기 프로젝트 확인	
	@Autowired
	public void setTemplate(JdbcTemplate template){
		this.template = template;
		
		// 어디서든 이용할 수 있도록 설정.
		Constant.template = this.template; 
	}
	
	@RequestMapping(value="/list")
	public String list(Model model){
		System.out.println("list()");
		
		command = new BListCommand();
		command.execute(model);
		
		// 이후에 해당하는 프론트 페이지를 보여준다.
		return "list";
	}
	
	// 글을 작성하기 위한 페이지
	@RequestMapping(value="/writeView")
	public String writeView(Model model){
		System.out.println("writeView()");
		
		return "writeView";
	}
	
	// 작성한 글의 데이터 폼을 받기 위해서 리퀘스트 객체
	@RequestMapping(method=RequestMethod.POST, value="/write")
	public String write(HttpServletRequest request, Model model){
		System.out.println("write()");
		
		model.addAttribute("request", request);
		
		command = new BWriteCommand();
		command.execute(model);
		
		// 작성이 다 되고 이후에 리스트 페이지
		// 하지만 컨트롤러에서 다시 리스트 페이지로 가기 위해서
		// 리다이렉트 작성
		return "redirect:list";
	}
	
	// 컨텐츠를 보기 위함
	@RequestMapping(method=RequestMethod.GET, value="/contentView")
	public String contentView(HttpServletRequest request, Model model){
		System.out.println("contentView()");
		
		// 데이터베이스에서 값을 조회하기 위해서 통째로 값을 넣는다.
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "contentView";
	}
	
	
	// 컨텐츠 내에서 내용을 수정하기 위한 컨트롤러
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	// 댓글창을 여는 경우
	@RequestMapping(method = RequestMethod.GET, value="/replyView")
	public String replyView(HttpServletRequest request, Model model){
		System.out.println("replyView()");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "replyView";
	}
	
	// 실제 작성 하는 경우
	@RequestMapping(value="/reply")
	public String reply(HttpServletRequest request, Model model){
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	// 삭제하는 경우
	@RequestMapping(method=RequestMethod.GET, value="/delete")
	public String delete(HttpServletRequest request, Model model){
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}