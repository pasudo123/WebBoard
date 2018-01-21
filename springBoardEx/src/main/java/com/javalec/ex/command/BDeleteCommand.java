package com.javalec.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.ex.dao.BDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest)map.get("request");
		
		String bId = httpServletRequest.getParameter("bId");
		
		BDao bDao = new BDao();
		bDao.delete(bId);
	}

}
