package com.kosta.sample.board;

import java.util.ArrayList;

public class BoardCallTest {

	public static void main(String[] args) {
		BoardDAO bdao = new BoardDAO();
		ArrayList<BoardVO> list = bdao.selectBoard();
		int delRows = bdao.deleteBoard(3);
		System.out.println(delRows + "건 삭제");
		
		System.out.println("총 :" + list.size());
		for(int i = 0; i<list.size(); i++) {
			int seq = list.get(i).getSeq();
			String title = list.get(i).getTitle();
			String contents = list.get(i).getContents();
			String regid = list.get(i).getRegid();
			String regdate = list.get(i).getRegdate();
			System.out.println(seq+"\t"+title +"\t" + contents + "\t" + regid + "\t" + regdate);
		}
		
//		for(BoardVO bvo :list) {
//			int seq = bvo.getSeq();
//			String title = bvo.getTitle();
//			String contents = bvo.getContents();
//			String regid = bvo.getRegid();
//			String regdate = bvo.getRegdate();
//			System.out.println(seq+"\t"+title +"\t" + contents + "\t" + regid + "\t" + regdate);
//		}
	}

}
