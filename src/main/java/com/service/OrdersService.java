package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Orders;

@Service("ordersService")
public interface OrdersService {
	public int insertOrders(Orders orders);

	public int updateOrders(Orders orders);

	public int deleteOrders(String ordersid);

	public List<Orders> getAllOrders();

	public List<Orders> getOrdersByCond(Orders orders);

	public List<Orders> getOrdersByLike(Orders orders);

	public Orders getOrdersById(String ordersid);
}
