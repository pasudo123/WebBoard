package com.javalec.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.ex.dao.BDao;

public class BWriteCommand implements BCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		// 모델을 맵 형태로 변환한다.
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		// DAO(Data Access Object) : 데이터베이스에 접근하려는 객체
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
