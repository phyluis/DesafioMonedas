package com.monedas.desafio.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monedas.desafio.domain.entity.EntityChange;
import com.monedas.desafio.domain.service.ChangeService;
import com.monedas.desafio.infrastructure.model.Message;
import com.monedas.desafio.infrastructure.repository.ChangeRepository;
import com.monedas.desafio.infrastructure.svcagents.RestClientService;

@Service
public class ChangeServiceImpl implements ChangeService{
	
	@Autowired
	private ChangeRepository  changeRepository;

	@Autowired
	private RestClientService restClientService;
	
	@SuppressWarnings({ "unused", "null" })
	public Message changeCurrency(EntityChange entityChange) {
		
		EntityChange obentityChange = new EntityChange();
		
		BigDecimal valueChange = null;
		Message message= new Message();

		try {
			System.out.println("getValueCurrencyOrigin" +entityChange.getValueCurrencyOrigin() +"getValueCurrencyDestiny"+  entityChange.getValueCurrencyDestiny());
			valueChange = entityChange.getValueCurrencyOrigin().multiply(entityChange.getValueCurrencyDestiny());
			
			entityChange.setValueChange(valueChange);
			entityChange.setDateChange(Calendar.getInstance().getTime());
			obentityChange = changeRepository.save(entityChange);
			
			message.setMessage("Se realizo el cambio de moneda " + obentityChange.getTypeCurrencyOrigin() + "hacie el tipo de moneda" + obentityChange.getTypeCurrencyDestiny());
			
			message.setChangeValue(obentityChange.getValueChange().toPlainString().toString());
			
			
			
		} catch (Exception e) {
			message.setMessage("Error al realizar el cambio de moneda" + e.getStackTrace() );
			System.out.println(e.getStackTrace());
			System.out.println(e);

		}
		
		
		return message;
		
	}
	
	public String changeType(String type) throws Exception {
		
		return restClientService.ChangeTypeCurrency(type);
		
	}

	@Override
	public String changeList() {
		changeRepository.findAll().toString();
		return changeRepository.findAll().toString();
	}
	
}
