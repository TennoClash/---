package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ItemsDAO;
import com.entity.Items;
import com.service.ItemsService;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	@Resource
	private ItemsDAO itemsDAO;

	@Override
	public int insertItems(Items items) {
		return this.itemsDAO.insertItems(items);
	}

	@Override
	public int updateItems(Items items) {
		return this.itemsDAO.updateItems(items);
	}

	@Override
	public int deleteItems(String itemsid) {
		return this.itemsDAO.deleteItems(itemsid);
	}

	@Override
	public List<Items> getAllItems() {
		return this.itemsDAO.getAllItems();
	}

	@Override
	public List<Items> getItemsByCond(Items items) {
		return this.itemsDAO.getItemsByCond(items);
	}

	@Override
	public List<Items> getItemsByLike(Items items) {
		return this.itemsDAO.getItemsByLike(items);
	}

	@Override
	public Items getItemsById(String itemsid) {
		return this.itemsDAO.getItemsById(itemsid);
	}

}
