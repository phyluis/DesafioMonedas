package com.monedas.desafio.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeDTO {
  private Long id;
	  
	  private String typeCurrencyOrigin;
	  private BigDecimal valueCurrencyOrigin;
	  private String typeCurrencyDestiny;
	  private BigDecimal valueCurrencyDestiny;
	  private BigDecimal valueChange;
	  private Date dateChange;
}
