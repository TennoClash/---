package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Orders;

@Repository("ordersDAO")
public interface OrdersDAO {

	public int insertOrders(Orders orders);

	public int updateOrders(Orders orders);

	public int deleteOrders(String ordersid);

	public List<Orders> getAllOrders();

	public List<Orders> getOrdersByCond(Orders orders);

	public List<Orders> getOrdersByLike(Orders orders);

	public Orders getOrdersById(String ordersid);

}
