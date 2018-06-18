package edu.doubler.util;

public enum EnumBoardMapper {
	NAME_SPACE("BoardMapper"),
	GET_FULL_COUNT_CONTENT("getFullCountOnContent"),
	GET_BOARD_TABLE_ROWS("getBoardTableRows"),
	GET_BOARD_CONTENT("getBoardContent"),
	UPDATE_READ_COUNT("updateReadCount"),
	ADD_BOARD_CONTENT("addBoardContent"),
	DELETE_BOARD_CONTENT("deleteBoardContent");
	
	private String value;
	
	private EnumBoardMapper(){}
	private EnumBoardMapper(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	@Override
	public String toString(){
		return value;
	}
}
