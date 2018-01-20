package com.javalec.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class BListCommand implements BCommand{

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		// 여기서 중요하게 생각해야 할 것은 리스트는 하나의 객체로서
		// 10개의 게시글을 들고온다고 하면 10개의 객체이다.
	
		model.addAttribute("list", dtos);
	}
	
}
