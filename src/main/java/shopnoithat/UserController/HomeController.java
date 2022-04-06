package shopnoithat.UserController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopnoithat.DAO.ProductsDAO;
import shopnoithat.DTO.PaginatesDTO;
import shopnoithat.DTO.ProductsDTO;
import shopnoithat.Entity.Users;
import shopnoithat.Service.User.AccountServiecImple;
import shopnoithat.Service.User.BillServiceImple;
import shopnoithat.Service.User.CategorysServiceImple;
import shopnoithat.Service.User.IBillService;
import shopnoithat.Service.User.PaginatesServiceImple;
import shopnoithat.Service.User.ProductDetailsServiceImple;

@Controller
public class HomeController extends BaseController {
	@Autowired
	ProductsDAO _ProductsDAO;

	@Autowired
	private IBillService _billService;

	@Autowired
	AccountServiecImple accountServiecImple = new AccountServiecImple();

	@Autowired
	BillServiceImple billServiceImple = new BillServiceImple();

	// -------------------
	@Autowired
	ProductDetailsServiceImple _productDetailsServiceImple;

	@Autowired
	ProductDetailsServiceImple productDetailsServiceImple = new ProductDetailsServiceImple();

	@Autowired
	private PaginatesServiceImple paginatesService;

	@Autowired
	private CategorysServiceImple categorysService;

	private int TotalProductsOfPage = 12;
	// -----------------------

