package edu.doubler.util;

public enum EnumBoardMapper {
	NAME_SPACE("BoardMapper"),
	GET_FULL_COUNT_CONTENT("getFullCountOnContent"),
	GET_BOARD_TABLE_ROWS("getBoardTableRows"),
	ADD_BOARD_CONTENT("addBoardContent");
	
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
