package shopnoithat.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCatogorys implements RowMapper<Catogorys> {

	@Override
	public Catogorys mapRow(ResultSet rs, int rowNum) throws SQLException {
		Catogorys catogorys = new Catogorys();

		catogorys.setMaLoai(rs.getInt("maLoai"));
		catogorys.setTenLoai(rs.getString("tenLoai"));

		return catogorys;
	}

}
