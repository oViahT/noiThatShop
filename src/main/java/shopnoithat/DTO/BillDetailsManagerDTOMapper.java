package shopnoithat.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BillDetailsManagerDTOMapper implements RowMapper<BillDetailsManagerDTO> {
	public BillDetailsManagerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetailsManagerDTO billDetailsManager = new BillDetailsManagerDTO();

		ProductsDTOMapper pdm = new ProductsDTOMapper();
		ProductsDTO sp = pdm.mapRow(rs, rowNum);

		billDetailsManager.setId(rs.getInt("id"));
		billDetailsManager.setProducts(sp);
		sp.setMaSP(rs.getLong("maSP"));
		billDetailsManager.setQuantity(rs.getInt("quantity"));
		billDetailsManager.setTotal(rs.getDouble("total"));

		return billDetailsManager;
	}

}
