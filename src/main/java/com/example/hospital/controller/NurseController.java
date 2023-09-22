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

import com.example.hospital.bean.NurseRequestBean;
import com.example.hospital.service.NurseService;

@RestController
@RequestMapping("/Nurse")
public class NurseController {

	@Autowired
	private NurseService nurseService;
	
	@PostMapping("/add")
	public ResponseEntity<NurseRequestBean> addNurse(@RequestBody NurseRequestBean nurse){
		nurseService.addNurse(nurse);
		return ResponseEntity.ok().body(nurse);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List> getAllNurse(){
		return ResponseEntity.ok(nurseService.getAllNurse());
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateNurse(@PathParam(value = "id") int id,@RequestBody NurseRequestBean bean){
		nurseService.updateNurse(id,bean);
		return new ResponseEntity<>("Nurse Updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> DeleteNurse(@PathParam(value = "id") int id){
		nurseService.deleteNurse(id);
		return new ResponseEntity<>("Nurse Deleted successfully", HttpStatus.OK);
	}
}
