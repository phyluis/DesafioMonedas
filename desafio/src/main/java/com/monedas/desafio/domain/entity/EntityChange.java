package com.monedas.desafio.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.monedas.desafio.domain.deserializer.ChangeDeserializer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@JsonDeserialize(using = ChangeDeserializer.class)
public class EntityChange {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  
	  private String typeCurrencyOrigin;
	  private BigDecimal valueCurrencyOrigin;
	  private String typeCurrencyDestiny;
	  private BigDecimal valueCurrencyDestiny;
	  private BigDecimal valueChange;
	  private Date dateChange;
	  
	  

}
