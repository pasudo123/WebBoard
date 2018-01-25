package com.javalec.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class BReplyCommand implements BCommand {

	// 답변 기능을 다는 폼이 나타난다.
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String,Object> map =model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent= request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		
		BDao dao = new BDao();
		dao.replyByTemplate(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
	}

}
