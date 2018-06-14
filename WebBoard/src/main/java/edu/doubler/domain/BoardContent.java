package edu.doubler.domain;

public class BoardContent {
	private int num;
	private String title;
	private String writer;
	private String content;
	private String date;
	private int read;
	private int hit;

	public int getNum() {
		return num;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getContent() {
		return content;
	}

	public String getDate(){
		return date;
	}
	
	public int getRead(){
		return read;
	}
	
	public int getHit() {
		return hit;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(String date){
		this.date = date;
	}

	public void setRead(int read){
		this.read = read;
	}
	
	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardContent [num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", date=" + date + ", read=" + read + ", hit=" + hit + "]";
	}
}
