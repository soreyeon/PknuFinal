package com.spring.pds.vo;

public class PdsVo {
	//게시물(board)
	private int idx;
	private String title;
	private String cont;
	private String writer;
	private String regdate;
	private int readcount;
	
	//게시물(답글)
	private int bnum;
	private int lvl;
	private int step;
	private int nref;
	
	//삭제여부
	private int delnum;
	
	//메뉴관련
	private String menu_id;
	private String menu_name;
	private int menu_seq;
	
	private int filescount;
	
	//페이징관련정보( 한페이지당 10개씩 잡을거 )
	private int nowpage; //현재페이지 정보
	private int prevnowpage; //이전 10개 클릭시 적용되는 nowpage
	private int nextnowpage; //다음 10개 클릭시 적용되는 nowpage
	
	private int totalcount; //조회된 전체 data Row 수(자료수) (ex.256개)
	private int totalpagecount; //화면에 보여줄 전체 페이지 수 (ex.26페이지)
	
	private int pagestartnum; //페이지 시작번호 (1, 11, 21, .....)
	private int pageendnum; //페이지 끝번호 (10, 20, 30, ......)
	private int pagegrpnum; //페이지 그룹 숫자 (1-10)--> 1, (11-20) --> 2, (21-30) --> 3 
	
	private int pagecount; //한페이지에 보여줄 자료라인 수 (한페이지당 10개)
	
	private boolean isshowpageprev; // 이전페이지 표시 true/false
	private boolean isshowpagenext; // 다음페이지 표시 true/false
	
	//Getter/Setter
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getNref() {
		return nref;
	}
	public void setNref(int nref) {
		this.nref = nref;
	}
	public int getDelnum() {
		return delnum;
	}
	public void setDelnum(int delnum) {
		this.delnum = delnum;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getMenu_seq() {
		return menu_seq;
	}
	public void setMenu_seq(int menu_seq) {
		this.menu_seq = menu_seq;
	}
	public int getFilescount() {
		return filescount;
	}
	public void setFilescount(int filescount) {
		this.filescount = filescount;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getPrevnowpage() {
		return prevnowpage;
	}
	public void setPrevnowpage(int prevnowpage) {
		this.prevnowpage = prevnowpage;
	}
	public int getNextnowpage() {
		return nextnowpage;
	}
	public void setNextnowpage(int nextnowpage) {
		this.nextnowpage = nextnowpage;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getTotalpagecount() {
		return totalpagecount;
	}
	public void setTotalpagecount(int totalpagecount) {
		this.totalpagecount = totalpagecount;
	}
	public int getPagestartnum() {
		return pagestartnum;
	}
	public void setPagestartnum(int pagestartnum) {
		this.pagestartnum = pagestartnum;
	}
	public int getPageendnum() {
		return pageendnum;
	}
	public void setPageendnum(int pageendnum) {
		this.pageendnum = pageendnum;
	}
	public int getPagegrpnum() {
		return pagegrpnum;
	}
	public void setPagegrpnum(int pagegrpnum) {
		this.pagegrpnum = pagegrpnum;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public boolean isIsshowpageprev() {
		return isshowpageprev;
	}
	public void setIsshowpageprev(boolean isshowpageprev) {
		this.isshowpageprev = isshowpageprev;
	}
	public boolean isIsshowpagenext() {
		return isshowpagenext;
	}
	public void setIsshowpagenext(boolean isshowpagenext) {
		this.isshowpagenext = isshowpagenext;
	}
	
	
	
	@Override
	public String toString() {
		return "PdsVo [idx=" + idx + ", title=" + title + ", cont=" + cont + ", writer=" + writer + ", regdate="
				+ regdate + ", readcount=" + readcount + ", bnum=" + bnum + ", lvl=" + lvl + ", step=" + step
				+ ", nref=" + nref + ", delnum=" + delnum + ", menu_id=" + menu_id + ", menu_name=" + menu_name
				+ ", menu_seq=" + menu_seq + ", filescount=" + filescount + ", nowpage=" + nowpage + ", prevnowpage="
				+ prevnowpage + ", nextnowpage=" + nextnowpage + ", totalcount=" + totalcount + ", totalpagecount="
				+ totalpagecount + ", pagestartnum=" + pagestartnum + ", pageendnum=" + pageendnum + ", pagegrpnum="
				+ pagegrpnum + ", pagecount=" + pagecount + ", isshowpageprev=" + isshowpageprev + ", isshowpagenext="
				+ isshowpagenext + "]";
	}
	
	
}
