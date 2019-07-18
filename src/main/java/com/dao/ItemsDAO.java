package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Items;

@Repository("itemsDAO")
public interface ItemsDAO {

	public int insertItems(Items items);

	public int updateItems(Items items);

	public int deleteItems(String itemsid);

	public List<Items> getAllItems();

	public List<Items> getItemsByCond(Items items);

	public List<Items> getItemsByLike(Items items);

	public Items getItemsById(String itemsid);

}
