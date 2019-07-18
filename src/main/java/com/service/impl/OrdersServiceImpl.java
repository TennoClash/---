package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.OrdersDAO;
import com.entity.Orders;
import com.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	@Resource
	private OrdersDAO ordersDAO;

	@Override
	public int insertOrders(Orders orders) {
		return this.ordersDAO.insertOrders(orders);
	}

	@Override
	public int updateOrders(Orders orders) {
		return this.ordersDAO.updateOrders(orders);
	}

	@Override
	public int deleteOrders(String ordersid) {
		return this.ordersDAO.deleteOrders(ordersid);
	}

	@Override
	public List<Orders> getAllOrders() {
		return this.ordersDAO.getAllOrders();
	}

	@Override
	public List<Orders> getOrdersByCond(Orders orders) {
		return this.ordersDAO.getOrdersByCond(orders);
	}

	@Override
	public List<Orders> getOrdersByLike(Orders orders) {
		return this.ordersDAO.getOrdersByLike(orders);
	}

	@Override
	public Orders getOrdersById(String ordersid) {
		return this.ordersDAO.getOrdersById(ordersid);
	}

}
