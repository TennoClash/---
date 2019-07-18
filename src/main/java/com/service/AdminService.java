package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Admin;

@Service("adminService")
public interface AdminService {
	public int insertAdmin(Admin admin);

	public int updateAdmin(Admin admin);

	public int deleteAdmin(String adminid);

	public List<Admin> getAllAdmin();

	public List<Admin> getAdminByCond(Admin admin);

	public List<Admin> getAdminByLike(Admin admin);

	public Admin getAdminById(String adminid);

}
