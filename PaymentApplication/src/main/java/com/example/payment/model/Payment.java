package com.example.payment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer payment_id;
	@Column(name="payment_status",length=60)
	private String payment_status;
	@Column(name="trans_id",length=60,unique=true)
	private String trans_id;
}
