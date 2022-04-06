package shopnoithat.UserController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopnoithat.Entity.Users;
import shopnoithat.Service.User.AccountServiecImple;

@Controller
public class UserController extends BaseController {
	@Autowired
	AccountServiecImple accountServiecImple = new AccountServiecImple();

	// Đăng ký
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView register() {

		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("usersRegister", new Users());

		return _mvShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("users") Users users) {
		 String checkGmail = "@gmail.com";
		 if (users.getUser() == "") {
			_mvShare.addObject("status", "Vui lòng nhập Email!!!");
		} else if (users.getUser().contains(checkGmail) == false) {
			_mvShare.addObject("status", "Vui lòng nhập đúng định dạng Gmail!!!");
		}
		else if (users.getPassword().length() < 8) {
			_mvShare.addObject("status", "Passowrd phải lớn hơn 8 ký tự!!!");
		}
		else if (users.getPassword() == "") {
			_mvShare.addObject("status", "Vui lòng nhập Password!!!");
		} else if (users.getName() == "") {
			_mvShare.addObject("status", "Vui lòng nhập Họ và Tên!!!");
		} else {

			int count = accountServiecImple.addAccount(users);
			if (count > 0) {
				_mvShare.addObject("status", "Đăng ký tài khoản thành công!!!");
			}
		}

		_mvShare.setViewName("user/account/register");

		return _mvShare;
	}

	// Đăng nhập
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, @ModelAttribute("users") Users users) {

		try {
			if (users.getUser() == "" && users.getPassword() == "") {
				_mvShare.addObject("statusLogin", "Đăng nhập tài khoản thất bại!!!");
			} else if (users.getUser() == "" || users.getPassword() == "") {
				_mvShare.addObject("statusLoginUser", "Vui lòng kiểm tra thông tin!!!");
			} else {
				users = accountServiecImple.checkAccount(users);

				if (users != null && users.isIdRoles() == false) {
					_mvShare.setViewName("redirect:trang-chu");
					session.setAttribute("loginInfo", users);

				} else {
					_mvShare.setViewName("redirect:quan-tri");
					session.setAttribute("loginInfo", users);
				}

			}
		} catch (Exception e) {
			_mvShare.addObject("statusLogin", "Sai thông tin đăng nhập!!!");
		}
		return _mvShare;
	}

	// Đăng xuất
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request) {

		session.removeAttribute("loginInfo");
		return "redirect:" + request.getHeader("Referer");
	}

	// Thông tin tài khoản
	@RequestMapping(value = { "/thong-tin-tai-khoan/{id}", "/thong-tin-tai-khoan" }, method = RequestMethod.GET)
	public ModelAndView infoAccount(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/account/infoAccount");

		Users user = new Users();

		Users infoAcc = (Users) session.getAttribute("loginInfo");
		if (infoAcc != null) {
			user.setUser(infoAcc.getUser());
			user.setPassword(infoAcc.getPassword());
			user.setName(infoAcc.getName());
			user.setAddress(infoAcc.getAddress());
			user.setPhoneNumber(infoAcc.getPhoneNumber());
		}

		_mvShare.addObject("Users", user);
		return _mvShare;
	}

	// ***************************************************** dang dở

	@RequestMapping(value = { "/thong-tin-tai-khoan/{id}", "/thong-tin-tai-khoan" }, method = RequestMethod.POST)
	public ModelAndView editInfoAccount(HttpServletRequest request, HttpSession session,
			@ModelAttribute("Users") Users Users, @PathVariable("id") long userID) {

		// Users user = (Users) session.getAttribute("loginInfo");
		if (Users.getName() == "" || Users.getAddress() == "" || Users.getPhoneNumber() == ""
				|| Users.getUser() == "") {
			_mvShare.addObject("statusUpdateInfo", "Cập nhật thất bại!!!");
		} else {
			accountServiecImple.editInfo(Users, userID);

			_mvShare.addObject("statusUpdateInfo", "Cập nhật thành công!!!");

		}

		_mvShare.setViewName("redirect:" + request.getHeader("Referer"));
		session.setAttribute("loginInfo", Users);
		// _mvShare.addObject("loginInfo", Users);

		return _mvShare;
	}

	@RequestMapping(value = "/dang-ky-admin", method = RequestMethod.GET)
	public ModelAndView registerAd(@ModelAttribute("users") Users users, HttpSession session) {
		
		
			_mvShare.setViewName("admin/accountManager/registerAdmin");
			_mvShare.addObject("usersRegister", new Users());
		
		return _mvShare;
	}

	// them tk nhanvien
	@RequestMapping(value = "/dang-ky-admin", method = RequestMethod.POST)
	public ModelAndView createAccountAd(@ModelAttribute("users") Users users, HttpSession session) {

		Users loginInfo = (Users) session.getAttribute("loginInfo");
		if (loginInfo == null) {
			_mvShare.setViewName("redirect:/dang-ky");
		} else {
			if (loginInfo.isIdRoles() != true) {
				_mvShare.setViewName("redirect:trang-chu");
			} else {
				if (loginInfo.getUser() == "admin1@gmail.com") {
					if (users.getUser() == "" && users.getPassword() == "" && users.getName() == ""
							&& users.getUser() == users.getUser()) {
						_mvShare.addObject("status", "Đăng ký tài khoản thất bại!!!");

					} else if (users.getUser() == "") {
						_mvShare.addObject("statusEmail", "Vui lòng nhập Email!!!");
					} else /*
							 * if (users.getUser() == users.getUser()) { _mvShare.addObject("statusEmail",
							 * "Email đã có người sử dụng!!!"); } else
							 */ if (users.getPassword() == "") {
						_mvShare.addObject("statusPassword", "Vui lòng nhập Password!!!");
					} else if (users.getName() == "") {
						_mvShare.addObject("statusName", "Vui lòng nhập Họ và Tên!!!");
					} else {

						int count = accountServiecImple.addAccountAd(users);
						if (count > 0) {
							_mvShare.addObject("status", "Đăng ký tài khoản thành công!!!");
							_mvShare.setViewName("redirect:/quan-ly-tai-khoan");
						}
					}
				} else {
					_mvShare.setViewName("redirect:/quan-ly-tai-khoan");

				}
			}
		}

		return _mvShare;

	}

	// *****************************************************

}
