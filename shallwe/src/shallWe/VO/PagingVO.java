package shallWe.VO;

public class PagingVO {
	int currentPage = 1;	// ���� ������ ��ȣ
	int totalData;			// ������ ��
	int startPage;			// ��� ����
	int endPage;			// ��� ��
	int displayData;		// �� �������� ���� ������ ��
	int displayPage;		// ���̴� ������ ��
	boolean prev;			// prev ��ư ���ϰ��� �Ⱥ��ϰ���
	boolean next;
	int startRowNum;
	int endRowNum;
	int totalPage;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
		paging();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getDisplayData() {
		return displayData;
	}
	public void setDisplayData(int displayData) {
		this.displayData = displayData;
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
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}
	public int getEndRowNum() {
		return endRowNum;
	}
	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	@Override
	public String toString() {
		return "PagingVO [currentPage=" + currentPage + ", totalData=" + totalData + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", displayData=" + displayData + ", displayPage=" + displayPage + ", prev="
				+ prev + ", next=" + next + ", startRowNum=" + startRowNum + ", endRowNum=" + endRowNum + ", totalPage="
				+ totalPage + "]";
	}
	public void paging() {
		startRowNum = (currentPage - 1) * displayData + 1;
		endRowNum = currentPage * displayData;
		
		endPage = ((currentPage + (displayPage - 1)) / displayPage) * displayPage;
		startPage = endPage - (displayPage - 1);
		
		// ������ ������
		totalPage = totalData / displayData;
		if(totalData % displayData > 0) totalPage++;
		
		if(endPage > totalPage) {
			endPage = totalPage;
			next = false;
		}else {
			next = true;
		}
		
		prev = (startPage == 1) ? false : true;
	}
}
