package com.example.order.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.model.Order;
import com.example.order.service.OrderService;

@RestController
public class OrderController
{
	@Autowired
	OrderService os;
	
	@GetMapping("/orders")
	public List<Order>getAllOrderDetails()
	{
		List<Order> oList=os.getAllOrderDetails();
		System.out.println(oList);
		return oList;
	}
	@GetMapping("/orders/{id}")
	public Order getOrderDetails(@PathVariable Integer id)
	{
		Order o=os.getOrderDetails(id);
		return o;
	}
	
	@PostMapping("/orders/add")
	public Order saveOrder(@RequestBody Order o)
	{
		os.saveOrder(o);
		return o;
	}
	
	@PutMapping("/orders/update/{id}")
	public Order updateOrder(@PathVariable Integer id,@RequestBody Order o) 
	{
		return os.updateOrder(id,o);
	}
	
	@DeleteMapping("/orders/delete/{id}")
	public Order deleteOrder(@PathVariable Integer id)
	{
		return os.deleteOrder(id);
	}
}