package mapper.board;

import java.util.List;

import com.doubler.board.dto.BoardContentDTO;

public interface BoardMapper {
	// 게시판의 게시글 가져오는 기능
	public List<BoardContentDTO> getBoardList();
}
