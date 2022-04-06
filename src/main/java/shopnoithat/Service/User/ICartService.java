package shopnoithat.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import shopnoithat.DTO.CartDTO;

@Service
public interface ICartService {
	public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart);
	public HashMap<Long, CartDTO> editCart(long id, int quantity, HashMap<Long, CartDTO> cart);
	public HashMap<Long, CartDTO> deleteCart(long id, HashMap<Long, CartDTO> cart);
	public int totalQuantity(HashMap<Long, CartDTO> cart);
	public double totalPrice(HashMap<Long, CartDTO> cart);

}
