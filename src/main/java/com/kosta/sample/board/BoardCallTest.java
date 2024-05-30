package com.kosta.sample.board;

import java.util.ArrayList;
import java.util.List;

public class BoardCallTest {
	/**
	 * public BoardVO boardSelect(int seq){
	 * 	1. 변수들 CPR
	 * Connetion conn = null;
	 * PrepareStatement ps = null;
	 * ResultSet rs = null;
	 *  2. SQL만들기
	 *  3. 커넥션
	 *  
	 *  4. while (next()){
	 *  	게시물 1건
	 *  	리스트(댓글)
	 *  }
	 * }
	 * 
	 */
	public static void main(String[] args) {
		BoardDAO bdao = new BoardDAO();
//		ArrayList<BoardVO> list = bdao.selectBoard();
//		int delRows = bdao.deleteBoard(3);
//		System.out.println(delRows + "건 삭제");
//		
//		System.out.println("총 :" + list.size());
//		for(int i = 0; i<list.size(); i++) {
//			int seq = list.get(i).getSeq();
//			String title = list.get(i).getTitle();
//			String contents = list.get(i).getContents();
//			String regid = list.get(i).getRegid();
//			String regdate = list.get(i).getRegdate();
//			System.out.println(seq+"\t"+title +"\t" + contents + "\t" + regid + "\t" + regdate);
//		}
//		
//		ArrayList<BoardVO> list = dao.selectBoard();
//		System.out.println("총 :" + list.size());
//		for(BoardVO bvo : list) {
//			int seq = bvo.getSeq();
//			String title = bvo.getTitle();
//			String contents = bvo.getContents();
//			String regid = bvo.getRegid();
//			String regdate = bvo.getRegdate();
//			System.out.println(seq+"\t"+title +"\t" + contents + "\t" + regid + "\t" + regdate);
//		}
//		
//		BoardVO ovo = bdao.selectBoardOne(1);
//		System.out.println(ovo.getSeq() + "," + ovo.getTitle());
//		for(BoardVO bvo :list) {
//			int seq = bvo.getSeq();
//			String title = bvo.getTitle();
//			String contents = bvo.getContents();
//			String regid = bvo.getRegid();
//			String regdate = bvo.getRegdate();
//			System.out.println(seq+"\t"+title +"\t" + contents + "\t" + regid + "\t" + regdate);
//		}
		
	//---------------------------------- JOIN
		BoardVO bvo = bdao.boardReplySelect(1);
		int seq = bvo.getSeq();
		String title = bvo.getTitle();
			
			List<ReplyVO> rlist = bvo.getReplies();
			for(ReplyVO rvo : rlist) {
				int rseq = rvo.getSeq();
				String reply = rvo.getReply();
				System.out.println(seq + "\t" + title + "\t" + rseq + "\t" + reply);
			}
	//----------------------------------상세보기 + 댓글목록
		BoardVO ovo1 = bdao.selectBoardOne(1);
		System.out.println(ovo1.getSeq()+","+ ovo1.getTitle());
		
		ArrayList<ReplyVO> livo = bdao.replyList(1);
		for(ReplyVO rvo : livo) {
			int rseq = rvo.getRseq();
			String reply = rvo.getReply();
			String regid = rvo.getRegid();
			System.out.println(rseq + "\t" + reply + "\t" + regid);
		}
//		
	}

}
