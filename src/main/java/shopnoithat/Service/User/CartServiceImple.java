package shopnoithat.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopnoithat.DAO.CartDAO;
import shopnoithat.DTO.CartDTO;

@Service
public class CartServiceImple implements ICartService {
	@Autowired
	public CartDAO cartDAO = new CartDAO();

	// Thêm vào giỏ hàng
	@Override
	public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart) {
		return cartDAO.addCart(id, cart);
	}

	// Sửa sản phẩm có trong giỏ hàng
	@Override
	public HashMap<Long, CartDTO> editCart(long id, int quantity, HashMap<Long, CartDTO> cart) {
		return cartDAO.editCart(id, quantity, cart);
	}

	// Xóa sản phẩm có trong giỏ hàng
	@Override
	public HashMap<Long, CartDTO> deleteCart(long id, HashMap<Long, CartDTO> cart) {
		return cartDAO.deleteCart(id, cart);
	}

	// Tổng số lượng sản phẩm có trong giỏ hàng
	@Override
	public int totalQuantity(HashMap<Long, CartDTO> cart) {
		return cartDAO.totalQuantity(cart);
	}

	// Tổng tiền
	@Override
	public double totalPrice(HashMap<Long, CartDTO> cart) {
		return cartDAO.totalPrice(cart);
	}
}
