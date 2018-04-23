package edu.doubler.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	public boolean BoardService(){
		return false;
	}
	
	@Autowired
	BoardDao boardDao;
	
	public int getFullCountOnContent(){
		return boardDao.getFullCountOnContent();
	}
}
