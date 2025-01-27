package com.example.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.payment.model.Payment;
import com.example.payment.repository.PaymentRepository;

@Service
public class PaymentService
{
	@Autowired
	PaymentRepository payRepo;
	public List<Payment> getAllPaymentDetails()
	{
		return payRepo.findAll();
	}
	
	public Payment savePayment(Payment p) 
	{
		p.setPayment_status(paymentProcessing());
		p.setTrans_id(UUID.randomUUID().toString());
		return payRepo.save(p);
	}
	
	public Payment updatePayment(Integer id,Payment p)
	{
		Payment p1=getPaymentDetails(id);
		p1.setPayment_status(p.getPayment_status());
		p1.setTrans_id(p.getTrans_id());
		p=payRepo.save(p1);
		return p;
	}
	
	public Payment getPaymentDetails(Integer id)
	{
		Optional<Payment> obj=payRepo.findById(id);
		Payment p=obj.get();
		return p;
	}
	
	public Payment deletePayment(Integer id)
	{
		Payment p=getPaymentDetails(id);
		payRepo.deleteById(id);
		return p;
	}
	
	public String paymentProcessing()
	{
		return new Random().nextBoolean()?"success":"false";
	}
}
