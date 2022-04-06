package shopnoithat.DTO;

public class PaginatesDTO {

	private int currentPage, limitProductsOfPage, numberStartPageOfProduct, numberEndPageOfProduct, totalPage;

	public PaginatesDTO() {
		super();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLimitProductsOfPage() {
		return limitProductsOfPage;
	}

	public void setLimitProductsOfPage(int limitProductsOfPage) {
		this.limitProductsOfPage = limitProductsOfPage;
	}

	public int getNumberStartPageOfProduct() {
		return numberStartPageOfProduct;
	}

	public void setNumberStartPageOfProduct(int numberStartPageOfProduct) {
		this.numberStartPageOfProduct = numberStartPageOfProduct;
	}

	public int getNumberEndPageOfProduct() {
		return numberEndPageOfProduct;
	}

	public void setNumberEndPageOfProduct(int numberEndPageOfProduct) {
		this.numberEndPageOfProduct = numberEndPageOfProduct;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
