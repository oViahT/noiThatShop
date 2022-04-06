package shopnoithat.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperRoles implements RowMapper<Roles> {
	@Override
	public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
		Roles roles = new Roles();
		
		roles.setId(rs.getBoolean("id"));
		roles.setName(rs.getString("name"));
		
		return roles;
	}
}
