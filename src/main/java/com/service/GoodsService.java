package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Goods;

@Service("goodsService")
public interface GoodsService {
	public int insertGoods(Goods goods);

	public int updateGoods(Goods goods);

	public int deleteGoods(String goodsid);

	public List<Goods> getAllGoods();

	public List<Goods> getGoodsByCond(Goods goods);

	public List<Goods> getGoodsByLike(Goods goods);

	public Goods getGoodsById(String goodsid);
}
