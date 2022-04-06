package shopnoithat.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopnoithat.DAO.ProductsDAO;
import shopnoithat.DTO.ProductsDTO;

@Service
public class ProductDetailsServiceImple implements IProductDetailsService{

	@Autowired
	ProductsDAO productsDAO = new ProductsDAO();
	
	// Lấy sản phẩm có theo id
	@Override
	public ProductsDTO GetProductByID(long id) {
		
		List<ProductsDTO> listProductDetails = productsDAO.GetProductByID(id);
		
		return listProductDetails.get(0);
	}

	// lấy tất cả sản phẩm cùng loại
	@Override
	public List<ProductsDTO> GetProductByIDType(int id) {
		
		return productsDAO.GetAllProductsByID(id);
	}

	// Tìm kiếm sản phẩm
	@Override
	public List<ProductsDTO> GetProductByName(String name) {
		return productsDAO.GetSearchProduct(name);
	}

	// Tìm kiếm sản phẩm
	@Override
	public ProductsDTO GetProductName(String name) {
		List<ProductsDTO> listProductDetails = productsDAO.GetSearchProduct(name);
		return listProductDetails.get(2);
	}


	// Xóa sản phẩm theo id
	public void delete(int id) {
		productsDAO.delete(id);
	}

	// Thêm sản phẩm
	public int addProduct(ProductsDTO addProducts) {
		return productsDAO.addProduct(addProducts);
	}

	public void editProduct(ProductsDTO product, long idProduct) {
		productsDAO.editProduct(product, idProduct);
		
	}

}
