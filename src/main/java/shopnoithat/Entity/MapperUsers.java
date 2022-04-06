package shopnoithat.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users users = new Users();
		
		users.setId(rs.getInt("id"));
		users.setIdRoles(rs.getBoolean("idRoles"));
		users.setUser(rs.getString("user"));
		users.setPassword(rs.getString("password"));
		users.setName(rs.getString("name"));
		users.setAddress(rs.getString("address"));
		users.setPhoneNumber(rs.getString("phoneNumber"));
		
		return users;
	}

}
