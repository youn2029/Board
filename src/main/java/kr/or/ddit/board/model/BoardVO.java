package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVO {
	
	private int board_no;			// 게시판 번호
	private String board_name;		// 게시판 이름
	private Date board_date;		// 게시판 등록일
	private String board_use;		// 사용여부
	private int id;					// 등록자번호
	private String std_id;			// 등록자ID
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public String getBoard_use() {
		return board_use;
	}
	public void setBoard_use(String board_use) {
		this.board_use = board_use;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	
	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", board_name=" + board_name
				+ ", board_date=" + board_date + ", board_use=" + board_use
				+ ", id=" + id + ", std_id=" + std_id + "]";
	}	

}
