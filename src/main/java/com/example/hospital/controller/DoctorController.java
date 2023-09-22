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

import com.example.hospital.bean.DoctorRequestBean;
import com.example.hospital.bean.SpecializationRequestBean;
import com.example.hospital.service.DoctorService;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {
	
	@Autowired(required =  true)
	private DoctorService doctorService;
	
	@PostMapping("/add")
    public ResponseEntity<DoctorRequestBean> addDoctor(@RequestBody DoctorRequestBean bean) {
		doctorService.addDoctor(bean);
		return ResponseEntity.ok().body(bean);
    }
	
	@GetMapping("/getAll")
	public ResponseEntity<List> getAllDoctor(){
		return ResponseEntity.ok(doctorService.getAllDoctor());
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateDoctor(@PathParam(value = "id") int id,@RequestBody DoctorRequestBean bean){
		doctorService.updateDoctor(bean,id);
		return new ResponseEntity<>("Doctor Updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> DeleteDoctor(@PathParam(value = "id") int id){
		doctorService.deleteDoctor(id);
		return new ResponseEntity<>("Doctor Deleted successfully", HttpStatus.OK);
	}

}
