package com.example.hospital.controller;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.bean.SpecializationRequestBean;
import com.example.hospital.service.SpecializationService;


@RestController()
@RequestMapping("/Specialization")
@CrossOrigin(origins = "http://localhost:3000/")
public class SpecializationController {
	
	@Autowired
	 private SpecializationService specializationService;
	
	@PostMapping("/add")
    public ResponseEntity<String> insertSpecialization(@RequestBody SpecializationRequestBean bean) {
		specializationService.insertSpecialization(bean.getDegree());
        return new ResponseEntity<>("Specialization created successfully", HttpStatus.CREATED);
    }
	
	@GetMapping("/getAll")
	public ResponseEntity<List> getAllSpecialization(){
		return ResponseEntity.ok(specializationService.getAllSpecialization());
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateSpecialization(@RequestBody SpecializationRequestBean bean,@PathParam(value = "degree") String degree){
		specializationService.updateSpecialization(bean.getDegree(),degree);
		return new ResponseEntity<>("Specialization Updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> DeleteSpecialization(@PathParam(value = "id") int id){
		specializationService.deleteSpecialization(id);
		return new ResponseEntity<>("Specialization Deleted successfully", HttpStatus.OK);
	}
}
