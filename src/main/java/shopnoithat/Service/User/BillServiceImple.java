
package shopnoithat.Service.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopnoithat.DAO.BillDAO;
import shopnoithat.DAO.BillDetailsManagerDAO;
import shopnoithat.DTO.BillDetailsManagerDTO;
import shopnoithat.DTO.CartDTO;
import shopnoithat.Entity.Bill;
import shopnoithat.Entity.BillDetails;

@Service
public class BillServiceImple implements IBillService {

	@Autowired
	public BillDAO billDAO;

	@Autowired
	BillDetailsManagerDAO billDetailsManagerDAO = new BillDetailsManagerDAO();

	// Thêm đơn hàng
	@Override
	public int addBill(Bill bill) {
		return billDAO.addBill(bill);
	}

	// Thêm vào chi tiết đơn hàng
	@Override
	public void addBillDetails(HashMap<Long, CartDTO> carts) {

		int idBill = billDAO.getLastBill();

		for (Map.Entry<Long, CartDTO> itemCart : carts.entrySet()) {
			BillDetails billDetails = new BillDetails();
			billDetails.setIdBill(idBill);
			billDetails.setIdProduct(itemCart.getValue().getProduct().getMaSP());
			billDetails.setQuantity(itemCart.getValue().getQuantity());
			billDetails.setTotal(itemCart.getValue().getTotalPrice());
			billDAO.addBillDetails(billDetails);
		}
	}

	// Lấy tất cả đơn hàng ra
	@Override
	public List<Bill> GetAllBills() {
		return billDAO.GetDataBill();
	}

	// Lấy tất cả sản phẩm có trong đơn hàng theo id của đơn hàng
	@Override
	public Bill GetAllProdutsByIDBill(int idBill) {
		List<Bill> listBill = billDAO.GetDataBillByID(idBill);
		return listBill.get(0);
	}

	@Override
	public List<Bill> GetProductByIDBill(int id) {
		return billDAO.GetDataBillByID(id);
	}

	//
	/*
	 * @Override public BillDetailsManagerDTO GetBillDetailsByIDBill(int idBill) {
	 * List<BillDetailsManagerDTO> listProductDetailsByIDBill =
	 * billDetailsManagerDAO.GetBillDetailsByIDBill(idBill); return
	 * listProductDetailsByIDBill.get(0); }
	 */

	@Override
	public List<BillDetailsManagerDTO> GetBillDetailsByIDBill(int idBill) {
		// List<BillDetailsManagerDTO> listProductDetailsByIDBill =
		// billDetailsManagerDAO.GetBillDetailsByIDBill(idBill);
		return billDetailsManagerDAO.GetBillDetailsByIDBill(idBill);
	}

	// Xóa đơn hàng
	public void delete(int id) {
		billDAO.deleteBill(id);

	}

	public List<Bill> GetAllBillByIDUser(String email) {
		return billDAO.GetAllBillByIDUser(email);
	}

	public List<BillDetailsManagerDTO> GetGistoryBillDetailsByIDBill(int idBill) {
		return billDetailsManagerDAO.GetBillDetailsByIDBill(idBill);
	}

}
