package com.cafe24.mysite.vo;

public class CommentVo {
	private Long no;
	private String content;
	private String regDate;
	private Long UserNo;
	private Long boardNo;

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getUserNo() {
		return UserNo;
	}

	public void setUserNo(Long userNo) {
		UserNo = userNo;
	}

	public Long getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(Long boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "CommentVo [no=" + no + ", content=" + content + ", regDate=" + regDate + ", UserNo=" + UserNo
				+ ", boardNo=" + boardNo + "]";
	}

}
