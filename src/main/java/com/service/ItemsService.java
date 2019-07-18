package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Items;

@Service("itemsService")
public interface ItemsService {
	public int insertItems(Items items);

	public int updateItems(Items items);

	public int deleteItems(String itemsid);

	public List<Items> getAllItems();

	public List<Items> getItemsByCond(Items items);

	public List<Items> getItemsByLike(Items items);

	public Items getItemsById(String itemsid);

}
