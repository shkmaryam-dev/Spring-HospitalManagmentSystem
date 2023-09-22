package com.example.hospital.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.bean.TransactionRequestBean;
import com.example.hospital.service.TransactionService;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@PostMapping("/add")
    public ResponseEntity<TransactionRequestBean> addTransaction(@RequestBody TransactionRequestBean bean) {
		service.addTransaction(bean);
		return ResponseEntity.ok().body(bean);
    }
	
	@GetMapping("/getAll")
	public ResponseEntity<List> getAllTransaction(){
		return ResponseEntity.ok(service.getAllTransaction());
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateDoctor(@PathParam(value = "id") int id,@RequestBody TransactionRequestBean bean){
		service.updateTransaction(id,bean);
		return new ResponseEntity<>("Transaction Updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> DeleteTransaction(@PathParam(value = "id") int id){
		service.deleteTrasaction(id);
		return new ResponseEntity<>("Transaction Deleted successfully", HttpStatus.OK);
	}
}
