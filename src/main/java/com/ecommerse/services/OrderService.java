package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.Order;

public interface OrderService {
	public List<Order> getAllOrders();
	public Order addOrder(Order order);
	public Order getOrderByID(int id);
	public void deleteOrderById(int id);
	public void deleteAllOrders();
	public void UpdateById(int id, Order existingOrder);
}
