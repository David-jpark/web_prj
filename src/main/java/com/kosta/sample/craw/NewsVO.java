package com.kosta.sample.craw;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// lombok으로 get/set 자동화

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class NewsVO {
	private int seq;
	private String href;
	private String img;
	private String title;
	private String ref;
	private String regdate;
	
	
//	public NewsVO(int seq, String href, String img, String title, String ref, String regdate) { //@AllArgsConstructor
//		super();
//		this.seq = seq;
//		this.href = href;
//		this.img = img;
//		this.title = title;
//		this.ref = ref;
//		this.regdate = regdate;
//	}

	//public NewsVO(){} //@NoArgsConstructor
}
