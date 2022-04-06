package shopnoithat.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shopnoithat.Service.User.IProductDetailsService;

@Controller
public class ProductDetailsController extends BaseController {

	@Autowired
	private IProductDetailsService _productDetailsService;

	// Hiện thị chi tiết sản phẩm
	@RequestMapping(value = { "san-pham/chi-tiet-san-pham/{id}", "chi-tiet-san-pham/{id}" })
	public ModelAndView Index(@PathVariable long id) {

		_mvShare.setViewName("user/products/productDetail");
		_mvShare.addObject("productDetail", _productDetailsService.GetProductByID(id));

		int idTypeProducts = _productDetailsService.GetProductByID(id).getMaLoai();
		_mvShare.addObject("productDetailByIDType", _productDetailsService.GetProductByIDType(idTypeProducts));

		return _mvShare;
	}
}
