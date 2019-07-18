package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.AdminDAO;
import com.entity.Admin;
import com.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	@Resource
	private AdminDAO adminDAO;

	@Override 
	public int insertAdmin(Admin admin) {
		return this.adminDAO.insertAdmin(admin);
	}

	@Override 
	public int updateAdmin(Admin admin) {
		return this.adminDAO.updateAdmin(admin);
	}

	@Override 
	public int deleteAdmin(String adminid) {
		return this.adminDAO.deleteAdmin(adminid);
	}

	@Override 
	public List<Admin> getAllAdmin() {
		return this.adminDAO.getAllAdmin();
	}

	@Override 
	public List<Admin> getAdminByCond(Admin admin) {
		return this.adminDAO.getAdminByCond(admin);
	}

	@Override 
	public List<Admin> getAdminByLike(Admin admin) {
		return this.adminDAO.getAdminByLike(admin);
	}

	@Override
	public Admin getAdminById(String adminid) {
		return this.adminDAO.getAdminById(adminid);
	}

}
