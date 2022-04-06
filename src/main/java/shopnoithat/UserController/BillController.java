package shopnoithat.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shopnoithat.Service.User.BillServiceImple;

@Controller
public class BillController extends BaseController {
	
	@Autowired
	BillServiceImple _billServiceImple;
	
	// Hiển thị trang thanh toán
	@RequestMapping(value = "/checkout")
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("user/bill/checkout");
		return mv;
	}

	// lịch sử mua hàng
	@RequestMapping(value = "/lich-su-mua-hang/{email}")
	public ModelAndView historyBill( @PathVariable String email) {
		_mvShare.setViewName("user/bill/historyBill");
		_mvShare.addObject("historyBill", _billServiceImple.GetAllBillByIDUser(email));
		return _mvShare;
	}
	
	// Hiển thị chi tiết hóa đơn theo id của đơn hàng
	@RequestMapping(value = { "/lich-su-mua-hang/{email}/{id}" })
	public ModelAndView historyBillsDetails(@PathVariable int id, @PathVariable String email) {

		_mvShare.setViewName("user/bill/historyBillDetails");
		_mvShare.addObject("historyBillDetails", _billService.GetGistoryBillDetailsByIDBill(id));
		return _mvShare;
	}
}
