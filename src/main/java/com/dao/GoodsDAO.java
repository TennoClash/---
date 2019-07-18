package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Goods;

@Repository("goodsDAO")
public interface GoodsDAO {

	public int insertGoods(Goods goods);

	public int updateGoods(Goods goods);

	public int deleteGoods(String goodsid);

	public List<Goods> getAllGoods();

	public List<Goods> getGoodsByCond(Goods goods);

	public List<Goods> getGoodsByLike(Goods goods);

	public Goods getGoodsById(String goodsid);

}
