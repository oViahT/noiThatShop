
package shopnoithat.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import shopnoithat.DTO.BillDetailsManagerDTO;
import shopnoithat.DTO.BillDetailsManagerDTOMapper;
import shopnoithat.Entity.Bill;
import shopnoithat.Entity.BillDetails;
import shopnoithat.Entity.MapperBill;

@Repository
public class BillDAO extends BaseDAO {

	@Autowired
	ProductsDAO productsDAO = new ProductsDAO();

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addBill(Bill bill) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO bill ");
		sql.append("( ");
		sql.append("`name`, `email`, `phoneNumber`, `address`, `note`, `quantity`, `total` ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("'" + bill.getName() + "', '" + bill.getEmail() + "', '" + bill.getPhoneNumber() + "', '"
				+ bill.getAddress() + "', '" + bill.getNote() + "', '" + bill.getQuantity() + "', '" + bill.getTotal()
				+ "' ");
		sql.append(") ");

		int insert = _jdbcTemplate.update(sql.toString());

		return insert;
	};

	// lấy bill cuối cùng ra
	public int getLastBill() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bill");
		int id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, int.class);
		return id;
	};

	// thêm bill mới thanh toán vào billDetails
	public int addBillDetails(BillDetails billDetails) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO billdetails ");
		sql.append("( ");
		sql.append(" idProduct, ");
		sql.append(" idBill, ");
		sql.append(" quantity, ");
		sql.append(" total ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append(" '" + billDetails.getIdProduct() + "', ");
		sql.append(" '" + billDetails.getIdBill() + "', ");
		sql.append(" '" + billDetails.getQuantity() + "', ");
		sql.append(" '" + billDetails.getTotal() + "' ");
		sql.append(") ");
		int insert = _jdbcTemplate.update(sql.toString());

		return insert;
	}

	// lấy dữ liệu Bill ra
	public List<Bill> GetDataBill() {
		List<Bill> listBills = new ArrayList<Bill>();

		String sql = "SELECT * FROM `bill`";
		listBills = _jdbcTemplate.query(sql, new MapperBill());

		return listBills;

	}

	// lấy dữ liệu của bill theo id của bill
	public List<Bill> GetDataBillByID(int idBill) {
		List<Bill> listBillsByID = new ArrayList<Bill>();

		String sql = "SELECT * FROM `bill` WHERE id=" + idBill + "";
		listBillsByID = _jdbcTemplate.query(sql, new MapperBill());

		return listBillsByID;

	}

	// truy vấn lấy billdetails từ id của bill
	private String SqlBillByID(int idBill) {

		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT sanpham.image, sanpham.gioiThieu, sanpham.giaBan, billdetails.quantity, billdetails.total FROM `bill`, billdetails, sanpham WHERE bill.id = billdetails.idBill AND billdetails.idProduct = sanpham.maSP and bill.id = "
						+ idBill + " ");

		return sql.toString();
	}

	// tìm kiếm id của bill trong DB
	public Bill FindBillByID(int id) {
		String sql = SqlBillByID(id);
		Bill bill = _jdbcTemplate.queryForObject(sql, new MapperBill());
		return bill;
	}

	// ------------------------------------------------
	public List<Bill> deleteBillByIDl(int idBill) {
		String sql = "DELETE FROM `bill` WHERE id= " + idBill + " ";
		List<Bill> listProducts = _jdbcTemplate.query(sql, new MapperBill());
		return listProducts;
	}
	// ------------------------------------------------

	public void deleteBill(int id) {
		String sql = "DELETE FROM `bill` WHERE id = " + id + "";
		jdbcTemplate.update(sql);

	}

	public List<Bill> GetAllBillByIDUser(String email) {
		String sql = "SELECT * FROM `bill` WHERE email = '"+email+".com'";
		List<Bill> listBills = _jdbcTemplate.query(sql, new MapperBill());
		return listBills;
	}
}
