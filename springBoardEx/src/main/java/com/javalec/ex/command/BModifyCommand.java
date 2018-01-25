package com.javalec.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.ex.dao.BDao;

public class BModifyCommand implements BCommand {
	// 글을 수정하는 명령
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		// 모델을 맵형태로 반환한다.
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest)map.get("request"); 
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = new BDao();
		dao.modify(bId, bName, bTitle, bContent);
	}

}
