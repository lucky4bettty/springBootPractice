package net.javaguides.springboot.controller.role;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;


/**
 * 建立日期：2015年3月18日
 * 程式摘要：com.ddim.happygo.web.role<P> 
 * 類別名稱：RoleFormValidator.java<P>
 * 程式內容說明：角色資料 驗證<P>
 * @author Yvonne
 * */
@Component
public class RoleFormValidator {
	
	protected String getPath() {
		return "admin/role";
	}

	/**
	 * 表單驗證
	 * 
	 * @param errors
	 */
	public void validate(RoleForm form, BindingResult result) {

		if (form.getTasksAry() == null || form.getTasksAry().length == 0) {
			result.rejectValue("tasksAry", "error", "請選擇");
		}

	}

}