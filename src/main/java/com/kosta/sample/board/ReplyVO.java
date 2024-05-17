package com.kosta.sample.board;

public class ReplyVO {
	
	private int rseq;
	private String reply;
	private String regid;
	private int regdate;
	
	public ReplyVO() {
		
	}
	public ReplyVO(int rseq, String reply, String regid, int regdate) {
		super();
		this.rseq = rseq;
		this.reply = reply;
		this.regid = regid;
		this.regdate = regdate;
	}
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	public int getRegdate() {
		return regdate;
	}
	public void setRegdate(int regdate) {
		this.regdate = regdate;
	}
	
	
	@Override
	public String toString() {
		return "ReplyVO [rseq=" + rseq + ", reply=" + reply + ", regid=" + regid + ", regdate=" + regdate + "]";
	}
	
	
}
