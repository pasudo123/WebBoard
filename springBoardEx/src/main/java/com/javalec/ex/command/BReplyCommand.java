package com.javalec.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.ex.dao.BDao;

public class BReplyCommand implements BCommand {

	// 답변 기능을 다는 폼이 나타난다.
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String,Object> map =model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		
		BDao bDao = new BDao();
		bDao.replyView(bId);
		
		// 이후에 리플라이 하는 경우, 모델에 실어서 replyView로 보내줘야 한다. 
	}

}
