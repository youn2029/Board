package kr.or.ddit.posts.model;

import java.util.Date;

public class RecommentVO {
	
	private int rec_no;			// 댓글 번호
	private String rec_content;	// 댓글 내용
	private Date rec_date;		// 작성일
	private String rec_delete;	// 삭제여부
	private int post_no;		// 게시글 번호
	private int id;				// 작성자번호
	private String std_id;		// 작성자ID
	
	public int getRec_no() {
		return rec_no;
	}
	public void setRec_no(int rec_no) {
		this.rec_no = rec_no;
	}
	public String getRec_content() {
		return rec_content;
	}
	public void setRec_content(String rec_content) {
		this.rec_content = rec_content;
	}
	public Date getRec_date() {
		return rec_date;
	}
	public void setRec_date(Date rec_date) {
		this.rec_date = rec_date;
	}
	public String getRec_delete() {
		return rec_delete;
	}
	public void setRec_delete(String rec_delete) {
		this.rec_delete = rec_delete;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
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
		return "RecommentVO [rec_no=" + rec_no + ", rec_content=" + rec_content
				+ ", rec_date=" + rec_date + ", rec_delete=" + rec_delete
				+ ", post_no=" + post_no + ", id=" + id + ", std_id=" + std_id
				+ "]";
	}	

}
