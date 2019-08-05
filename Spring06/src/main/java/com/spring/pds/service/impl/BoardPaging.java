package com.spring.pds.service.impl;

import com.spring.pds.vo.PdsVo;

public class BoardPaging {
	//field
	private int totalCount;
	private int nowPage;
	private int prevNowPage;
	private int nextNowPage;
	private int pageCount;
	
	private int pageTotalCount;
	private int pageGrpNum;
	
	private int startPageNum;
	private int endPageNum;
	
	private int totalRecordPageCount;
	
	private boolean isShowPagePrev = true;
	private boolean isShowPageNext = true;
	
	//Getter/Setter
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPrevNowPage() {
		return prevNowPage;
	}
	public void setPrevNowPage(int prevNowPage) {
		this.prevNowPage = prevNowPage;
	}
	public int getNextNowPage() {
		return nextNowPage;
	}
	public void setNextNowPage(int nextNowPage) {
		this.nextNowPage = nextNowPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public int getPageGrpNum() {
		return pageGrpNum;
	}
	public void setPageGrpNum(int pageGrpNum) {
		this.pageGrpNum = pageGrpNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getTotalRecordPageCount() {
		return totalRecordPageCount;
	}
	public void setTotalRecordPageCount(int totalRecordPageCount) {
		this.totalRecordPageCount = totalRecordPageCount;
	}
	public boolean isShowPagePrev() {
		return isShowPagePrev;
	}
	public void setShowPagePrev(boolean isShowPagePrev) {
		this.isShowPagePrev = isShowPagePrev;
	}
	public boolean isShowPageNext() {
		return isShowPageNext;
	}
	public void setShowPageNext(boolean isShowPageNext) {
		this.isShowPageNext = isShowPageNext;
	}
	
	//constructor
	public BoardPaging() {
		
	}
	
	public BoardPaging(int nowPage, int pageCount, int totalCount, int pageTotalCount, int pageGrpNum) {
		this.totalCount = totalCount;
		this.nowPage = nowPage;
		this.pageCount = pageCount;
		this.pageTotalCount = pageTotalCount;
		this.pageGrpNum = pageGrpNum;
	}
	
	//toString
	@Override
	public String toString() {
		return "BoardPaging [totalCount=" + totalCount + ", nowPage=" + nowPage + ", prevNowPage=" + prevNowPage
				+ ", nextNowPage=" + nextNowPage + ", pageCount=" + pageCount + ", pageTotalCount=" + pageTotalCount
				+ ", pageGrpNum=" + pageGrpNum + ", startPageNum=" + startPageNum + ", endPageNum=" + endPageNum
				+ ", totalRecordPageCount=" + totalRecordPageCount + ", isShowPagePrev=" + isShowPagePrev
				+ ", isShowPageNext=" + isShowPageNext + "]";
	}
	
	//필요한 Method 구현
	//paging.jspf -> pagePdsVo
	public PdsVo getPdsPagingInfo() {
		PdsVo vo = new PdsVo();
		
		//전체 페이지 수: totalCount/pageCount  263/10 = 27
		this.totalRecordPageCount = (int) Math.ceil((double) totalCount / (double) pageCount);
		
		//페이지 시작/끝번호 계산
		this.startPageNum = (this.pageGrpNum -1) * this.pageTotalCount + 1;
		this.endPageNum = this.totalRecordPageCount < (this.pageGrpNum * this.pageTotalCount) ? this.totalRecordPageCount : (this.pageGrpNum * this.pageTotalCount);
		this.prevNowPage = this.startPageNum  - 1;
		this.nextNowPage = this.endPageNum + 1;
		
		//돌려주기 위해 값을 저장
		vo.setNowpage(nowPage);
		
		vo.setPrevnowpage(prevNowPage);
		vo.setNextnowpage(nextNowPage);
		
		vo.setTotalcount(totalCount);
		vo.setTotalpagecount(pageTotalCount);
		
		vo.setPagestartnum(startPageNum);
		vo.setPageendnum(endPageNum);
		
		vo.setPagecount(pageCount);
		vo.setPagegrpnum(pageGrpNum);
		
		if(this.startPageNum == 1)
			isShowPagePrev = false;
		if(this.endPageNum >= this.totalRecordPageCount)
			isShowPageNext = false;
		
		vo.setIsshowpagenext(isShowPageNext);
		vo.setIsshowpageprev(isShowPagePrev);
		
		//System.out.println("boardPaging List: " + vo);
		
		return vo;
	}
	
}
