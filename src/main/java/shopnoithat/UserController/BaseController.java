package shopnoithat.UserController;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import shopnoithat.Service.User.AccountServiecImple;
import shopnoithat.Service.User.BillServiceImple;
import shopnoithat.Service.User.HomeServiecImple;

@Controller
public class BaseController {
	@Autowired
	HomeServiecImple _homeService;
	
	@Autowired
	BillServiceImple _billService;
	
	@Autowired
	AccountServiecImple _accountService;

	public ModelAndView _mvShare = new ModelAndView();

	@PostConstruct
	public ModelAndView Init() {
		_mvShare.addObject("menus", _homeService.GetDataMenus());
		return _mvShare;
	}
}
