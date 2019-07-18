package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.GoodsDAO;
import com.entity.Goods;
import com.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	@Resource
	private GoodsDAO goodsDAO;

	@Override
	public int insertGoods(Goods goods) {
		return this.goodsDAO.insertGoods(goods);
	}

	@Override
	public int updateGoods(Goods goods) {
		return this.goodsDAO.updateGoods(goods);
	}

	@Override
	public int deleteGoods(String goodsid) {
		return this.goodsDAO.deleteGoods(goodsid);
	}

	@Override
	public List<Goods> getAllGoods() {
		return this.goodsDAO.getAllGoods();
	}

	@Override
	public List<Goods> getGoodsByCond(Goods goods) {
		return this.goodsDAO.getGoodsByCond(goods);
	}

	@Override
	public List<Goods> getGoodsByLike(Goods goods) {
		return this.goodsDAO.getGoodsByLike(goods);
	}

	@Override
	public Goods getGoodsById(String goodsid) {
		return this.goodsDAO.getGoodsById(goodsid);
	}

}
