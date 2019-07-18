package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Cate;

@Service("cateService")
public interface CateService {
	public int insertCate(Cate cate);

	public int updateCate(Cate cate);

	public int deleteCate(String cateid);

	public List<Cate> getAllCate();

	public List<Cate> getCateByCond(Cate cate);

	public List<Cate> getCateByLike(Cate cate);

	public Cate getCateById(String cateid);
}
