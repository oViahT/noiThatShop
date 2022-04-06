package shopnoithat.UserController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopnoithat.DTO.CartDTO;
import shopnoithat.Entity.Bill;
import shopnoithat.Entity.Users;
import shopnoithat.Service.User.BillServiceImple;
import shopnoithat.Service.User.CartServiceImple;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImple cartServiceImple = new CartServiceImple();

	@Autowired
	private BillServiceImple billServiceImple = new BillServiceImple();

	// Hiện thị trang giỏ hàng
	@RequestMapping(value = "gio-hang")
	public ModelAndView listCart() {

		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("catogorys", _homeService.GetDataCatogorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		/* _mvShare.addObject("newProducts", _homeService.GetDataNewProducts()); */

		_mvShare.setViewName("user/cart/listCart");
		return _mvShare;
	}

	// Thêm vào giỏ hàng
	@RequestMapping(value = "AddCart/{id}")
	public String addcart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");

		if (cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartServiceImple.addCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartServiceImple.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartServiceImple.totalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}

	// Sửa số lượng sản phẩm theo id của sản phẩm
	@RequestMapping(value = "EditCart/{id}/{quantity}")
	public String editCart(HttpServletRequest request, HttpSession session, @PathVariable long id,
			@PathVariable int quantity) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");

		if (cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartServiceImple.editCart(id, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartServiceImple.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartServiceImple.totalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}

	// Xóa sản phẩm theo id của sản phẩm
	@RequestMapping(value = "DeleteCart/{id}")
	public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");

		if (cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartServiceImple.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartServiceImple.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartServiceImple.totalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}

	// Trang thanh toán đơn hàng
	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/bill/checkout");

		Bill bill = new Bill();
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			_mvShare.setViewName("redirect:dang-ky");
		
		}
		else {
			bill.setAddress(loginInfo.getAddress());
			bill.setName(loginInfo.getName());
			bill.setPhoneNumber(loginInfo.getPhoneNumber());
			bill.setEmail(loginInfo.getUser());
			_mvShare.addObject("bill", bill);
		}
		
		return _mvShare;
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public ModelAndView checkoutBill(HttpServletRequest request, HttpSession session,
			@ModelAttribute("bill") Bill bill) {
try {
			if (bill.getName() == "" || bill.getEmail() == "" || bill.getPhoneNumber() == ""
					|| bill.getAddress() == "") {
				_mvShare.addObject("statusCheckout", "Thanh toán thất bại!!!");
			} else {
				
				bill.setQuantity((int) session.getAttribute("TotalQuantityCart"));
				bill.setTotal((double) session.getAttribute("TotalPriceCart"));
				HashMap<Long, CartDTO> carts = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
				
					if (carts == null) {
						_mvShare.addObject("statusCheckout", "Hiện không có sản phẩm nào trong giỏ hàng!!!");
						
					} else {
						double checkTotal=bill.getTotal();
						if(checkTotal<=0) {
							_mvShare.addObject("statusCheckout", "Không có hàng để thanh toán!");
							return _mvShare;
						}		
						billServiceImple.addBill(bill);
						billServiceImple.addBillDetails(carts);
						session.removeAttribute("Cart");
						session.removeAttribute("TotalQuantityCart");
						session.removeAttribute("TotalPriceCart");
						_mvShare.addObject("statusCheckout", "Thanh toán thành công!!!");
					}
					
				_mvShare.setViewName("redirect:" + request.getHeader("Referer"));
				
			}

}catch(Exception ex) {
	_mvShare.addObject("statusCheckout", "Website đang bảo trì, vui lòng quay lại sau ít phút!");
}
		return _mvShare;
	}
	//
}
