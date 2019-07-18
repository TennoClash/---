package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CateDAO;
import com.entity.Cate;
import com.service.CateService;

@Service("cateService")
public class CateServiceImpl implements CateService {
	@Autowired
	@Resource
	private CateDAO cateDAO;

	@Override
	public int insertCate(Cate cate) {
		return this.cateDAO.insertCate(cate);
	}

	@Override
	public int updateCate(Cate cate) {
		return this.cateDAO.updateCate(cate);
	}

	@Override
	public int deleteCate(String cateid) {
		return this.cateDAO.deleteCate(cateid);
	}

	@Override
	public List<Cate> getAllCate() {
		return this.cateDAO.getAllCate();
	}

	@Override
	public List<Cate> getCateByCond(Cate cate) {
		return this.cateDAO.getCateByCond(cate);
	}

	@Override
	public List<Cate> getCateByLike(Cate cate) {
		return this.cateDAO.getCateByLike(cate);
	}

	@Override
	public Cate getCateById(String cateid) {
		return this.cateDAO.getCateById(cateid);
	}

}
