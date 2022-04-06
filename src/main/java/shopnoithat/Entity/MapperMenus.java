package shopnoithat.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperMenus implements RowMapper<Menus> {

	@Override
	public Menus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Menus menus = new Menus();

		menus.setMaDS(rs.getInt("maDS"));
		menus.setTenDS(rs.getString("tenDS"));
		menus.setUrl(rs.getString("url"));

		return menus;
	}
}
