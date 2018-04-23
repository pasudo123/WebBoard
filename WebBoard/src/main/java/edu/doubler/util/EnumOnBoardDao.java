package edu.doubler.util;

public enum EnumOnBoardDao {
	NAME_SPACE("BoardMapper"),
	QUERY_THAT_GET_FULL_COUNT_ON__CONTENT("getFullCountOnContent");
	
	private String value;
	
	private EnumOnBoardDao(){}
	private EnumOnBoardDao(String value){
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
