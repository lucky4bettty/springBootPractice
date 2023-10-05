package net.javaguides.springboot.controller.role;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.mdbs.jdbc.PagingParameter;
import net.javaguides.springboot.mdbs.util.Id;
import net.javaguides.springboot.mdbs.util.LogUtil;
import net.javaguides.springboot.MessageConstants;
import net.javaguides.springboot.controller.Constants;
import net.javaguides.springboot.dao.ManagerRoleDao;
import net.javaguides.springboot.mdbs.jdbc.Page;
import net.javaguides.springboot.model.ManagerRole;
import net.javaguides.springboot.service.ManagerRoleService;
import net.javaguides.springboot.util.ManagerUtil;

import java.sql.Timestamp;

@Controller
@RequestMapping("/admin/role")
public class RoleController {
	
	@Autowired
	private ManagerRoleService managerRoleService;
	@Autowired
	private ManagerRoleDao dao;
	@Autowired
	private ManagerUtil managerUtil ;
	

	
	/**
	 * 列表
	 * 
	 * @param request
	 * @param form
	 * @param paging
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
    public String showLoginPage(HttpServletRequest request,@ModelAttribute RoleForm form, PagingParameter paging,
    		Model model)throws Exception {
		
		
		List<ManagerRole> listManagers = managerRoleService.getList(form);

		model.addAttribute("listManagers",listManagers);

        return "admin/role/list"; 
    }
	
	/**
	 * 新增頁
	 * 
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/new")
	public String add(@ModelAttribute("command") RoleForm form, ModelMap model)
			throws Exception {
		
		ManagerRole newDataManagerRole = new ManagerRole();
		
		model.addAttribute("data",newDataManagerRole);
		
        return "admin/role/new_form"; 
	}
	
	/**
	 * 儲存(新增)
	 * 
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save" , method = RequestMethod.POST )
	public String save(HttpServletRequest request,@ModelAttribute("command") ManagerRole form , Model model)
	{

		try {
//			---Authority control
//			String returnPath = managerUtil.haveRight(request, getRightID());
			
			managerRoleService.save(form, managerUtil.getManagerAccount(request));

	        return "redirect:/admin/role/list"; 
			
			
		}catch(Exception e) {
			LogUtil.setErrorLog("save", e);
			model.addAttribute("message", MessageConstants.MESSAGE_SYSTEM_BUSY);
			model.addAttribute("relativeUrl", Constants.LOGIN_PAGE);

			return "common/jsAlert"; 
		}
		
	}
	
	/**
	 * 編輯頁
	 * 
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") String id ,Model model)
	{
		
			ModelAndView mav = new ModelAndView("admin/role/edit");
			ManagerRole data = dao.get(id);
			
			mav.addObject("data",data );
			
			return mav;
			


	}
	
	/**
	 * 儲存(編輯)
	 * 
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update" , method = RequestMethod.POST )
	public String update(HttpServletRequest request, @ModelAttribute("command") ManagerRole form , Model model)
	{

		
		try {
//			---Authority control
//			String returnPath = managerUtil.haveRight(request, getRightID());
			
			// getManagerAccount 順便檢查登入狀態
			managerRoleService.update(form,managerUtil.getManagerAccount(request));
			

	        return "redirect:/admin/role/list"; 
			
		}catch(Exception e) {
			LogUtil.setErrorLog("save", e);
			model.addAttribute("message", MessageConstants.MESSAGE_SYSTEM_BUSY);
			model.addAttribute("relativeUrl", Constants.LOGIN_PAGE);

			return "common/jsAlert"; 
		}
		

	}
	
	@RequestMapping("/delete/{id}")
	public String delete(HttpServletRequest request,@PathVariable(name = "id") String id , Model model) {
		try {
			managerRoleService.delete(id , managerUtil.getManagerAccount(request));
			return "redirect:/admin/role/list"; 
		}catch(Exception e) {
			LogUtil.setErrorLog("save", e);
			model.addAttribute("message", MessageConstants.MESSAGE_SYSTEM_BUSY);
			model.addAttribute("relativeUrl", Constants.LOGIN_PAGE);

			return "common/jsAlert"; 
		}

		
	}
	

	
	
	
}