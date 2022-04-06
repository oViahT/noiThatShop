package shopnoithat.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

// Nhung Mapper nay dung de ket noi voi cac ham DAO hoac DTO de co the lien ket DB vs Website cua chung ta

public class ProductsDTOMapper implements RowMapper<ProductsDTO> {

	public ProductsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDTO products = new ProductsDTO();
		
		products.setMaSP(rs.getLong("maSP"));
		products.setMaLoai(rs.getInt("maLoai"));
		products.setTenSP(rs.getString("tenSP"));
		products.setImage(rs.getString("image"));
		products.setNgayTao(rs.getDate("ngayTao"));
		products.setDvt(rs.getString("dvt"));
		products.setNgayCapNhat(rs.getDate("ngayCapNhat"));
		products.setGiaBan(rs.getDouble("giaBan"));
		products.setGiamGia(rs.getInt("giamGia"));
		products.setGioiThieu(rs.getString("gioiThieu"));
		products.setNoiBat(rs.getBoolean("noiBat"));
		products.setSanPhamMoi(rs.getBoolean("sanPhamMoi"));
		
		return products;
	}
}
