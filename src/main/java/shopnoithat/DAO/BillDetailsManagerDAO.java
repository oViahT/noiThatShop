package shopnoithat.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import shopnoithat.DTO.BillDetailsManagerDTO;
import shopnoithat.DTO.BillDetailsManagerDTOMapper;

@Repository
public class BillDetailsManagerDAO extends BaseDAO {

	// Lay ra danh sach san pham có idBill

	public List<BillDetailsManagerDTO> GetBillDetailsByIDBill(int idBill) {
		//String sql = "SELECT * FROM `billdetails` WHERE idBill = " + idBill + " "; 
		String sql = "SELECT * FROM `billdetails` b join sanpham s on b.idProduct=s.maSP WHERE idBill= " + idBill + " ";
		List<BillDetailsManagerDTO> listProducts = _jdbcTemplate.query(sql, new BillDetailsManagerDTOMapper());
		return listProducts;
	}
}
