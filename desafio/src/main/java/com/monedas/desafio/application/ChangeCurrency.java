package com.monedas.desafio.application;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monedas.desafio.domain.entity.EntityChange;
import com.monedas.desafio.domain.service.ChangeService;
import com.monedas.desafio.infrastructure.model.Message;

@RestController
@RequestMapping("/changecurrency")
public class ChangeCurrency {
	
	@Autowired
    private  ChangeService changeService;
    
    @PostMapping(produces = "application/json")
    public ResponseEntity changeCurrency(@RequestBody EntityChange  entityChange){
     Message  Message = changeService.changeCurrency(entityChange);
     return new ResponseEntity<>(Message, HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity changeType(@PathVariable String  type) throws Exception{
     String  Message = changeService.changeType(type);
     return new ResponseEntity<>(Message, HttpStatus.OK);
    }

    
    @GetMapping("/listChange")
    public ResponseEntity changeType() throws Exception{
     String  Message = changeService.changeList();
     return new ResponseEntity<>(Message, HttpStatus.OK);
    }
    
}
