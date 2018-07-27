package kr.or.ddit.posts.model;

import java.util.Date;

public class PostsVO {
	
	private int post_no;			// 게시글 번호
	private String post_title;		// 제목
	private String post_content;	// 내용
	private Date post_date;			// 작성일
	private String post_delete;		// 삭제여부
	private int post_group;			// 게시글 그룹
	private int post_pno;			// 부모게시글 번호
	private int id;					// 작성자번호
	private int board_no;			// 게시판 번호
	private String std_id;			// 작성자ID
	
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getPost_delete() {
		return post_delete;
	}
	public void setPost_delete(String post_delete) {
		this.post_delete = post_delete;
	}
	public int getPost_group() {
		return post_group;
	}
	public void setPost_group(int post_group) {
		this.post_group = post_group;
	}	
	public int getPost_pno() {
		return post_pno;
	}
	public void setPost_pno(int post_pno) {
		this.post_pno = post_pno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	
	@Override
	public String toString() {
		return "PostsVO [post_no=" + post_no + ", post_title=" + post_title
				+ ", post_content=" + post_content + ", post_date=" + post_date
				+ ", post_delete=" + post_delete + ", post_group=" + post_group
				+ ", post_pno=" + post_pno + ", id=" + id + ", board_no="
				+ board_no + ", std_id=" + std_id + "]";
	}	
	
}
