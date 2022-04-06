package shopnoithat.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopnoithat.DAO.ProductsDAO;
import shopnoithat.DTO.ProductsDTO;

@Service
public class CategorysServiceImple implements ICategorysService {

	@Autowired
	private ProductsDAO productsDAO;

	// Lấy tất cả sản phẩm có cùng loại
	@Override
	public List<ProductsDTO> GetAllProductsByID(int id) {
		return productsDAO.GetAllProductsByID(id);
	}

	// Phân trang
	@Override
	public List<ProductsDTO> GetDataProductsPaginate(int id, int start, int totalPage) {
		return productsDAO.GetDataProductsPaginates(id, start, totalPage);
	}
	
	public List<ProductsDTO> GetDataAllProductsPaginate( int start, int totalPage) {
		return productsDAO.GetDataAllProductsPaginates( start, totalPage);
	}
	
	public List<ProductsDTO> GetDataAllNewProductsPaginate( int start, int totalPage) {
		return productsDAO.GetDataAllNewProductsPaginates( start, totalPage);
	}

	public List<ProductsDTO> GetDataAllHighlithsProductsPaginate( int start, int totalPage) {
		return productsDAO.GetDataAllHighlithsProductsPaginates( start, totalPage);
	}

}
