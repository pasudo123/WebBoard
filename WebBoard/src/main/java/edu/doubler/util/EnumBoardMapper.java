package edu.doubler.util;

public enum EnumBoardMapper {
	NAME_SPACE("BoardMapper"),
	FULL_COUNT_CONTENT("getFullCountOnContent"),
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