	// Hiển thị trang chủ
	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index() {

		String name = "";

		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("catogorys", _homeService.GetDataCatogorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.addObject("viewProductsNew", _homeService.GetDataProductsViewNew());
		_mvShare.addObject("searchProducts", _homeService.GetSearchProducts(name));

		_mvShare.setViewName("user/index");
		return _mvShare;
	}

	// Hiển thị trang tất cả sản phẩm và phân trang
	@RequestMapping(value = "/tat-ca-san-pham")
	public ModelAndView Product() {
		// _mvShare.addObject("allProducts", _homeService.GetAllProducts());

		_mvShare.setViewName("user/products/allProducts");

		int totalData = _homeService.GetAllProducts().size();

		PaginatesDTO paginateInfo = paginatesService.GetInfoPaginates(totalData, TotalProductsOfPage, 1);
		_mvShare.addObject("allProducts", _homeService.GetAllProducts());
		_mvShare.addObject("paginateInfoAllProdcts", paginateInfo);
		_mvShare.addObject("allProductsPaginate", categorysService
				.GetDataAllProductsPaginate(paginateInfo.getNumberStartPageOfProduct(), TotalProductsOfPage));

		return _mvShare;
	}

	@RequestMapping(value = "/tat-ca-san-pham/{currentPage}")
	public ModelAndView Product(@PathVariable String currentPage) {
		// _mvShare.addObject("allProducts", _homeService.GetAllProducts());

		_mvShare.setViewName("user/products/allProducts");

		int totalData = _homeService.GetAllProducts().size();

		PaginatesDTO paginateInfo = paginatesService.GetInfoPaginates(totalData, TotalProductsOfPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("allProducts", _homeService.GetAllProducts());
		_mvShare.addObject("paginateInfoAllProdcts", paginateInfo);
		_mvShare.addObject("allProductsPaginate", categorysService
				.GetDataAllProductsPaginate(paginateInfo.getNumberStartPageOfProduct(), TotalProductsOfPage));

		return _mvShare;
	}

	// Hiển thị trang tất cả sản phẩm mới
	@RequestMapping(value = "/san-pham-moi")
	public ModelAndView newProduct() {
		// _mvShare.addObject("allNewProducts", _homeService.GetAllNewProducts());

		_mvShare.setViewName("user/products/newProducts");

		int totalData = _homeService.GetAllNewProducts().size();

		PaginatesDTO paginateInfo = paginatesService.GetInfoPaginates(totalData, TotalProductsOfPage, 1);
		_mvShare.addObject("allNewProducts", _homeService.GetAllNewProducts());
		_mvShare.addObject("paginateInfoAllNewProdcts", paginateInfo);
		_mvShare.addObject("allNewProductsPaginate", categorysService
				.GetDataAllNewProductsPaginate(paginateInfo.getNumberStartPageOfProduct(), TotalProductsOfPage));

		return _mvShare;
	}

	@RequestMapping(value = "/san-pham-moi/{currentPage}")
	public ModelAndView newProduct(@PathVariable String currentPage) {
		// _mvShare.addObject("allProducts", _homeService.GetAllProducts());

		_mvShare.setViewName("user/products/newProducts");

		int totalData = _homeService.GetAllNewProducts().size();

		PaginatesDTO paginateInfo = paginatesService.GetInfoPaginates(totalData, TotalProductsOfPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("allNewProducts", _homeService.GetAllNewProducts());
		_mvShare.addObject("paginateInfoAllNewProdcts", paginateInfo);
		_mvShare.addObject("allNewProductsPaginate", categorysService
				.GetDataAllNewProductsPaginate(paginateInfo.getNumberStartPageOfProduct(), TotalProductsOfPage));

		return _mvShare;
	}

	// Hiển thị trang tất cả sản nổi bật
	@RequestMapping(value = "/san-pham-noi-bat")
	public ModelAndView highlightProduct() {
		// _mvShare.addObject("allNewProducts", _homeService.GetAllNewProducts());

		_mvShare.setViewName("user/products/highlighProducts");

		int totalData = _homeService.GetAllHighlighProducts().size();

		PaginatesDTO paginateInfo = paginatesService.GetInfoPaginates(totalData, TotalProductsOfPage, 1);
		_mvShare.addObject("allHighlithsProducts", _homeService.GetAllHighlighProducts());
		_mvShare.addObject("paginateInfoAllHighlithsProdcts", paginateInfo);
		_mvShare.addObject("allHighlithsProductsPaginate", categorysService
				.GetDataAllHighlithsProductsPaginate(paginateInfo.getNumberStartPageOfProduct(), TotalProductsOfPage));

		return _mvShare;
	}

	@RequestMapping(value = "/san-pham-noi-bat/{currentPage}")
	public ModelAndView highlightProduct(@PathVariable String currentPage) {
		// _mvShare.addObject("allNewProducts", _homeService.GetAllNewProducts());

		_mvShare.setViewName("user/products/highlighProducts");

		int totalData = _homeService.GetAllHighlighProducts().size();

		PaginatesDTO paginateInfo = paginatesService.GetInfoPaginates(totalData, TotalProductsOfPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("allHighlithsProducts", _homeService.GetAllHighlighProducts());
		_mvShare.addObject("paginateInfoAllHighlithsProdcts", paginateInfo);
		_mvShare.addObject("allHighlithsProductsPaginate", categorysService
				.GetDataAllHighlithsProductsPaginate(paginateInfo.getNumberStartPageOfProduct(), TotalProductsOfPage));

		return _mvShare;
	}

	// Hiển thị trang giới thiệu website
	@RequestMapping(value = "/gioi-thieu")
	public ModelAndView aboutUs() {

		_mvShare.setViewName("user/aboutUS");
		return _mvShare;
	}

	// Hiển thị trang liên hệ
	@RequestMapping(value = "/lien-he")
	public ModelAndView contact() {

		_mvShare.setViewName("user/contact");
		return _mvShare;
	}

	// ***********************************************************ADMIN***********************************************************
	// Hiện thị trang quản trị
	@RequestMapping(value = { "/quan-tri" })
	public ModelAndView IndexAdmin(HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			_mvShare.setViewName("redirect:dang-ky");
		} else {
			if (loginInfo.isIdRoles() == true)
				_mvShare.setViewName("admin/admin");
			else {
				_mvShare.setViewName("redirect:trang-chu");
			}
		}
		return _mvShare;
	}

	// ----------------Account----------------
	// Hiển thị trang quản lý tài khoản
	@RequestMapping(value = { "/quan-ly-tai-khoan" })
	public ModelAndView accountsManager(HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			_mvShare.setViewName("redirect:dang-ky");
		} else {
			if (loginInfo.isIdRoles() != true)
				_mvShare.setViewName("redirect:trang-chu");
			else {
				_mvShare.addObject("accManagger", _accountService.GetDataUsers());
				_mvShare.setViewName("admin/accountManager/accounts");
			}
		}

		return _mvShare;
	}

	// xóa user
	@RequestMapping(value = "/deleteUser/{id}")
	public String deleteUser(@PathVariable int id, Model model, HttpServletRequest request, HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			return "redirect:/dang-ky";
		} else {
			if (loginInfo.isIdRoles() != true) {
				_mvShare.setViewName("redirect:trang-chu");

			} else {
					if(loginInfo.getId() == id) {
						_mvShare.addObject("statusAdd", "Không thể xóa tài khoản đang đăng nhập!!!");
						return "redirect:" + request.getHeader("Referer");
					}
							accountServiecImple.delete(id);
							model.addAttribute("listUser", accountServiecImple.GetDataUsers());
							_mvShare.addObject("statusAdd", "Xóa thành công!!!");
							return "redirect:" + request.getHeader("Referer");
						

					}
			
		}

		return "redirect:" + request.getHeader("Referer");
	}

	// ----------------Products----------------
	// Hiển thị trang quản lý sản phẩm
	@RequestMapping(value = { "/quan-ly-san-pham" })
	public ModelAndView productsManager(HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			_mvShare.setViewName("redirect:/dang-ky");
		} else {
			if (loginInfo.isIdRoles() != true) {
				_mvShare.setViewName("redirect:/trang-chu");
			} else {
				_mvShare.addObject("productsManager", _homeService.GetAllProducts());
				_mvShare.setViewName("admin/productsManager/products");

			}
		}

		return _mvShare;
	}

	// Hiển thị trang thêm sản phẩm
	@RequestMapping(value = { "/them-san-pham" })
	public ModelAndView index(HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			_mvShare.setViewName("redirect:/dang-ky");
		} else {
			if (loginInfo.isIdRoles() != true) {
				_mvShare.setViewName("redirect:/trang-chu");
			} else {
				_mvShare.setViewName("admin/productsManager/addProduct");

			}
		}

