package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Cate;

@Repository("cateDAO")
public interface CateDAO {

	public int insertCate(Cate cate);

	public int updateCate(Cate cate);

	public int deleteCate(String cateid);

	public List<Cate> getAllCate();

	public List<Cate> getCateByCond(Cate cate);

	public List<Cate> getCateByLike(Cate cate);

	public Cate getCateById(String cateid);

}
