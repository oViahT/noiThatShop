package shopnoithat.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// Day la lop co so

public class BaseDAO {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
}
