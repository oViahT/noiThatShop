package shopnoithat.Service.User;

import org.springframework.stereotype.Service;

import shopnoithat.DTO.PaginatesDTO;

@Service
public class PaginatesServiceImple {
	
	// Phân trang 
	public PaginatesDTO GetInfoPaginates(int totalData, int limitProductsOfPage, int currentPage) {
		PaginatesDTO paginates = new PaginatesDTO();

		// Giới hạn sản phẩm trong 1 trang
		paginates.setLimitProductsOfPage(limitProductsOfPage);
		
		// Tổng số trang 
		paginates.setTotalPage(setInfoTotalPages(totalData, limitProductsOfPage));
		
		// Check trang hiện tại
		paginates.setCurrentPage(checkCurrentPage(currentPage, paginates.getTotalPage()));

		// số bắt đầu và số kết thúc
		int start = findStartNumdber(paginates.getCurrentPage(), limitProductsOfPage);
		paginates.setNumberStartPageOfProduct(start);
		
		int end = findEndNumdber(paginates.getNumberStartPageOfProduct(), limitProductsOfPage, totalData);
		paginates.setNumberEndPageOfProduct(end);

		return paginates;
		
		
	}

	// Tính số kết thúc trang
	private int findEndNumdber(int numberStartPageOfProduct, int limitProductsOfPage, int totalData) {
		return numberStartPageOfProduct + limitProductsOfPage > totalData ? totalData
				: (numberStartPageOfProduct + limitProductsOfPage) - 1;
	}

	// Tính số bắt đầu trang
	private int findStartNumdber(int currentPage, int limitProductsOfPage) {
		return ((currentPage - 1) * limitProductsOfPage) + 1;
	}

	// Tính tổng số trang
	private int setInfoTotalPages(int totalData, int limitProductsOfPage) {
		int totalPage = 0;
		totalPage = totalData / limitProductsOfPage;
		totalPage = totalPage * limitProductsOfPage < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}

	// Check trang hiện tại
	private int checkCurrentPage(int currentPage, int totalPages) {
		if (currentPage < 1) {
			return 1;
		}
		if (currentPage > totalPages) {
			return totalPages;
		}
		return currentPage;
	}
}
