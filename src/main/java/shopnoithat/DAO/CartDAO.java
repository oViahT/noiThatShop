package shopnoithat.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopnoithat.DTO.CartDTO;
import shopnoithat.DTO.ProductsDTO;

@Repository
public class CartDAO extends BaseDAO {

	@Autowired
	ProductsDAO productsDAO = new ProductsDAO();

	// Ham nay dung de them cac san pham co trong gio hang
	public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();
		
		// Su dung FindProductByID(id); cua ham ProductsDAO de co the tim kiem san pham theo id cua no 
		ProductsDTO product = productsDAO.FindProductByID(id);

		// Neu san pham ton tai va ton tai 1 id nao do thi cho phep dat lai so luong san pham co trong gio va nguoc lai
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getGiaBan());
		} else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(product.getGiaBan());
		}

		// Dua san pham ra 
		cart.put(id, itemCart);

		return cart;
	}

	// Sua lai so luong
	public HashMap<Long, CartDTO> editCart(long id, int quantity, HashMap<Long, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();

		if (cart == null) {
			return cart;
		}

		if (cart.containsKey(id)) {
			itemCart = cart.get(id);

			itemCart.setQuantity(quantity);
			double totalPrice = (quantity * itemCart.getProduct().getGiaBan());
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);

		return cart;
	}

	// Xoa san pham 
	public HashMap<Long, CartDTO> deleteCart(long id, HashMap<Long, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();

		if (cart == null) {
			return cart;
		}

		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	// Tinh tong so luong
	public int totalQuantity(HashMap<Long, CartDTO> cart) {

		int totalQua = 0;

		for (Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			totalQua += itemCart.getValue().getQuantity();
		}

		return totalQua;
	}

	// Tong gia
	public double totalPrice(HashMap<Long, CartDTO> cart) {

		double totalPri = 0;

		for (Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			totalPri += itemCart.getValue().getTotalPrice();
		}

		return totalPri;
	}
}
