package com.example.order.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;

@Service
public class OrderService
{
	@Autowired
	OrderRepository orderRepo;
	public List<Order> getAllOrderDetails()
	{
		return orderRepo.findAll();
	}
	
	public Order saveOrder(Order o) 
	{
		orderRepo.save(o);
		return o;
	}
	
	public Order updateOrder(Integer id,Order o)
	{
		Order o1=getOrderDetails(id);
		o1.setOrder_name(o.getOrder_name());
		o1.setPrice(o.getPrice());
		o1.setQuantity(o.getQuantity());
		o=orderRepo.save(o1);
		return o;
	}
	
	public Order getOrderDetails(Integer id)
	{
		Optional<Order> obj=orderRepo.findById(id);
		Order o=obj.get();
		return o;
	}
	
	public Order deleteOrder(Integer id)
	{
		Order o=getOrderDetails(id);
		orderRepo.deleteById(id);
		return o;
	}
}