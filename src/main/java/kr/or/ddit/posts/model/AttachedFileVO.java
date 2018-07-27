package kr.or.ddit.posts.model;

import java.util.Date;

public class AttachedFileVO {
	
	private int file_no;			// 첨부파일 번호
	private String file_name;		// 파일명
	private String file_path;		// 파일경로
	private String file_upload;		// 업로드파일명
	private Date file_date;			// 작성일
	private int post_no;			// 게시글번호
	
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_upload() {
		return file_upload;
	}
	public void setFile_upload(String file_upload) {
		this.file_upload = file_upload;
	}
	public Date getFile_date() {
		return file_date;
	}
	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	
	@Override
	public String toString() {
		return "AttachedFileVO [file_no=" + file_no + ", file_name="
				+ file_name + ", file_path=" + file_path + ", file_upload="
				+ file_upload + ", file_date=" + file_date + ", post_no="
				+ post_no + "]";
	}

}
