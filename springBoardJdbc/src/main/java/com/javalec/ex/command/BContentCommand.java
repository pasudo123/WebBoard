package com.javalec.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class BContentCommand implements BCommand {
	/*
	 * 클릭한 내용의 글을 보기위한 컨트롤
	 * */
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		// DAO -> DTO 객체 변환 
		
		BDao dao = new BDao();
		BDto dto = dao.contentViewByTemplate(bId);
		
		model.addAttribute("contentView", dto);
	}

}
