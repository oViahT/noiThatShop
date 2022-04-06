package shopnoithat.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import shopnoithat.DTO.ProductsDTO;
import shopnoithat.DTO.ProductsDTOMapper;

@Repository
public class ProductsDAO extends BaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final boolean YES = true;
	private final boolean NO = false;

	// D�ng Stringbuffer de co the truy van kep
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("* ");
		sql.append("FROM ");
		sql.append("sanpham ");
		return sql;
	}

	// truy van lay ra cac san pham noi bat hoac san pham moi
	private String SqlProducts(boolean sanPhamMoi, boolean noiBat) {
		StringBuffer sql = SqlString();
		if (noiBat) {
			sql.append("WHERE noiBat = true ");
		}
		if (sanPhamMoi) {
			sql.append("WHERE sanPhamMoi = true ");
		}
		sql.append("ORDER BY RAND() ");
		sql.append("LIMIT 12 ");
		return sql.toString();
	}

	// Lay ra danh sach san pham noi bat hoac san pham moi
	public List<ProductsDTO> GetDataProducts() {
		String sql = SqlProducts(YES, NO);
		List<ProductsDTO> listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}

	// tim san pham theo id loai cua no
	private StringBuffer SqlProductsByID(int id) {
		StringBuffer sql = SqlString();

		sql.append("WHERE maLoai = " + id + "   ");

		return sql;
	}

	// lay ra tat ca san pham co cung id loai
	public List<ProductsDTO> GetAllProductsByID(int id) {
		String sql = SqlProductsByID(id).toString();
		List<ProductsDTO> listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}

	// truy van gioi han san pham co trong 1 trang de co the de dang phan trang
	private String SqlProductsPaginates(int id, int start, int totalPage) {
		StringBuffer sql = SqlProductsByID(id);

		sql.append("LIMIT " + start + ", " + totalPage + " ");

		return sql.toString();
	}

	private String SqlAllProductsPaginates(int start, int totalPage) {
		StringBuffer sql = SqlString();

		sql.append("LIMIT " + start + ", " + totalPage + " ");

		return sql.toString();
	}

	private StringBuffer SqlAllNewProductsPaginates() {
		StringBuffer sql = SqlString();

		sql.append("WHERE sanPhamMoi =true ");

		return sql;
	}

	private StringBuffer SqlAllHighlithsProductsPaginates() {
		StringBuffer sql = SqlString();

		sql.append("WHERE noiBat =true ");

		return sql;
	}

	private String SqlAllNewProductsPaginates(int start, int totalPage) {
		StringBuffer sql = SqlAllNewProductsPaginates();

		sql.append("LIMIT " + start + ", " + totalPage + " ");

		return sql.toString();
	}

	private String SqlAllHighlithsProductsPaginates(int start, int totalPage) {
		StringBuffer sql = SqlAllNewProductsPaginates();

		sql.append("LIMIT " + start + ", " + totalPage + " ");

		return sql.toString();
	}

	// lay ra so san pham tu cau truy van LIMIT
	public List<ProductsDTO> GetDataProductsPaginates(int id, int start, int totalPage) {
		StringBuffer sqlDataByID = SqlProductsByID(id);

		List<ProductsDTO> listDataByID = _jdbcTemplate.query(sqlDataByID.toString(), new ProductsDTOMapper());
		List<ProductsDTO> listProducts = new ArrayList<ProductsDTO>();

		if (listDataByID.size() > 0) {
			String sql = SqlProductsPaginates(id, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		}

		return listProducts;
	}

	// lay ra so san pham tu cau truy van LIMIT
	public List<ProductsDTO> GetDataAllProductsPaginates(int start, int totalPage) {
		StringBuffer sqlDataAllProducts = SqlString();

		List<ProductsDTO> listDataAllProducts = _jdbcTemplate.query(sqlDataAllProducts.toString(),
				new ProductsDTOMapper());
		List<ProductsDTO> listAllProducts = new ArrayList<ProductsDTO>();

		if (listDataAllProducts.size() > 0) {
			String sql = SqlAllProductsPaginates(start, totalPage);
			listAllProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		}

		return listAllProducts;
	}

	// lay ra so san pham tu cau truy van LIMIT
	public List<ProductsDTO> GetDataAllNewProductsPaginates(int start, int totalPage) {
		StringBuffer sqlDataAllNewProducts = SqlAllNewProductsPaginates();

		List<ProductsDTO> listDataAllNewProducts = _jdbcTemplate.query(sqlDataAllNewProducts.toString(),
				new ProductsDTOMapper());
		List<ProductsDTO> listAllNewProducts = new ArrayList<ProductsDTO>();

		if (listDataAllNewProducts.size() > 0) {
			String sql = SqlAllNewProductsPaginates(start, totalPage);
			listAllNewProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		}

		return listAllNewProducts;
	}

	// lay ra so san pham tu cau truy van LIMIT
	public List<ProductsDTO> GetDataAllHighlithsProductsPaginates(int start, int totalPage) {
		StringBuffer sqlDataAllHighlithsProducts = SqlAllHighlithsProductsPaginates();

		List<ProductsDTO> listDataAllHighlithsProducts = _jdbcTemplate.query(sqlDataAllHighlithsProducts.toString(),
				new ProductsDTOMapper());
		List<ProductsDTO> listAllHighlithsProducts = new ArrayList<ProductsDTO>();

		if (listDataAllHighlithsProducts.size() > 0) {
			String sql = SqlAllHighlithsProductsPaginates(start, totalPage);
			listAllHighlithsProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		}

		return listAllHighlithsProducts;
	}

	// lay ra san pham co id
	private String SqlProductDetailsByID(long id) {
		StringBuffer sql = SqlString();

		sql.append("WHERE maSP = N'" + id + "' ");

		return sql.toString();
	}

	// lay ra danh sach tat ca san pham co cung id san pham
	public List<ProductsDTO> GetProductByID(long id) {
		String sql = SqlProductDetailsByID(id);
		List<ProductsDTO> productDetails = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return productDetails;
	}

	// tim va xem chi tiet san pham bang id
	public ProductsDTO FindProductByID(long id) {
		String sql = SqlProductDetailsByID(id);
		ProductsDTO product = _jdbcTemplate.queryForObject(sql, new ProductsDTOMapper());
		return product;
	}

	// lay ra tat ca san pham
	public List<ProductsDTO> GetAllProduct() {
		String sql = "SELECT * FROM sanpham ORDER BY RAND() ";
		List<ProductsDTO> listAllProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listAllProducts;
	}

	// tim kiem
	public List<ProductsDTO> GetSearchProduct(String name) {
		String sql = "SELECT * FROM `sanpham` WHERE tenSP LIKE '%" + name + "%'";
		List<ProductsDTO> listAllProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listAllProducts;
	}

	// xóa
	public void delete(int id) {
		String sql = "DELETE FROM `sanpham` WHERE maSP = '" + id + "'";
		_jdbcTemplate.update(sql);

	}

	// Truy vấn lấy random 7 sản phẩm mới
	private String SqlProductsViewNew(boolean sanPhamMoi) {
		StringBuffer sql = SqlString();
		if (sanPhamMoi) {
			sql.append("WHERE sanPhamMoi = true ");
		}
		sql.append("ORDER BY RAND() ");
		sql.append("LIMIT 7 ");
		return sql.toString();
	}

	// Hiện lên website
	public List<ProductsDTO> GetDataProductsViewNew() {
		String sql = SqlProductsViewNew(YES);
		List<ProductsDTO> listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}

	// Thêm sản phẩm
	public int addProduct(ProductsDTO addProducts) {

		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO `sanpham` ");
		sql.append("( ");
		sql.append(" `maLoai`,`tenSP`,`image`, `giaBan`, `dvt`,`giamGia`,`gioiThieu` ");
		sql.append(" )  ");
		sql.append(" VALUES ");
		sql.append("( ");
		sql.append("'" + addProducts.getMaLoai() + "','" + addProducts.getTenSP() + "','" + addProducts.getImage()
				+ "','" + addProducts.getGiaBan() + "','" + addProducts.getDvt() + "','" + addProducts.getGiamGia()
				+ "','" + addProducts.getGioiThieu() + "' ");
		sql.append(" )  ");
		int result = _jdbcTemplate.update(sql.toString());
		return result;
	}

	// cập nhật sản phẩm
	public void editProduct(ProductsDTO product, long idProduct) {
		String sql = "UPDATE `sanpham` SET `maLoai`='" + product.getMaLoai() + "',`tenSP`='" + product.getTenSP()
				+ "',`image`='" + product.getImage() + "',`giaBan`='" + product.getGiaBan() + "',`dvt`='"
				+ product.getDvt() + "',`giamGia`='" + product.getGiamGia() + "',`gioiThieu`='" + product.getGioiThieu()
				+ "' WHERE `maSP`='" + idProduct + "'";
		jdbcTemplate.update(sql);
		/*
		 * String sql = "UPDATE `sanpham` SET `maLoai`='" + product.getMaLoai() +
		 * "',`tenSP`='" + product.getTenSP() + "',`image`='" + product.getImage() +
		 * "',`giaBan`='" + product.getGiaBan() + "',`dvt`='" + product.getDvt() +
		 * "',`giamGia`='" + product.getGiamGia() + "',`gioiThieu`='" +
		 * product.getGioiThieu() +
		 * "',`noiBat`='"+product.isNoiBat()+"',`sanPhamMoi`='"+product.isSanPhamMoi()
		 * +"' WHERE `maSP`='" + idProduct + "'"; jdbcTemplate.update(sql);
		 */
	}

	// lấy danh sách sản phẩm mới
	public List<ProductsDTO> GetAllNewProducts() {
		String sql = "SELECT * FROM `sanpham` WHERE sanPhamMoi= true";
		List<ProductsDTO> listNewProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listNewProducts;
	}

	// lấy danh sách sản phẩm nổi bật
	public List<ProductsDTO> GetAllHighlighProducts() {
		String sql = "SELECT * FROM `sanpham` WHERE noiBat= true";
		List<ProductsDTO> listNewProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listNewProducts;
	}

}
