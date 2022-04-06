package shopnoithat.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperNewProducts implements RowMapper<Products> {

	@Override
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products products = new Products();

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
