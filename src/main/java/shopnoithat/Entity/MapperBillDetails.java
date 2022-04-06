
package shopnoithat.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBillDetails implements RowMapper<BillDetails> {

	@Override
	public BillDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetails billDetails = new BillDetails();

		billDetails.setId(rs.getInt("id"));
		billDetails.setIdProduct(rs.getLong("idProduct"));
		billDetails.setIdBill(rs.getInt("idBill"));
		billDetails.setQuantity(rs.getInt("quantity"));
		billDetails.setTotal(rs.getDouble("total"));

		return billDetails;
	}
}
