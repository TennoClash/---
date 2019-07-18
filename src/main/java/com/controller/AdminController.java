package com.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Admin;
import com.service.AdminService;
import com.util.MD5;
import com.util.PageHelper;
import com.util.VeDate;

import com.util.RSACrypt;


@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
	@Autowired
	@Resource
	private AdminService adminService;


	@RequestMapping(value = "login.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(String username,String password,HttpSession session) throws Exception {
		String privateKey = (String) session.getAttribute("privateKeyStr");
		password = RSACrypt.decrypt(RSACrypt.loadPrivateKey(privateKey), RSACrypt.strToBase64(password));
		password = MD5.md5(password);
		Admin adminEntity = new Admin();
		adminEntity.setUsername(username);
		List<Admin> adminlist = this.adminService.getAdminByCond(adminEntity);
		if (adminlist.size() == 0) {
			return "用户名不存在";
		} else {
			Admin admin = adminlist.get(0);
			if (password.equals(admin.getPassword())) {
				this.getSession().setAttribute("adminid", admin.getAdminid());
				this.getSession().setAttribute("adminname", admin.getUsername());
				this.getSession().setAttribute("realname", admin.getRealname());
				this.getSession().setAttribute("role", admin.getRole());
			} else {
				
				return "密码错误";
			}
		}
		return "1";
	}

	@RequestMapping(value = "getkey.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getKey(HttpSession session) throws NoSuchAlgorithmException {
		HashMap<String, String> map2 = RSACrypt.getKeys();
		String privateKeyStr = map2.get("privateKey");
		String publicKeyStr = map2.get("publicKey");
		session.setAttribute("privateKeyStr", privateKeyStr);
		return publicKeyStr;
	}
	
	@RequestMapping("prePwd.action")
	public String prePwd() {
		return "admin/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		String password = this.getRequest().getParameter("password");
		password = MD5.md5(password);
		String repassword = this.getRequest().getParameter("repassword");
		repassword = MD5.md5(repassword);
		Admin admin = this.adminService.getAdminById(adminid);
		if (password.equals(admin.getPassword())) {
			admin.setPassword(repassword);
			this.adminService.updateAdmin(admin);
		} else {
			this.getRequest().setAttribute("message", "旧密码错误");
		}
		return "admin/editpwd";
	}

	@RequestMapping("exit.action")
	public String exit() {
		this.getSession().invalidate();
		return "admin/index";
	}

	@RequestMapping("createAdmin.action")
	public String createAdmin() {
		return "admin/addadmin";
	}


	@RequestMapping("addAdmin.action")
	public String addAdmin(Admin admin) {
		admin.setPassword(MD5.md5(admin.getPassword()));
		admin.setAddtime(VeDate.getStringDateShort());
		this.adminService.insertAdmin(admin);
		return "redirect:/admin/createAdmin.action";
	}

	@RequestMapping("deleteAdmin.action")
	public String deleteAdmin(String id) {
		this.adminService.deleteAdmin(id);
		return "redirect:/admin/getAllAdmin.action";
	}

	@RequestMapping("deleteAdminByIds.action")
	public String deleteAdminByIds() {
		String[] ids = this.getRequest().getParameterValues("adminid");
		for (String adminid : ids) {
			this.adminService.deleteAdmin(adminid);
		}
		return "redirect:/admin/getAllAdmin.action";
	}

	@RequestMapping("updateAdmin.action")
	public String updateAdmin(Admin admin) {
		this.adminService.updateAdmin(admin);
		return "redirect:/admin/getAllAdmin.action";
	}

	@RequestMapping("getAllAdmin.action")
	public String getAllAdmin(String number) {
		List<Admin> adminList = this.adminService.getAllAdmin();
		PageHelper.getPage(adminList, "admin", null, null, 10, number, this.getRequest(), null);
		return "admin/listadmin";
	}

	@RequestMapping("queryAdminByCond.action")
	public String queryAdminByCond(String cond, String name, String number) {
		Admin admin = new Admin();
		if (cond != null) {
			if ("username".equals(cond)) {
				admin.setUsername(name);
			}
			if ("password".equals(cond)) {
				admin.setPassword(name);
			}
			if ("realname".equals(cond)) {
				admin.setRealname(name);
			}
			if ("sex".equals(cond)) {
				admin.setSex(name);
			}
			if ("birthday".equals(cond)) {
				admin.setBirthday(name);
			}
			if ("contact".equals(cond)) {
				admin.setContact(name);
			}
			if ("role".equals(cond)) {
				admin.setRole(name);
			}
			if ("addtime".equals(cond)) {
				admin.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.adminService.getAdminByLike(admin), "admin", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryadmin";
	}

	@RequestMapping("getAdminById.action")
	public String getAdminById(String id) {
		Admin admin = this.adminService.getAdminById(id);
		this.getRequest().setAttribute("admin", admin);
		return "admin/editadmin";
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
