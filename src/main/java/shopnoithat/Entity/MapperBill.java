package shopnoithat.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBill implements RowMapper<Bill> {

	@Override
	public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bill bill = new Bill();

		bill.setId(rs.getInt("id"));
		bill.setName(rs.getString("name"));
		bill.setEmail(rs.getString("email"));
		bill.setPhoneNumber(rs.getString("phoneNumber"));
		bill.setNote(rs.getString("note"));
		bill.setBuyDate(rs.getDate("buyDate"));
		bill.setQuantity(rs.getInt("quantity"));
		bill.setTotal(rs.getDouble("total"));
		bill.setAddress(rs.getString("address"));

		return bill;
	}
}
