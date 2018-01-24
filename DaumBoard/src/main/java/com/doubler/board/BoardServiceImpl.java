package com.doubler.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doubler.board.dto.BoardContentDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public int getContentCount() {
		return boardDao.getContentCount();
	}
	
	@Override
	public List<BoardContentDTO> getBoardList() {
		List<BoardContentDTO> boardList = boardDao.getBoardList();
		return boardList;
	}

	@Override
	public void writeContent(int contentNum, String contentTitle, String contentWriter, String contentDetail) {
		boardDao.writeContent(contentNum, contentTitle, contentWriter, contentDetail);
	}

	@Override
	public BoardContentDTO getContent(int contentNum) {
		return boardDao.getContent(contentNum);
	}
	
	@Override
	public void updateHit(int contentNum){
		boardDao.updateHit(contentNum);
	}

	@Override
	public void deleteContent(int contentNum) {
		boardDao.deleteContent(contentNum);
	}

	@Override
	public void updateContentNum(int contentNum) {
		boardDao.updateContentNum(contentNum);
	}

	@Override
	public void updateContentDetail(int contentNum, String contentTitle, String contentDetail) {
		boardDao.updateContentDetail(contentNum, contentTitle, contentDetail);
	}
}
