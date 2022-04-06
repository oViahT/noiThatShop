package shopnoithat.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import shopnoithat.Entity.MapperUsers;
import shopnoithat.Entity.Users;

@Repository
public class UsersDAO extends BaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// them user vao DB
	
	public int addAccount(Users user) {

		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO users ");
		sql.append("( ");
		sql.append(" user, password, name, address, phoneNumber ");
		sql.append(" )  ");
		sql.append(" VALUES ");
		sql.append("( ");
		sql.append("'" + user.getUser() + "','" + user.getPassword() + "','" + user.getName() + "','"
				+ user.getAddress() + "','" + user.getPhoneNumber() + "' ");
		sql.append(" )  ");

		int insert = _jdbcTemplate.update(sql.toString());

		return insert;
	}
	
	public int addAccountAd(Users user) {

		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO users ");
		sql.append("( ");
		sql.append(" idRoles, user, password, name, address, phoneNumber ");
		sql.append(" )  ");
		sql.append(" VALUES ");
		sql.append("( ");
		sql.append("'1','" + user.getUser() + "','" + user.getPassword() + "','" + user.getName() + "',' ',' ' ");
		sql.append(" )  ");

		int insert = _jdbcTemplate.update(sql.toString());

		return insert;
	}

	// Lay user co trong DB ra de kiem tra dang nhap
	public Users getAccount(Users user) {

		String sql = "SELECT * FROM users WHERE user = '" + user.getUser() + "'";
//		String sql = "SELECT u.id, r.name, user, password, u.name, address, phoneNumber FROM users u, roles r WHERE u.user = '" + user.getUser() + "'";

		Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());

		return result;
	}

	// Lấy dữ liệu của user ra và sắp xếp theo idRoles
	public List<Users> GetDataUsers() {
		List<Users> listUsers = new ArrayList<Users>();

		String sql = "SELECT * FROM `users` ORDER BY idRoles DESC";

		listUsers = _jdbcTemplate.query(sql, new MapperUsers());

		return listUsers;
	}

	// Xóa user
	public void delete(int id) {
		String sql = "DELETE FROM `users` WHERE id = " + id + "";
		jdbcTemplate.update(sql);
	}

	// ************************************dang dở
	public void editInfo(Users users, long userID) {
		String sql = "UPDATE `users` SET `password`='"+users.getPassword()+"', `name`='" + users.getName() + "',`address`='" + users.getAddress()
				+ "',`phoneNumber`='" + users.getPhoneNumber() + "'  WHERE  `id`='" + userID + "' ";
		jdbcTemplate.update(sql);
	}
	// ************************************
}
