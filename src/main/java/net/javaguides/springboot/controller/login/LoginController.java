package net.javaguides.springboot.controller.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.controller.Constants;
import net.javaguides.springboot.mdbs.util.LogUtil;
import net.javaguides.springboot.model.Manager;
import net.javaguides.springboot.model.ManagerRole;
import net.javaguides.springboot.service.ManagerRoleService;
import net.javaguides.springboot.service.ManagerService;
import net.javaguides.springboot.util.ManagerUtil;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ManagerRoleService managerRoleService;
	@Autowired
	private ManagerUtil managerUtil ;
	
	@RequestMapping("/index")
    public String showAdminFontPage(Model model) {

        return "admin/homePage"; 
    }
	
	@RequestMapping("/login")
    public String showLoginPage(Model model) {
		LoginForm loginForm = new LoginForm() ;
		model.addAttribute("data",loginForm);
        return "admin/login"; 
    }
	
	/**
	 * login active
	 * 
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login_active" , method = RequestMethod.POST )
	public String update(HttpServletRequest request,@ModelAttribute("command") LoginForm form , Model model)
	{

		try {
			
			Manager manager = null ;
			
			manager = managerService.login(form.getAccount(), form.getPwd());
						
			if(manager == null) {
				
			}
			
			if (!"1".equals(manager.getStatus())) {
				model.addAttribute("message", "此帳號已被停權!");
				model.addAttribute("relativeUrl", "login.do");
//				return "common/jsAlert";
			}
			
			ManagerRole role = managerRoleService.get(manager.getRole_id());

			
			if (!"1".equals(manager.getStatus())) {
				model.addAttribute("message", "此帳號已被停權!");
				model.addAttribute("relativeUrl", "login.do");
//				return "common/jsAlert";
			}
			
			// 判斷登入者權限使用
			
			LogUtil.setActionLog("LOGIN", "login success: " + form.getAccount());
			
//			後台功能 左邊欄位 todo: 不一定要做
//			List<ManagerTask> menuTasks = managerTaskService.getLoginTask(manager.getRole_id());
//			managerUtil.setManager(request, manager, menuTasks);
			
			managerUtil.setManager(request,manager);

			
	        return "redirect:/admin/role/list"; 
			
		}catch(Exception e) {
			LogUtil.setErrorLog("save", e);
			model.addAttribute("message", e);
			model.addAttribute("relativeUrl", Constants.LOGIN_PAGE);
			return "common/jsAlert";  
		}
		

	}
	
	/**
	 * 登出
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		managerUtil.clearManagerLogin(request);
		return "redirect:/admin/login";
	}
	
	
	
}
