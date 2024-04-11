package com.monedas.desafio.domain.deserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.monedas.desafio.domain.entity.EntityChange;

public class ChangeDeserializer extends JsonDeserializer<EntityChange>{

	@Override
	public EntityChange deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {

		ObjectCodec oc = jsonParser.getCodec();
	    JsonNode changeNode = oc.readTree(jsonParser);
     
		try {
			EntityChange entityChange = new EntityChange();

		
			
			entityChange.setTypeCurrencyOrigin(changeNode.get("typeCurrencyOrigin").asText()); 
			entityChange.setValueCurrencyOrigin(BigDecimal.valueOf(changeNode.get("valueCurrencyOrigin").asLong())); 
			entityChange.setTypeCurrencyDestiny(changeNode.get("typeCurrencyDestiny").asText()); 
			entityChange.setValueCurrencyDestiny(BigDecimal.valueOf(changeNode.get("valueCurrencyDestiny").asLong()));
			
			if(changeNode.get("Id") != null && changeNode.get("valueChange") != null && changeNode.get("dateChange") != null ) {
				entityChange.setId(changeNode.get("Id").asLong());
				entityChange.setValueChange(BigDecimal.valueOf(changeNode.get("valueChange").asLong())); 
				entityChange.setDateChange(Date.valueOf(changeNode.get("dateChange").asText())); 					
			}
		
			
		    return entityChange;
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
