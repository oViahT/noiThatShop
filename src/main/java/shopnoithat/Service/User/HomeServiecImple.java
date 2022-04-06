package shopnoithat.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopnoithat.DAO.CatogorysDAO;
import shopnoithat.DAO.MenusDAO;
import shopnoithat.DAO.ProductsDAO;
import shopnoithat.DAO.SlidesDAO;
import shopnoithat.DTO.ProductsDTO;
import shopnoithat.Entity.Catogorys;
import shopnoithat.Entity.Menus;
import shopnoithat.Entity.Slides;

@Service
public class HomeServiecImple implements IHomeService {

	@Autowired
	private SlidesDAO slidesDAO;
	@Autowired
	private CatogorysDAO catogorysDAO;
	@Autowired
	private MenusDAO menusDAO;
	@Autowired
	private ProductsDAO productsDAO;

	// Lấy dữ liệu từ bảng slide ra
	@Override
	public List<Slides> GetDataSlide() {
		return slidesDAO.GetDataSlide();
	}

	// Lấy dữ liệu từ bảng catogorys ra
	public List<Catogorys> GetDataCatogorys() {
		return catogorysDAO.GetDataCatogorys();
	}

	// Lấy dữ liệu từ bảng menu ra
	public List<Menus> GetDataMenus() {
		return menusDAO.GetDataMenus();
	}

	// Lấy dữ liệu từ bảng products ra
	@Override
	public List<ProductsDTO> GetDataProducts() {
		List<ProductsDTO> listProducts = productsDAO.GetDataProducts();
		return listProducts;
	}
	
	// Lấy tất cả dữ liệu từ bảng slide ra
	@Override
	public List<ProductsDTO> GetAllProducts() {
		List<ProductsDTO> listAllProducts = productsDAO.GetAllProduct();
		return listAllProducts;
	}
	
	// Tìm kiếm theo tên của sản phẩm
	public List<ProductsDTO> GetSearchProducts(String name) {
		List<ProductsDTO> listAllProducts = productsDAO.GetAllProduct();
		return listAllProducts;
	}

	// Lấy dữ liệu của sản phẩm mới để in ra trang chủ
	public List<ProductsDTO> GetDataProductsViewNew() {
		List<ProductsDTO> listProducts = productsDAO.GetDataProductsViewNew();
		return listProducts;
	}

	// Lấy dữ liệu tất cả sản phẩm mới
	public List<ProductsDTO> GetAllNewProducts() {
		List<ProductsDTO> listAllNewProducts = productsDAO.GetAllNewProducts();
		return listAllNewProducts;
	}

	// Lấy dữ liệu tất cả sản phẩm nổi bật
	public List<ProductsDTO> GetAllHighlighProducts() {
		List<ProductsDTO> listAllHighlighProducts = productsDAO.GetAllHighlighProducts();
		return listAllHighlighProducts;
	}

}
