package com.monedas.desafio.domain.service;

import com.monedas.desafio.domain.entity.EntityChange;
import com.monedas.desafio.infrastructure.model.Message;

public interface ChangeService  {

	public  Message changeCurrency(EntityChange entityChange);
	public String changeType(String type) throws Exception;
	public String changeList();
	
}
