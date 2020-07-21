package www.aast.Domain;

public class PageVO {
	private int page = 1; //시작페이지   totalcount - ((page.page-1)*page.displayRow)
	private int totalCount; //테이블에 등록된 총 게시글 수
	private int beginPage; //시작 페이지
	private int endPage; //끝 페이지
	private int displayRow = 10; //한페이지에 보여질 게시글 수
	private int displayPage = 5; //하단목록에서 보여질 수 
	boolean prev; //뒤로가기
	boolean next; //앞으로가기
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getDisplayRow() {
		return displayRow;
	}

	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}

	public int getDisplayPage() {
		return displayPage;
	}

	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	private void Paging() {
		endPage = ((page+(displayPage-1)) / displayPage) * displayPage;
		beginPage = endPage - (displayPage - 1);
		int totalPage = (int)Math.ceil(totalCount / (double)displayRow);
		
		if(endPage > totalPage) {
			endPage = totalPage;
			next = false;
		} else {
			next = true;
		}
		
		if(beginPage == 1) {
			prev = false;
		} else {
			prev = true;
		}
	}
	
}