		return _mvShare;
	}

	// Thêm sản phẩm
	@RequestMapping(value = { "/them-san-pham" }, method = RequestMethod.GET)
	public ModelAndView addProduct() {
		_mvShare.addObject("addProducts", new ProductsDTO());
		_mvShare.setViewName("admin/productsManager/addProduct");
		return _mvShare;
	}

	@RequestMapping(value = { "/them-san-pham" }, method = RequestMethod.POST)
	public ModelAndView createProduct(@ModelAttribute("addProducts") ProductsDTO addProducts) {

		if (addProducts.getMaLoai() == 0 || addProducts.getTenSP() == "" || addProducts.getImage() == ""
				|| addProducts.getGiaBan() == 0 || addProducts.getDvt() == "") {
			_mvShare.addObject("statusAdd", "Thêm sản phẩm thất bại!!!");
		} else {
			// addProducts.setMaLoai()=1 ;
			int count = _productDetailsServiceImple.addProduct(addProducts);

			if (count > 0) {
				_mvShare.addObject("statusAdd", "Thêm sản phẩm thành công!!!");
			}
		}

		_mvShare.setViewName("admin/productsManager/addProduct");
		return _mvShare;
	}

	// Tìm kiếm sản phẩm
	@RequestMapping(value = "/search")
	public ModelAndView searchProduct(@RequestParam String name) {
		List<ProductsDTO> productsDTO = productDetailsServiceImple.GetProductByName(name);
		_mvShare.addObject("search", productsDTO);
		_mvShare.setViewName("user/products/searchProduct");
		return _mvShare;
	}

	// hiện thông tin sản phẩm theo id
	@RequestMapping(value = "/sua-san-pham/{id}")
	public ModelAndView editProduct(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			_mvShare.setViewName("redirect:/dang-ky");
		} else {
			if (loginInfo.isIdRoles() != true) {
				_mvShare.setViewName("redirect:/trang-chu");
			} else {
				_mvShare.setViewName("admin/productsManager/editProduct");
				_mvShare.addObject("products", _productDetailsServiceImple.GetProductByID(id));

			}
		}

		return _mvShare;
	}

	// Sửa sản phẩm
	@RequestMapping(value = "/sua-san-pham/{id}", method = RequestMethod.POST)
	public String editProduct(HttpServletRequest request, HttpSession session,
			@ModelAttribute("products") ProductsDTO products, @PathVariable("id") long idProduct) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			return "redirect:/dang-ky";
		} else {
			if (loginInfo.isIdRoles() != true) {
				return "redirect:/trang-chu";
			} else {

				_mvShare.setViewName("admin/productsManager/editProduct");
				_productDetailsServiceImple.editProduct(products, idProduct);
				_mvShare.addObject("statusUpdateProdcut", "Cập nhật thành công!!!");

			}
		}
		return "redirect:/quan-ly-san-pham";
	}

	// Xóa sản phẩm
	@RequestMapping(value = "/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request, HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			return "redirect:/dang-ky";
		} else {
			if (loginInfo.isIdRoles() != true) {
				return "redirect:/trang-chu";
			} else {
				productDetailsServiceImple.delete(id);
				model.addAttribute("listProduct", _homeService.GetAllProducts());
				// System.out.println("xoa thanh cong");

			}
		}
		return "redirect:/quan-ly-san-pham";
	}

	// ----------------Bill----------------
	// Hiển thị trang quản lý hóa đơn mua hàng
	@RequestMapping(value = { "/quan-ly-hoa-don" })
	public ModelAndView billsManager(HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			_mvShare.setViewName("redirect:/dang-ky");
		} else {
			if (loginInfo.isIdRoles() != true) {
				_mvShare.setViewName("redirect:/trang-chu");
			} else {
				_mvShare.addObject("billManager", _billService.GetAllBills());
				_mvShare.setViewName("admin/billManager/billManager");
			}
		}

		return _mvShare;
	}

	// Hiển thị chi tiết hóa đơn theo id của đơn hàng
	@RequestMapping(value = { "/quan-ly-chi-tiet-hoa-don/{id}" })
	public ModelAndView billsManagerDetails(@PathVariable int id, HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			_mvShare.setViewName("redirect:/dang-ky");
		} else {
			if (loginInfo.isIdRoles() != true) {
				_mvShare.setViewName("redirect:/trang-chu");
			} else {
				_mvShare.setViewName("admin/billManager/billManagerDetaills");
				_mvShare.addObject("billDetails", _billService.GetBillDetailsByIDBill(id));
			}
		}
		return _mvShare;
	}

	// xóa Bill
	@RequestMapping(value = "/deleteBill/{id}")
	public String deleteBill(@PathVariable int id, Model model, HttpServletRequest request, HttpSession session) {
		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			return "redirect:/dang-ky";
		} else {
			if (loginInfo.isIdRoles() != true) {
				return "redirect:/trang-chu";
			} else {

				billServiceImple.delete(id);

				model.addAttribute("listBill", billServiceImple.GetAllBills());
			}
		}

		return "redirect:" + request.getHeader("Referer");
	}
}
