package com.example.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class Order
{
	@Id
	@Column(insertable=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer order_id;
	@Column(name="order_name",length=60)
	private String order_name;
	@Column(name="quantity")
	private Integer quantity;
	@Column(name="price")
	private Double price;
}